<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Input - <c:out value="${choice}"></c:out></h3>
	<form action="input/${choiceIndex}" method="post">
	<input type="hidden" name="choiceIndex" value="${choiceIndex }">
		<label for="date1">Date 1 (dd-mm-yyyy hh:mm:ss) </label> 
		<input type="text" id="date1" name="date1" value=""> <br/>
		<c:if test="${date2}">
			<label for="date2">Date 2 (dd-mm-yyyy hh:mm:ss) </label> 
			<input type="text" id="date2" name="date2" value=""><br/>
		</c:if>
		<c:if test="${date3}">
			<label for="noOfDays">No. of Days</label> 
			<input type="text" id="noOfDays" name="noOfDays" value="0"><br/>
			<label for="noOfWeeks">No. of Weeks</label> 
			<input type="text" id="noOfWeeks" name="noOfWeeks" value="0"><br/>
			<label for="noOfMonths">No. of Months</label> 
			<input type="text" id="noOfMonths" name="noOfMonths" value="0"><br/>
			<label for="noOfYears">No. of Years</label>
			<input type="text" id="noOfYears" name="noOfYears" value="0"><br/> 
		</c:if>
		<br/> <input type="submit" />
	</form>
</body>
</html>