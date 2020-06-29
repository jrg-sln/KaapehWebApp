<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Kaapeh - Accesos</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/fixedheader/3.1.7/css/fixedHeader.bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.5/css/responsive.bootstrap.min.css">
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
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
				<h1>Lista de accesos</h1>
				<!-- <p>Datos del trabajador</p> -->
				<hr />
			</header>
			<div class="row 200%">
				<div class="12u">
					<c:if test="${not empty message}">
						<div class="alert alert-success" role="alert">
  							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
  								<span aria-hidden="true">&times;</span>
  							</button>
							<strong>${message}</strong>
						</div>
			      	</c:if>
					<div class="table-wrapper">
						<table id="example" class="table table-striped table-bordered nowrap" style="width:100%">
							<thead>
								<tr>
									<th>IP</th>
									<th>Fecha</th>
									<th>Correo</th>
									<th>Recurso</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="access" items="${accessLog}">
									<tr>
										<td>${access.ip_address}</td>
										<td>${access.date_access}</td>
										<td>${access.email}</td>
										<td>${access.resource}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
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
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap.min.js"></script>
	<script src="https://cdn.datatables.net/fixedheader/3.1.7/js/dataTables.fixedHeader.min.js"></script>
	<script src="https://cdn.datatables.net/responsive/2.2.5/js/dataTables.responsive.min.js"></script>
	<script src="https://cdn.datatables.net/responsive/2.2.5/js/responsive.bootstrap.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
		    var table = $('#example').DataTable( {
		        responsive: true
		    } );
		 
		    new $.fn.dataTable.FixedHeader( table );
		} );
	</script>
</body>
</html>