package br.com.dell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringController {
	
	@RequestMapping("adicionaFilme")
	@ResponseBody
	public String adicionarFilme(String nome,String genero,Integer ano) {
		String resposta = "Nome Filme:"+ nome + "Genero" + genero + "Ano" + ano;
		return resposta;
		
	}

}
