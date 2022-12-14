package database;

import model.chiTietDonHang;
import model.tacGia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class chiTietDonHangDAO implements DAOInterface<chiTietDonHang>{

    @Override
    public ArrayList<chiTietDonHang> selectAll() {
        ArrayList<chiTietDonHang> ketQua = new ArrayList<chiTietDonHang>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM chitietdonhang";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while(rs.next()) {
                String maChiTietDonHang = rs.getString("machitietdonhang");
                String donHang = rs.getString("donhang");
                String sanPham = rs.getString("sanpham");
                double soLuong = rs.getDouble("soluong");
                double giaGoc = rs.getDouble("giagoc");
                double giaBan = rs.getDouble("giaban");
                double thueVAT = rs.getDouble("thuevat");
                double tongTien = rs.getDouble("tongtien");

                chiTietDonHang ctdh = new chiTietDonHang(maChiTietDonHang, donHang, sanPham, soLuong, giaGoc, giaBan, thueVAT, tongTien);
                ketQua.add(ctdh);
            }

            // Bước 5: đóng kết nối
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public chiTietDonHang selectById(chiTietDonHang chiTietDonHang) {
        return null;
    }

    @Override
    public int insert(chiTietDonHang chiTietDonHang) {
        return 0;
    }

    @Override
    public int insertAll(ArrayList<chiTietDonHang> arr) {
        return 0;
    }

    @Override
    public int delete(chiTietDonHang chiTietDonHang) {
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<chiTietDonHang> arr) {
        return 0;
    }

    @Override
    public int update(chiTietDonHang chiTietDonHang) {
        return 0;
    }
}
