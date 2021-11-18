<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Show User JSP</title>
</head>
<body>
<%--   User Name: <c:out value="${sessionScope.User.name}"/><br>--%>
<%--   User Email: <c:out value="${sessionScope.User.email}"/><br>--%>

   <h1>Welcome ${sessionScope.User.name}</h1>
   <br>
   <br>
<form>
    <table>
        <tr>
            <td>Make</td>
            <td><input type = "text" name="make"></td>
        </tr>
        <tr>
            <td>Model</td>
            <td><input type = "text" name="model"></td>
        </tr>
        <tr>
            <td>CC</td>
            <td><input type = "text" name="CC"></td>
        </tr>
        <tr>
            <td><button type = "submit" formmethod="controller here" formaction="post">Create</button></td>
            <td><button type = "submit" formmethod="post" formaction="MotorbikeController">Show users bikes</button></td>
            <td><button type = "submit" formmethod="post" formaction="AllMotorbikeController">Show all bikes</button></td>
            <td><button type = "submit" formmethod="controller here" formaction="post">Update</button></td>
            <td><button type = "submit" formmethod="controller here" formaction="post">Delete</button></td>
        </tr>
    </table>
</form>

</body>
</html>
















<%--<c:forEach items="${userList}" var="user">--%>

<%--User Password: <c:out value="${myUser.password}"/><br>
<%--</c:forEach>--%>
<%--<c:set var="email" value="${email}" scope="session"/>--%>
<%--<c:set var="name" value="${name}" scope="session"/>--%>
<%--<c:set var="password" value="${password}" scope="session"/>--%>