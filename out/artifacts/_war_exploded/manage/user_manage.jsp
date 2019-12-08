<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.User" %>
<%@ page import="pojo.Passenger" %><%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/8
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
    <meta charset="UTF-8">
    <title>管理用户信息</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css" type="text/css">
    <script type="text/javascript" src="<%=basePath%>/js/bootstrap.js"></script>
    <style>
        .table th, .table td {
            text-align: center;
            vertical-align: middle!important;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>
                    用户ID
                </th>
                <th>
                    用户姓名
                </th>
                <th>
                    用户电话
                </th>
                <th>
                    用户类别
                </th>
                <th colspan="2">
                    管理用户
                </th>
            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<User> userList = (ArrayList<User>) request.getAttribute("userList");
                ArrayList<Passenger> passengers = (ArrayList<Passenger>) request.getAttribute("passengerList");
                boolean flag = false;
                if (userList != null) {
                    for (User user : userList) {
                        out.print("<tr>");
                        out.print(String.format("<td>%s</td>", user.getUserId()));
                        out.print(String.format("<td>%s</td>", user.getUserName()));
                        out.print(String.format("<td>%s</td>", user.getPhoneNumber()));
                        for (Passenger passenger : passengers) {
                            if (user.getUserIDCard() != null
                                    && user.getUserIDCard().equals(passenger.getPassengerIDcard())) {
                                out.print(String.format("<td>%s</td>", passenger.getPassengerType()));
                                flag = true;
                            } else {
                                out.print(String.format("<td>%s</td>", "未设置类别"));
                                flag=true;
                            }
                        }
                        if(flag == false) out.print(String.format("<td>%s</td>", "未登记乘客信息"));
                        out.print(String.format("<td><a href='%s/UserServlet?method=deleteOneUser&userId=%s' class=\"btn btn-default active\" role=\"button\">删除用户信息</a></td>",basePath,user.getUserId()));
                        out.print(String.format("<td><a href='%s/UserServlet?method=modifyUser&passengerIDcard=%s' class=\"btn btn-default active\" role=\"button\">修改用户类别</a></td>",basePath,user.getUserIDCard()));
                        out.print(String.format("<tr>"));
                    }
                } else {
                    response.sendRedirect("../UserServlet?method=showAllUsers");
                }
            %>
            <tr>
                <td colspan="6" align="center">
                <button class="btn" onclick="location.href='manage/manager_main.jsp'">返回</button></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
