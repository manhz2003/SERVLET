package com.example.helloservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// tên truy cập đường dẫn tới trang
@WebServlet("/test")
public class demo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      nếu tạo nhiều session thì làm như sau:
//      kết nối với đường dẫn file jsp hoặc file html (thêm dấu / trước tên đường dẫn)
        String url = "/demo.html";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(req, resp);
    }
}
