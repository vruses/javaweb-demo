<%--
  Created by IntelliJ IDEA.
  User: redis
  Date: 2022/9/23
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<%--注意action相对路径--%>
<form  action="../treatRegister" method = "post">
    姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="name" id="name"/><br />
    密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password"/>
    <br/>
    密码确认：<input type="password" name="passwordConfirm"><br>
    <input type="submit" value="注册"/>
    <input type="reset" value="重设">
</form>

</body>
</html>
