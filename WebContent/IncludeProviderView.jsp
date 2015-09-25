<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>Cadastrar Fornecedor</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body class="yellow lighten-5">

	<c:import url="header.jsp" />
	<div class="row center">
		<h1>Cadastro de Fornecedores</h1>
	</div>

	 <div class="container">
	<form action="IncludeProvider" method="POST" class="center">
		
		<div class="input-field center">
		CNPJ do Fornecedor
		<textarea id="textarea1" class="materialize-textarea" length="120" type="textarea1" name="cnpj" >
		</textarea><br>
			
		<div class="input-field center">
		Nome do Fornecedor
		<input type="text" name="name" /><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Email do Fornecedor
		<input type="text" name="email" /><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Senha do Fornecedor
		<input type="text" name="password" /><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		DDD do Fornecedor
		<input type="text" name="ddd" /><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Telefone do Fornecedor
		<input type="text" name="phone" /><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Endereço do Fornecedor
		<input type="text" name="adress" /><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Cidade do Fornecedor
		<input type="text" name="city" /><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		Estado do Fornecedor
		<input type="text" name="state" /><br><br><br><br>
		</div>
		
		<div class="input-field center"> 
		CEP do Fornecedor
		<input type="text" name="zip" /><br><br><br><br>
		</div>
		
		<button class="btn waves-effect waves-light" type="submit" name="action">Cadastrar 			
		</button>
		<br><br>
	</form>
	</div>
	

</body>
</html>