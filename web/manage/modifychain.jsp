<%@ page import="pojo.Chain" %><%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/8
  Time: 19:46
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
    <title>车票信息修改</title>
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
        <form action="<%=basePath%>/ChainServlet?method=updateChain" method="post">
<%
    Chain chain = (Chain) request.getAttribute("chain");
    out.print("<table class = 'table table-bordered'><th>车次</th><th>时间</th>");
    if(chain!=null) {
        out.print(String.format("<tr><td><input type='text' class='form-control' placeholder='车次' value='%s' name='chainId' readonly='readonly'></td>", chain.getChainId()));
        out.print(String.format("<td><input type='datetime-local' class='form-control' placeholder='时间' value=%s name='updatedTime'></td></tr>", chain.getDepartureTime()));
    }
   // out.print(String.format("<input type='hidden' class='form-control' value=%s name = 'chainId'",chain.getChainId()));
    out.print("<td colspan='2'><input value='提交修改' type='submit' class='btn-default btn'></td>");
    out.print("</table>");
%>
        </form>
    </div>
</div>
</body>
</html>
