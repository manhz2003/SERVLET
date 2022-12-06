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
<div class="container mt-4">
    <form class="row g-3 needs-validation" action="save-product" id="my_form">
        <div class="row">
            <div class="col-6">
                <label for="maSanPham" class="form-label">Mã sản phẩm <span class="red">*</span></label>
                <input type="text" class="form-control" id="maSanPham" value="Mark" required name="maSanPham">
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>

            <div class="col-6">
                <label for="tenSanPham" class="form-label">Tên sản phẩm <span class="red">*</span></label>
                <input type="text" class="form-control" id="tenSanPham" value="Mark" required name="tenSanPham">
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <label for="giaNhap" class="form-label">Giá nhập <span class="red">*</span></label>
                <input type="number" step="0.01" class="form-control" id="giaNhap" value="Mark" required name="giaNhap">
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>

            <div class="col-6">
                <label for="giaBan" class="form-label">Giá bán <span class="red">*</span></label>
                <input type="number" step="0.01" class="form-control" id="giaBan" value="Mark" required name="giaBan">
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-6">
                <label for="hanSuDung" class="form-label">Hạn sử dụng <span class="red">*</span></label>
                <input type="datetime-local" step="0.01" class="form-control" id="hanSuDung" name="hanSuDung">
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>

            <div class="col-6">
                <label for="vat" class="form-label">Thuế VAT <span class="red">*</span></label>
                <input type="number" step="0.01" class="form-control" id="vat" value="Mark" name="vat">
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
        </div>

        <div class="row">
            <label for="moTa" class="form-label">Mô tả sản phẩm <span class="red">*</span></label>
            <textarea rows="10" id="moTa" cols="20" name="moTa"> </textarea>
        </div>

        <div class="row">
            <button class="btn btn-primary" type="submit">Lưu sản phẩm</button>
        </div>
</form>
</div>
</body>
</html>