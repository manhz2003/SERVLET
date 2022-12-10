package controller;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/dangNhap")
public class dangNhap extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        cài font chữ tiếng việt
        response.setContentType("text/html; charset=UTF-8");

//        lấy ra name của các thẻ cần sử lý bên file login.jsp
        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");

        String url = ""; // chứa link trang cần chuyển đến
        if (tenDangNhap.equals("manh")&&matKhau.equals("123")){
            url = "/Succsess.jsp";
        }else {
            url = "/Error.jsp";
        }

//      RequestDispatcher giúp điều hướng đến 1 trang khác
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
