package br.edu.ifsudestemg.ssad.loja.cliente;

import java.rmi.Naming;

import br.edu.ifsudestemg.ssad.loja.rmi.Livraria;
import br.edu.ifsudestemg.ssad.loja.rmi.Livro;

public class ClienteLivraria {

	public static void main(String[] args) throws Exception{
	
		Livraria livraria = (Livraria) Naming.lookup("rmi://localhost:1099/carrinho/livraria");
		
		Livro l = new Livro();
		l.setIspn("1111");
		l.setNome("EJB in Action 3.1");
		l.setPreco(150);
		livraria.adiciona(l);
		
		l =new Livro();
		l.setIspn("2222");
		l.setNome("JPA 2.0");
		l.setPreco(100);
		livraria.adiciona(l);
		
		System.out.println("Preço total do carrinho: R$ "+livraria.getTotal());
	
	}

}
