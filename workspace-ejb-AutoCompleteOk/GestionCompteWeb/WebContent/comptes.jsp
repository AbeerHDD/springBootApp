<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/jquery-ui.min.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajout de compte bancaire</h1>
	<form action="CompteServlet" method="POST">

		<table>
			<tr>
				<td>Client</td>
				<td><input id="client" type="text" name="client"> <input
					id="cin" type="hidden" name="cin"></td>
				<td>Solde</td>
				<td><input type="text" name="solde"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="action" value="add"
					class="btn btn-primary"></td>
			</tr>
		</table>

	</form>
	<h1>Liste des comptes</h1>
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Rib</th>
				<th scope="col">Client</th>
				<th scope="col">Solde</th>
				<th scope="col">Delete</th>
				<th scope="col">Edit</th>
			</tr>
		</thead>
		<c:forEach items="${comptes}" var="compte">
			<tr id="tr${compte.rib}">
				<td>${compte.rib}</td>
				<td>${compte.client.prenom} ${compte.client.nom}</td>
				<td>${compte.solde}</td>
				<td><a href="#" onclick="deleteCompte(${compte.rib})">delete</a></td>
				<td><form action="CompteServlet" method="POST">
						<input type="hidden" name="rib" value="${compte.rib}"> <input
							type="submit" name="action" value="edit" class="btn btn-danger">
					</form></td>
			</tr>
		</c:forEach>
	</table>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<script src="js/sweetalert.min.js"></script>

	<script src="js/jquery-ui.min.js"></script>

	<script src="js/comptes.js"></script>

	<script>
	 var availableClients;
	$( document ).ready(function() {
		 getAllDtos();
	
		 function getAllDtos(){
		    	$.ajax({
		    		url : "ClientServlet",
		    		type : "GET",
		    		data : {
		    			action : "getDto",
		    		},
		    		async:false,
		    		success : function(data) {
		    			availableClients =  $.parseJSON("["+ data + "]");
		    		},
		    		error : function() {
		    			swal("Poof! server error!", {
		    			      icon: "error",
		    			    });
		    		}
		    	});
		    }
		 
			    $( "#client" ).autocomplete({
			      source: availableClients,
			      select: function (event, ui) {
			    	  $("#cin").val(ui.item.id); 
			      }
			    });
			   
	});	
	

  </script>


</body>
</html>