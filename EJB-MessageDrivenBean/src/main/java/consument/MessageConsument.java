package consument;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import email.ServiceMessage;
@MessageDriven(activationConfig= {@ActivationConfigProperty(
		propertyName = "destination",
		propertyValue = "jms/queue/Emails")})
public class MessageConsument implements MessageListener {

	@Override
	public void onMessage(Message message) {
		
		try {
			ServiceMessage Servicemessage = message.getBody(ServiceMessage.class);
			System.out.println("Send by user: "+Servicemessage.getUserName());
			System.out.println("Message: "+Servicemessage.getUserMessage());
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
