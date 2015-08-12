<%--@elvariable id="shortText" type="java.lang.String"--%>
<%--@elvariable id="longText" type="java.lang.String"--%>
<temp:main htmlTitle="Abbriviating Text">
  ${arth:abbreviateString(shortText, 23)}<br/>
  ${arth:abbreviateString(longText, 23)}<br/>
  ${arth:abbreviateString('This text is really long and should be cut to 23 characters', 23)}<br/>
</temp:main>