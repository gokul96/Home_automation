import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.json.JSONArray;
import org.json.JSONObject;


public class Main {

    public static void main(final String[] argv) throws SocketException {
    	Enumeration e = NetworkInterface.getNetworkInterfaces();
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
    	if(ips[1].startsWith(ips[2].substring(0, 9)))
    		current_ip = ips[2];
    	else
    		current_ip = ips[1];
    	
    	System.out.println("current_ip : "+ current_ip);
		
    	current_ip = "tcp://"+current_ip+":1883";
		System.out.println("client : "+current_ip);;
    }
}