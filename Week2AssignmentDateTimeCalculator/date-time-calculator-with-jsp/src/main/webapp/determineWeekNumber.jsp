<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Determine Week Number</title>
</head>
<body>
	<h2>Determine Week Number</h2>
	<h3>Result: <c:out value="${output}"></c:out> </h3>
	<a href="<%=request.getContextPath()%>/menu">Back to menu</a>
</body>
</html>