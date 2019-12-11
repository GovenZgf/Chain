<%@ page import="pojo.Chain" %>
<%@ page import="pojo.Ticket" %>
<%@ page import="pojo.order.Order" %><%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/11
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>改签</title>
    <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="../css/bootstrap-theme.css" type="text/css">
    <style>
        .table th, .table td {
            text-align: center;
            vertical-align: middle !important;
        }
    </style>
    <script>
        function time_disable() {
            var oTime = document.getElementById("时间");
            var oStation = document.getElementById("终点");
            oStation.disabled = "disabled";
        }

        function station_disable() {
            var oTime = document.getElementById("时间");
            var oStation = document.getElementById("终点");
            oTime.disabled = "disabled";
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header"><p style="margin-left: 32px">火车站网上售票系统</p></div>
        <form action="../OrderServlet?method=changeTicket" method="post">
            <table class="table table-bordered">
                <caption>原车票</caption>
                <th>车票号</th>
                <th>车次</th>
                <th>乘客</th>
                <th>出发时间</th>
                <th>起点</th>
                <th>终点</th>
                <th>价格</th>
                <th>订单状态</th>
                <%
                    Chain chain = (Chain) request.getAttribute("chain");
                    Ticket ticket = (Ticket) request.getAttribute("ticket");
                    Order order = (Order) request.getAttribute("order");
                    if (chain != null && ticket != null && order != null) {
                        out.print("<tr>");
                        out.print(String.format("<td>%s</td>", ticket.getTicketId()));
                        out.print(String.format("<td>%s</td>", chain.getChainId()));
                        out.print(String.format("<td>%s</td>", order.getPassengerName()));
                        out.print(String.format("<td>%s</td>", chain.getDepartureTime()));
                        out.print(String.format("<td>%s</td>", chain.getStartStation()));
                        out.print(String.format("<td>%s</td>", chain.getEndStation()));
                        out.print(String.format("<td>%s</td>", ticket.getTicketPrice()));
                        out.print(String.format("<td>%s</td>", order.getOrderStatus()));
                        out.print(String.format("<input hidden='hidden' name = 'ticketId' value=%s>", ticket.getTicketId()));
                        out.print(String.format("<input hidden='hidden' name='startStation' value=%s>", chain.getStartStation()));
                        out.print("</tr>");
                    } else {
                        request.getRequestDispatcher("../TicketServlet?method=readyForChangeTicket").forward(request, response);
                    }
                %>
            </table>
            <table class="table table-bordered">
                <th>根据出发时间选择改签</th>
                <th>根据终点选择改签</th>
                <tr>
                    <td><label for="时间" style="font-size: 22px">时间</label>
                        <input type="datetime-local" class="form-control" id="时间" placeholder="请输入时间"
                               onfocus="time_disable()" name="departureTime"></td>
                    <td><label for="终点" style="font-size: 22px">终点</label>
                        <input type="text" class="form-control" id="终点" placeholder="请输入终点" onfocus="station_disable()" name="endStation">
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" class="btn" value="查询"></td>
                </tr>
            </table>
        </form>
    </div>

</div>
</body>
</html>
