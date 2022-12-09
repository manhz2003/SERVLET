package controller.servlet_03;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// Bắt lỗi với Regular Expression
@WebServlet("/muaHang")
public class muaHang extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String soLuong = request.getParameter("soLuong");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");

        boolean checkError = false;
        double giatri_soluong = 0;

//        bắt lỗi số lượng
        try {
            giatri_soluong = Double.parseDouble(soLuong);
        } catch (Exception e) {
            checkError = true;
            request.setAttribute("err_SoLuong", "Nhập số lượng không hợp lệ !");
        }
//        Bắt lỗi số lượng > 0
        if(giatri_soluong == 0){
            checkError = true;
            request.setAttribute("err_SoLuong", "Vui lòng nhập số lượng lớn hơn không !");
        }
//        bắt lỗi số điện thoại
//
        Pattern soDienThoaiPattern = Pattern.compile("\\d{10}"); // giới hạn sdt chỉ nhập 10 số
        Matcher soDienThoaiMatcher = soDienThoaiPattern.matcher(soDienThoai); // kiểm tra sdt nhập vào khớp với yêu cầu 10 kí tự

        if(!soDienThoaiMatcher.matches()){ // nếu sdt nhập vào không khớp với yêu cầu
            checkError = true; // thì hiện thông báo lỗi
            request.setAttribute("err_SDT", " Số điện thoại bao gồm 10 ký tự !");
        }

//        bắt lỗi email
        Pattern emaillPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+(\\.\\w+)*");
        Matcher emailMatcher = emaillPattern.matcher(email);
        if(!emailMatcher.matches()){
            checkError = true; // thì hiện thông báo lỗi
            request.setAttribute("err_Email", "Cấu trúc email không hợp lệ !");
        }

        String url = "/succsess.jsp";
        if(checkError){
            url = "/index.jsp";
        }
        RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void destroy() {
    }
}