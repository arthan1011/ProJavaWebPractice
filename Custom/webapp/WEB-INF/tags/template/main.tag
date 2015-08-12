<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes" trimDirectiveWhitespaces="true" %>
<%@ attribute name="htmlTitle" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ include file="/WEB-INF/jsp/base.jspf" %>
<!DOCTYPE html>
<html>
    <c:forEach items="${dynamicAttributes}" var="a">
        <c:out value='${a.key}="${fn:escapeXml(a.value)}"' escapeXml="false" />
    </c:forEach>
    <head>
        <title>
            <c:out value="${fn:trim(htmlTitle)}" />
        </title>
    </head>
    <body>
        <jsp:doBody />
    </body>
</html>