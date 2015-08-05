<%@ page import="org.arthan.support.entity.Ticket" %>
<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 05.08.2015
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="false" %>
<%
  String ticketID = (String) request.getAttribute("ticketID");
  Ticket ticket = (Ticket) request.getAttribute("ticket");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
  <h2>Ticket #<%= ticketID%> : <%= ticket.getSubject()%></h2>
  <i>Customer name - <%= ticket.getCustomerName()%></i><br/><br/>
  <%= ticket.getBody()%><br/><br/>
  <%
    if (ticket.getNumberOfAttachments() > 0) {
      %>Attachments: <%
      int i = 0;
      for (Attachment attachment : ticket.getAttachments()) {
        if (i++ > 0) {
          out.print(", ");
        }
        %>
        <a href="<c:url value="/tickets">
          <c:param name="action" value="download" />
          <c:param name="ticketId" value="<%= ticketID%>" />
          <c:param name="attachment" value="<%= attachment.getName()%>" />
        </c:url>"><%= attachment.getName()%></a><br/><%
      }
    }
  %>
  <a href="<c:url value="/tickets"/>">Return to list tickets</a>
</body>
</html>
