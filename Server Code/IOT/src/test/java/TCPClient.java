import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

class TCPClient
{
	public static void main(String argv[]) throws IOException       // *****working program ********//
	{
		try{
			int i = 1;
			  String cmd = "*1*0*33##";
				String ihreply;
			  Socket clientSocket = new Socket("127.0.0.1",8081);
			  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			  BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			  System.out.println("waiting to connect....");
			  try
			  {
				  if(clientSocket.isConnected())
				  {
					  System.out.println("inside connnection block....");
					  if(i==1)
					  {
						  System.out.println("I : "+ i);
						  wr.write("*99*9##");
						  wr.write(cmd);
						  wr.flush();
						  System.out.println("lights on....");
						  try {
				                BufferedReader rd = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				                String str;
				                System.out.println("before while......");
				                while ((str = rd.readLine()) != null) {
				                    System.out.println(str);
				                }
				                rd.close();
				            } catch (IOException e) {
				                e.printStackTrace();
				            }
						 
					  }
					  else if(i==2)
					  {
						  System.out.println("I : "+ i); 
						  wr.write("*99*1##");
						  wr.flush();
						  ihreply = inFromServer.readLine().toString();
						  System.out.println("cmd sent..." + ihreply);
						  BufferedReader rd = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
						  System.out.println("ACK : "+ rd.readLine());
						  try {
				               
				                String str;
				                System.out.println("before while......");
				                while ((str = rd.readLine()) != null) {
				                    System.out.println(str);
				                }
				                rd.close();
				            } catch (IOException e) {
				                e.printStackTrace();
				            }
					  }
					  else
					  {
						  System.out.println("Invalid session selection");
					  }
				  }
			  }
			  catch(Exception e)
			  {
				  System.out.println("connection ex : " + e);
			  }
			 
		}
		catch(Exception e)
		{
			System.out.println("e : " + e);
		}
	  
	}
	
	} 
		
//		 ihreply = inFromServer.readLine();
		  
		  
////		  System.out.println("****************");
////			String command = "*99*9##";
//			wr.write("*99*9##");
//
//			wr.write("*1*0*34##");
//			wr.flush();
//
//			ihreply = inFromServer.readLine();
		 
	  
	
//		  System.out.println("Hi LMS..");
//		  ihreply = inFromServer.readLine();
//		  System.out.println("**********");
//		  System.out.println("connection created..."+ ihreply );
//		  System.out.println("selecting seccion...");
//		  wr.write("*99*9##");
//		  if(inFromServer.ready())
//		  {
//			  ihreply = inFromServer.readLine();
//			  System.out.println( "*99*9## : " + ihreply );
//		  }
//		  
//		  System.out.println("trying to switch on the light...");
//		  wr.write("*1*1*34##");
//		  if(inFromServer.ready())
//		  {
//			  ihreply = inFromServer.readLine();
//			  System.out.println( "*1*1*34## : " + ihreply );
//		  }
//	  }
//	  else
//	  {
//		  System.out.println("Sorry Connection is not created...");
//	  }
//	}
	
//}
//	
////		  telegram = "*99*9##";
////		  byte[] b = telegram.getBytes();
////		  System.out.println(" Byte b : " + b);
////	  	  System.out.println("before while loop : "+ telegram);
//	 
//		  while(telegram != null)
//		  {
////			  System.out.println("telegram : " + telegram);
//			  wr.writeUTF(telegram); // wr.writeBytes(telegram);  //*1*1*34## //*99*9##
//			  wr.flush();
//			  
//			  ihreply = inFromServer.readLine();
//			  System.out.println( telegram + " : "+ ihreply );
//			  System.out.println("command sent to lms..."); 
//			  if(inFromServer.ready())
//			  {
//				  System.out.println("lms is ready...");
//				  while(ihreply != null)
//					  {
//						  System.out.println("lights ON...");
//					  	  System.out.println("FROM LMS : " + ihreply);
////						  ihreply = inFromServer.readLine();
//						  break;
//					  }
//			  }
//				  
//			  System.out.println();
//			  System.out.println("***************************************************************************************************************");
//
//			  if(i==0)
//			  {
//				  telegram = "*1*1*34##";
//				  i++;
//				  System.out.println("i : " + i);
//			  }
//			  else if(i==1)
//			  {
//				  System.out.println("i : " + i);
//				  telegram = "*1*1*33##";
//			  }
//			  else
//			  {
//				  break;
//			  }
//				
//			  
////			  inFromUser = new BufferedReader( new InputStreamReader(System.in));
////			  telegram = inFromUser.readLine();
//		  }	
//	  clientSocket.close();
//	  System.out.println("socket connection is closed");
//	}
//	  else
//	  {
//		  System.out.println("Is not connected...");
//	  }
//	}
// 
//}