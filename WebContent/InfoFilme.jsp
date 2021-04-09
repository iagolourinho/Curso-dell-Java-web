<%@page import="br.com.dell.model.Filmes"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Filmes</title>
</head>
<body>
	<h2>Lista de Filmes</h2>
	<ol>
		<%
			ArrayList<Filmes> list = new ArrayList<Filmes>();
			
			list = (ArrayList<Filmes>) request.getAttribute("listaFiltrada");
			
			for(Filmes filmes : list) {
				
		%>
		
		<li>
			<%
				out.println("Nome:" + filmes.getNome()+ "<br/>");
				out.println("Genero:" + filmes.getGenero()+ "<br/>");
				out.println("Ano:" + filmes.getAno()+ "<br/>");
			%></br>
		</li></br>
		
		<%
			}		
		%>	</br>
	</ol></br>
</body>
</html>