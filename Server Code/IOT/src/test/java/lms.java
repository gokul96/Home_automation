import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
 

public class lms {
 
    public static void main(String[] args) {
 
        try {
            Socket socket = new Socket("192.168.1.146", 20000);
            
            if(socket.isConnected())
            {
            	System.out.println("TCP connection created...");
            try {
                 
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String command1= "*99*9##";
                String command2 = "*1*0*34##";
                wr.write(command1);
                wr.write(command2);
                System.out.println("Send cmd : "+command1);
                System.out.println("Send cmd : "+command2);
                 
                wr.flush();
 
            	} catch (IOException e) {
                e.printStackTrace();
            	}
            }
            else{
            	System.out.println("connection error...");
            }
 
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str;
                while (rd.ready()) {
                    System.out.println("ACK from lms : " + rd.readLine());
                }
                rd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             
            socket.close();
        } catch (Exception e) {
            System.out.println("connection EX :"+ e);
        } 
    }
}