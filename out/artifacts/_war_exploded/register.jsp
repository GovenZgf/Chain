<%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/11/30
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style type="text/css">
        .m1 {
            margin-top: 15%;
            margin-left:40%;
            margin-right:40%;
            padding:1cm;
            background-color: #CFE1E7;
        }
    </style>

</head>
<body>
<div class=m1>
    <div align="center">
        <form action="UserServlet?method=userRegister" method="post">
            <div>
                <label>姓 名:</label> <input type="text" name="userName" />
            </div>
            <div>
                <label>账 号:</label> <input type="text" name="userId" />
            </div>
            <div>
                <label>密 码:</label> <input type="password" name="userPassword" />
            </div>
            <div>
                <label>电 话:</label> <input type="text" name="userPhoneNum" />
            </div>
            <div>
                <button type="submit">完成</button>
                <button type="reset">重填</button>
            </div>
            <div>
                您有账号？ <a href="index.jsp">直接登录</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
