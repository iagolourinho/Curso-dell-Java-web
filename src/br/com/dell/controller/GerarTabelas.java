package br.com.dell.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas {
	public static void main(String[] args) {
		
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("h2");
			factory.close();
			System.out.println("Tabelas geradas com sucesso !!!");
		} catch (Exception e) {
			System.out.println("Erro ao gerar as tabelas !!! Verificar as entidades !!!");
			e.printStackTrace();
		}
	}
}