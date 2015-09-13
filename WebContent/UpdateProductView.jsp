<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>Alterar Produto</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<c:import url="header.jsp" />
	<div class="row center">
		<h1>Alterar Produtos</h1>
	</div>
	
	<h3 class="row center">Produto selecionado: <b><%= request.getParameter("productName") %></h3><br><br>
	 <div class="container">
	 <h4 <%= request.getParameter("ProductName") %>></h4>
	 
	<form action="UpdateProduct" method="POST" class="center">
		
		
		<div class="input-field center"> 

		
		Nome do Produto
		<input type="text" name="actualName" value = <%= request.getParameter("productName") %>><br><br><br><br>
		
		
		Novo nome do produtp
		<input type="text" name="name" ><br><br><br><br>
		</div>
		
		Descrição do Produto 
		<textarea id="textarea1" class="materialize-textarea" length="120" type="textarea1" name="description" >
		</textarea><br>
		
		
		
		<button class="btn waves-effect waves-light" type="submit" name="action">Alterar			
		</button>
		</div>
		<br>
		<br>
	</form>
	</div>
	

</body>
</html>