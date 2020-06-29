<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Kaapeh - Editar</title>
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

	<%@include file="header.jsp" %>
	
	<section id="main" class="wrapper">
		<div class="inner">
			<header class="align-center">
				<h1>Editar trabajador</h1>
				<p>
					NOTA: La contraseña está cifrada, si desea cambiarla debe reemplazar todo el texto por la nueva contraseña. 
					Si no realiza cambios la contraseña actual se mantendrá.
				</p>
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
					<form:form action="saveUpdateWorker" modelAttribute="worker">
						<form:hidden path="id" />
						<form:hidden path="created" />
						<div class="row uniform">
							<div class="6u 12u$(xsmall)">
								<form:input path="email"  placeholder="Email" size="40"/>
								<form:errors path="email" cssClass="alert alert-danger"/>
							</div>
							<div class="6u$ 12u$(xsmall)">
						    	<form:input path="pwd" placeholder="Password" size="30"/>
								<form:errors path="pwd" cssClass="alert alert-danger"/>
							</div>
							<div class="6u 12u$(xsmall)">
								<form:input path="firstName"  placeholder="Primer nombre" size="20"/>
								<form:errors path="firstName" cssClass="alert alert-danger"/>
							</div>
							<div class="6u$ 12u$(xsmall)">
								<form:input path="secondName"  placeholder="Segundo nombre" size="20"/>
								<form:errors path="secondName" cssClass="alert alert-danger"/>
							</div>
							<div class="6u 12u$(xsmall)">
								<form:input path="lastName1"  placeholder="Apellido paterno" size="20"/>
								<form:errors path="lastName1" cssClass="alert alert-danger"/>
							</div>
							<div class="6u$ 12u$(xsmall)">
								<form:input path="lastName2"  placeholder="Apellido materno" size="20"/>
								<form:errors path="lastName2" cssClass="alert alert-danger"/>
							</div>
							<div class="12u$">
								<div class="select-wrapper">
									<form:select path="usertype">
										<form:option value="0" label="TIPO DE USUARIO"/>
                						<form:options items="${typesList}" />
									</form:select>
								</div>
								<form:errors path="usertype" cssClass="alert alert-danger"/>
							</div>
							<div class="12u$">
								<div class="select-wrapper">
									<form:select path="userarea">
										<form:option value="0" label="AREA"/>
                						<form:options items="${areasList}" />
									</form:select>
								</div>
								<form:errors path="userarea" cssClass="alert alert-danger"/>
							</div>
							<div class="6u 12u$(small)">
								<form:checkbox path="vigent" label="Activo"/>
								<form:errors path="vigent" cssClass="alert alert-danger"/>
							</div>
							<div class="12u$">
								<ul class="actions">
									<li><input type="submit" value="Realizar cambios" /></li>
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