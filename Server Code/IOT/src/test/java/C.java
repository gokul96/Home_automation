 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class C {
 
	public static void main(String[] args) {
		String s = null;
 
		try {
 
			Process p = Runtime.getRuntime().exec("arp -a");
 
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
 
			// read the output from the command
			System.out.println("Here is the standard output of the command:\n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}
 
			// read any errors from the attempted command
			System.out.println("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}
 
			System.exit(0);
		} catch (IOException e) {
			System.out.println("exception happened - here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		}
	}
}


//Output:
//
//This will show all running process on your box.
//
//More Java Tutorials.
//
//Have a suggestion on article? Please chime in and share it as a comment.
// Buffer Follow
//
// 
//TOP DEALS