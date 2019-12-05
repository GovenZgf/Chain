<%--
  Created by IntelliJ IDEA.
  User: 95841
  Date: 12/4/2019
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script language="javascript">
    function on_subimit() {
        if (form1.username.value == "") {
            alter("姓名不能为空，请输入姓名！");
            form1.user.focus();
            return false;
        }
        if (form1.password.value == "") {
            alter("密码不能为空，请输入密码！");
            form1.password.focus();
            return false;
        }
        if (form1.reuserpassword.value != form1.password.value) {
            alter("密码与确认密码不一致");
            form1.reuserpassword.focus();
            return false;
        }
    }
</script>
<head>
    <title>修改个人信息</title>
    <style type="text/css">
        .m2 {
            margin-top: 15%;
            margin-left:40%;
            margin-right:40%;
            padding:1cm;
            background-color: #CFE1E7;
        }
    </style>
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<div class="m2">
    <div align="center"></div>
        <form method="POST" action="modify" name="formal">
            <div>
                <label>姓 名:</label> <input type="text" name="userName" />
            </div>
            <div>
                <label>密 码:</label> <input type="password" name="userPassword" />
            </div>
            <div>
                <label>再一次输入密码:</label> <input type="password" name="userPassword" />
            </div>

            <div>
                <label>性&nbsp;别:</label><input type="radio" value="male" checked name="sex">男&nbsp;
                <input type="radio" value="female" name="sex">女<br>
            </div>
            <div>
                <label>身份证号:</label><input type="text" name="useridNum"><br>
            </div>
            <div>
                <label>电话号码：</label><input type="text" name="userphoneNum"><br>
            </div>
            <div>
                <label>旅客类型:</label><input type="radio" name="usertype" value="adult" checked>成人&nbsp;&nbsp;
                <input type="radio" name="usertype" value="student">学生<br>
            </div>

            <a href="index.jsp"><botton type="submit">确认</botton></a>
            <a href="user_info.jsp"><botton type="reset">重新填写</botton></a>
        </form>
    </div>
</div>

</body>
</html>