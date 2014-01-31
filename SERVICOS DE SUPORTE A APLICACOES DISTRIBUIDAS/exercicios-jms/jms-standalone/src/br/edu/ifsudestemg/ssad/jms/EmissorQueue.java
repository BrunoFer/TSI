package br.edu.ifsudestemg.ssad.jms;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EmissorQueue {
	public static void main(String[] args) throws NamingException, JMSException {
		InitialContext ic = new InitialContext();
		QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) ic
				.lookup("ConnectionFactory");
		QueueConnection queueConnection = queueConnectionFactory
				.createQueueConnection();
		System.out.println("Passei aqui");
		QueueSession queueSession = queueConnection.createQueueSession(false,
				Session.AUTO_ACKNOWLEDGE);
		TextMessage textMessage = queueSession.createTextMessage();
		textMessage.setText("Mensagem de texto para uma Queue");
		Queue queue = (Queue) ic.lookup("filateste");
		QueueSender sender = queueSession.createSender(queue);
		sender.send(textMessage);
		System.out.println("Terminei emissor queue");
	}
}
