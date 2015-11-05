
<nav class="light-blue lighten-1" role="navigation">
	<div class="nav-wrapper container">
		<a id="logo-container" href="/SisCot" class="brand-logo">SisCot</a>
		<ul class="right hide-on-med-and-down ">
			<%
				if (session.getAttribute("user") != null) {
					String user = (String) session.getAttribute("userType");
					if (user.equals("manager")) {
			%>
			<li><a class="tooltipped" data-position="bottom" data-delay="50"
				data-tooltip="Consultar Fornecedores" href="/SisCot/ConsultProvider">Fornecedores</a></li>
			<%
				
			%>
			<li><a class="tooltipped" data-position="bottom" data-delay="50"
				data-tooltip="Consultar Cota��es"
				href="/SisCot/ConsultQuotationManager">Cota��es</a></li>
			<%
				}
			%>
			<li><a class="tooltipped" data-position="bottom" data-delay="50"
				data-tooltip="Consultar Produtos" href="/SisCot/ConsultProduct">Produtos</a></li>
			<%
				}
			%>
			<%
				if (session.getAttribute("user") != null) {
					String user = (String) session.getAttribute("userType");
					if (user.equals("provider")) {
			%>
			<li><a class="tooltipped" data-position="bottom" data-delay="50"
				data-tooltip="Consultar Cota��es"
				href="/SisCot/ConsultQuotationProvider">Cota��es</a></li>
			<li><a class="tooltipped" data-position="bottom" data-delay="50"
				data-tooltip="Atualizar Dados" href="/SisCot/UpdateProviderView.jsp">
					Ol� <%=session.getAttribute("user")%>
			</a></li>
			<%
				} else {
			%>
			<li>Ol� <%=session.getAttribute("user")%></li>
			<%
				}
			%>
			<li><a class="tooltipped" data-position="bottom" data-delay="50"
				data-tooltip="Sair do Sistema" href="/SisCot/Logout">Logout</a></li>
			<%
				} else {
			%>
			<li><a href="/SisCot/login.jsp">Fazer Login</a></li>
			<%
				}
			%>
		</ul>
		<ul id="nav-mobile" class="side-nav">
		</ul>
		<a href="#" data-activates="nav-mobile" class="button-collapse"><i
			class="material-icons">menu</i></a>
	</div>
</nav>

<!-- ================================================
    Scripts
    ================================================ -->

<!-- jQuery Library -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<!--materialize js-->
<script type="text/javascript" src="js/materialize.js"></script>
