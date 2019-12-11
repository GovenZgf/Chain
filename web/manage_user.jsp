<%--
  Created by IntelliJ IDEA.
  User: 95841
  Date: 12/6/2019
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理用户信息</title>
    <style type="text/css">
        .table-bordered{
            width: 50%;
            border-spacing: 0px;
            border-collapse: collapse;
            border-color: black;
        }
        .table-bordered th{
            height: 30px;
            border: 2px solid black;
            width: 16%;
        }
        .table-bordered td{
            height: 30px;
            border: 2px solid black;
            text-align: center;
            width: 16%;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-8 column">
            <table class="table table-condensed table-bordered">
                <thead>
                <tr>
                    <th>
                        用户姓名
                    </th>
                    <th>
                        用户性别
                    </th>
                    <th>
                        用户电话
                    </th>
                    <th>
                        用户类别
                    </th>
                    <th colspan="3">
                        管理用户
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>
                        <input type="button" value="修改用户类别">
                    </td>
                    <td>
                        <input type="button" value="删除用户信息">
                    </td>
                    <td>
                        <input type="button" value="完成">
                    </td>
                </tr>
                <tr class="success">
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>
                        <input type="button" value="修改用户类别">
                    </td>
                    <td>
                        <input type="button" value="删除用户类别">
                    </td>
                    <td>
                        <input type="button" value="完成">
                    </td>
                </tr>
                <tr class="error">
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>
                        <input type="button" value="修改用户类别">
                    </td>
                    <td>
                        <input type="button" value="删除用户类别">
                    </td>
                    <td>
                        <input type="button" value="完成">
                    </td>
                </tr>
                <tr class="warning">
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>
                        <input type="button" value="修改用户类别">
                    </td>
                    <td>
                        <input type="button" value="删除用户类别">
                    </td>
                    <td>
                        <input type="button" value="完成">
                    </td>
                </tr>
                <tr class="info">
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>

                    </td>
                    <td>
                        <input type="button" value="修改用户类别">
                    </td>
                    <td>
                        <input type="button" value="删除用户类别">
                    </td>
                    <td>
                        <input type="button" value="完成">
                    </td>
                </tr>
                <tr>
                    <td colspan="7">
                        <input type="button" value="添加">
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
