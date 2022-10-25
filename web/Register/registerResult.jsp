<%--
  Created by IntelliJ IDEA.
  User: redis
  Date: 2022/10/7
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page import="javabean.UserBean" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册结果处理</title>
</head>
<body>

<%--如果传过来的request设置为带name的信息，则可以通过request和application里的值比较是否已经注册--%>
<%--通过application或者request传过来的键值对如果为空且未判断的话，tomcat容器会直接报空指针异常，为了方便直接都用request带回结果--%>
<% String result=(String)request.getAttribute("result");%>
<%=result%>

<%--<%--%>
<%--    UserBean user=(UserBean)application.getAttribute("user");--%>
<%--    String name=user.getUserName();--%>
<%--    String result=(String)request.getAttribute("error");--%>
<%--   if(result.equals(null))--%>
<%--   {%>您好<%=name%>!恭喜你注册成功！--%>
<%--   <%}else{--%>
<%--      %>--%>
<%--       <%=result%>--%>
<%--  <% }--%>
<%--%>--%>
</body>
</html>
