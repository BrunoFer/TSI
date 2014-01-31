package br.edu.ifsudestemg.livraria.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.ifsudestemg.livraria.ejb.Carrinho;
import br.edu.ifsudestemg.livraria.modelo.Livro;

public class ClienteCarrinhoLivraria {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws NamingException {
		InitialContext contexto = new InitialContext();
		Carrinho carrinho = (Carrinho) contexto.lookup("CarrinhoBean/remote");
		
		Livro livro = new Livro();
		livro.setNome("Engenharia de Software");
		livro.setPreco(50.00);
		carrinho.addLivro(livro);

		livro = new Livro();
		livro.setNome("Servidores Linux");
		livro.setPreco(70.50);
		carrinho.addLivro(livro);
		
		livro = new Livro();
		livro.setNome("Redes");
		livro.setPreco(60.90);
		carrinho.addLivro(livro);
		
		livro = new Livro();
		livro.setNome("Aplicações Web");
		livro.setPreco(44.90);
		carrinho.addLivro(livro);
		
		carrinho.getLivros();
		carrinho.getTotal();
		carrinho.finalizaCompra();
		carrinho.getTotal();
	}
}
