<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajout de compte bancaire</h1>
	<form action="ClientServlet" method="POST">

		<table>
			<tr>
				<td>cin</td>
				<td><input type="text" name="cin"></td>
			</tr>
			<tr>
				<td>nom</td>
				<td><input type="text" name="nom"></td>
			</tr>
			<tr>
				<td>prenom</td>
				<td><input type="text" name="prenom"></td>
			</tr>
			<tr>
				<td>adresse</td>
				<td><input type="text" name="adresse"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="action" value="add"
					class="btn btn-primary"></td>
			</tr>
		</table>

	</form>
	<h1>Liste des clients</h1>
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Cin</th>
				<th scope="col">Nom</th>
				<th scope="col">Prenom</th>
				<th scope="col">Adresse</th>
				<th scope="col">Delete</th>
				<th scope="col">Edit</th>
			</tr>
		</thead>
		<c:forEach items="${clients}" var="client">
			<tr id="tr${client.cin}">
				<td>${client.cin}</td>
				<td>${client.nom}</td>
				<td>${client.prenom}</td>
				<td>${client.adresse}</td>
				<td><a href="#" onclick="deleteClient(${client.cin})">delete</a></td>
				<td><form action="ClientServlet" method="POST">
						<input type="hidden" name="cin" value="${client.cin}"> <input
							type="submit" name="action" value="edit" class="btn btn-danger">
					</form></td>
			</tr>
		</c:forEach>
	</table>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<script src="js/sweetalert.min.js"></script>

	<script src="js/clients.js"></script>

</body>
</html>