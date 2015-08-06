<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 06.08.2015
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
  private static String toString(long timeInterval)
  {
    if(timeInterval < 1_000)
      return "less than one second";
    if(timeInterval < 60_000)
      return (timeInterval / 1_000) + " seconds";
    return "about " + (timeInterval / 60_000) + " minutes";
  }
%>
<%
  int numberOfSessions = (int) request.getAttribute("numberOfSessions");
  @SuppressWarnings("unchecked")
  List<HttpSession> sessionList = (List<HttpSession>) request.getAttribute("sessionList");
%>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
  <a href="<c:url value="/login?logout" />">Logout</a>
  <h2>Sessions</h2>
  There are total <%= numberOfSessions%> in this application<br/><br/>
  <%
    long timestamp = System.currentTimeMillis();
    for(HttpSession aSession : sessionList) {
      out.print(aSession.getId() + " - " + aSession.getAttribute("username"));
      if (aSession.getId().equals(session.getId())) {
        out.print(" you");
      }
      out.print(" - last active " + toString(timestamp - aSession.getLastAccessedTime()));
      out.print(" ago<br/>");
    }
  %>
</body>
</html>
