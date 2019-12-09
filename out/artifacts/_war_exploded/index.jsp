<%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/11/27
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
  <link rel="stylesheet" href="css/login.css" type="text/css">
  <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<%
    String error = (String)session.getAttribute("error");
    if(error!=null){
      if (error.equals("addError")) response.sendRedirect("manage/error.jsp");
    }
%>
<div class="container-fluid" contenteditable="false">
  <div class="row">
    <div class="page-header"><p style="margin-left: 32px" >火车站网上售票系统</p></div>
    <div style="background: #3b80ff ;">
      <ul class="nav nav-pills" contenteditable="false">
        <li class="active"><a href="index.html">主页</a></li>
        <li><a href="index.html">登录</a></li>
        <li><a href="ChainServlet?method=showAllChainForUser">车票</a></li>
      </ul>
    </div>
  </div>
  <div class="row" style="margin-top: 50px">
    <div class="col-md-4" >
      <form role="form" style="margin-left: 32px">
        <div class="form-group">
          <label for="起点" style="font-size: 28px">起点</label>
          <input type="text" class="form-control" id="起点" placeholder="请输入名称">
          <label for="终点" style="font-size: 28px">终点</label>
          <input type="text" class="form-control" id="终点" placeholder="请输入名称">
          <label for="时间" style="font-size: 28px" >时间</label>
          <input type="datetime-local" class="form-control" id="时间" placeholder="请输入时间">
        </div>
        <div class="checkbox"  style="zoom:120%;">
          <label>
            <input type="checkbox">学生
          </label>
          <label>
            <input type="checkbox">动车
          </label>
        </div>
        <button type="submit" class="btn btn-default">查询车票</button>
      </form>
    </div>
    <div class="col-md-8">
      右边表格
    </div>
  </div>
</div>
</body>
</html>