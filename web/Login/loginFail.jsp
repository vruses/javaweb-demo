<%--
  Created by IntelliJ IDEA.
  User: redis
  Date: 2022/9/28
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String reason = request.getParameter("reason");
%>
<h3><%= reason%></h3></body>
</body>
</html>
