<%--
  Created by IntelliJ IDEA.
  User: Temo
  Date: 3/12/2016
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <style type="text/css">
        #context { position: relative; }
        #login {
            position: relative;
            top: 100px;
        }
        .html-editor-align-right {
            text-align: right;
        }
        table {
            border: 1px solid gray;
            padding: 20px;
            background-color: #CCCCFF;
        }
        .login-error {
            font: 16px bold red;
        }
    </style>
</head>
<body>
<div id="Login" align="center">
<form method="post" action="<%= response.encodeURL(request.getContextPath() + "/Controller?action=dologin")%>">
<input type="hidden" name="action" value="dologin"/>
    <table>
        <tr><td class="html-editor-align-right">Email address: </td><td><input type="text" name="email" value="<%= request.getAttribute("email") %>"/></td></tr>
        <tr><td class="html-editor-align-right">Password: </td><td><input type="password" name="password" value="<%= request.getAttribute("password") %>"/></td></tr>
        <tr><td class="html-editor-align-right" colspan="2"><input type="submit" value="Log in"/></td></tr>
    </table>
    <p class="Login-error"><%= request.getAttribute("message") %></p>
</form>
</div>
</body>
</html>
