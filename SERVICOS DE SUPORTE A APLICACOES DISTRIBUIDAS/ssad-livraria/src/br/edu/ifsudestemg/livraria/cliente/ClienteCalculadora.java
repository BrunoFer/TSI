package br.edu.ifsudestemg.livraria.cliente;

import javax.naming.InitialContext;
import java.lang.Thread;

import br.edu.ifsudestemg.livraria.ejb.Calculadora;

public class ClienteCalculadora {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		float res;
		
		InitialContext contexto = new InitialContext();
		Calculadora calc= (Calculadora) contexto.lookup("CalculadoraBean/remote");
		
		res = calc.soma(10, 20);
		
		System.out.println("Resultado da soma entre 10 e 20 = "+res);
		Thread.sleep(100000);
		System.out.println("Resultado da subtração entre 20 e 10 = "+calc.subtrai(20, 10));
	}

}
