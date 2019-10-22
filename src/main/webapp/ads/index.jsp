<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: brancealexander
  Date: 10/22/19
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ads</title>
    <%@ include file="../partials/head.jsp" %>
</head>
<body>
<%@ include file="../partials/navbar.jsp" %>
<h1>New Test</h1>
<c:forEach var="ad" items="${ads}">
    <div class="ad">
        <h3>${ad.title}</h3>
        <p>${ad.description}</p>
    </div>
</c:forEach>
</body>
</html>
