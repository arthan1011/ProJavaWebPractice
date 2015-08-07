<%--@elvariable id="foo" type="java.lang.String"--%>
<%--@elvariable id="user" type="org.arthan.support.entity.User"--%>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
  User ID: ${user.userId}<br/>
  Username: ${user.username} (${user.username.length()} characters)<br/>
  Full name: ${fn:escapeXml(user.lastName += ', ' += user.firstName)}<br/><br/>
  <b>Permissions (${fn:length(user.permissions)})</b><br/>
  User: ${user.permissions["user"]}<br/>
  Moderator: ${user.permissions["admin"]}<br/>
  Admin: ${user.permissions["admin"]}<br/>

  Query param foo is: ${param.foo}
</body>
</html>
