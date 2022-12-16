package database;

import model.sanPham;
import model.tacGia;
import model.theLoai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class sanPhamDAO implements DAOInterface<sanPham>{
    @Override
    public ArrayList<sanPham> selectAll() {
        ArrayList<sanPham> ketQua = new ArrayList<sanPham>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM sanpham";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maSanPham = rs.getString("masanpham");
                String tenSanPham = rs.getString("tensanpham");
                String maTacGia = rs.getString("matacgia");
                int namXuatBan = rs.getInt("namxuatban");
                double giaNhap = rs.getDouble("gianhap");
                double giaGoc = rs.getDouble("giagoc");
                double giaBan = rs.getDouble("giaban");
                int soLuong = (int) rs.getDouble("soluong");
                String maTheLoai = rs.getString("matheloai");
                String ngonNgu = rs.getString("ngonngu");
                String moTa = rs.getString("mota");

                tacGia tacGia = (new tacGiaDAO().selectById(new tacGia(maTacGia, "", null, "")));
                theLoai theLoai = (new theLoaiDAO().selectById(new theLoai(maTheLoai, "")));

                sanPham sp = new sanPham(maSanPham, tenSanPham, tacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong,
                        theLoai, ngonNgu, moTa);
                ketQua.add(sp);
            }

            // Bước 5:
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public sanPham selectById(sanPham sanPham) {
        sanPham ketQua = null;
        try {
            Connection con = JDBC.getConnection();

            String sql = "SELECT * FROM sanpham WHERE masanpham=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sanPham.getMaSanPham());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maSanPham = rs.getString("masanpham");
                String tenSanPham = rs.getString("tensanpham");
                String maTacGia = rs.getString("matacgia");
                int namXuatBan = rs.getInt("namxuatban");
                double giaNhap = rs.getDouble("gianhap");
                double giaGoc = rs.getDouble("giagoc");
                double giaBan = rs.getDouble("giaban");
                int soLuong = (int) rs.getDouble("soluong");
                String maTheLoai = rs.getString("matheloai");
                String ngonNgu = rs.getString("ngonngu");
                String moTa = rs.getString("mota");

                tacGia tacGia = (new tacGiaDAO().selectById(new tacGia(maTacGia, "", null, "")));
                theLoai theLoai = (new theLoaiDAO().selectById(new theLoai(maTheLoai, "")));

                ketQua = new sanPham(maSanPham, tenSanPham, tacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong, theLoai, ngonNgu, moTa);
                break;
            }

            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insert(sanPham sanPham) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO sanpham (masanpham,tensanpham, matacgia, namxuatban,"
                    + " gianhap, giagoc, giaban, soluong, matheloai, ngonngu, mota) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sanPham.getMaSanPham());
            st.setString(2, sanPham.getTenSanPham());
            st.setString(3, sanPham.getTacGia().getMaTacGia());
            st.setInt(4, sanPham.getNamXuatBan());
            st.setDouble(5, sanPham.getGiaNhap());
            st.setDouble(6, sanPham.getGiaGoc());
            st.setDouble(7, sanPham.getGiaBan());
            st.setDouble(8, sanPham.getSoLuong());
            st.setString(9, sanPham.getTheLoai().getMaTheLoai());
            st.setString(10, sanPham.getNgonNgu());
            st.setString(11, sanPham.getMoTa());

            // Bước 3: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insertAll(ArrayList<sanPham> arr) {
        int dem = 0;
        for (sanPham sp : arr) {
            dem += this.insert(sp);
        }
        return dem;
    }

    @Override
    public int delete(sanPham sanPham) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from sanpham " + " WHERE masanpham=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sanPham.getMaSanPham());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int deleteAll(ArrayList<sanPham> arr) {
        int dem = 0;
        for (sanPham sp : arr) {
            dem += this.delete(sp);
        }
        return dem;
    }

    @Override
    public int update(sanPham sanPham) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE sanpham " + " SET " + "tensanpham=?, matacgia=?, namxuatban=?, gianhap=?, giagoc=?, "
                    + "giaban=?, soluong=?, matheloai=?, ngonngu=?, mota=?" + " WHERE masanpham=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sanPham.getTenSanPham());
            st.setString(2, sanPham.getTacGia().getMaTacGia());
            st.setInt(3, sanPham.getNamXuatBan());
            st.setDouble(4, sanPham.getGiaNhap());
            st.setDouble(5, sanPham.getGiaGoc());
            st.setDouble(6, sanPham.getGiaBan());
            st.setDouble(7, sanPham.getSoLuong());
            st.setString(8, sanPham.getTheLoai().getMaTheLoai());
            st.setString(9, sanPham.getNgonNgu());
            st.setString(10, sanPham.getMoTa());
            st.setString(11, sanPham.getMaSanPham());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println("Bạn đã thực thi: " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    public static void main(String[] args) {
//        sanPhamDAO spd = new sanPhamDAO();
//
//        sanPham sp = new sanPham("SP01", "lập trình c", "12", 2003, 20, 20, 20, 10, "12", "tieng viet", "");
//   spd.insert(sp);

    }
}
