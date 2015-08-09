<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 09.08.2015
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="contacts" type="java.util.set"--%>
<html>
<head>
    <title>Address Book</title>
</head>
<body>
  <h2>Address book contacts</h2>
  <c:choose>
    <c:when test="${empty contacts}">
      <i>There are no contacts in the address book</i>
    </c:when>
    <c:otherwise>
      <c:forEach items="${contacts}" var="contact">
        <b>
          <c:out value="${contact.firstName}, ${contact.lastName}" /><br/><br/>
        </b>
        <c:out value="${contact.address}" /><br/>
        <c:out value="${contact.phoneNumber}" /><br/>
        <c:if test="${contact.birthDay ne null}">
          Birthday: ${contact.birthDay}<br/>
        </c:if>
        Created: ${contact.dateCreated}<br/><br/>
      </c:forEach>
    </c:otherwise>
  </c:choose>
</body>
</html>
