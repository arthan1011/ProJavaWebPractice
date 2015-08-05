<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 05.08.2015
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>View Cart</title>
</head>
<body>
  <h2>View cart</h2>
  <a href="<c:url value="/shop"/>">Product list</a><br/>
  <%
    @SuppressWarnings("unchecked")
    Map<Integer, String> products = (Map<Integer, String>) request.getAttribute("products");
    @SuppressWarnings("unchecked")
    Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

    if (cart == null || cart.isEmpty()) {
      out.println("Your cart is empty");
    } else {
      for (int id : cart.keySet()) {
        out.println(products.get(id) + " (количество: " + cart.get(id) + ")<br/>");
      }
    }
  %>
</body>
</html>
