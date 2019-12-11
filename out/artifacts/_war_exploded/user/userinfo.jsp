<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/11
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
    <script type="text/javascript" src="../js/bootstrap.js"></script>
    <script>
            function modify(){
                var oBtn = document.getElementById("modifyUser");
                var oUserName = document.getElementById("userName");
                var oUserPhoneNumber = document.getElementById("userPhoneNumber");
                var oUserIDcard = document.getElementById("userIDcard");
                oUserName.readOnly='';
                oUserPhoneNumber.readOnly='';
                oUserIDcard.readOnly='';
                return false;
            }
    </script>
</head>
<body>
<%
    String error = (String)session.getAttribute("error");
    if(error!=null){
        if (error.equals("addError")) response.sendRedirect("manage/error.jsp");
    }
    User user = (User) session.getAttribute("user");
    if (user == null) {response.sendRedirect("../index.html");}
    else {
%>
<div class="container">
    <div class="row">
        <div class="page-header"><p style="margin-left: 32px">火车站网上售票系统</p></div>
                <div style="background: #3b80ff ;">
                    <ul class="nav nav-pills" contenteditable="false">
                        <li><a href="../index.jsp">主页</a></li>
                        <li><a href="../ChainServlet?method=showAllChainForUser">车票</a></li>
                        <li><a href="../TicketServlet?method=showTicketForUser">历史车票</a></li>
                        <li class="active"><a href="../index.jsp">个人信息</a></li>
                    </ul>
                </div>
                        <form action="../UserServlet?method=modifyUserInfo" method="post" class="form-horizontal">
                            <table class="table">
                                <%
                                    out.print("<tr><td>用户基本信息</td></tr>");
                                    out.print("<tr>");
                                    out.print("<td>");
                                    out.print("<div class=\"form-group\">");
                                    out.print("<label for=\"userId\" class='col-sm-2 control-label'>用户Id</label>");
                                    out.print(String.format(" <div class=\"col-sm-10\">\n" +
                                            "      <p class=\"form-control-static\" >%s</p>\n" +
                                            "    </div>", user.getUserId()));
                                    out.print("</div>");


                                    out.print("<div class=\"form-group\">");
                                    out.print("<label for=\"userName\" class='col-sm-2 control-label'>用户姓名</label>");
                                    out.print(String.format(" <div class=\"col-sm-10\">\n" +
                                            "      <input class=\"form-control\" id='userName' name='userName' readonly='readonly' value=%s></input>\n" +
                                            "    </div>", user.getUserName()));
                                    out.print("</div>");


                                    out.print("<div class=\"form-group\">");
                                    out.print("<label for=\"userIDcard\" class='col-sm-2 control-label'>用户身份证</label>");
                                    out.print(String.format(" <div class=\"col-sm-10\">\n" +
                                            "      <input class=\"form-control\" name='userIDcard' id='userIDcard' readonly='readonly' value=%s></input>\n" +
                                            "    </div>", user.getUserIDCard()));
                                    out.print("</div>");

                                    out.print("<div class=\"form-group\">");
                                    out.print("<label for=\"userIDcard\" class='col-sm-2 control-label'>手机号码</label>");
                                    out.print(String.format(" <div class=\"col-sm-10\">\n" +
                                            "      <input class=\"form-control\" id='userPhoneNumber' name='userPhoneNumber' value=%s readonly='readonly'></p>\n" +
                                            "    </div>", user.getPhoneNumber()));
                                    out.print("</div>");
                                    out.print("</td>");
                                    out.print("</tr>");
                                    }
                                %>
                            </table>
                            <p ><input  id="modifyUser" class="btn btn-default" type="button" onclick="return modify()" value="修改"></p>
                            <p ><input  id="modifyConfirm" class="btn btn-default" type="submit" value="提交"></p>
                        </form>
                </div>
            </div>
</body>
</html>
