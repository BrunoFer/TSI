package br.edu.ifsudestemg.ssad.cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("p1");
	
	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
