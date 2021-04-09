package br.com.dell.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//static EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogodefilmes");
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
	
	public static EntityManager getEntituManager() {
		return emf.createEntityManager();
	}

}
