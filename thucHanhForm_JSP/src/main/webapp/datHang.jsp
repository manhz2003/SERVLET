<%--
  Created by IntelliJ IDEA.
  User: manht
  Date: 12/4/2022
  Time: 2:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
 String hoVaTen = request.getParameter("hoVaTen");
 String email = request.getParameter("email");
 String soLuong = request.getParameter("soLuong");
 int soLuongSanPham = 0;

 try {
     soLuongSanPham = Integer.parseInt(soLuong);
 }catch (Exception e){


 }
%>
<h1>Xác nhận đặt hàng</h1>
<p>Xin cảm ơn bạn <b><%= hoVaTen%></b> đã đặt <b><%=soLuong%></b> sản phẩm</p> <br>
<p> Số tiền bạn cần thanh toán là: <b><%=soLuongSanPham*5%>$</b> </p>
<p>Bạn sẽ được thông báo qua email: <b><%=email%></b></p>

</body>
</html>
