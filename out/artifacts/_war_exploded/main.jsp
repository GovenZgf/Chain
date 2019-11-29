<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: sj150
  Date: 2019/11/28
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if(session.getAttribute("username") instanceof ArrayList<?>){
        List<User> stuList = (ArrayList<User>)session.getAttribute("username");}
%>
</body>
</html>
