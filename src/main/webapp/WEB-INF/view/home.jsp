<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Kaapeh - Inicio</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="resources/css/main.css" />
</head><%@page isELIgnored="false" %>
<body>

	<%@ include file="header.jsp" %>

	<!-- Banner -->
	<section id="banner">
		<div class="content">
			<h1>Proyecto final</h1>
			<p>Desarrollo de aplicaciones WEB basadas en Frameworks de Java</p>
			<ul class="actions">
				<li><a href="#one" class="button scrolly">Descripción</a></li>
			</ul>
		</div>
	</section>

	<!-- One -->
	<section id="one" class="wrapper style1 special">
		<div class="inner">
			<h2>Control de asistencia</h2>
			<figure>
			    <blockquote>
			        El objetivo de la aplicación es llevar el control de asistencia de los trabajadores de una empresa.
			    </blockquote>
			    <footer>
			        <cite class="author">Jorge Solano</cite>
			        <cite class="company">IIMAS - UNAM</cite>
			    </footer>
			</figure>
		</div>
	</section>
	
	<!-- Two -->
	<section id="two" class="wrapper">
		<div class="inner flex flex-3">
			<div class="flex-item left">
				<div>
					<h3>Inicio de sesión</h3>
					<p>Manejo de inicio y cierre de sesi&oacute;n<br /> con perfiles de administrador y usuario.</p>
				</div>
				<div>
					<h3>Bit&aacute;cora de acceso</h3>
					<p>Almacena en base de datos IP, recurso, <br /> fecha y usuario que accede al sitio.</p>
				</div>
			</div>
			<div class="flex-item image fit round">
				<img src="resources/images/pic01.jpg" alt="" />
			</div>
			<div class="flex-item right">
				<div>
					<h3>Registro de usuarios</h3>
					<p>Permite operaciones CRUD <br /> sobre las tablas de usuario y trabajador.</p>
				</div>
				<div>
					<h3>Registro de asistencia</h3>
					<p>Permite operación CR <br /> en la tabla de asistencia.</p>
				</div>
			</div>
		</div>
	</section>

	<%@include file="footer.jsp" %>

	<!-- Scripts -->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/jquery.scrolly.min.js"></script>
	<script src="resources/js/skel.min.js"></script>
	<script src="resources/js/util.js"></script>
	<script src="resources/js/main.js"></script>
</body>
</html>