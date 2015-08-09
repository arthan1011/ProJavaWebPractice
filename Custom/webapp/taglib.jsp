<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 07.08.2015
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE >
<html>
<head>
    <title>Collections</title>
</head>
<body>
    <h2>Testing TagLib</h2>
    <c:if test="${param.foo == 'task'}">
        Show this only if task is parameter
    </c:if>
    <br/>
    <c:choose>
        <c:when test="${not empty param.foo}">
            if Parameter exists
        </c:when>
        <c:otherwise>
            Parameter not exists
        </c:otherwise>
    </c:choose>
    <br/>
    <a href="<c:url value="tickets" />">To tickets</a><br/>
    <c:forEach begin="1" end="10" var="i">
        <c:forEach begin="1" end="10" var="j">
            ${i * j += ' '}
        </c:forEach>
        <br/>
    </c:forEach>
</body>
</html>
