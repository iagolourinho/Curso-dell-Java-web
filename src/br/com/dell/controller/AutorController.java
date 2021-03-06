package br.com.dell.controller;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.dell.model.Autor;
import br.com.dell.util.JPAUtil;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class AutorController {
	
	@RequestMapping(value = "/consultar-autor", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Autor consultarAutor(@RequestParam Integer id) {
		EntityManager entityManager = JPAUtil.getEntituManager();

		Autor autores = entityManager.find(Autor.class, id);
		
		return autores;
	}

}
