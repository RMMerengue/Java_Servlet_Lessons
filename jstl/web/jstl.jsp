<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 王天语
  Date: 2021/11/8
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("str","happy");
    request.setAttribute("hello","world");
    request.setAttribute("java","1234");
%>
<c:out value="haha" default="heihei"></c:out><br>
<c:out value="${str}" default="heihei"></c:out><br>
<c:out value="${hello}"></c:out><br>

<c:set var="java" value="pageContext" scope="page"></c:set>
<c:set var="java" value="request" scope="request"></c:set>
<c:set var="java" value="session" scope="session"></c:set>
<c:set var="java" value="application" scope="application"></c:set>

<c:out value="${pageScope.java}"></c:out><br>
<c:out value="${requestScope.java}"></c:out><br>
<c:out value="${sessionScope.java}"></c:out><br>
<c:out value="${applicationScope.java}"></c:out><br>

<c:remove var="java "></c:remove>
<c:out value="${java}"></c:out>

<c:set var="a" value="6"></c:set>
<c:if test="${a>5}">
    <h1>jstl is easy
</c:if>

<c:set var="age" value="15"></c:set>
<c:choose>
    <c:when test="${age<10}">
        <h1>child</h1>
    </c:when>
    <c:when test="${age<20}">
        <h1>junior</h1>
    </c:when>
    <c:when test="${age<30}">
        <h1>adult</h1>
    </c:when>
    <c:otherwise>
        <h1>i don't know</h1>
    </c:otherwise>
</c:choose>
<table border="1px">
    <tr>
        <td>1</td>
        <td>11</td>
    </tr>
    <tr>
        <td>2</td>
        <td>22</td>
    </tr>
    <tr>
        <td>3</td>
        <td>33</td>
    </tr>
</table>

<c:forEach begin="0" end="3" varStatus="sta">
    ${sta.index}---${sta.count}---${sta.first}---${sta.last}<br>
</c:forEach>

        <%
            ArrayList<String> list = new ArrayList<>();
            list.add("aaa");
            list.add("bbb");
            list.add("ccc");
            request.setAttribute("list",list);

            HashMap<String,String> map = new HashMap<>();
            map.put("1","111");
            map.put("2","222");
            map.put("3","333");
            request.setAttribute("map",map);
        %>

        <c:forEach begin="0" end="3" varStatus="sta" var="i" items="${list}">
            ${i}<br>
        </c:forEach>

        <table border="1px">
            <c:forEach begin="0" end="2" var="i" items="${map}">
                <tr>
                    <td>${i.key}</td>
                    <td>${i.value}</td>
                </tr>
            </c:forEach>
        </table>

</body>
</html>
