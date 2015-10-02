<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>Criar Novo Pregão</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  Scripts-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="../../bin/materialize.js"></script>
<script src="js/init.js"></script>
</head>
<body class="blue lighten-5">

	<c:import url="header.jsp" />
	<br>
	<br>
	<br>
	<br>

	<div class="row center">
		<h1>Criar Pregao</h1>
	</div>


	<div class="row center"></div>

	<div class="container">
		<form action="IncludePregao" method="POST" class="center">

			<div class="input-field center">
			Nome do Gerente
			<input type = "text" name="managerName" /><br><br><br><br>
			</div><br>
			
			<div class="input-field center">
			Data do Pregão
			<input type="text" name="date" /><br><br><br><br>
			</div>
			
			<button class="btn waves-effect waves-light" type="submit" name="action">Cadastrar 			
		</button>
		<br><br>

		</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:import url="footer.jsp" />
</body>
</html>