<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register JSP</title>
</head>
<body>

<h1>Your email is not recognized, please register</h1><br>
<form method="post" action="RegisterController">
    Email: <input type="email" name="userEmail"/><br>
    Name: <input type="text" name="userName"/><br>
    Password: <input type="text" name="userPassword"/><br>
    <input type="submit" value="Register"/>
</form>
</body>
</html>

<%--<form method="post" action="MotorbikeController">--%>
<%--    Name: <input type="text" name="bikeName"/><br>--%>
<%--    Make: <input type="text" name="bikeName"/><br>--%>
<%--    Model: <input type="text" name="bikeModel"/><br>--%>
<%--    CC: <input type="text" name="bikeCc"/><br>--%>
<%--    <input type="submit" value="show motorbikes"/>--%>
<%--</form>--%>