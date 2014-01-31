package br.edu.ifsudestemg.ssad.beans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/fila­teste") })
public class FinanceiroMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			String text = ((TextMessage) message).getText();
			System.out.println("Financeiro Recebendo :" + text);
		} catch (JMSException e) {
			throw new EJBException(e);
		}
	}

}
