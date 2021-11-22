<%@ page import="com.msb.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 王天语
  Date: 2021/11/8
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
name:<%=request.getParameter("name")%><br>
pwd:<%=request.getParameter("pwd")%><br>
aa:<%=request.getAttribute("aa")%><br>
town:<%=((User)request.getAttribute("user")).getAddress().getTown()%><br>
wuan:<%=((User)((ArrayList)request.getAttribute("list")).get(1)).getAddress().getTown()%><br>
mapvalue:<%=((HashMap)request.getAttribute("map")).get("beijing")%><br>

<br>
name:${param.name}<br>
pwd:${param.pwd}<br>
aa:${aa}<br>
town:${user.address.town}<br>
wuan:${list[1].address.town}<br>
mapvalue:${map.beijing}<br>

<br>
${header}<br>
<br>
${header["host"]}<br>
${headerValues["accept-language"][0]}<br>
<br>

${cookie}<br>
${cookie.JSESSIONID}<br>
${cookie.JSESSIONID.name}<br>
${cookie.JSESSIONID.value}<br>



</body>
</html>
