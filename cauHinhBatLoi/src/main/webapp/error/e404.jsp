<%--
  Created by IntelliJ IDEA.
  User: manht
  Date: 12/10/2022
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
<h1>Rất tiếc, trang bạn truy cập không tồn tại!</h1>
<img alt="Error 404" src="<%=path%>/images/error404.jpg">
</body>
</html>
