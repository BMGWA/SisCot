<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Starter Template - Materialize</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Produto</title>
</head>
<body>

	<c:import url="header.jsp" />
	<h1>Cadastro do Produtos</h1>
		
	<form action="IncludeProduct" method="POST">
	
		
		Nome do Produto: <input type="text" name="name" /><br>
		Descrição do Produto: <input type="text" name="description" /><br>
				     
      	<input type="submit" value="Gravar" />
	
	</form>
	
</body>
</html>