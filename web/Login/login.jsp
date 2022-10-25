<%--
  Created by IntelliJ IDEA.
  User: redis
  Date: 2022/9/23
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="../treatLogin" method="post">
    姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<label>
    <input type="text" name="name"/>
</label><br/>
    学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<label>
    <input type="password" name="number"/>
</label>
    <br/>
    <input type="submit" value="登录"/>
    <input type="reset" value="重设"></form>
</body>
</html>
