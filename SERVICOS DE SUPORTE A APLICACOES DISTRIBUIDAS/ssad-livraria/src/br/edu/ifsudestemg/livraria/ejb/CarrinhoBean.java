package br.edu.ifsudestemg.livraria.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.annotation.ejb.cache.simple.CacheConfig;

import br.edu.ifsudestemg.livraria.modelo.Livro;

@Stateful
@Remote(Carrinho.class)
@CacheConfig(maxSize=1)
public class CarrinhoBean implements Carrinho{
	private List<Livro> livros = new ArrayList<Livro>();
	private double total;

	@Override
	public void addLivro(Livro livro) {
		this.livros.add(livro);
		this.total += livro.getPreco();
		System.out.println("Livro - "+livro.getNome()+" - adicionado!");	
	}
	
	@Override
	public List<Livro> getLivros(){
		System.out.println("Método getLivros() executado!");
		return livros;
	}

	@Override
	public double getTotal() {
		System.out.println("Método getTotal() executado e o total é :"+total);
		return total;
	}

	@Override
	@Remove
	public void finalizaCompra() {
		for (Livro l: livros){
			System.out.println("Livro: "+l.getNome());
			System.out.println("Preço: "+l.getPreco());
		}
	}
}
