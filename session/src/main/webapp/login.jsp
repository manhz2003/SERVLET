<%--
  Created by IntelliJ IDEA.
  User: manht
  Date: 12/10/2022
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = (String)session.getAttribute("username");
%>

<%-- nếu đã đăng nhập thành công thì tk mk được lưu lại trong session--%>
<% if(username!=null){ %>
<jsp:forward page="success.jsp"></jsp:forward>
<%} %>

<form action="login" method="post">
    <table>
        <tr>
            <td colspan="2">Login</td>
        </tr>

        <tr>
            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>

        <tr>
            <td>password</td>
            <td><input type="password" name="password"></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Login"></td>
        </tr>
    </table>
</form>
</body>
</html>
