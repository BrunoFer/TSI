package br.edu.ifsudestemg.ssad.cliente;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.edu.ifsudestemg.ssad.beans.Gerenciador;
import br.edu.ifsudestemg.ssad.beans.Livro;

public class Cliente {

	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		Gerenciador g = (Gerenciador) ic.lookup("GerenciadorLivraria/remote");
		Livro l = new Livro();
		l.setId(1);
		l.setNome("Java - Como programar");
		l.setPreco(70);
		g.addLivro(l);
		g.finaliza();
	}

}
