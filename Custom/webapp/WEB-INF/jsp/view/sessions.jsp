<%--@elvariable id="numberOfSessions" type="java.lang.Integer"--%>
<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 06.08.2015
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="timestamp" type="java.lang.Long"--%>
<%--@elvariable id="sessionList" type="java.util.List<javax.servlet.http.HttpSession"--%>
<temp:basic htmlTitle="Sessions" bodyTitle="Sessions">
  <a href="<c:url value="/login?logout" />">Logout</a>
  <h2>Sessions</h2>
  There are total ${numberOfSessions} in this application<br/><br/>
  <c:forEach items="${sessionList}" var="aSession">
    <c:out value="${aSession.id} - ${aSession.getAttribute('username')}" />
    <c:if test="${aSession.id eq pageContext.session.id}">
      &nbsp;(you)
    </c:if>
    &nbsp; - last active ${arth:timeIntervalToString(timestamp - aSession.lastAccessedTime)} ago<br/>
  </c:forEach>
</temp:basic>
