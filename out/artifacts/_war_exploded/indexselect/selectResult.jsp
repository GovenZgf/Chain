<%@ page import="pojo.utils.TimeUtil" %>
<%@ page import="pojo.Chain" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/11
  Time: 21:14
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
    <title>查询结果</title>
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
            <thead>
            <tr>
                <th>
                    车次
                </th>
                <th>
                    出发站
                </th>
                <th>
                    到达站
                </th>
                <th>
                    离开时间
                </th>
                <th>
                    历时
                </th>
                <th>
                    一等座
                </th>
                <th>
                    二等座
                </th>
                <th>
                    软卧
                </th>
                <th>
                    硬卧
                </th>
                <th>
                    无座
                </th>
                <th>
                    预订
                </th>
            </tr>
            </thead>
            <tbody>
<%
    ArrayList<Chain> chains = (ArrayList<Chain>) request.getAttribute("chains");
    HashMap<String, HashMap<String,Integer>> map = (HashMap<String, HashMap<String, Integer>>) session.getAttribute("seatNums");
    if(chains !=null&&map!=null) {
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
            if(!TimeUtil.isTimeOut(chain.getDepartureTime()))
                out.print(String.format("<td><a href='%s/ChainServlet?method=showForBooking&chainId=%s' class=\"btn btn-default active\" role=\"button\">预订</a></td>",basePath,chain.getChainId()));
            out.print("</tr>");
        }
    }else {
            response.sendRedirect("../../index.jsp");
    }

%>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
