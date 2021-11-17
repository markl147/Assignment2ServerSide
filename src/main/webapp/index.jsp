<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Index JSP</title>
</head>
<body>
<form method="post" action="UserController">
    Email: <input type="email" name="userEmail"/><br>
    Password: <input type="text" name="userPassword"/><br>
    <input type="submit" value="Login"/>
</form>
<c:set var="email" value="${email}" scope="session"/>
<c:set var="name" value="${name}" scope="session"/>
</body>
</html>