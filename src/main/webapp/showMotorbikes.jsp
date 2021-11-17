<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Show Motorbikes JSP</title>
</head>
<body>
<c:forEach items="${myList}" var="motorbike">
    Bike ID: <c:out value="${motorbike.motorbikeID }"/><br>
    Bike Name: <c:out value="${motorbike.email }"/><br>
    Bike Make: <c:out value="${motorbike.make}"/><br>
    Bike Model: <c:out value="${motorbike.model}"/><br>
    Bike CC: <c:out value="${motorbike.cc}"/><br>
</c:forEach>
</body>
</html>