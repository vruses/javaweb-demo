<%--
  Created by IntelliJ IDEA.
  User: redis
  Date: 2022/9/13
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册成功</title>
</head>
<body>
<%
    String name = request.getParameter("name");
%>
<h3>用户<%= name%>,恭喜您注册成功！</h3>
</body>
</html>
