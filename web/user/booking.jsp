<%@ page import="pojo.Chain" %><%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/2
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="../css/login.css" type="text/css">
    <script type="text/javascript" src="../js/bootstrap.js"></script>

</head>
<body>
<div class="container">
    <div class="row">
        <div style="margin-top: 165px">
<form action="OrderServlet?method=booking" method="post">
    <h1>请填入乘客信息</h1>
    <div class="form-group">
        <%
            Chain chain = (Chain)request.getAttribute("chain");
            out.print("<label for=\"chainId\">车次</label>");
            out.print(String.format("<input type=\"text\" id=\"chainId\" name=\"chainId\" readonly=\"readonly\" class=\"form-control\" value=%s>",chain.getChainId()));
            out.print("<label for=\"startStation\" x>起点</label>");
            out.print(String.format("<input type=\"text\" id=\"startStation\" readonly=\"readonly\" name=\"startStation\" class=\"form-control\" value=%s>",chain.getStartStation()));
            out.print("<label for=\"endStation\">终点</label>");
            out.print(String.format("<input type=\"text\" id=\"endStation\" name=\"endStation\" readonly = \"readonly\" class=\"form-control\" value=%s>",chain.getEndStation()));
        %>
        <label for="seatType">座位类型</label>
        <select class="form-control " id="seatType" name="seatType" >
            <option value="一等座">一等座</option>
            <option value="二等座">二等座</option>
            <option value="硬卧">硬卧</option>
            <option value="软卧">软卧</option>
            <option value="无座">无座/站票</option>
        </select>

        <label for="passengerName">乘客姓名</label>
        <input type="text" id="passengerName" name="passengerName" class="form-control">

        <label for="passengerIDcard">身份证号码</label>
        <input type="text" id="passengerIDcard" name="passengerIDcard" class="form-control">

        <label for="mealsOrder">订餐选择</label>
        <select class="form-control" id="mealsOrder" name="mealsOrder">
            <option>无</option>
            <option value="套餐一">套餐一：黄焖鸡米饭</option>
            <option value="套餐二">套餐二：双味鸡排饭</option>
            <option value="套餐三">套餐三：红烧牛肉面</option>
            <option value="套餐四">套餐四：饭团</option>
            <option value="套餐五">套餐五：皮蛋瘦肉粥</option>
        </select>
    </div>
    <button type="submit" class="btn btn-default">预订</button>
</form>
        </div>
    </div>
</div>
</body>
</html>