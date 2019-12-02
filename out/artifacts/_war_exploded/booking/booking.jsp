<%--
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
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="css/login.css" type="text/css">
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<form action="OrderServlet?method=booking">
    <div class="form-group">
        <label for="passengerName">乘客姓名</label>
        <input type="text" id="passengerName" name="passengerName" class="form-control">
        <label for="passengerIDcard">身份证号码</label>
        <input type="text" id="passengerIDcard" name="passengerIDcard" class="form-control">
        <label for="startStation" >起点</label>
        <select class="form-control" id="startStation" name="startStation">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>
        <label for="endStation">终点</label>
        <select class="form-control" id="endStation" name="endStation">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>
        <label for="mealsOrder">订餐选择</label>
        <select class="form-control" id="mealsOrder" name="mealsOrder">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>
    </div>
    <label for="departureTime">发车时间</label>
    <input data-format="dd/MM/yyyy hh:mm:ss" type="text" id="departureTime" name="departureTime">
    <button type="submit" class="btn btn-default">预订</button>
</form>
</body>
</html>