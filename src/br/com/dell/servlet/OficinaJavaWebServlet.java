package br.com.dell.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dell.model.Filmes;

@WebServlet(urlPatterns = "/oficina-filme")
public class OficinaJavaWebServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Filmes jesus = new Filmes("Jesus Cristo", "Religião", 1992);
			Filmes Jose = new Filmes("São José", "Religião", 2020);
			Filmes Bento = new Filmes("São Bento", "Religião", 2021);
			
			ArrayList<Filmes> filmes = new ArrayList<Filmes>();
			
			filmes.add(Bento);
			filmes.add(Jose);
			filmes.add(jesus);
			
			String ano = req.getParameter("ano");
			
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			out.println("<h2> Lista de Filmes </h2>");
			
			out.println("<ol>");
			
			filmes.stream().filter(filme -> filme.getAno().toString().equals(ano.toString())).forEach(filme -> {
				out.println(String.format("<li> Nome: %s", filme.getNome()));
				out.println(String.format(" Genero: %s", filme.getGenero()));
				out.println(String.format(" Ano: %s</li>", filme.getAno()));
			});
			out.println("</ol>");
			out.close();
			
			
		}
	
}
