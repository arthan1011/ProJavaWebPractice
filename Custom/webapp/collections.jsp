<%--@elvariable id="x" type="java.lang.Integer"--%>
<%@ page import="org.arthan.support.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 07.08.2015
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%
  List<User> users = new ArrayList<>(5);
  users.add(new User(111L, "John1", "Jogn", "Smith"));
  users.add(new User(222L, "Hagibbator22", "Joe", "Hanks"));
  users.add(new User(333L, "eclectro32", "Jack", "Hanks"));
  users.add(new User(444L, "farmer-hero42", "Adam", "Fisther"));
  request.setAttribute("users", users);
%>
<!DOCTYPE >
<html>
<head>
    <title>Collections</title>
</head>
<body>
  ${users.stream()
      .filter(u -> fn:contains(u.username, '2'))
      .sorted((u1, u2) -> (
          x = u1.lastName.compareTo(u2.lastName);
          x == 0 ? u1.firstName.compareTo(u2.firstName) : x))
      .map(u -> {
          'username' : u.username,
          'first' : u.firstName,
          'last' : u.lastName
          })
      .toList()
  }
</body>
</html>
