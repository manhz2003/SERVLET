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

//        lấy ra name của các thẻ input
        String soLuong = request.getParameter("soLuong");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");

//        giữ lại giá trị ô input khi người dùng nhập sai dữ liệu
        request.setAttribute("soLuong", soLuong);
        request.setAttribute("soDienThoai", soDienThoai);
        request.setAttribute("email", email);


//        mặc định ta xét cho checkError là false
//        các trường hợp bắt lỗi ta xét cho checkError = true
//        khi còn lỗi ta xét cho url = index.jsp, ở lại trang index.jsp, nếu pass qua lỗi thì chuyển trang success.jsp
        boolean checkError = false;
        int giatri_soluong = 0;

//        bắt lỗi số lượng
        try {
            giatri_soluong = Integer.parseInt(soLuong); // ép kiểu về int

            // Bắt lỗi số lượng >= 0
            if(giatri_soluong <= 0){
                checkError = true;
                request.setAttribute("err_SoLuong", "Vui lòng nhập số lượng lớn hơn không !");
            }
        } catch (Exception e) {
            checkError = true;
            request.setAttribute("err_SoLuong", "Nhập số lượng không hợp lệ !");
        }

//        bắt lỗi số điện thoại
        Pattern soDienThoaiPattern = Pattern.compile("\\d{10}"); // giới hạn sdt chỉ nhập 10 số
        Matcher soDienThoaiMatcher = soDienThoaiPattern.matcher(soDienThoai); // kiểm tra sdt nhập vào khớp với yêu cầu 10 kí tự

        int sdt = 0;
        try {
            sdt  = Integer.parseInt(soDienThoai);
            if( ! soDienThoaiMatcher.matches()){ // nếu sdt nhập vào không khớp với yêu cầu
                checkError = true;
                request.setAttribute("err_SDT", " Số điện thoại phải bao gồm 10 ký tự !"); // thì hiện thông báo lỗi
            }
        }catch (Exception e){
            checkError = true;
            request.setAttribute("err_SDT", "Không hợp lệ !");
        }

//        bắt lỗi email
        Pattern emaillPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+(\\.\\w+)*");
        Matcher emailMatcher = emaillPattern.matcher(email);
        if(!emailMatcher.matches()){
            checkError = true;
            request.setAttribute("err_Email", "Cấu trúc email không hợp lệ !");
        }

        String url = "/success.jsp"; // nếu k có lỗi
        if(checkError){
            url = "/index.jsp"; // nếu có lỗi thì quay lại trang index.jsp
        }
        RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

}