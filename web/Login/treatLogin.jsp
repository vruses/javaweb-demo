<%--
  Created by IntelliJ IDEA.
  User: redis
  Date: 2022/9/28
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javabean.UserBean"%>
<%@ page import="org.apache.catalina.User" %>
<html>
<head>
    <title>登录处理</title>
</head>
<body>
<% String name = request.getParameter("name");
    String number =request.getParameter("number");
    if(!name.equals("") && !number.equals("")) {
        UserBean user = (UserBean)application.getAttribute("user");
        //user私有属性只能通过方法获取，对属性进行私有化封装，防止被随意修改，提高了安全性
        if (number.equals(user.getUserPassword()) && name.equals(user.getUserName())) {
        //如果判断登录成功不需要额外给user添加属性
            session.setAttribute("user", user);//设置登录成功标识

//            session.setAttribute("isLogin",true);
//            System.out.println(application.getAttribute(name));
//        if(name.equals("hlt") && number.equals("20200038")){
%>
<jsp:forward page="loginSuccess.jsp" >
    <jsp:param name="name" value="<%=name%>"/>
    <jsp:param name="number" value="<%=number%>"/>
</jsp:forward>
<% } else { %>
<jsp:forward page="loginFail.jsp" >
    <jsp:param name="reason" value="Please confirm whether the user name or password is entered correctly!"/>
</jsp:forward>
<% }
    }else{%>
<jsp:forward page="loginFail.jsp" >
    <jsp:param name="reason" value="Please make sure your username or password is not empty!"/>
</jsp:forward>
<%}%>
</body>
</html>
