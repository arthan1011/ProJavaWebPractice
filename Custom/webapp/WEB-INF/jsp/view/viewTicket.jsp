<%--@elvariable id="ticket" type="org.arthan.support.entity.Ticket"--%>
<%--@elvariable id="ticketID" type="java.lang.String"--%>
<%@ page import="org.arthan.support.entity.Ticket" %>
<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 05.08.2015
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%
  Ticket ticket = (Ticket) request.getAttribute("ticket");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
  <a href="<c:url value="/login?logout" />">Logout</a>
  <h2>Ticket #${ticketID} : ${ticket.subject}</h2>
  <i>Customer name - ${ticket.customerName}</i><br/><br/>
  ${ticket.body}<br/><br/>
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
          <c:param name="ticketId" value="${ticketID}" />
          <c:param name="attachment" value="<%= attachment.getName()%>" />
        </c:url>"><%= attachment.getName()%></a><br/><%
      }
    }
  %>
  <a href="<c:url value="/tickets"/>">Return to list tickets</a>
</body>
</html>
