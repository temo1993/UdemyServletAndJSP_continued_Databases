<%--
  Created by IntelliJ IDEA.
  User: Temo
  Date: 3/14/2016
  Time: 1:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body>
<%
    String userValidated = request.getParameter("uservalidated");
    if ("allright".equals(userValidated)) {
%>

<p>Hello user</p>
<% } else { %>
<h2>It's a beautiful day, isn't it?</h2>
<% } %>

</body>
</html>
