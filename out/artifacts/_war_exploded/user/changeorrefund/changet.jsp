<%@ page import="pojo.Chain" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/11
  Time: 19:05
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
    <title></title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap-theme.css" type="text/css">
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
        <table class="table">
            <th>车次</th>
            <th>起点</th>
            <th>终点</th>
            <th>出发时间</th>
            <th>历时</th>
            <th>一等座</th>
            <th>二等座</th>
            <th>软卧</th>
            <th>硬卧</th>
            <th>无座</th>
<%
    ArrayList<Chain> chains = (ArrayList<Chain>) request.getAttribute("chainList");
    HashMap<String, HashMap<String,Integer>> map = (HashMap<String, HashMap<String, Integer>>) session.getAttribute("seatNums");
         if(chains !=null) {
             for (Chain chain : chains) {
                 HashMap<String, Integer> seatNum = map.get(chain.getChainId());
                 out.print("<tr>");
                 out.print(String.format("<td>%s</td>", chain.getChainId()));
                 out.print(String.format("<td>%s</td>", chain.getStartStation()));
                 out.print(String.format("<td>%s</td>", chain.getEndStation()));
                 out.print(String.format("<td>%s</td>", chain.getDepartureTime()));
                 out.print(String.format("<td>%s</td>", chain.getTime()));
                 out.print(String.format("<td>%s</td>", seatNum.get("一等座")));
                 out.print(String.format("<td>%s</td>", seatNum.get("二等座")));
                 out.print(String.format("<td>%s</td>", seatNum.get("软卧")));
                 out.print(String.format("<td>%s</td>", seatNum.get("硬卧")));
                 out.print(String.format("<td>%s</td>", seatNum.get("站票")));
                 out.print(String.format("<td><a href='%s/OrderServlet?method=confirmChange&chainId=%s&orderId=%s' class=\"btn btn-default active\" role=\"button\">选择改签</a></td>",basePath,chain.getChainId(),request.getAttribute("orderId")));
                 out.print("</tr>");
             }
         }
    %>
        </table>
    </div>
</div>
</body>
</html>
