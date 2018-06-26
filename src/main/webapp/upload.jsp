<%--
  Created by IntelliJ IDEA.
  User: zxd19
  Date: 2018/06/21
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="file" name="upload">
        <button type="submit">Submit</button>
    </form>
</body>
</html>
