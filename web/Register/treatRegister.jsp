<%--
  Created by IntelliJ IDEA.
  User: redis
  Date: 2022/9/13
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="javabean.UserBean"%>

<html>
<head>
    <title>注册处理</title>
</head>
<body>
<% String name = request.getParameter("name");
    String password =request.getParameter("password");
    String passwordConfirm =request.getParameter("passwordConfirm");
    if(!name.equals("") && !password.equals("")){
        if(password.equals(passwordConfirm)){
            UserBean user = new UserBean();
            user.setUserName(name);
            user.setUserPassword(password);
//            application.setAttribute(name,password);
            application.setAttribute("user",user);
        %>
<jsp:forward page="registerSuccess.jsp" >
    <jsp:param name="name" value="<%= name%>"/>
</jsp:forward>
<% }else { %>
<jsp:forward page="registerFail.jsp" >
    <jsp:param name="reason" value="Please make sure that the password you entered is the same!"/>
    </jsp:forward>
<% }
    }else{%>
  <jsp:forward page="registerFail.jsp" >
    <jsp:param name="reason" value="Please make sure your username or password is not empty!"/>
    </jsp:forward>
<%}%>
</body>
</html>

