package br.com.dell.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dell.model.Autor;
import br.com.dell.model.Filmes;
import br.com.dell.util.JPAUtil;

//@WebServlet("/persistir-filme")
public class PersistenciaFilmeServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String genero = req.getParameter("genero");
		Integer ano = Integer.valueOf(req.getParameter("ano"));
		
		String NomeAutor =req.getParameter("nomeautor");
		LocalDate DataNacismentoAutor = LocalDate.parse(req.getParameter("datanascimentoautor"));
		
		Autor autor = new Autor();
		autor.setNome(NomeAutor);
		autor.setDatanascimento(DataNacismentoAutor);
		
		Filmes filme = new Filmes(nome,genero,ano);
		filme.setAutor(autor);
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogodefilmes");
		//EntityManager em = emf.createEntityManager();
		
		EntityManager em = JPAUtil.getEntituManager();
		
		em.getTransaction().begin();
		
		em.persist(autor);
		em.persist(filme);
		
		em.getTransaction().commit();
		
		em.close();
		//emf.close();
	}
	
}
