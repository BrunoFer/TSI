package br.edu.ifsudestemg.ssad.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifsudestemg.ssad.modelo.Livro;

public class ClienteJPA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager manager = new JPAUtil().getEntityManager();
		
		/*
		Livro l;
		l = new Livro();
		l.setNome("Novo livro");
		l.setValor(200);

		manager.getTransaction().begin();
		manager.persist(l);
		manager.getTransaction().commit();
		System.out.println("Livro cadastrado com sucesso!");
		
		manager.getTransaction().begin();
		l = manager.find(Livro.class, 1);
		if (l==null)
			System.out.println("Livro não existente!!");
		else {
			manager.remove(l);
			manager.getTransaction().commit();
			System.out.println("Livro removido!!");
		}
		**/
		
		manager.getTransaction().begin();
		Query query = manager.createQuery("from Livro l");
		@SuppressWarnings("unchecked")
		List<Livro> listaLivros = (List<Livro>)query.getResultList();
		for (Livro i: listaLivros){
			System.out.println(i.getNome());
		}
		manager.getTransaction().commit();
	}

}
