package com.IOT.Controller;

import java.io.IOException;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pi4j.io.serial.Baud;
import com.pi4j.io.serial.DataBits;
import com.pi4j.io.serial.FlowControl;
import com.pi4j.io.serial.Parity;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialConfig;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.io.serial.StopBits;

@Controller
@RequestMapping("/Ardunio")
public class ArduinoController {

//	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	int x=0;
	
	static int[] a={0,0,0,0,0,0,0,0};
	static int dim_val;
	static final Serial serial = SerialFactory.createInstance(); //pi4j serial instance creation
	static byte[] r1={(byte)0x00,(byte)0x13,(byte)0xA2,(byte)0x00,(byte)0x41,(byte)0x54,(byte)0xED,(byte)0xC9}; //address of router 1
	static byte[] r2={(byte)0x00,(byte)0x13,(byte)0xA2,(byte)0x00,(byte)0x40,(byte)0xD7,(byte)0xBD,(byte)0x24}; //address of router 2
	static byte[] r3={(byte)0x00,(byte)0x13,(byte)0xA2,(byte)0x00,(byte)0x40,(byte)0xD7,(byte)0xBD,(byte)0x2F}; //address of router 3
		
	static byte[] dat={(byte)0x01,(byte)0x01,(byte)0x00}; //data to be sent.
	//static byte[] rec_dat={0,0,0,0,0,00,0,0,0,0,00,0,0,00,0,0,0,00,0,0,0,0,0};
	static byte[] rec_inf;
	static void printswitch()
	{
		System.out.println();
		for(int l=0;l<8;l++)
				System.out.print(" "+a[l]);
		System.out.println();
	}
	static void printar(byte[] a)
	{
		System.out.println();
		for(int l=0;l<a.length;l++)
				System.out.print(a[l]);
		System.out.println();
	}
	static void printar(int[] a)
	{
		System.out.println();
		for(int l=0;l<a.length;l++)
				System.out.print(a[l]);
		System.out.println();
	}
	
	//current device status
	static void packet_parse(byte[] rec_dat)
	{
		System.out.println("Invoked");
		printar(rec_dat);
		if(rec_dat[0]==(byte)0x7E)
			System.out.println("delimited");
		if (rec_dat[11]==(byte)0xC9)//data from router 1 type sw
			if (rec_dat[15]==(byte)0x03)
			{
				
				System.out.println("data recieved");
				int sw_st=rec_dat[17];
				int i=0;
				for(i=0;i<8;i++)
					if((sw_st|(1<<(7-i)))==sw_st)
						a[i]=1;
				System.out.println("rxd packet");
				printar(a);
				
			}
		
		// for future routers
		if (rec_dat[11]==(byte)0x24)
		{
			System.out.println("This is to be developed...1");
		}
		if (rec_dat[11]==(byte)0x2F)
		{
			System.out.println("This is to be developed...2");
		}
	}
	
	static byte[] frame_make(byte[] address, byte data[])
	{
		int s=18+data.length;
		byte[] frame= new byte[s];
		//frametype
		int i=0;
		int j=0;
		byte len=(byte)0x0E;
		len=(byte)(len+data.length);

		frame[i++]=(byte)0x7E; 		//frame Delimiter
		frame[i++]=(byte)0x00; 		//frame length high (not used)
		frame[i++]=(byte)len;		//frame length low
		frame[i++]=(byte)0x10;		//frame type 0x10 - Tx req 64bit address
		frame[i++]=(byte)0x00;		//frame ID (oxo1-disable retry, 0x00 - disable ACK)
		
					
		for (j=0; j<8; j++)
			frame[i++]=address[j];	//insert address fixedlength of 8 bytes
	
		frame[i++]=(byte)0xFF;		//16bit broad cast address high (not used)
		frame[i++]=(byte)0xFE;		//16bit broadcast address low	(not used)
		frame[i++]=(byte)0x00;		//broadcast radius 0x00 - max
		frame[i++]=(byte)0x00;		//options
			
		for (j=0;j<data.length;j++)
			frame[i++]=data[j];	//insert data
	
		byte cs=(byte)0x00;		//initalize checksum byte
	
		for(int t=3; t<s; t++)
			cs+=(byte)frame[t];	//calulate checksum add all bytes
	
		cs = (byte)((-1)-cs);		//checksum = 0xFF-cs, 0xFF is -1 as a signed int
		frame[i]=cs;			//put frame checksum in its place
		System.out.println("frame Made");
		return frame;			//return frame
	}
	
	static byte sw(int[] s)
	{
		byte ss=(byte)0x00;
		int i=0;
		for(i=0;i<8;i++)
			if(s[i]==1)
				ss=(byte)(ss|(1<<(7-i)));
			
		return ss;
	}
	
	static byte toggle(int t)
	{
		if(a[t-1]==1)
			a[t-1]=0;
		else
			a[t-1]=1;
		return sw(a);
	}

	static int send_byte(byte [] abc)
	{    
		try 
		{
			serial.write((byte[]) abc);		
			//System.out.println("writing packet");
			return 1;
        }
		catch(IOException ex)
		{
            ex.printStackTrace();
			return -1;
        }
    }
	
	//TO control the switches
	static String sw_tog(int p)
	{
			dat[0]=(byte)0x01;
			dat[1]=(byte)0x01;
			dat[2]=(byte)toggle(p);
			byte[] abc=frame_make(r1,dat);
			
			if(send_byte(abc)!=1)
			{
				System.out.println("failure");
				return "failure";
			}
			else
				System.out.println("success");
				return "success";
	}
 	
	//To get the status of the switches
	static void sw_req()
	{
		dat[0]=(byte)0x02;
		dat[1]=(byte)0x01;
		byte[] abc=frame_make(r1,dat);
		printar(abc);
		if(send_byte(abc)!=1)
				System.out.println("failure");
		//System.out.println("swtich status requested");
	}
	
	
//	@RequestMapping(value = "/getIP", method = RequestMethod.GET)
//	public @ResponseBody String get_IP() 
//	{
//		System.out.println("this is get ip...###");
//		return "hellllloooooooooooooo******oo";
//	}
	
	//To control
	@RequestMapping(value="/control",method = RequestMethod.POST, produces="application/json") 
	public @ResponseBody String control(@RequestBody Map <String,Object> requestbody) throws JSONException
	{
		System.out.println("Switch control invoked..."); 
		System.out.println(requestbody.get("status").toString());
//		String sw = requestbody.get("status").toString();
//		int i = Integer.parseInt(sw);
//		
//		//To open the serial port
//		if(x==0)
//		{
//			System.out.println("trying to open serial port...");
//			
//			try 
//			{
//	            // create serial config object
//	            SerialConfig config = new SerialConfig();
//	
//	            config.device("/dev/ttyUSB0")
//	                  .baud(Baud._9600)
//	                  .dataBits(DataBits._8)
//	                  .parity(Parity.NONE)
//	                  .stopBits(StopBits._1)
//	                  .flowControl(FlowControl.NONE);
//	
//				serial.open(config);
//				System.out.println("SERIAL PORT OPENED...");
//			}
//			catch(IOException ex) 
//			{
//	            System.out.println(" ==>> SERIAL SETUP FAILED : " + ex.getMessage());
//	        }
//			x++;
//		}
//		
//		System.out.println("hello , serial port opened....."); 
//			
//		//adding a serial listener
//		serial.addListener(new SerialDataEventListener() //function comes in as a parameter O.o fujava
//		{
//            public void dataReceived(SerialDataEvent event) 
//			{
//            	System.out.println("adding a serial listener...");
//                try 
//				{ 
//                    System.out.println("[HEX DATA]   " + event.getHexByteString());
////					printar(event.getBytes());
//                	packet_parse(event.getBytes());
//					System.out.println("got data");							
//                } 
//				catch (IOException e) 
//				{
//                    e.printStackTrace();
//                }
//            }
//        });
//		
//			String ACK = sw_tog(i);
//			JSONObject status = new JSONObject();
//			try {
//				status.put("ACK", ACK);
//			} catch (JSONException e) {
//				System.out.println("Exception in status...");
//				e.printStackTrace();
//			}
//			
//			sw_req();
//			
//			return status.toString();
			return "hellooo";
	}
	
	//one time switch request
	@RequestMapping (value="/oneTimeSW_req", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody void oneTimeSW_req()
	{
		System.out.println("OneTimeSW_req invoked...");
		System.out.println("a : "+ a);
		sw_req();
	}
	
	
	//To get current status
	@RequestMapping (value="/current_status",method=RequestMethod.GET,produces = "application/json")
	 public @ResponseBody String current_Status()
	 {
		System.out.println("current_status invoked...");
		JSONObject sw = new JSONObject();
		int l = a.length;
		int temp = 0;
		for(int x=0; x<l; x++)
		{
			temp = a[x];
			System.out.println("switch: "+ x + "; status: "+temp);
			
			switch(x)
			{
			case 0 :
				try {
					sw.put("sw_1", temp+"");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			case 1 :
				try {
					sw.put("sw_2", temp+"");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			case 2 :
				try {
					sw.put("sw_3", temp+"");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			case 3 :
				try {
					sw.put("sw_4", temp+"");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			case 4 :
				try {
					sw.put("sw_5", temp+"");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			case 5 :
				try {
					sw.put("sw_6", temp+"");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			case 6 :
				try {
					sw.put("sw_7", temp+"");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			case 7 :
				try {
					sw.put("sw_8", temp+"");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
		}
		 
//		System.out.println(sw.toString());
		 return sw.toString();
		 
	 }
	
}