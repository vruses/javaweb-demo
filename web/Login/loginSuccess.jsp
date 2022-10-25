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
    <title>登录成功</title>
</head>
<body>
<%--<%--%>
<%--    String name = request.getParameter("name");--%>
<%--    String number = request.getParameter("number");--%>
<%--%>--%>
<%--<h3>用户<%= name%>,恭喜您登录成功！</h3><br>--%>
<%--<h3>您的学号是<%= number%>！</h3>--%>
<jsp:useBean id="user" scope="session" class="javabean.UserBean" />
<%--<jsp:setProperty name="user" property="userName" value="<%= name%>" />--%>
<%--<jsp:setProperty name="user" property="userPassword" value="<%=password%>" />--%>
您好！<jsp:getProperty name="user" property="userName" /><br />
您密码<jsp:getProperty name="user" property="userPassword" /><br />

</body>
</html>
