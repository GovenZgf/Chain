<%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/12/5
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加列车选项</title>
    <link rel="stylesheet" href="../css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="../css/login.css" type="text/css">
    <script type="text/javascript" src="../js/bootstrap.js"></script>
</head>
<body>

<div class="container">
    <div class="row" style="margin-bottom: 20px">
        <div class="page-header"><p style="margin-left: 32px" >火车站网上售票系统</p></div>
    </div>
    <div style="padding: 17.5% ;border: #848185 1px solid">
        <div class="row" style="background: #aca9ad">
            <form class="form-horizontal" style="margin: 10px" action="../ChainServlet?method=addChain" method="post">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="inputtext1">车次</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputtext1" name="chainId" placeholder="请输入车次">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="inputtext2">发车站</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputtext2" name="startStation" placeholder="请输入发车站">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="inputtext3">终点站</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="inputtext3" name="endStation" placeholder="请输入终点站">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="inputtime1">发车时间</label>
                    <div class="col-sm-5">
                        <input type="datetime-local" class="form-control" id="inputtime1"name="departureTime" placeholder="请输入发车时间">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="inputtime2">历经时间</label>
                    <div class="col-sm-5">
                        <input type="time" class="form-control" id="inputtime2"name="time" placeholder="请输入历经时间">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="inputtext4">价格</label>
                    <div class="col-sm-5">
                        <input type="number" class="form-control" id="inputtext4" name="chainPrice"placeholder="请输入价格">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="select1">车厢信息</label>
                    <div class="col-sm-5">
                        <select class="form-control" id="select1">
                            <option value="8车厢">8车厢</option>
                            <option value="16车厢">16车厢</option>
                        </select>
                    </div>
                </div>
                <div class="col-sm-10" style="margin-left: 300px">
                    <button class="btn btn-default" type="submit">确认添加</button>
                </div>

            </form>
        </div>
    </div>
</div>
</body>
</html>