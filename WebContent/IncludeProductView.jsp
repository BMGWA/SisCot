<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Produto</title>
</head>
<body>
	<h1>Cadastro do Produtos</h1>
	
	
	<form action="IncludeProduct" method="POST">
		Nome do Produto: <input type="text" name="name" /><br>
		Descrição do Produto: <input type="text" name="description" /><br>
				     
      	<input type="submit" value="Gravar" />
	
	</form>
</body>
</html>