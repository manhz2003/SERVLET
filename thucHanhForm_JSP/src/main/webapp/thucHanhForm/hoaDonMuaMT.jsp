<%--
  Created by IntelliJ IDEA.
  User: manht
  Date: 12/5/2022
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<%-- Để chạy file jsp nhập trên url tên thư mục + tên file , thucHanhForm/hoaDonMuaMT.jsp--%>
    <%
//         radio button
//         Khi người dùng bấm chọn => trả về value được chọn

        String CPU = request.getParameter("CPU"); // CPU là thuộc tính name trong thẻ html
        double tongTien = 0;
        if (CPU != null) { // Nếu người dùng k bấm vào radio input thì trả về null
            double cpuPrice = 0;
            if (CPU.equals("CoreI9")) { // coreI9 là thuộc tính values trong thẻ
                cpuPrice = 5000000;
            } else if (CPU.equals("CoreI5")) {
                cpuPrice = 2000000;
            } else if (CPU.equals("CoreI7")) {
                cpuPrice = 4000000;
            }
            tongTien += cpuPrice; // tongTien = tongTien + cpuPrice
        }

//       radio button
        String RAM = request.getParameter("RAM"); // RAM là thuộc tính name = "RAM"
        double ramPrice = 0;
        if (RAM != null) { // Nếu người dùng k bấm vào radio input thì trả về null
            if (RAM.equals("RAM4GB")) {  // RAM4GB là thuộc tính values = "RAM4GB"
                ramPrice = 500000;
            } else if (RAM.equals("RAM16GB")) {
                ramPrice = 800000;
            } else if (RAM.equals("RAM8GB")) {
                ramPrice = 600000;
            }
            tongTien +=ramPrice;
        }

//         check box
        String thietBi = request.getParameter("thietBi");
           double thietBiPrice = 0;
        if (thietBi == null) {
            tongTien = 1500000;
            tongTien += thietBiPrice;
        }

//        select
//        vì select là lấy ra nhều giá trị nên phải sử dụng phương thức: getParameterValues()
        String[] phuKienMT = new String[0];
        if (request.getParameterValues("phuKienMT") != null) {  // nếu người dùng bấm vào 1 trong các lựa chọn thì thực hiện
            double phuKienMTPrice = 0;
            phuKienMT = request.getParameterValues("phuKienMT");
            for (String s : phuKienMT) {
                if (s.equals("Scanner")) {
                    phuKienMTPrice += 1800000;
                }
                if (s.equals("Printer")) {
                    phuKienMTPrice += 8010000;
                }
                if (s.equals("Camera")) {
                    phuKienMTPrice += 8200000;
                }
            }
            tongTien += phuKienMTPrice;
        }
    %>

    <h1>HÓA ĐƠN</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Giá tiền</th>
        </tr>
        </thead>
        <tbody>
        <%if (CPU != null) {%>
        <tr>
            <td><%=CPU%></td>
            <td><%=tongTien%> Đồng</td>
        </tr>
        <%}%>

            <%if (RAM != null) {%>
        <tr>
            <td><%=RAM%></td>
            <td><%=ramPrice%> Đồng</td>
        </tr>
            <%}%>

            <%if (thietBi != null) {%>
        <tr>
            <td><%=thietBi%></td>
            <td><%=thietBiPrice%> Đồng</td>
        </tr>
            <%}%>

            <%if (phuKienMT != null)
                for (String s : phuKienMT){
                double phuKienMTPrice = 0;
                if (s.equals("Scanner")) {
                    phuKienMTPrice += 1800000;
                }
                if (s.equals("Printer")) {
                    phuKienMTPrice += 8010000;
                }
                if (s.equals("Camera")) {
                    phuKienMTPrice += 8200000;
                }
                %>
        <tr>
            <td><%=s%></td>
            <td><%=phuKienMTPrice%> Đồng</td>
        </tr>
                <%}%>

    </table>
</body>
</html>
