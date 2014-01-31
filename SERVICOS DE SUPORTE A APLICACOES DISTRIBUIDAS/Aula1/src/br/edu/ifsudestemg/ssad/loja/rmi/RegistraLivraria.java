package br.edu.ifsudestemg.ssad.loja.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RegistraLivraria {

	public static void main(String[] args) throws Exception{
		LocateRegistry.createRegistry(1099);
		Naming.rebind("carrinho/livraria", new LivrariaBean());
		System.out.println("Objeto registrado com sucesso!");
	}

}
