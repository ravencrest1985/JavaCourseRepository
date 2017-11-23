package email;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

public class MailService {
	
	@Inject
	private JMSContext jmsContext;
	@Resource(mappedName="jms/queue/Emails")
	private Queue queue;

	public void sendMessage(ServiceMessage message) {
		JMSProducer createProducer = jmsContext.createProducer();
		createProducer.send(queue, message);
	}
	
	
	
}
