<%--
  Created by IntelliJ IDEA.
  User: redis
  Date: 2022/9/13
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册失败</title>
</head>
<body>
<%
    String reason = request.getParameter("reason");
%>
<h3><%= reason%></h3></body>
</html>
