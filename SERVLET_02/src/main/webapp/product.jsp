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
    String error_msp = request.getAttribute("error_msp")+"";
    String value_msp = request.getAttribute("value_msp")+"";
    String value_giaNhap = request.getAttribute("value_giaNhap")+"";
    String value_giaBan = request.getAttribute("value_giaBan")+"";
    String value_VAT = request.getAttribute("value_VAT")+"";
    String value_moTa = request.getAttribute("value_moTa")+"";
    String value_tenSanPham = request.getAttribute("value_tenSanPham")+"";

    value_msp = value_msp.equals("null")?"":value_msp; // nếu value_msp = null thì hiển thị 1 chuỗi rỗng, ngược lại hiển thị value_msp
    error_msp = error_msp.equals("null")?"":error_msp;
    value_giaNhap = value_giaNhap.equals("null")?"":value_giaNhap;
    value_giaBan = value_giaBan.equals("null")?"":value_giaBan;
    value_VAT = value_VAT.equals("null")?"":value_VAT;
    value_moTa = value_moTa.equals("null")?"":value_moTa;
    value_tenSanPham = value_tenSanPham.equals("null")?"":value_tenSanPham;

%>
<div class="container mt-4">
    <form class="row g-3 needs-validation" action="save_product" id="my_form" method="post">
        <div class="row">
            <div class="col-6">
                <label for="maSanPham" class="form-label">Mã sản phẩm <span class="red">*</span></label>
                <input type="text" class="form-control" id="maSanPham" name="maSanPham" value="<%=value_msp%>">
                <div class="red"><%= error_msp%></div>
            </div>

            <div class="col-6">
                <label for="tenSanPham" class="form-label">Tên sản phẩm <span class="red">*</span></label>
                <input type="text" class="form-control" id="tenSanPham" required name="tenSanPham" value="<%=value_tenSanPham%>">
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <label for="giaNhap" class="form-label">Giá nhập <span class="red">*</span></label>
                <input type="number" step="0.01" class="form-control" id="giaNhap" value="<%=value_giaNhap%>" required name="giaNhap">
            </div>

            <div class="col-6">
                <label for="giaBan" class="form-label">Giá bán <span class="red">*</span></label>
                <input type="number" step="0.01" class="form-control" id="giaBan" value="<%=value_giaBan%>" required name="giaBan">
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <label for="hanSuDung" class="form-label">Hạn sử dụng <span class="red">*</span></label>
                <input type="datetime-local" step="0.01" class="form-control" id="hanSuDung" name="hanSuDung">
            </div>

            <div class="col-6">
                <label for="vat" class="form-label">Thuế VAT <span class="red">*</span></label>
                <input type="number" step="0.01" class="form-control" id="vat" value="<%=value_VAT%>" name="VAT">
            </div>
        </div>

        <div class="row">
            <label for="moTa" class="form-label">Mô tả sản phẩm <span class="red">*</span></label>
            <textarea rows="10" id="moTa" cols="20" name="moTa"><%=value_moTa%>> </textarea>
        </div>

        <div class="row">
            <button class="btn btn-primary" type="submit">Lưu sản phẩm</button>
        </div>
</form>
</div>
</body>
</html>