<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>Alterar Fornecedor</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body class="blue lighten-5">
	<c:import url="header.jsp" />
	<div class="row center">
		<h1>Alterar Fornecedor</h1>
	</div>

	<h3 class="row center">
		Fornecedor selecionado: <b><%=session.getAttribute("user")%></b>
	</h3>
	<br>
	<br>
	<div class="container">
		<h4 <%=session.getAttribute("user")%>></h4>

		<form action="UpdateProvider" method="POST" class="center">


			<div class="input-field center">

				<input type="hidden" name="actualCnpj"
					value=<%=session.getAttribute("providerCnpj")%>> <br>
				<br> <br> <br>


				<div class="input-field center">
					CNPJ do Fornecedor <input type="text" name="cnpj"
						value=<%=session.getAttribute("providerCnpj")%>><br>

					<div class="input-field center">
						Nome do Fornecedor <input type="text" name="name"
							value=<%=session.getAttribute("user")%>><br> <br>
						<br> <br>
					</div>

					<div class="input-field center">
						Email do Fornecedor <input type="text" name="email"
							value=<%=session.getAttribute("providerEmail")%>><br>
						<br> <br> <br>
					</div>

					<div class="input-field center">
						Senha do Fornecedor <input type="text" name="password"
							value=<%=session.getAttribute("providerPassword")%>><br>
						<br> <br> <br>
					</div>

					<div class="input-field center">
						DDD do Fornecedor <input type="text" name="ddd"
							value=<%=session.getAttribute("providerDdd")%>><br>
						<br> <br> <br>
					</div>

					<div class="input-field center">
						Telefone do Fornecedor <input type="text" name="phone"
							value=<%=session.getAttribute("providerPhone")%>><br>
						<br> <br> <br>
					</div>

					<div class="input-field center">
						Endereço do Fornecedor <input type="text" name="adress"
							value=<%=session.getAttribute("providerAdress")%>><br>
						<br> <br> <br>
					</div>

					<div class="input-field center">
						Cidade do Fornecedor <input type="text" name="city"
							value=<%=session.getAttribute("providerCity")%>><br>
						<br> <br> <br>
					</div>

					<div class="input-field center">
						Estado do Fornecedor <input type="text" name="state"
							value=<%=session.getAttribute("providerState")%>><br>
						<br> <br> <br>
					</div>

					<div class="input-field center">
						CEP do Fornecedor <input type="text" name="zip"
							value=<%=session.getAttribute("providerZip")%>><br>
						<br> <br> <br>
					</div>


					<%
					String user = (String)session.getAttribute("userType");
					if(user.equals("manager")){ %>
					<div class="input-field center">
						<input type="checkbox" name="authorized" class="filled-in"
							id="filled-in-box" <%=session.getAttribute("authorized")%> /> <label
							for="filled-in-box">Fornecedor Autorizado</label> <br> <br>
						<br> <br>
					</div>
					<%}%>

					<button class="btn waves-effect waves-light" type="submit"
						name="action">Alterar</button>
				</div>
			</div>
				<br> <br>
		</form>
	</div>


</body>
</html>