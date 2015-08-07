<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 07.08.2015
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%
  application.setAttribute("appAttribute", "foo");
  pageContext.setAttribute("pageAttribute", "bar");
  session.setAttribute("sessionAttribute", "sun");
  request.setAttribute("requestAttribute", "miracle");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Info</title>
</head>
<body>
  Remote Address: ${pageContext.request.remoteAddr}<br/>
  Request URL: ${pageContext.request.requestURL}<br/>
  Session ID: ${pageContext.session.id}<br/>
  Application Scope: ${applicationScope["appAttribute"]}<br/>
  Session Scope: ${sessionScope["sessionAttribute"]}<br/>
  Request Scope: ${requestScope["requestAttribute"]}<br/>
  User Parameter: ${param["user"]}<br/>
  Color Multi-Parameter: ${fn:join(paramValues["color"], ', ')}<br/>
  Accept Header: ${header["Accept"]}<br/>
  Session ID Cookie Value: ${cookie["JSESSIONID"].value}<br/>

</body>
</html>
