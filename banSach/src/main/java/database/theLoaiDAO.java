package database;

import model.tacGia;
import model.theLoai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class theLoaiDAO implements DAOInterface<theLoai>{
    @Override
    public ArrayList<theLoai> selectAll() {
        ArrayList<theLoai> ketQua = new ArrayList<theLoai>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM theloai";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while(rs.next()) {
                String maTheLoai = rs.getString("matheloai");
                String tenTheLoai = rs.getString("tenTheLoai");

                theLoai tl = new theLoai(maTheLoai, tenTheLoai);
                ketQua.add(tl);
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
    public theLoai selectById(theLoai theLoai) {
        theLoai ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM theloai WHERE matheloai =?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, theLoai.getMaTheLoai());
            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4: kết quả
            while(rs.next()) {
                String maTheLoai = rs.getString("matheloai");
                String tentheloai = rs.getString("tentheloai");

                ketQua = new theLoai(maTheLoai, tentheloai);
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
    public int insert(theLoai theLoai) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO theloai (matheloai, tentheloai) "+
                    " VALUES (?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, theLoai.getMaTheLoai());
            st.setString(2, theLoai.getTenTheLoai());

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
    public int insertAll(ArrayList<theLoai> arr) {
        int dem = 0;
        for (theLoai tl : arr) {
            dem+=this.insert(tl);
        }
        return dem;
    }

    @Override
    public int delete(theLoai theLoai) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from theloai "+
                    " WHERE matheloai=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, theLoai.getMaTheLoai());

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
    public int deleteAll(ArrayList<theLoai> arr) {
        int dem = 0;
        for (theLoai tl : arr) {
            dem+=this.delete(tl);
        }
        return dem;
    }

    @Override
    public int update(theLoai theLoai) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE theloai "+
                    " SET " +
                    " tentheloai=?"+
                    " WHERE matacgia=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, theLoai.getMaTheLoai());
            st.setString(2, theLoai.getTenTheLoai());
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
        theLoaiDAO tld = new theLoaiDAO();
//        ArrayList<theLoai> kq = tld.selectAll();
//		for (theLoai tl : kq) {
//			System.out.println(tl.toString());
//		}
//        theLoai tl = tld.selectById(new theLoai("TL1", null));
//        System.out.println(tl);
        theLoai tl = new theLoai("TL", "");

    }
}
