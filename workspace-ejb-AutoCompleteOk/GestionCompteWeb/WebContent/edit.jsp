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
	<h1>Modifier le compte bancaire ayant le rib = ${compte.rib}</h1>
	<form action="CompteServlet" method="POST">

		<table>
			<tr>
				<td>Rib</td>
				<td><input type="hidden" name="rib" value="${compte.rib}"></td>
			</tr>
			<tr>
				<td>Client</td>
				<td><input type="text" name="client" value="${compte.client}"></td>
			</tr>
			<tr>
				<td>Solde</td>
				<td><input type="text" name="solde" value="${compte.solde}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="action" value="update"></td>
			</tr>
		</table>

	</form>
	
</body>
</html>