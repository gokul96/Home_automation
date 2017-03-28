import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class A
{
	public static void main(String[] args) throws UnknownHostException
	{
		
		String 	ip = InetAddress.getLocalHost().getHostAddress();
		System.out.println("My IP address : " + ip);
		
		String[] splittedIP = ip.split("\\.");
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

		    while ((s = stdInput.readLine()) != null) 
		    {
		        if(!((s.startsWith("Starting Nmap")) || (s.startsWith("Host is up"))))
		        {
		        		System.out.println(s);
		        }
		    }
		    // read any errors from the attempted command
		    while ((s = stdError.readLine()) != null) 
		    {
		        System.err.println(s);
		    }
		} catch (IOException ex) {
		    System.err.println("****** "+ex);
		}
		
	}
}