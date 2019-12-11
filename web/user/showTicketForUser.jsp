<%@ page import="pojo.Ticket" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Chain" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="pojo.order.Order" %>
<%@ page import="pojo.utils.TimeUtil" %><%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/11
  Time: 10:00
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
    <title>我的车票</title>
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
        <form>
            <table class="table">
                <thead>
                <th>车票号</th>
                <th>车次</th>
                <th>乘客</th>
                <th>出发时间</th>
                <th>起点</th>
                <th>终点</th>
                <th>价格</th>
                <th>订单状态</th>
                <th>是否完成</th>
                <th colspan="2">退票/改签</th>
                </thead>
                <tbody>
                <%
                    List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
                    HashMap<String,Chain> chainHashMap = (HashMap<String, Chain>) request.getAttribute("chainHashMap");
                    HashMap<String,Order> orderHashMap = (HashMap<String, Order>) request.getAttribute("orderHashMap");
                    if(tickets==null) response.sendRedirect(String.format("%s/TicketServlet?method=showTicketForUser",basePath));
                    else
                    for (Ticket ticket:tickets){
                        out.print("<tr>");
                        out.print(String.format("<td>%s</td>",ticket.getTicketId()));
                        out.print(String.format("<td>%s</td>",ticket.getChainId()));
                        out.print(String.format("<td>%s</td>",orderHashMap.get(ticket.getOrderId()).getPassengerName()));
                        out.print(String.format("<td>%s</td>",chainHashMap.get(ticket.getChainId()).getDepartureTime()));
                        out.print(String.format("<td>%s</td>",chainHashMap.get(ticket.getChainId()).getStartStation()));
                        out.print(String.format("<td>%s</td>",chainHashMap.get(ticket.getChainId()).getEndStation()));
                        out.print(String.format("<td>%s</td>",ticket.getTicketPrice()));
                        out.print(String.format("<td>%s</td>",orderHashMap.get(ticket.getOrderId()).getOrderStatus()));
                        if(!TimeUtil.isTimeOut(chainHashMap.get(ticket.getChainId()).getDepartureTime())&&orderHashMap.get(ticket.getOrderId()).getOrderStatus().equals("已支付")){
                            out.print("<td>未完成</td>");
                            out.print(String.format("<td><a href=\"user/changeTicket.jsp?orderId=%s\" class=\"btn btn-default\" role=\"button\">改签</a></td>",ticket.getOrderId()));
                            out.print(String.format("<td><a href=\"OrderServlet?method=refundTicket&orderId=%s\" class=\"btn btn-default\" role=\"button\">退票</a></td>",ticket.getOrderId()));
                        }else{
                            out.print("<td>已完成</td>");
                        }
                        out.print("</tr>");
                    }
                %>
                <tr>
                    <td colspan="11"><a class="btn btn-default" href="<%=basePath%>/index.jsp" role="button">返回首页</a></td>


                </tr>
                </tbody>
            </table>
        </form>
    </div>
</div>
</body>
</html>
