<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 04.08.2015
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%! public static final String DEFAULT_USER = "Guest";%>
<% String user = request.getParameter("user") == null ? DEFAULT_USER : request.getParameter("user"); %>
<html>
<head>
    <title>Hello User JSP</title>
</head>
<body>
  Hello, <%= user %><br/>
  <form action="hello-user.jsp" method="post">
    <label for="userInput"></label><br/>
    <input id="userInput" type="text" name="user" /><br/>
    <input type="submit" />
  </form>
</body>
</html>
