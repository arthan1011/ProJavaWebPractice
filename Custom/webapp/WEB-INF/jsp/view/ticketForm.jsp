<%--
  Created by IntelliJ IDEA.
  User: Артур
  Date: 04.08.2015
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<temp:basic htmlTitle="Create a Ticket" bodyTitle="Create a Ticket">
  <a href="<c:url value="/login?logout" />">Logout</a>
  <h2>Create a ticket</h2>
  <form action="tickets" method="POST" enctype="multipart/form-data">
    <input type="hidden" name="action" value="create"/>
    <label for="subjectInput">Subject</label><br/>
    <input id="subjectInput" name="subject" type="text" /><br/>
    <label for="bodyInput">Body</label><br/>
    <textarea name="body" id="bodyInput" rows="5" cols="30"></textarea><br/>
    <label for="attachmentInput">Attachments:</label><br/>
    <input type="file" id="attachmentInput" name="file1" /><br/>
    <input type="submit" />
  </form>
</temp:basic>
