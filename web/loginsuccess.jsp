<%--
  Created by IntelliJ IDEA.
  User: Temo
  Date: 3/12/2016
  Time: 12:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="refresh" content="3;url=//localhost:8080/userpage.jsp" />
    <title>Login Success Page</title>
    <style type="text/css">
        #message {
            position: relative;
            top: 100px;
            width: 300px;
            border: 1px solid gray;
            padding: 20px;
            background-color: #CCFFCC;
            text-align: center;
            font-weight: bold;
            margin: auto;
        }
    </style>
</head>
<body>
<div id="message" align="center">
    <p>You are logged in.</p>
    <p><%= request.getAttribute("email") %></p>
</div>
</body>
</html>
