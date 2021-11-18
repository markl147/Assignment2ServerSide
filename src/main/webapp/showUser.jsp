<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Show User</title>
</head>
<body>
<%--   User Name: <c:out value="${sessionScope.User.name}"/><br>--%>
<%--   User Email: <c:out value="${sessionScope.User.email}"/><br>--%>

   <h1>Welcome ${sessionScope.User.name}</h1>
<form>
    <table>
        <tr>
            <td><input type = "hidden" name="email" value="${sessionScope.User.email}"></td>
        </tr>

        <tr>
            <td><button type = "submit" formmethod="post" formaction="MotorbikeController">Show users bikes</button></td>
            <td><button type = "submit" formmethod="post" formaction="AllMotorbikeController">Show all bikes</button></td>
        </tr>

        <tr>
            <td><button type = "submit" formmethod="post" formaction="ShowAllUsersController">Show all users</button></td>
            <td><button type = "submit" formmethod="post" formaction="createMotorbike.jsp">Create new</button></td>
        </tr>

        <tr>
            <td><button type = "submit" formmethod="post" formaction="updateMotorbike.jsp">Update</button></td>
            <td><button type = "submit" formmethod="post" formaction="deleteMotorbike.jsp">Delete</button></td>
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