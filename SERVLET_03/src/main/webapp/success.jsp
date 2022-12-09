<%--
  Created by IntelliJ IDEA.
  User: 84347
  Date: 12/10/2022
  Time: 3:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả</title>
</head>
<body>
<%
  String soLuong = request.getAttribute("soLuong")+"";
  String soDienThoai = request.getAttribute("soDienThoai")+"";
  String email = request.getAttribute("email")+"";
  int gia = Integer.parseInt(soLuong);
  gia*= 200000;
%>
Số lượng cần mua là: <b><%=soLuong%></b> <br>
Số tiền bạn cần thanh toán là: <b><%=gia%></b> <br>
Số điện thoại của bạn là: <b><%=soDienThoai%></b> <br>
Email của bạn là: <b><%=email%></b>
</body>
</html>
