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
		<h1>Alterar Fornecedor</h1>
	</div>
	
	<h3 class="row center">Fornecedor selecionado: <b><%= request.getParameter("providerName") %></h3><br><br>
	 <div class="container">
	 <h4 <%= request.getParameter("ProviderName") %>></h4>
	 
	<form action="UpdateProvider" method="POST" class="center">
		
		
		<div class="input-field center"> 

		<input type="hidden" name="actualCnpj" value=<%= request.getParameter("providerCnpj") %>>
		  <br><br><br><br>
		
		
		<div class="input-field center">
		CNPJ do Fornecedor
		<textarea id="textarea1" class="materialize-textarea" length="120" type="textarea1" name="cnpj"
		value=<%= request.getParameter("providerCnpj") %> >
		</textarea><br>
			
		<div class="input-field center">
		Nome do Fornecedor
		<input type="text" name="name" value=<%= request.getParameter("providerName") %>><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Email do Fornecedor
		<input type="text" name="email" value=<%= request.getParameter("providerEmail") %>><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Senha do Fornecedor
		<input type="text" name="password" value=<%= request.getParameter("providerPassword") %>><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		DDD do Fornecedor
		<input type="text" name="ddd" value=<%= request.getParameter("providerDdd") %>><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Telefone do Fornecedor
		<input type="text" name="phone" value=<%= request.getParameter("providerPhone") %>><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Endereço do Fornecedor
		<input type="text" name="adress" value=<%= request.getParameter("providerAdress") %>><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Cidade do Fornecedor
		<input type="text" name="city" value=<%= request.getParameter("providerCity") %>><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Estado do Fornecedor
		<input type="text" name="state" value=<%= request.getParameter("providerState") %>><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		CEP do Fornecedor
		<input type="text" name="zip" value=<%= request.getParameter("providerZip") %>><br><br><br><br>
		</div>
		
		<button class="btn waves-effect waves-light" type="submit" name="action">Alterar			
		</button>
		</div>
		<br>
		<br>
	</form>
	</div>
	

</body>
</html>