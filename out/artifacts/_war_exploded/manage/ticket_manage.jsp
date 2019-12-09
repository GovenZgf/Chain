<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/12/6
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="pojo.Chain" %>
<%@ page import="pojo.ChainCarriage" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<head>
    <title>车票管理</title>
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
            <table class="table table-bordered">
                <tr>
                    <th>车次</th>
                    <th>起始站</th>
                    <th>终点站</th>
                    <th>离开时间</th>
                    <th>历时</th>
                    <th>一等座</th>
                    <th>二等座</th>
                    <th>软卧</th>
                    <th>硬卧</th>
                    <th>站票</th>
                    <th colspan="3">管理车票</th>
                </tr>
           <%
               ArrayList<Chain> chains = (ArrayList<Chain>) request.getAttribute("chainList");
               HashMap<String,HashMap<String,Integer>> map = (HashMap<String, HashMap<String, Integer>>) session.getAttribute("seatNums");
               if(chains !=null) {
                   for (Chain chain : chains) {
                       HashMap<String,Integer> seatNum = map.get(chain.getChainId());
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
                       out.print(String.format("<td><a href='%s/ChainServlet?method=deleteChain&chainId=%s' class=\"btn btn-default active\" role=\"button\">删除</a></td>",basePath,chain.getChainId()));
                       out.print(String.format("<td><a href='%s/ChainServlet?method=updateChain&chainId=%s' class=\"btn btn-default active\" role=\"button\" >修改</a></td>",basePath,chain.getChainId()));
                       out.print(String.format("<td><a href='%s/ChainServlet?method=priceMethod&chainId=%s' class=\"btn btn-default active\" role=\"button\" >价格操作</a></td>",basePath,chain.getChainId()));

                       out.print("</tr>");
                   }
               }else {
                   response.sendRedirect("../ChainServlet?method=showAllChain");
               }
           %>
                <tr><td colspan="13" align="center"><button class="btn" onclick="location.href='manage/addchain.jsp'">添加</button>
                    <button class="btn" onclick="location.href='manage/manager_main.jsp'">返回</button></td></tr>
            </table>
        </div>
</div>
</body>
</html>
