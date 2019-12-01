<%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/11/27
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
  <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/bootstrap-theme.css" type="text/css">
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <title>火车站网上售票系统</title>
  </head>
  <body>
<p class="h1 text-center">火车站网上售票系统</p>
<div class="login_box">
  <div class="center-block">
    <form action="UserServlet?method=userLogin" method="post" class="form-horizontal">
      <div class="form-group">
      <label class="col-sm-4 control-label">账号</label>
      <div class="col-sm-5"><input type="text" class="form-control" placeholder="请输入账号" name="userId"/></div>
      </div>
      <div class="form-group">
      <label class="col-sm-4 control-label">密码</label>
      <div class="col-sm-5"><input type="password" class="form-control" placeholder="请输入密码" name="userPassword"/></div>
      </div>
      <div class="form-group">
          <button type="submit" class="btn btn-default">登录</button>
          <button type="submit" class="btn btn-default" onclick="">注册</button>
      </div>
    </form>
  </div>
</div>
  </body>
</html>
