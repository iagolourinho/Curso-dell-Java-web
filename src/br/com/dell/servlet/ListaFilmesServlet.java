package br.com.dell.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dell.model.Filmes;
import br.com.dell.util.JPAUtil;

@WebServlet("/filmes")
public class ListaFilmesServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Filmes coringa = new Filmes("Coringa", "Drama", 2019); Filmes matrix = new
		 * Filmes("Matrix", "Acao", 2020);
		 * 
		 * ArrayList<Filmes> filmes = new ArrayList<Filmes>();
		 * 
		 * filmes.add(coringa); filmes.add(matrix);
		 * 
		 * 
		 * String nome = req.getParameter("nome"); String genero =
		 * req.getParameter("genero"); String ano = req.getParameter("ano");
		 */
		EntityManager em = JPAUtil.getEntituManager();
		
		em.getTransaction().begin();
		
		Filmes filme = em.find(Filmes.class, 1);
		
		em.close();
		
		/*
		 * resp.setContentType("text/html"); PrintWriter out = resp.getWriter();
		 * 
		 * out.println("<h2> Lista de Filmes , utilizando Servlet </h2>");
		 * out.println("<ol>");
		 * 
		 * 
		 * filmes.stream().filter(filme ->
		 * filme.getGenero().toUpperCase().equals(genero.toUpperCase())).forEach(filme
		 * -> { out.println(String.format("<li>Nome %s", filme.getNome()));
		 * out.println(String.format("Gênero %s", filme.getGenero()));
		 * out.println(String.format("Ano %s</li>", filme.getAno())); });
		 * 
		 * out.println("</ol>"); out.close();
		 */
		
		

		/*
		 * ArrayList<Filmes> listaFiltrada = filmes.stream() .filter(filme ->
		 * filme.getNome().toUpperCase().equals(nome.toUpperCase())) .filter(filme ->
		 * filme.getGenero().toUpperCase().equals(genero.toUpperCase())) .filter(filme
		 * -> filme.getAno().toString().equals(ano))
		 * .collect(Collectors.toCollection(ArrayList::new));
		 */
		ArrayList<Filmes> listaFiltrada = new ArrayList<Filmes>();
		listaFiltrada.add(filme);
		
		req.setAttribute("listaFiltrada", listaFiltrada);
		
		//RequestDispatcher dispacther = req.getRequestDispatcher("/ListaFilmes.jsp");
		RequestDispatcher dispacther = req.getRequestDispatcher("/InfoFilme.jsp");
		dispacther.forward(req, resp);
	}

}
