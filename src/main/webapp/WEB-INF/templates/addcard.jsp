<%@ taglib prefix="form" uri= "http://www.springframework.org/tags/form" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Card info</title>
</head>
<body>
<h2>Add card</h2>

<br>
<form:form action="addCard" modelAttribute="card">
CARDNUMBER : <form:input path="cardNumber"/>
PANNUMBER : <form:input path="panNumber"/>
ISSUEDDATE : <form:input type="date" path="issuedDate" />
    <input type="submit" value="Add Card">
</form:form>
</body>
</html>