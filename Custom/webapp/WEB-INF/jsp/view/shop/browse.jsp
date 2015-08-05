<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 05.08.2015
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Product List</title>
</head>
<body>
  <h2>Product list</h2>
  <a href="<c:url value="/shop?action=viewCart"/>">View Cart</a><br/><br/>
  <%
    @SuppressWarnings("unchecked")
    Map<Integer, String> products = (Map<Integer, String>) request.getAttribute("products");
    for (int id : products.keySet()) {
      %>
        <a href="<c:url value="shop">
          <c:param name="action" value="addToCart" />
          <c:param name="productId" value="<%= Integer.toString(id)%>" />
        </c:url>"><%= products.get(id)%></a>
      <%
    }
  %>
</body>
</html>
