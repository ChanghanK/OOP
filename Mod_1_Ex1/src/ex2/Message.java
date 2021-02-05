package ex2;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable
{
	//Constants
	static final long serialVersionUID = 5488945625178844229L;
	
	//Attributes
	private String user;
	private String msg;
	private Date timeStamp;
	
	//Constructors
	public Message()
	{
			
	}
		
	public Message(String user, String msg, Date timeStamp)
	{
		this.user = user;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "User Name: " + user + "      " + "Date and Time: " + timeStamp + "\nMessage: " + msg;
	}

	
}
