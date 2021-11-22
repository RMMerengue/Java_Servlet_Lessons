<%--
  Created by IntelliJ IDEA.
  User: 王天语
  Date: 2021/11/1
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action = "response" method = "get">
        UserName:<input type="text" name="name" value=""/><br/>
        PassWord:<input type="text" name="pwd" value=""/><br/>
        hobbies:<br/>
        <input type="checkbox" name="fav" value="1">java
        <input type="checkbox" name="fav" value="2">c#
        <input type="checkbox" name="fav" value="3">php

        <input type="submit" value="login">
    </form>
</body>
</html>
