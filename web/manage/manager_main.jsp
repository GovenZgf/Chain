<%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/1
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="pojo.Manager" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员主页</title>
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
                            <a href="../UserServlet?method=showAllUsers">管理用户信息</a>
                        </h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h3>
                            <a href="../ChainServlet?method=showAllChain">管理车票信息</a>
                        </h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h3><a href="../ManagerServlet?method=errorMethod">故障处理</a></h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h3><a href="../ManagerServlet?method=errorMethodDelete">撤销故障处理</a></h3>
                    </td>
                </tr>
            </table>
            <%
                Manager manager = (Manager) session.getAttribute("manager");
                out.print(String.format("管理员Id：<input readonly='readonly' type=text value=%s>",manager.getManagerId()));
            %>
        </div>
    </div>
</div>
</body>
</html>
