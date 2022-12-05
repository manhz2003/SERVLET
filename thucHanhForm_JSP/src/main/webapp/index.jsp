<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--Thêm thư viện java bất kì vào file jsp--%>
<%@ page import="java.lang.Math" %>
<!DOCTYPE html>
<html>
<head>
  <title>Form</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>

<%-- để chạy được các file html jsp cần thay đổi tên file + đuôi định dạng. Ví dụ: index.jsp, hello.html.....--%>

<div class="container">
<%--  action trong form giúp chuyển đến 1 trang jsp khác sau khi người dùng bấm submit--%>
<%--  method là phương thức gồm get và post--%>
<%--  get:  hiện dữ liệu trên thanh url trình duyệt, nếu ta k đặt thuộc tính cho method mặc định sẽ là get--%>
<%--  post: nội dung của Http Request gửi đến Server và là ẩn với người dùng, sử dụng post an toàn hơn--%>
  <form action="datHang.jsp" method="get">
    <div class="form-group row">
      <label for="hoVaTen" class="col-sm-2 col-form-label">Họ và tên</label>
      <div class="col-sm-10">
        <input type="text"  class="form-control" id="hoVaTen" name="hoVaTen">
      </div>
    </div>

    <div class="form-group row">
      <label for="email" class="col-sm-2 col-form-label">Email</label>
      <div class="col-sm-10">
        <input type="text"  class="form-control" id="email" name="email">
      </div>
    </div>

    <div class="form-group row">
      <label for="soLuong" class="col-sm-2 col-form-label">Số lượng</label>
      <div class="col-sm-10">
        <input type="text"  class="form-control" id="soLuong" name="soLuong">
      </div>
    </div>

    <div class="form-group row">
      <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
      <div class="col-sm-10">
        <input type="password" class="form-control" id="inputPassword" placeholder="Password">
      </div>
    </div>

    <div class="form-group row">
      <button type="submit" class="btn btn-primary">Đặt hàng</button>
    </div>

  </form>
</div>
</body>
</html>