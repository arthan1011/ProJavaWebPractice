<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 06.08.2015
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
  <a href="<c:url value="/login?logout" />">Logout</a>
  <h2>Login</h2>
  You must log in to access the customer support site.<br/><br/>
  <%
    if ((Boolean)request.getAttribute("loginFailed")) {
      %>
        <b>The username or password you typed are not correct. Try again</b><br/>
      <%
    }
  %>
  <form action="login" method="POST">
    <label for="usernameInput">Username</label><br/>
    <input id="usernameInput" name="username" /><br/>
    <label for="passwordInput">Password</label><br/>
    <input id="passwordInput" name="password" /><br/>
    <input type="submit" value="Log in" />
  </form>
</body>
</html>
