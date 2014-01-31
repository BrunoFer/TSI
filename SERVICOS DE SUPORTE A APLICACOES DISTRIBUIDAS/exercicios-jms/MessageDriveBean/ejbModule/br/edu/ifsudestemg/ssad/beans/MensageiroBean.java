package br.edu.ifsudestemg.ssad.beans;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
@Local(Mensageiro.class)
public class MensageiroBean implements Mensageiro {

	@Resource(mappedName = "QueueConnectionFactory")
	private ConnectionFactory fabrica;
	@Resource(mappedName = "queue/fila­teste")
	private Queue queue;

	@Override
	public void enviaMensagem(String msg) {
		try {
			Connection conexao = this.fabrica.createConnection();
			Session sessao = conexao.createSession(true,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer produtor = sessao.createProducer(this.queue);
			TextMessage textMessage = sessao.createTextMessage();
			textMessage.setText(msg);
			System.out.println("Vendas Enviando: " + msg);
			produtor.send(textMessage);
			produtor.close();
			conexao.close();
		} catch (JMSException e) {
			throw new EJBException(e);
		}
	}

}
