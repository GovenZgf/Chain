<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/12/6
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>车票管理</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->

</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column"></div>
        <div class="col-md-4 column">
            <table class="table table-bordered" border="1" align="center"
                   cellspacing="0" cellpadding="0" >
                <thead>
                <tr>
                    <th>车次</th>
                    <th>起始站</th>
                    <th>终点站</th>
                    <th>离开时间</th>
                    <th>历时</th>
                    <th>价格</th>
                    <th>一等座</th>
                    <th>二等座</th>
                    <th>软卧</th>
                    <th>硬卧</th>
                    <th>站票</th>
                    <th>管理车票</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="button" name="modify" value="修改">&nbsp;
                        <input type="button" name="delete" value="删除">&nbsp; <input
                                type=submit name="delete" value="完成"></td>
                </tr>
                <tr class="success">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="button" name="modify" value="修改">&nbsp;
                        <input type="button" name="delete" value="删除">&nbsp; <input
                                type=submit name="delete" value="完成"></td>
                </tr>
                <tr class="error">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="button" name="modify" value="修改">&nbsp;
                        <input type="button" name="delete" value="删除">&nbsp; <input
                                type=submit name="delete" value="完成"></td>
                </tr>
                <tr class="warning">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="button" name="modify" value="修改">&nbsp;
                        <input type="button" name="delete" value="删除">&nbsp; <input
                                type=submit name="delete" value="完成"></td>
                </tr>
                <tr class="info">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><input type="button" name="modify" value="修改">&nbsp;
                        <input type="button" name="delete" value="删除">&nbsp; <input
                                type=submit name="delete" value="完成"></td>
                </tr>
                <tr>
                    <td colspan="12" align="center"><input type="button"
                                                           name="add" value="添加"></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-md-4 column"></div>
    </div>
</div>
</body>
</html>
