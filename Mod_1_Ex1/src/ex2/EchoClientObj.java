/**
 * EchoClient
 */
package ex2;

/**
 * @author dwatson, kitty
 * @version 1.1
 * Sep 5, 2012
 */

import java.io.*;
import java.net.*;
import java.util.Date;

import javax.swing.JOptionPane;

public class EchoClientObj
{
	/**
	 * @param args
	 */
	String text = "";
	String user = "";
	String logOff = "";
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	
	public static void main( String[] args )
	{
		try
		{
			String ip = JOptionPane.showInputDialog( "Enter ip address" );
			
			// Open a connection to my server listening on port 3333
			user = JOptionPane.showInputDialog( "Enter User Name" );
			
			while(logOff.equals("quit")) 
			{
				Socket socket = new Socket(ip,3333);
				
				text = JOptionPane.showInputDialog("Enter Message");
				
				Message msg = new Message(user,text,new Date());
				
				
				// Creating an output stream to send text to the server
				OutputStream os = socket.getOutputStream();
				oos = new DataOutputStream( os );
				oos.writeObject( msg );
				
				// Create an input stream to receive echo from server
				InputStream is = socket.getInputStream();
				ois = new DataInputStream( is );
				msg = (Message)ois.readObject();
				JOptionPane.showMessageDialog(null, msg, toString() );
				
				ois.close();
				oos.close();
				socket.close();
				
				logOff = JOptionPane.showMessageDialog("Enter \"quit\" to end connetion");
			}

		
		}
		catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
