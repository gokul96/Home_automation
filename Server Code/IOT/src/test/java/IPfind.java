 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
public class IPfind {
 
    public static void main(String a[]){
     
    	
    	String Hue_mac = "00:17:88:1C:89:0E";
    	String XDK_mac = "F4:B8:5E:3B:1A:37";
    	String LMS_mac = "00:03:50:A0:02:07";
    	String Intesis_mac = "00:1D:C9:A1:84:49";
	    
	    String Hue_ip = null;
	    String XDK_ip = null;
	    String LMS_ip = null;
	    String Intesis_ip = null;
    	
    	
    	Enumeration e = null;
		try {
			e = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	String[] ips = new String[10];
    	String current_ip = null;
    	int x = 0;
    	JSONArray iot_ip = new JSONArray();
    	JSONObject ipANDmac = new JSONObject();
    	
    	
    	while(e.hasMoreElements())
    	{
    	    NetworkInterface n = (NetworkInterface) e.nextElement();
    	    Enumeration ee = n.getInetAddresses();
    	    while (ee.hasMoreElements())
    	    {
    	    	InetAddress i = (InetAddress) ee.nextElement();
//	    	    System.out.println(i.getHostAddress());
	    	    
	    	    String[] my_ip = i.getHostAddress().split("\\.");
	    	    if(my_ip.length==4)
	    	    {
	    	    	ips[x] = my_ip[0]+"."+my_ip[1]+"."+my_ip[2]+"."+my_ip[3];
	    	    	x++;
	    	    }
    	    }
    	}
    	
    	if(!(ips[2]==null))
    	{
	    	if(ips[1].startsWith(ips[2].substring(0, 9)))
	    		current_ip = ips[2];
	    	else
	    		current_ip = ips[1];
    	}
    	else
    		current_ip = ips[1];
    	
    	System.out.println("current_ip : "+ current_ip);
    	System.out.println();
    	
    	
    	String[] splittedIP = current_ip.split("\\.");
		String Network_id = splittedIP [0] + "." + splittedIP [1] + "." + splittedIP [2] ;
		System.out.println("firstThreeSegments : " + Network_id);
		
		String cmd = "nmap -PR -sn "+Network_id+".0/24";
		System.out.println("cmd : "+cmd);
		try {
			    Process proc = Runtime.getRuntime().exec(cmd);
	
			    BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			    BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
	
			    // read the output from the command
			    String s = null;
			    int c = 0;
		    while ((s = stdInput.readLine()) != null) 
		    {
		    	
		        if((s.startsWith("Nmap scan report for")) || (s.startsWith("MAC Address:")))
		        {
		        	c++;
//		        	System.out.println(s);
		        	if(s.startsWith("Nmap scan report for"))
		        	{
		        		String temp_ip = null;
		        		temp_ip = s.substring(21);
		        		try {
							ipANDmac.put("IP", temp_ip);
						} catch (JSONException e1) {
							e1.printStackTrace();
						}
		        	}
		        	if((s.startsWith("MAC Address:")))
		        	{
		        		String temp_mac = null;
	        			temp_mac = s.substring(13,30);
	        			try {
							ipANDmac.put("MAC", temp_mac);
						} catch (JSONException e1) {
							e1.printStackTrace();
						}
		        	}
		        	if(c==2)
		        	{
		        		iot_ip.put(ipANDmac);
		        		ipANDmac = new JSONObject();
		        		c = 0;
		        	}
		        }
		    }
		    System.out.println("local network scanned ... ");
		    System.out.println(iot_ip );
		    
		    int ip_lenght = iot_ip.length();
		    for(int t=0;t<ip_lenght;t++)
		    {
		    	JSONObject object = iot_ip.getJSONObject(t);
		    	if(object.length()==2)
		    	{
		    		System.out.println("object.length() " + object.length());
			    	String mac = object.getString("MAC");
			    	if(mac.equals(Hue_mac))
			    	{
			    		Hue_ip = object.getString("IP");
			    		System.out.println("Hue ip " +Hue_ip );
			    	}
			    	else if(mac.equals(XDK_mac))
			    	{
			    		XDK_ip = object.getString("IP");
			    		System.out.println("XDK ip " +XDK_ip );
			    	}
			    	else if(mac.equals(LMS_mac))
			    	{
			    		LMS_ip = object.getString("IP");
			    		System.out.println("LMS ip " +LMS_ip );
			    	}
			    	else if(mac.equals(Intesis_mac))
			    	{
			    		Intesis_ip = object.getString("IP");
			    		System.out.println("Intesis ip " +Intesis_ip );
			    	}
		    	}
		    }
		    
		    // read any errors from the attempted command
		    while ((s = stdError.readLine()) != null) 
		    {
		        System.err.println(s);
		    }
		} catch (IOException ex) {
		    System.err.println("****** "+ex);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		
    	
    }
}
