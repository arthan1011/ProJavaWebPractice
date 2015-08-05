<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 03.08.2015
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>                                                              \
<%@ page session="false" %>
<c:redirect url="/tickets" />
<html>
<head>
    <title>Hello, Planet application</title>
</head>
<body>
  Hello, planet! <br/>
  <jsp:forward page="component.jsp" />
  After included component
</body>
</html>
