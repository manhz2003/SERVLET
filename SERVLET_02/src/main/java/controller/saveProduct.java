package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/save_product")
public class saveProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String maSanPham = request.getParameter("maSanPham");
        String tenSanPham = request.getParameter("tenSanPham");
        String giaBan = request.getParameter("giaBan");
        String giaNhap = request.getParameter("giaNhap");
        String VAT = request.getParameter("VAT");
        String moTa = request.getParameter("moTa");

//        check
        String error_msp = "";
        if(maSanPham == null || maSanPham.trim().length() == 0){
            error_msp = "Vui lòng nhập mã sản phẩm";
        }else if(maSanPham.equals("123")){
            error_msp += "Mã sản phẩm 123 đã tồn tại, vui lòng nhập lại mã sản phẩm !";
        }
        request.setAttribute("error_msp", error_msp);

        request.setAttribute("value_msp", maSanPham);
        request.setAttribute("value_giaNhap", giaNhap);
        request.setAttribute("value_giaBan", giaBan);
        request.setAttribute("value_VAT", VAT);
        request.setAttribute("value_moTa", moTa);
        request.setAttribute("value_tenSanPham", tenSanPham);


//        url
        String url = "/succsess.jsp"; // nếu k có lỗi thì chuyển sang trang succsess.jsp
        if(error_msp.length()>0){ // kiểm tra nếu error_msp chứa chuỗi báo lỗi thì ở lại trang product.jsp
            url = "/product.jsp";
        }

//        RequestDispatcher giúp chuyển trang
        RequestDispatcher rq = getServletContext().getRequestDispatcher(url);
        rq.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
