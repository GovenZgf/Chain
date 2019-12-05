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

    <script type="text/javascript">
        function formCheck() {
            var url = "UserServlet";
            var userId = document.getElementById("userId").value();
            var params = "method = formCheck"+"userId=" + "userId.value";
            sendRequest(url, params, 'POST', showResult);
        }
        function showResult() {
            var result = xmlHttp_request.responseText;
            if (xmlHttp_request.readyState == 4&&xmlHttp_request.status == 200) {
                var info = xmlHttp_request.responseText;
                result.innerHTML = info;
            }
        }
        function pwdCheck() {
            var pwd1 = document.getElementById("pwd1").value;
            var pwd2 = document.getElementById("pwd2").value;
            var pwd2check = document.getElementById("pwd2check");
            if (pwd2 != pwd1) {
                pwd2check.innerHTML = "<font color='red'>两次密码不一致<font>";
            } else {
                pwd2check.innerHTML = "两次密码一致";
            }
        }
    </script>
</head>
<body>
<div class=m1>
    <div align="center">
        <form action="UserServlet?method=userRegister" method="post">
            <div>
                <label>姓 名:</label> <input type="text" name="userName" />
            </div>
            <div>
                <label>账 号:</label> <input type="text" id = "userId" name="userId" onblur="formCheck()"/>
                <span id="result"></span>
            </div>
            <div>
                <label>请输入密码:</label> <input type="password" name="userPassword" id="pwd1" onblur="pwdCheck()" />
            </div>
            <div>
                <label>再次输入密码:</label> <input type="password" onblur="pwdCheck()" id="pwd2"/>
                <span id="pwd2check"></span>
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
