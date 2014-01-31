package br.edu.ifsudestemg.ssad.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Remote(Gerenciador.class)
@Stateful
public class GerenciadorLivraria implements Gerenciador {
	@EJB
	private Mensageiro mensageiro;
	private List<Livro> livros = new ArrayList<Livro>();
	private float total=0;
	
	@Override
	public void addLivro(Livro livro) {
		// TODO Auto-generated method stub
		livros.add(livro);
		total+=livro.getPreco();
	}

	@Override
	@Remove
	public void finaliza() {
		// TODO Auto-generated method stub
		for (Livro l: livros){
			System.out.println("Livro: "+l.getNome()+"\nPreço: "+l.getPreco());
		}
		mensageiro.enviaMensagem("Total da compra: "+total);
		System.out.println("Finalizando o pedido. Total= "+total);
	}

}
