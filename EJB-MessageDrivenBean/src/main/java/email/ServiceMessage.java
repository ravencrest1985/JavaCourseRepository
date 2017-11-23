package email;

import java.io.Serializable;

public class ServiceMessage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String userMessage;
	private String userName;
	
	public ServiceMessage(String userMessage,String userName) {
		this.userMessage=userMessage;
		this.userName=userName;	
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
