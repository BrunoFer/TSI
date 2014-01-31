package br.edu.ifsudestemg.ssad.cliente;

import javax.persistence.EntityManager;

import br.edu.ifsudestemg.ssad.modelo.Cliente;
import br.edu.ifsudestemg.ssad.modelo.ItemNota;
import br.edu.ifsudestemg.ssad.modelo.NotaFiscal;
import br.edu.ifsudestemg.ssad.modelo.Produto;

public class ClienteEmpresa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager manager = new JPAUtil().getEntityManager();
		Cliente cliente = new Cliente();
		cliente.setNome("Joaquim");
		
		Produto prod = new Produto();
		prod.setNome("Feijão");
		prod.setValor(5.60);
		
		ItemNota item = new ItemNota();
		item.setQtde(10);
		prod.getItens().add(item);
		
		NotaFiscal nota = new NotaFiscal();
		nota.setNumero(01);
		nota.getItens().add(item);
		
		cliente.getNotas().add(nota);
		
		manager.getTransaction().begin();
		manager.persist(prod);
		//manager.persist(item);
		//manager.persist(nota);
		manager.persist(cliente);
		manager.getTransaction().commit();
	}

}
