<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/12/6
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="pojo.Chain" %>

<html>
<head>
    <title>车票管理</title>
    <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="../css/login.css" type="text/css">
    <script type="text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
            <table class="table table-bordered">
                <tr>
                    <th>车次</th>
                    <th>起始站</th>
                    <th>终点站</th>
                    <th>离开时间</th>
                    <th>历时</th>
                    <th>价格</th>
                    <th>一等座</th>
                    <th>二等座</th>
                    <th>软卧</th>
                    <th>硬卧</th>
                    <th>站票</th>
                    <th>管理车票</th>
                </tr>
           <%
               ArrayList<Chain> chains = (ArrayList<Chain>) request.getAttribute("chainList");
               if(chains !=null) {
                   for (Chain chain : chains) {
                       out.print("<tr>");
                       out.print(String.format("<td>%s</td>", chain.getChainId()));
                       out.print(String.format("<td>%s</td>", chain.getStartStation()));
                       out.print(String.format("<td>%s</td>", chain.getEndStation()));
                       out.print(String.format("<td>%s</td>", chain.getDepartureTime()));
                       out.print(String.format("<td>%s</td>", chain.getTime()));
                       out.print(String.format("<td>%s</td>", chain.getPrice()));
                       //out.print(String.format("<td>%s</td>"));
                       //out.print(String.format("<td>%s</td>"));
                       //out.print(String.format("<td>%s</td>"));
                       //out.print(String.format("<td>%s</td>"));
                       //out.print(String.format("<td>%s</td>"));
                       //out.print(String.format("<td>%s</td>"));
                       out.print("</tr>");
                   }
               }
           %>
                <tr><td colspan="12" align="center"><button class="btn" onclick="location.href='addchain.jsp'">添加</button></td></tr>
            </table>
        </div>
</div>
</body>
</html>
