<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes" trimDirectiveWhitespaces="true" %>
<%@ attribute name="htmlTitle" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ attribute name="bodyTitle" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ include file="/WEB-INF/jsp/base.jspf" %>

<temp:main htmlTitle="${htmlTitle}" bodyTitle="${bodyTitle}">
    <jsp:attribute name="headContent">
        <link rel="stylesheet" href="<c:url value="/resource/stylesheet/login.css" /> " />
    </jsp:attribute>
    <jsp:attribute name="navigationContent" />
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</temp:main>
