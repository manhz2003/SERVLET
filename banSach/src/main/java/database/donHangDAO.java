package database;

import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class donHangDAO implements DAOInterface<donHang>{
    @Override
    public ArrayList<donHang> selectAll() {
        ArrayList<donHang> ketQua = new ArrayList<donHang>();
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhang";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maDonHang = rs.getString(1);
                String maKhachHang = rs.getString(2);
                String diaChiNguoiMua = rs.getString(3);
                String diaChiNhanHang = rs.getString(4);
                String trangThai = rs.getString(5);
                String hinhThucThanhToan = rs.getString(6);
                String trangThaiThanhToan = rs.getString(7);
                double soTienDaThanhToan = rs.getDouble(8);
                double soTienConThieu = rs.getDouble(9);
                Date ngayDatHang = rs.getDate(10);
                Date ngayGiaoHang = rs.getDate(11);

                khachHang kh1 = new khachHang();
                kh1.setMaKhachHang(maKhachHang);

                khachHang khachHang = new khachHangDAO().selectById(kh1);

                donHang dh = new donHang(maDonHang, khachHang, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, (java.sql.Date) ngayDatHang, (java.sql.Date) ngayGiaoHang);

                ketQua.add(dh);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public donHang selectById(donHang donHang) {
        donHang ketQua = null;
        Connection con = JDBC.getConnection();
        String sql = "SELECT * FROM donhang WHERE madonhang = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, donHang.getMaDonHang());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maDonHang = rs.getString(1);
                String maKhachHang = rs.getString(2);
                String diaChiNguoiMua = rs.getString(3);
                String diaChiNhanHang = rs.getString(4);
                String trangThai = rs.getString(5);
                String hinhThucThanhToan = rs.getString(6);
                String trangThaiThanhToan = rs.getString(7);
                double soTienDaThanhToan = rs.getDouble(8);
                double soTienConThieu = rs.getDouble(9);
                Date ngayDatHang = rs.getDate(10);
                Date ngayGiaoHang = rs.getDate(11);

                khachHang kh1 = new khachHang();
                kh1.setMaKhachHang(maKhachHang);

                khachHang khachHang = new khachHangDAO().selectById(kh1);

                donHang dh = new donHang(maDonHang, khachHang, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, soTienDaThanhToan, soTienConThieu, (java.sql.Date) ngayDatHang, (java.sql.Date) ngayGiaoHang);

                ketQua = dh;
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int insert(donHang donHang) {
        int kq = 0;
        Connection con = JDBC.getConnection();
        String sql = "INSERT INTO donhang(madonhang, khachhang, diachinguoimua, diachinguoinhan, trangthai, thanhtoan,trangthaithanhtoan ,tienthanhtoan, tienthieu,ngaydathang,ngaygiaohang)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, donHang.getMaDonHang());
            st.setString(2, donHang.getKhachHang().getMaKhachHang());
            st.setString(3, donHang.getDiaChiMuaHang());
            st.setString(4, donHang.getDiaChiNhanHang());
            st.setString(5, donHang.getTrangThai());
            st.setString(6, donHang.getHinhThucThanhToan());
            st.setString(7, donHang.getTrangThaiThanhToan());
            st.setDouble(8, donHang.getSoTienDaThanhToan());
            st.setDouble(9, donHang.getSoTienConThieu());
            st.setDate(10, donHang.getNgayDatHang());
            st.setDate(11, donHang.getNgayGiaoHang());

            kq = st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int insertAll(ArrayList<donHang> arr) {
        int kq = 0;
        for (donHang donHang : arr) {
            kq += this.insert(donHang);
        }
        return kq;
    }

    @Override
    public int delete(donHang donHang) {
        int kq = 0;
        Connection con = JDBC.getConnection();
        String sql = "DELETE FROM donhang WHERE madonhang = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, donHang.getMaDonHang());
            kq = st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public int deleteAll(ArrayList<donHang> arr) {
        int kq = 0;
        for (donHang t : arr) {
            kq += this.delete(t);
        }
        return kq;
    }

    @Override
    public int update(donHang donHang) {
        int kq = 0;
        Connection con = JDBC.getConnection();

        String sql = "UPDATE donhang" + " SET " + "khachhang=?" + ", diachinguoimua=?" + ",diachinguoinhan=?"
                + ",trangthai=?" + ",thanhtoan=?"+ ",trangthaithanhtoan=?" + ",tienthanhtoan=?" + ",tienthieu=?" + ",ngaydathang=?"
                + ",ngaygiaohang=?" + " WHERE madonhang=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, donHang.getMaDonHang());
            st.setString(2, donHang.getKhachHang().getMaKhachHang());
            st.setString(3, donHang.getDiaChiMuaHang());
            st.setString(4, donHang.getDiaChiNhanHang());
            st.setString(5, donHang.getTrangThai());
            st.setString(6, donHang.getHinhThucThanhToan());
            st.setString(7, donHang.getTrangThaiThanhToan());
            st.setDouble(8, donHang.getSoTienDaThanhToan());
            st.setDouble(9, donHang.getSoTienConThieu());
            st.setDate(10, donHang.getNgayDatHang());
            st.setDate(11, donHang.getNgayGiaoHang());

            kq = st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
}
