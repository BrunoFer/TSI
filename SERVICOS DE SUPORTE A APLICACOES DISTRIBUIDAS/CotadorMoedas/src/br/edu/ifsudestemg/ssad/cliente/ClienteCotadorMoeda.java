package br.edu.ifsudestemg.ssad.cliente;

import javax.naming.InitialContext;

import br.edu.ifsudestemg.ssad.session.CotadorMoeda;

public class ClienteCotadorMoeda {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InitialContext contexto = new InitialContext();
		CotadorMoeda cotador = (CotadorMoeda) contexto.lookup("CotadorMoedaBean/remote");
		
		System.out.println("Valor em reais de 2 dólares: "+cotador.fazCotacao("dollar", "real", 2));
	}

}
