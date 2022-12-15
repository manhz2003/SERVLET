package database;

import model.khachHang;
import model.tacGia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class khachHangDAO implements DAOInterface<khachHang>{
    @Override
    public ArrayList<khachHang> selectAll() {
        ArrayList<khachHang> ketQua = new ArrayList<khachHang>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM khachhang";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while(rs.next()) {
                String maKhachHang = rs.getString("makhachhang");
                String tenDangNhap = rs.getString("tendangnhap");
                String matKhau = rs.getString("matkhau");
                String hoVaTen = rs.getString("hovaten");
                String gioiTinh = rs.getString("gioitinh");
                String diaChi = rs.getString("diachi");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                String diaChiMuaHang = rs.getString("diachimuahang");
                Date ngaySinh = rs.getDate("ngaysinh");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");

                khachHang kh = new khachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, (java.sql.Date) ngaySinh , soDienThoai, email, dangKyNhanBangTin);
                ketQua.add(kh);
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
    public khachHang selectById(khachHang khachHang) {
        khachHang ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM khachhang WHERE makhachhang =?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, khachHang.getMaKhachHang());
            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4: kết quả
            while(rs.next()) {
                String maKhachHang = rs.getString("makhachhang");
                String tenDangNhap = rs.getString("tendangnhap");
                String matKhau = rs.getString("matkhau");
                String hoVaTen = rs.getString("hovaten");
                String gioiTinh = rs.getString("gioitinh");
                String diaChi = rs.getString("diachi");
                String diaChiNhanHang = rs.getString("diachinhanhang");
                String diaChiMuaHang = rs.getString("diachimuahang");
                Date ngaySinh = rs.getDate("ngaysinh");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                boolean dangKyNhanBangTin = rs.getBoolean("dangkynhanbangtin");

                ketQua = new khachHang(maKhachHang, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, diaChiNhanHang, diaChiMuaHang, (java.sql.Date) ngaySinh , soDienThoai, email, dangKyNhanBangTin);
                break;
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
    public int insert(khachHang khachHang) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO khachhang (makhachhang, tendangnhap, matkhau, hovaten, gioitinh, diachi, diachinhanhang, diachimuahang, ngaysinh, sodienthoai, email, dangkynhanbangtin) "+
                    " VALUES (?,?,?,?, ?,?,?,?, ?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, khachHang.getMaKhachHang());
            st.setString(2, khachHang.getTenDangNhap());
            st.setString(3, khachHang.getMatKhau());
            st.setString(4, khachHang.getHoVaTen());
            st.setString(5, khachHang.getGioiTinh());
            st.setString(6, khachHang.getDiaChi());
            st.setString(7, khachHang.getDiaChiNhanHang());
            st.setString(8, khachHang.getDiaChiMuaHang());
            st.setDate(9,  khachHang.getNgaySinh());
            st.setString(10, khachHang.getSoDienThoai());
            st.setString(11, khachHang.getEmail());
            st.setBoolean(12, khachHang.getDangKyNhanBangTin());

            // Bước 3: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ ketQua+" dòng bị thay đổi!");

            // Bước 5:
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insertAll(ArrayList<khachHang> arr) {
        int dem = 0;
        for (khachHang kh : arr) {
            dem+=this.insert(kh);
        }
        return dem;
    }

    @Override
    public int delete(khachHang khachHang) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from khachhang "+
                    " WHERE makhachhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, khachHang.getMaKhachHang());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ ketQua+" dòng bị thay đổi!");

            // Bước 5:
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int deleteAll(ArrayList<khachHang> arr) {
        int dem = 0;
        for (khachHang kh : arr) {
            dem+=this.delete(kh);
        }
        return dem;
    }

    @Override
    public int update(khachHang khachHang) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE khachhang "+
                    " SET " +
                    " tendangnhap=?"+
                    ", matkhau=?"+
                    ", hovaten=?"+
                    ", gioitinh=?"+
                    ", diachi=?"+
                    ", diachinhanhang=?"+
                    ", diachimuahang=?"+
                    ", ngaysinh=?"+
                    ", sodienthoai=?"+
                    ", email=?"+
                    ", dangkynhanbangtin=?"+
                    " WHERE matacgia=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, khachHang.getTenDangNhap());
            st.setString(2, khachHang.getMatKhau());
            st.setString(3, khachHang.getHoVaTen());
            st.setString(4, khachHang.getGioiTinh());
            st.setString(5, khachHang.getDiaChi());
            st.setString(6, khachHang.getDiaChiNhanHang());
            st.setString(7, khachHang.getDiaChiMuaHang());
            st.setDate(8,  khachHang.getNgaySinh());
            st.setString(9, khachHang.getSoDienThoai());
            st.setString(10, khachHang.getEmail());
            st.setBoolean(11, khachHang.getDangKyNhanBangTin());
            st.setString(12, khachHang.getMaKhachHang());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: "+ sql);
            System.out.println("Có "+ ketQua+" dòng bị thay đổi!");

            // Bước 5:
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    public static void main(String[] args) {
        khachHangDAO khd = new khachHangDAO();
        khachHang kh = new khachHang("KH001", "", "", "", "", "", "", "", null, "", "", true);
        khd.insert(kh);

    }
}
