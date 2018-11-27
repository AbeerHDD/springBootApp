<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Modifier le client ayant le cin = ${client.cin}</h1>
	<form action="CompteServlet" method="POST">

		<table>
			<tr>
				<td>Cin</td>
				<td><input type="hidden" name="rib" value="${client.cin}"></td>
			</tr>
			<tr>
				<td>nom</td>
				<td><input type="text" name="nom" value="${client.nom}"></td>
			</tr>
			<tr>
				<td>prenom</td>
				<td><input type="text" name="prenom" value="${client.prenom}"></td>
			</tr>
			<tr>
				<td>adresse</td>
				<td><input type="text" name="adresse" value="${client.adresse}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="action" value="update"></td>
			</tr>
		</table>

	</form>
	
</body>
</html>