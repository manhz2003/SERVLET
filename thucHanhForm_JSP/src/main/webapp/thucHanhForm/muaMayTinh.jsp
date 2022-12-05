<%--
  Created by IntelliJ IDEA.
  User: manht
  Date: 12/5/2022
  Time: 10:29 PM
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
<%-- Để chạy file jsp nhập trên url tên thư mục + tên file , thucHanhForm/muaMayTinh.jsp--%>
<div class="container">
    <h1>Chọn cấu hình máy tính bạn cần mua</h1>
    <form action="hoaDonMuaMT.jsp">

        <h2>CPU</h2>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="core I 9" id="coreI9" name="CPU">
            <label class="form-check-label" for="coreI9">
                Core i9
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="coreI7" id="coreI7" name="CPU">
            <label class="form-check-label" for="coreI7">
                Core i7
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="coreI7" id="coreI5" name="CPU">
            <label class="form-check-label" for="coreI5">
                Core i7
            </label>
        </div>

        <h2>RAM</h2>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="RAM8GB" id="RAM8GB" name="RAM">
            <label class="form-check-label" for="RAM8GB">
                Ram 8 GB
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="RAM16GB" id="RAM16GB" name="RAM">
            <label class="form-check-label" for="RAM16GB">
                Ram 16 GB
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" value="RAM4GB" id="RAM4GB" name="RAM">
            <label class="form-check-label" for="RAM4GB">
                Ram 4 GB
            </label>
        </div>

        <h2>Thiết bị khác</h2>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="manHinh" id="manHinh" name="thietBi">
            <label class="form-check-label" for="manHinh">
                Màn hình
            </label>
        </div>

        <h2>Phụ kiện máy tính</h2>

        <select class="form-select" multiple aria-label=".form-select-sm example" name="phuKienMT">
            <option selected>Open this select menu</option>
            <option value="Camera">Camera</option>
            <option value="Printer">Printer</option>
            <option value="Scanner">Scanner</option>
        </select> <br>
        <button class="btn btn-primary" type="submit">Buy</button>
    </form>
</div>

</body>
</html>
