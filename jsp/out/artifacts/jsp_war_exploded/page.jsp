<%--
  Created by IntelliJ IDEA.
  User: 王天语
  Date: 2021/11/4
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*, java.lang.*" pageEncoding="utf-8"%>
<%@ page session="false"%>
<%@ page errorPage="error.jsp"%>
<%
    String path = request.getContextPath();
    System.out.println(path);
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.println(basePath);
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<%
    //int i = 5/0;
%>
page
<%
    int i = new Random().nextInt(10);
    if(i>5){
%>
<b>appear</b>
<%
    }
%>

<%@ include file="staticImport.jsp"%>
<jsp:include page="dynamicImport.jsp"></jsp:include>

<%--<jsp:forward page="forward.jsp">--%>
<%--    <jsp:param name="china" value="beijing"/>--%>
<%--    <jsp:param name="hebei" value="shijiangzhuang"/>--%>
<%--</jsp:forward>--%>

<a href="a/a.jsp">aaa</a>
<a href="b/b.jsp">bbb</a>
</body>
</html>
