<%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/1
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>管理员主页</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
    <style type="text/css">
        .m1 {
            background-color: #D1EEEE;
        }
    </style>

</head>

<body class=m1>
<div>
    <div align="center">
        <div>
            <h1>管理员页面</h1>
        </div>
        <div>
            <table border=0>
                <tr>
                    <td>
                        <h3>
                            <a href="">管理用户信息</a>
                        </h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h3>
                            <a href="ticker_manage.jsp">管理车票信息</a>
                        </h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h3><a href="">故障处理</a></h3>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
