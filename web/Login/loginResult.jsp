<%--
  Created by IntelliJ IDEA.
  User: redis
  Date: 2022/10/9
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录处理结果</title>
</head>
<body>
<%

    String result  = (String) request.getAttribute("result");
 %>
<%=result%>

</body>
</html>
