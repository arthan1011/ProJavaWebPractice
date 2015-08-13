<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes" trimDirectiveWhitespaces="true" %>
<%@ attribute name="htmlTitle" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ attribute name="bodyTitle" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ attribute name="extraHeadContent" fragment="true" required="false" %>
<%@ attribute name="extraNavigationContent" fragment="true" required="false" %>
<%@ include file="/WEB-INF/jsp/base.jspf" %>

<temp:main htmlTitle="${htmlTitle}" bodyTitle="${bodyTitle}">
    <jsp:attribute name="headContent">
        <jsp:invoke fragment="extraHeadContent" />
    </jsp:attribute>
    <jsp:attribute name="navigationContent">
        <a href="<c:url value="/tickets" />">List Tickets</a><br/>
        <a href="<c:url value="/tickets">
                    <c:param name="action" value="create"/>
                 </c:url>">Create a Ticket</a><br/>
        <a href="<c:url value="/sessions" />">List Sessions</a><br />
        <a href="<c:url value="/login?logout" />">Log Out</a><br />
        <jsp:invoke fragment="extraNavigationContent" />
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</temp:main>
