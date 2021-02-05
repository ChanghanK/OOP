/**
 * EchoServer
 */
package ex2;

/**
 * @author dwatson, kitty
 * @version 1.1
 * Sep 5, 2012
 */

import java.net.*;
import java.util.Date;
import java.io.*;

public class EchoServerObj
{
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		ServerSocket serverSocket = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Socket socket = null;
		
		// Bind our server to port 3333
		try
		{
			serverSocket = new ServerSocket( 3333 );
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println( "Server is up and running!" );
		
		while( true )
		{
			try
			{
				socket = serverSocket.accept();
				System.out.println( "Accepted a client connection" );
					
				// Read input from client
				ois = new ObjectInputStream( socket.getInputStream() );
				Message msg = (Message)ois.readObject();
				System.out.println( msg );
				
				// Echo text back to client
				oos = new ObjectOutputStream(socket.getOutputStream());
				msg.setTimeStamp(new Date());
				oos.writeObject(msg);
				
				ois.close();
				oos.close();
				socket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
