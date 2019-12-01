<%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/1
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="page-header">管理员登录</div>
    <div class="row">
        <form method="post" action="ManagerServlet?method=managerLogin">
            <div class="form-group">
                <label for="管理员用户名">账号</label>
                <input type="text" class="form-control" id="管理员用户名" name="mid">
                <label for="管理员密码">密码</label>
                <input type="password" class="form-control" id="管理员密码" name="mpassword">
                <button type="submit" class=" btn btn-default">登录</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
