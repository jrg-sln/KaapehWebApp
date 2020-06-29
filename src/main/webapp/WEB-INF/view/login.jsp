<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Kaapeh - Iniciar sesi&oacute;n</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/css/main.css" />
	
	<script type="text/javascript">
		window.setTimeout(function() {
	    	$(".alert").fadeTo(500, 0).slideUp(500, function(){
	        	$(this).remove(); 
	    	});
		}, 2000);
	</script>
</head><%@page isELIgnored="false" %>
<body class="subpage">

	<!-- Header -->
	<header id="header">
		<a href="home" class="logo">Kaapeh</a>
	</header>
	
	<section id="main" class="wrapper">
		<div class="inner">
			<header class="align-center">
				<h1>Iniciar sesi&oacute;n</h1>
				<!-- <p>Favor de ingresar los siguientes datos </p> -->
			</header>
			<div class="row 200%">
				<div class="12u">
					<c:if test="${not empty message}">
						<div class="alert alert-danger" role="alert">
  							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
  								<span aria-hidden="true">&times;</span>
  							</button>
							<strong>Error</strong> ${message}
						</div>
			      	</c:if>
					<form:form action="login" modelAttribute="userForm">
						<div class="row uniform">
							<div class="6u$ 12u$(xsmall)">
								<form:input path="email"  placeholder="Email" size="40"/>
								<form:errors path="email" cssClass="alert alert-danger"/>
							</div>
							<div class="6u$ 12u$(xsmall)">
								<form:password path="password" placeholder="Password" size="30"/>
								<form:errors path="password" cssClass="alert alert-danger"/>
							</div>
							<div class="12u$">
								<ul class="actions">
									<li><input type="submit" value="Iniciar" /></li>
									<li><input type="reset" value="Limpiar" class="alt" /></li>
								</ul>
							</div>
						</div>
					</form:form>
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