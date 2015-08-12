<%--@elvariable id="date" type="java.util.Date"--%>
<%--@elvariable id="instance" type="java.time.Instant"--%>
<%--@elvariable id="Calendar" type="java.util.Calendar"--%>
<temp:main htmlTitle="Displaying Dates Properly">
  <b>Date:</b>
  <arth:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" /><br/>
  <b>Date, Time with separator:</b>
  <arth:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" timeFirst="true" separateDateTimeWith=" on "/><br/>
  <b>Calendar:</b>
  <arth:formatDate value="${Calendar}" type="both" dateStyle="full" timeStyle="full" /><br/>
  <b>Instant:</b>
  <arth:formatDate value="${instance}" type="both" dateStyle="full" timeStyle="full" /><br/>
  <b>Instant, time with separator:</b>
  <arth:formatDate value="${instance}" type="both" dateStyle="full" timeStyle="full" timeFirst="true" separateDateTimeWith=" on "/><br/>
</temp:main>