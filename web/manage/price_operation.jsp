<%@ page import="pojo.ChainCarriage" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/8
  Time: 23:15
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
    <title>价格操作</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="<%=basePath%>/css/login.css" type="text/css">
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
        <form action="<%=basePath%>/ChainServlet?method=priceUpdate"></form>
    <table class="table table-bordered">
        <thead>
        <th>一等座</th>
        <th>二等座</th>
        <th>软卧</th>
        <th>硬卧</th>
        <th>站票</th>
        </thead>
        <tbody>
        <%
            HashMap<String,Double> priceMap = (HashMap<String, Double>) request.getAttribute("priceMap");
            out.print("<tr>");
            if(priceMap !=null) {
                out.print(String.format("<td><input type='text' class=\"form-control\" value=%s name='oneSeat'></td>", priceMap.get("一等座")));
                out.print(String.format("<td><input type='text' class=\"form-control\" value=%s name='twoSeat'></td>", priceMap.get("二等座")));
                out.print(String.format("<td><input type='text' class=\"form-control\" value=%s name='soft'></td>", priceMap.get("软卧")));
                out.print(String.format("<td><input type='text' class=\"form-control\" value=%s name='hard'></td> ", priceMap.get("硬卧")));
                out.print(String.format("<td><input type='text' class=\"form-control\" value=%s name='left></td>", priceMap.get("站票")));
            }
            out.print("</tr>");
            out.print("<tr><td colspan='5'><input type=\"submit\" value=\"提交\" class=\"btn btn-default\"><td></tr>");
        %>
        </tbody>
    </table>

    </div>
</div>
</body>
</html>
