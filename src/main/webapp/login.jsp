<%--
  Created by IntelliJ IDEA.
  User: zxd19
  Date: 2018/06/06
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>1.</h3><a href="/unit/add.jsp">Leave Comment</a>
<hr>
<h3>2.</h3><a href="/findwithcon?page=1">View Comments</a><hr>
<form name="form" action="/Login" method="post">
    Account:<input type="text" name="username"><br><br>
    Password:<input type="password" name="password"><br><br>
    <input type="submit" name="submit" value="Login">
</form>
</body>
</html>
