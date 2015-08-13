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
<temp:basic htmlTitle="View a Ticket" bodyTitle="View a Ticket">
  <a href="<c:url value="/login?logout" />">Logout</a>
  <h2>Ticket #${ticketID} : ${ticket.subject}</h2>
  <i>Customer name - ${ticket.customerName}<br/>
    Created <arth:formatDate value="${ticket.dateCreated}" type="both" timeStyle="long" dateStyle="full" /></i><br/>
  ${ticket.body}<br/><br/>
  <c:if test="${not empty ticket.attachments}">
    <c:forEach items="${ticket.attachments}" var="attachment" varStatus="loopStatus">
      <c:if test="${not loopStatus.first}">
        ", "
      </c:if>
      <a href="<c:url value="/tickets">
          <c:param name="action" value="download" />
          <c:param name="ticketId" value="${ticketID}" />
          <c:param name="attachment" value="${attachment.name}" />
        </c:url>">${attachment.name}</a><br/>
    </c:forEach>
  </c:if>
  <a href="<c:url value="/tickets"/>">Return to list tickets</a>
</temp:basic>
