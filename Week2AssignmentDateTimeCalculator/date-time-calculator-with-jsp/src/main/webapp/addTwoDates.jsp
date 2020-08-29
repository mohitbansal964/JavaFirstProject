<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Two Dates</title>
</head>
<body>
	<h2>Add Two Dates</h2>
	<h3>Result:</h3>
	<table>
		<tbdody>
		<tr>
			<td>Number of Days</td>
			<td>${output.getNumberOfDays()}</td>
		</tr>
		<tr>
			<td>Number of Weeks</td>
			<td>${output.getNumberOfWeeks()}</td>
		</tr>
		<tr>
			<td>Number of Months</td>
			<td>${output.getNumberOfMonths()}</td>
		</tr>
		<tr>
			<td>Number of Years</td>
			<td>${output.getNumberOfYears()}</td>
		</tr>
		</tbdody>
	</table>
	
	<a href="<%=request.getContextPath()%>/menu">Back to menu</a>
</body>
</html>