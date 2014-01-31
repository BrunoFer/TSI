package br.edu.ifsudestemg.ssad.loja.rmi;

import javax.naming.InitialContext;

public class RegistraLivrariaNoJBoss {

	public static void main(String[] args) throws Exception{
		InitialContext context = new InitialContext();
		context.rebind("livraria", new LivrariaBean());
		System.out.println("Livraria registrada com sucesso!");
	}

}
