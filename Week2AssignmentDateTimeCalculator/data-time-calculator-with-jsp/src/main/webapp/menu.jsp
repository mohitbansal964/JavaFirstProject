<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator Input</title>
</head>
<body>
	<h3>Menu</h3>
	<form action="menu" method="post">
		<c:forEach var="choice" items="${choicesList}" varStatus="loop">
			<input type="radio" name="choice" value="${loop.index }"> ${choice} <br />
		</c:forEach>
		
		<input type="submit">
	</form>
</body>
</html>