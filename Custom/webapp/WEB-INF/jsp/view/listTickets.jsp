<%@ page import="java.util.Map" %>
<%@ page import="org.arthan.support.entity.Ticket" %>
<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 05.08.2015
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%
  @SuppressWarnings("unchecked")
  Map<Integer, Ticket> ticketDatabase = (Map<Integer, Ticket>) request.getAttribute("ticketDatabase");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
  <h2>Tickets</h2>
  <a href="<c:url value="/tickets">
  <c:param name="action" value="create" />
  </c:url> ">Create ticket</a><br/><br/>
  <%
    if (ticketDatabase.size() == 0) {
      %><i>There are no tickets in the system</i><%
    }
    else {
      for (int ticketID : ticketDatabase.keySet()) {
        String idString = Integer.toString(ticketID);
        Ticket ticket = ticketDatabase.get(ticketID);
      %>
        Ticket #<%= idString%> : <a href="<c:url value="/tickets">
          <c:param name="action" value="view"/>
          <c:param name="ticketId" value="<%= idString%>" />
        </c:url>"><%= ticket.getSubject()%></a> (customer: <%= ticket.getCustomerName() %>)<br/>
      <%
      }
    }
  %>

</body>
</html>
