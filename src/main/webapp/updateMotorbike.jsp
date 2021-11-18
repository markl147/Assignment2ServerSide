<%--
  Created by IntelliJ IDEA.
  User: Mark
  Date: 18/11/2021
  Time: 01:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Motorbike JSP</title>
</head>
<body>

<h1>Please ensure the id of the bike you are trying to update is correct</h1>

<form method="post" action="UpdateMotorbike">
    Motorbike ID: <input type="text" name="motorbikeID"/><br>
    Email: <input readonly name="motorbikeEmail" value="${sessionScope.User.email}"/><br>
    Make: <input type="text" name="motorbikeMake"/><br>
    Model: <input type="text" name="motorbikeModel"/><br>
    CC: <input type="text" name="motorbikeCc"/><br>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
