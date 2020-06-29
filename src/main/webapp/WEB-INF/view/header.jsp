	<%
		String user = (String) session.getAttribute("user");
		Integer type = (Integer) session.getAttribute("type");
	%>
	<!-- Header -->
	<header id="header">
		<nav class="left">
			<a href="#menu"><span>Men&uacute;</span></a>
		</nav>
		<a href="home" class="logo">Kaapeh</a>
		<nav class="right">
			<% if (user == null) { %>
				<a href="login" class="button alt">Iniciar sesi&oacute;n</a>
			<%} else {%>
				<a href="logout" class="button alt">Cerrar sesi&oacute;n</a>
				<h6><%=user %></h6>
			<%} %>
		</nav>
	</header>

	<!-- Menu -->
	<nav id="menu">
		<ul class="links">
			<li><a href="home">Home</a></li>
			<% if (user != null) { %>
				<li><a href="listWorkers">Lista de trabajadores</a></li>
				<% if (type == 1) { %>
					<li><a href="log">Lista de accesos</a></li>
				<%} %>
			<%} %>
		</ul>
		<!-- <ul class="actions vertical">
			<li><a href="#" class="button fit">Login</a></li>
		</ul> -->
	</nav>