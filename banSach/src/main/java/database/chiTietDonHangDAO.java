package database;

import model.chiTietDonHang;
import model.donHang;
import model.sanPham;
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

            while (rs.next()) {
                String maChiTietDonHang = rs.getString("machitietdonhang");
                String maDonHang = rs.getString("madonhang");
                String maSanPham = rs.getString("masanpham");
                double soLuong = rs.getDouble("soluong");
                double giaGoc = rs.getDouble("giagoc");
                double giamGia = rs.getDouble("giamgia");
                double giaBan = rs.getDouble("giaban");
                double thueVAT = rs.getDouble("thuevat");
                double tongTien = rs.getDouble("tongtien");

                donHang dh1 = new donHang();
                dh1.setMaDonHang(maDonHang);

                sanPham sp1 = new sanPham();
                sp1.setMaSanPham(maSanPham);
                donHang donHang = (new donHangDAO()).selectById(dh1);
                sanPham sanPham = (new sanPhamDAO()).selectById(sp1);

                chiTietDonHang ctdh = new chiTietDonHang(maChiTietDonHang, donHang, sanPham, soLuong, giaGoc, giamGia, giaBan, thueVAT, tongTien);
                ketQua.add(ctdh);
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
    public chiTietDonHang selectById(chiTietDonHang chiTietDonHang) {
        chiTietDonHang ketQua = null;
        try {
            Connection con = JDBC.getConnection();

            String sql = "SELECT * FROM chitietdonhang WHERE machitietdonhang=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, chiTietDonHang.getMaChiTietDonHang());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String maChiTietDonHang = rs.getString("machitietdonhang");
                String madonhang = rs.getString("donhang");
                String masanpham = rs.getString("sanpham");
                double soluong = rs.getDouble("soluong");
                double giagoc = rs.getDouble("giagoc");
                double giamgia = rs.getDouble("giamgia");
                double giaban = rs.getDouble("giaban");
                double thuevat = rs.getDouble("thuevat");
                double tongtien = rs.getDouble("tongtien");

                donHang dh1 = new donHang();
                dh1.setMaDonHang(madonhang);

                sanPham sp1 = new sanPham();
                sp1.setMaSanPham(masanpham);

                donHang dh = new donHangDAO().selectById(dh1);
                sanPham sp = new sanPhamDAO().selectById(sp1);

                ketQua = new chiTietDonHang(maChiTietDonHang, dh, sp, soluong, giagoc, giamgia, giaban, thuevat,
                        tongtien);
                break;
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
    public int insert(chiTietDonHang chiTietDonHang) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO chitietdonhang (machitietdonhang, donhang,sanpham, soluong, giagoc,giamgia,giaban,thuevat,tongtien) "
                    + " VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, chiTietDonHang.getMaChiTietDonHang());
            st.setString(2, chiTietDonHang.getDonHang().getMaDonHang());
            st.setString(3, chiTietDonHang.getSanPham().getMaSanPham());
            st.setDouble(4, chiTietDonHang.getSoLuong());
            st.setDouble(5, chiTietDonHang.getGiaGoc());
            st.setDouble(7, chiTietDonHang.getGiamGia());
            st.setDouble(6, chiTietDonHang.getGiaBan());
            st.setDouble(8, chiTietDonHang.getThueVAT());
            st.setDouble(9, chiTietDonHang.getTongTien());
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
    public int insertAll(ArrayList<chiTietDonHang> arr) {
        int dem = 0;
        for (chiTietDonHang ChiTietDonHang : arr) {
            dem += this.insert(ChiTietDonHang);
        }
        return dem;
    }

    @Override
    public int delete(chiTietDonHang chiTietDonHang) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from chitietdonhang " + " WHERE machitietdonhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, chiTietDonHang.getMaChiTietDonHang());

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
    public int deleteAll(ArrayList<chiTietDonHang> arr) {
        int dem = 0;
        for (chiTietDonHang ChiTietDonHang : arr) {
            dem += this.delete(ChiTietDonHang);
        }
        return dem;
    }

    @Override
    public int update(chiTietDonHang chiTietDonHang) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE chitietdonhang SET donhang=?, sanpham=?, soluong=?, giagoc=?, giamgia=?, giaban=?, thuevat=?, tongtien=?"
                    + " WHERE machitietdonhang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, chiTietDonHang.getDonHang().getMaDonHang());
            st.setString(2, chiTietDonHang.getSanPham().getMaSanPham());
            st.setDouble(3, chiTietDonHang.getSoLuong());
            st.setDouble(4, chiTietDonHang.getGiaGoc());
            st.setDouble(5, chiTietDonHang.getGiamGia());
            st.setDouble(6, chiTietDonHang.getGiaBan());
            st.setDouble(7, chiTietDonHang.getThueVAT());
            st.setDouble(8, chiTietDonHang.getTongTien());
            st.setString(9, chiTietDonHang.getMaChiTietDonHang());

            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            JDBC.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }
}
