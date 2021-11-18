<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 18/11/2021
  Time: 02:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete JSP</title>
</head>
<body>
<h1>Please ensure the id of the bike you are trying to delete is correct</h1>

<form method="post" action="DeleteMotorbike">
    Motorbike ID: <input type="text" name="motorbikeID"/><br>
    Email: <input readonly name="motorbikeEmail" value="${sessionScope.User.email}"/><br>
    <input type="submit" value="Delete"/>
</form>
</body>
</html>
