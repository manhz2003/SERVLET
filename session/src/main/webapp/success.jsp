<%--
  Created by IntelliJ IDEA.
  User: manht
  Date: 12/10/2022
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: aqua">
  <%
    String username = (String)session.getAttribute("username");
  %>

Xin chào: <%=username%> <br>

  <h1>ĐÂY LÀ TRANG CHÀO MỪNG</h1>
  <a href="trang1.jsp">Trang 1</a>
</body>
</html>
