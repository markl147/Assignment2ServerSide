<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 18/11/2021
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show all Users</title>
</head>
<body>
<h1>Here is a list of all users in the database</h1>
<c:forEach items="${myUserList}" var="user">
<%--  User ID: <c:out value="${user.id }"/><br>--%>
  User Name: <c:out value="${user.name}"/><br>
  User Email: <c:out value="${user.email}"/><br><br>
</c:forEach>
</body>
</html>
