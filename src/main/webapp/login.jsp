<%--
  Created by IntelliJ IDEA.
  User: brancealexander
  Date: 2019-10-21
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="partials/head.jsp"%>
</head>
<body>

    <%@include file="partials/navbar.jsp"%>

    <h1>My God... it's a login page.</h1>

    <form action="/login.jsp" method="post">
        <label for="username-input">Username</label>
        <input type="text" id="username-input" name="usernameInput">
        <label for="password-input">Password</label>
        <input type="password" id="password-input" name="passwordInput">
        <button>Submit</button>
    </form>

    <%
        String username = request.getParameter("usernameInput");
        String password = request.getParameter("passwordInput");
        if(username != null && password != null) {
            if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")) {
                response.sendRedirect("/profile.jsp");
            }
        }
    %>

    <%@include file="partials/body-links.jsp"%>

</body>
</html>
