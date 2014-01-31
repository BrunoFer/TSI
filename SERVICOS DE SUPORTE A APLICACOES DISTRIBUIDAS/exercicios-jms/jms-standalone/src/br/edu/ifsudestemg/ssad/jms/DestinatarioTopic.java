package br.edu.ifsudestemg.ssad.jms;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DestinatarioTopic {

	public static void main(String[] args) throws JMSException, NamingException {
		InitialContext ic = new InitialContext();
		TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) ic
				.lookup("ConnectionFactory");
		TopicConnection topicConnection = topicConnectionFactory
				.createTopicConnection();
		TopicSession topicSession = topicConnection.createTopicSession(false,
				Session.AUTO_ACKNOWLEDGE);
		Topic topic = (Topic)ic.lookup("filatopico");
		TopicSubscriber topicSubscriber = topicSession.createSubscriber(topic);
		topicSubscriber.setMessageListener(new TratadorMensagem());
		topicConnection.start();
	}

}
