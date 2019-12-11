<%@ page import="pojo.order.Order" %>
<%@ page import="pojo.Chain" %>
<%@ page import="pojo.Passenger" %><%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/9
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付页面</title>
    <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
    <script type="text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div style="margin-top: 165px">
            <form action="OrderServlet?method=confirmPay" method="post">
                <h1>请确认乘客信息并支付</h1>
                <div class="form-group">
                    <%
                        Chain chain = (Chain) request.getAttribute("chain");
                        Order order = (Order) request.getAttribute("order");
                        String seatType = (String) request.getAttribute("seatType");
                        Passenger passenger = (Passenger) request.getAttribute("passenger");
                        if(chain!=null&&order!=null&&seatType!=null&&passenger!=null) {
                            out.print("<label for=\"chainId\">订单号</label>");
                            out.print(String.format("<input type=\"text\"  name=\"orderId\" readonly=\"readonly\" class=\"form-control\" value=%s>", order.getOrderId()));
                            out.print("<label for=\"chainId\">车次</label>");
                            out.print(String.format("<input type=\"text\"  name=\"chainId\" readonly=\"readonly\" class=\"form-control\" value=%s>", chain.getChainId()));
                            out.print("<label for=\"startStation\" x>起点</label>");
                            out.print(String.format("<input type=\"text\"  readonly=\"readonly\" name=\"startStation\" class=\"form-control\" value=%s>", chain.getStartStation()));
                            out.print("<label for=\"endStation\">终点</label>");
                            out.print(String.format("<input type=\"text\"  name=\"endStation\" readonly = \"readonly\" class=\"form-control\" value=%s>", chain.getEndStation()));
                            out.print("<label for=\"seatType\">座位类型</label>");
                            out.print(String.format("<input type='text'  name='seatType' readonly = 'readonly' class='form-control' value=%s>", seatType));
                            out.print("<label for=\"seatType\">乘客类型</label>");
                            out.print(String.format("<input type='text'  name='passengerType' readonly = 'readonly' class='form-control' value=%s>", passenger.getPassengerType()));
                            out.print("<label for=\"passengerName\">乘客姓名</label>");
                            out.print(String.format("<input type=\"text\"  name=\"passengerName\" readonly = 'readonly' class=\"form-control\" value=%s>", passenger.getPassengerName()));
                            out.print("<label for=\"passengerIDcard\">身份证号码</label>");
                            out.print(String.format("<input type=\"text\"  name=\"passengerIDcard\" readonly = 'readonly' class=\"form-control\" value=%s>", passenger.getPassengerIDcard()));
                            out.print("<label for=\"mealsOrder\">订餐选择</label>");
                            out.print(String.format("<input type=\"text\" name=\"mealsOrder\"readonly = 'readonly'  class=\"form-control\" value=%s>", order.getMealsName()));
                            out.print("<label for=\"mealsOrder\">订餐价格</label>");
                            out.print(String.format("<input type='text' name='mealsPrice' readonly = 'readonly'  class=\"form-control\"   value=%s>", order.getMealsPrice()));
                            out.print("<label for=\"mealsOrder\">车票价格</label>");
                            out.print(String.format("<input type='text' name='ticketPrice' readonly = 'readonly'  class=\"form-control\"  value=%s>", order.getTicketPrice()));
                            out.print("<label for=\"mealsOrder\">应付金额</label>");
                            out.print(String.format("<input type='text' name='accountPayable' readonly='readonly'  class=\"form-control\"  value=%s>", order.getAccountPayable()));
                        }else {
                            response.sendRedirect("user/booking.jsp");
                        }%>
                </div>
                <button type="submit" class="btn btn-default">确认支付</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
