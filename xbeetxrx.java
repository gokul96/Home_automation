
import com.pi4j.io.serial.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.util.Console;

import java.io.IOException;
import java.util.*;


public class xbeetxrx
{
	//Final variables 
	static final Serial serial = SerialFactory.createInstance(); //pi4j serial instance creation
	//IR
	static final byte[] r1={(byte)0x00,(byte)0x13,(byte)0xA2,(byte)0x00,(byte)0x41,(byte)0x54,(byte)0xED,(byte)0xC9}; //address of router 1
	//Switch
	static final byte[] r2={(byte)0x00,(byte)0x13,(byte)0xA2,(byte)0x00,(byte)0x40,(byte)0xD7,(byte)0xBD,(byte)0x24}; //address of router 2
	//dimmer ?
	static final byte[] r3={(byte)0x00,(byte)0x13,(byte)0xA2,(byte)0x00,(byte)0x40,(byte)0xD7,(byte)0xBD,(byte)0x2F}; //address of router 3
	//dyanmic variables
	static int[] a={0,0,0,0,0,0,0,0};
	static int dim_val;	
	static byte[] dat={(byte)0x00,(byte)0x00,(byte)0x00}; //data to be sent
	
	public static void xbeetxrx() // constructor for xbee serial opening and listening
	{
		//opening Serial port
		try 
		{
            // create serial config object
            SerialConfig config = new SerialConfig();

            config.device("/dev/ttyUSB0")
                  .baud(Baud._9600)
                  .dataBits(DataBits._8)
                  .parity(Parity.NONE)
                  .stopBits(StopBits._1)
                  .flowControl(FlowControl.NONE);

			serial.open(config);
			
		}
			
		catch(IOException ex) 
		{
            System.out.println(" SERIAL SETUP FAILED" + ex.getMessage());
            //return;
        }
		
		//adding a serial listener
		serial.addListener(new SerialDataEventListener() //function comes in as a parameter O.o fujava
		{
            @Override
            public void dataReceived(SerialDataEvent event) 
			{

                try 
				{ 
                	packet_parse(event.getBytes()); // calls the parseing function; cant handle millisecond delays yet			
                } 
				
				catch (IOException e) 
				{
                    e.printStackTrace();
                }
            }
        });
	}

	static void printar(byte[] a) //array printer function for elminating useless extra code
	{
		System.out.println();
		for(int l=0;l<a.length;l++)
				System.out.print(a[l]);
		System.out.println();
	}
	static void printar(int[] a)//array printer function for elminating useless extra code
	{
		System.out.println();
		for(int l=0;l<a.length;l++)
				System.out.print(a[l]);
		System.out.println();
	}
	
	static void packet_parse(byte[] rec_dat) //accepts the input data and does relevant operations
	{
		//System.out.println("Invoked");
		//printar(rec_dat);
		if(rec_dat[0]==(byte)0x7E) // checks if actual Xbee packet is recieved by checking for delmiter
		{	//System.out.println("delimited");
			if (rec_dat[11]==(byte)0x24)							// checks last byte of address field in xbee frame
			{
				System.out.println("data recieved from router 1");
				if (rec_dat[15]==(byte)0x03)
				{
					for(int i=0;i<8;i++)							// ###CHANGE TO YOUR NEEDS###
						if((rec_dat[17]|(1<<(7-i)))==rec_dat[17])	// Application Specific code change as per your needs
							a[i]=1;									// here rec_dat[15] is the first byte of recived data
					System.out.println("rxd packet");				// i use it to ID what kind of packet i got for application
					printar(a);										// ###CHANGE TO YOUR NEEDS###
				}													//
			if (rec_dat[11]==(byte)0xC9)							// checks last byte of address field in xbee frame
			{														//
																	//
			}														//			
			if (rec_dat[11]==(byte)0x2F)							// checks last byte of address field in xbee frame
			{														//	
																	//
			}														//
		}
	}
}

	static byte[] frame_make(byte[] address, byte data[]) //makes the API mode frame for the Xbee transmit request type
	{
		int s=18+data.length;
		byte[] frame= new byte[s];
		int i=0;
		int j=0;
		byte len=(byte)0x0E;
		byte lenh=(byte)0x00;
		//len=(byte)(len+data.length);
		
		for (int i=0;i<data.length;i++)
		{
			if(len=(byte)0xff)
			{
				lenh++;
				len=(byte)0x00
			}
			else 
				len++;
		}	

		frame[i++]=(byte)0x7E; 		//frame Delimiter
		frame[i++]=(byte)lenh; 		//frame length high (not used)
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
		return frame;			//return frame
	}
	
	static byte sw(int[] s) // creates byte to be sent to change switch status
	{
		byte ss=(byte)0x00;
		int i=0;
		for(i=0;i<8;i++)
			if(s[i]==1)
				ss=(byte)(ss|(1<<(7-i)));
			
			//intln("Switch byte set");
		return ss;
	}
	
	static byte toggle(int t) // cahnges switch array status
	{
		if(a[t-1]==1)
			a[t-1]=0;
		else
			a[t-1]=1;
		//System.out.println("toggling"+ t);
		//System.out.println();
		//printswitch();
		return sw(a);
	}
 
	static int send_byte(byte [] abc) //writes given byte array to serial
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
	
	static void sw_tog(int p) //toggles and sends frame for switch control
	{
			dat[0]=(byte)0x01;
			dat[1]=(byte)0x01;
			dat[2]=(byte)toggle(p);
			byte[] abc=frame_make(r1,dat);
			
			if(send_byte(abc)!=1)
				System.out.println("failure");
	}
 	
	static void sw_req() //requests switch status
	{
		dat[0]=(byte)0x02;
		dat[1]=(byte)0x01;
		byte[] abc=frame_make(r1,dat);
		//printar(abc);
		if(send_byte(abc)!=1)
				System.out.println("failure");
		//System.out.println("swtich status requested");
	}
		
	public static void main(String args[]) throws InterruptedException, IOException
	{
		xbeetxrx(); //invoke constructor IDK why i have to do this
		
		Scanner hey=new Scanner(System.in); //new scanner for getting input from user
		int k;
		
		for(;;)
		{	
			System.out.println("enter switch");
			k=hey.nextInt();		//get I/p from user 
			sw_tog(k); 				//call toggle function
			System.out.println("");
			
			Thread.sleep(10); //delay
			sw_req(); // asks Arduino what status the switches are in
		}
	}
}

			
            	