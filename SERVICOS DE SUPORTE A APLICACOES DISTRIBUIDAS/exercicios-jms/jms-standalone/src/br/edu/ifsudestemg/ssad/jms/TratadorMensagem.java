package br.edu.ifsudestemg.ssad.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TratadorMensagem implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		TextMessage textMessage = (TextMessage) msg;
		try {
			System.out.println("Recebendo mensagem: " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
