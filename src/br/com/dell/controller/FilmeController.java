package br.com.dell.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.dell.model.Autor;
import br.com.dell.model.Filmes;
import br.com.dell.util.JPAUtil;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@Controller
public class FilmeController {
	
	@RequestMapping(value = "/persistir-filme", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Filmes persistirFilme(@RequestBody Filmes filme) {

		EntityManager em = JPAUtil.getEntituManager();
		
		em.getTransaction().begin();
		
		em.persist(filme.getAutor());
		em.persist(filme);
		
		em.getTransaction().commit();
		
		em.close();

		return filme;
		
	}
	
	@RequestMapping(value = "/consulta-filme",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public Filmes consultaFilme(@RequestParam Integer id) {
		
		EntityManager entityManager = JPAUtil.getEntituManager();
		
		Filmes filme = entityManager.find(Filmes.class, id);
		
		return filme;
		
		
		
	}

}
