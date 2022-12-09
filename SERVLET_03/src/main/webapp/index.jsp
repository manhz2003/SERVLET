<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
    <style>
        .red{
            color: red;
        }
    </style>
</head>
<body>
<%
    String err_SoLuong = request.getAttribute("err_SoLuong")+"";
    String err_soDienThoai = request.getAttribute("err_soDienThoai")+"";
    String err_email = request.getAttribute("err_email")+"";

    err_SoLuong = (err_SoLuong.equals("null"))?"":err_SoLuong;
    err_soDienThoai = (err_soDienThoai.equals("null"))?"":err_soDienThoai;
    err_email = (err_email.equals("null"))?"":err_email;
%>

<div class="container mt-5">
    <form action="/muaHang" method="post">
        Số lượng cần mua <input class="form-control" type="text" name="soLuong" required="required">
        <div class="red"><%= err_SoLuong%></div>  <br>
        Số điện thoại <input class="form-control"  type="text" name="soDienThoai" required="required">
        <div class="red"><%= err_soDienThoai%></div> <br>
        Email <input class="form-control" type="email" name="email" required="required">
        <div class="red"><%= err_email%></div> <br>
        <input type="submit" value="Mua Hàng">
    </form>
</div>

</body>
</html>