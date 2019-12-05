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
            margin-top: 10%;
            margin-left:40%;
            margin-right:40%;
            padding:1cm;
            background-color: #D1EEEE;
        }
        .m2{

        }
    </style>
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <script type="text/javascript" src="js/bootstrap.js"></script>


</head>
<body>
<div >
    <div class=m1>
        <form action="UserServlet?method=userRegister" method="post">
            <div>
                <label>账 号:</label> <input type="text" name="userId" placeholder="请输入账号"/>
            </div>
            <div>
                <label>密 码:</label> <input type="password" name="userPassword" placeholder="请输入密码" />
            </div>
            <div>
                <label>姓 名:</label> <input type="text" name="userName"  placeholder="请输入姓名"/>
            </div>
            <div>
                <label>I &nbsp;&nbsp;&nbsp;&nbsp;D:</label> <input type="text" name="userNUm" placeholder="请输入身份证号" />
            </div>
            <div>
                    <label>电 话:</label> <input type="text" name="userPhoneNum" placeholder="请输入电话号码"/>
            </div>
            <div>
                <label>性 别:</label>
                <input type="radio" name="userGender" value="male" />男&nbsp;&nbsp;
                <input type="radio" name="userGender" value="female" />女
            </div>
            <div>
                <label>旅客类别:</label>
                <input type="radio" name="userType" value="sutdent" />学生&nbsp;&nbsp;
                <input type="radio" name="userType" value="adult" />成人
            </div>
            <div>
                <button type="submit">完成</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
