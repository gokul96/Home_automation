 
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
 
public class B {
 
    public static void main(String a[]) throws SocketException, UnknownHostException{
     
    	Enumeration e = NetworkInterface.getNetworkInterfaces();
//    	int a1 = 0;
    	while(e.hasMoreElements())
    	{
    	    NetworkInterface n = (NetworkInterface) e.nextElement();
    	    Enumeration ee = n.getInetAddresses();
    	    while (ee.hasMoreElements())
    	    {
    	    	InetAddress i = (InetAddress) ee.nextElement();
    	        System.out.println("i.getHostAddress() "+i.getHostAddress());
    	    }
    	}
    }
}
