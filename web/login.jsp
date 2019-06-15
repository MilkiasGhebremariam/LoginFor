<%--
  Created by IntelliJ IDEA.
  User: milkias
  Date: 2019-06-13
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGING FORM</title>
</head>
<body>
<form action="login" method="post">
    <fieldset>
        <legend>USER FORM</legend>
        <legend>User Name:<input type="text" name="username" > </legend>
        <legend>Password :<input type="password" name="userpassword" > </legend>

        <legend> <label><input type="checkbox" name="rememberme"  ${rememberme} />Remember me?</label></legend>
        <legend> <label>Login<input type="submit" name="submit"></label></legend>

    </fieldset>
</form>
</body>
</html>
