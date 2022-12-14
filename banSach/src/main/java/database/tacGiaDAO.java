package database;

import model.tacGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class tacGiaDAO implements DAOInterface<tacGia> {

    @Override
    public ArrayList<tacGia> selectAll() {
        ArrayList<tacGia> ketQua = new ArrayList<tacGia>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM tacgia";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while(rs.next()) {
                String maTacGia = rs.getString("matacgia");
                String hoVaTen = rs.getString("hovaten");
                Date ngaySinh = rs.getDate("ngaysinh");
                String tieuSu = rs.getString("tieusu");

                tacGia tg = new tacGia(maTacGia, hoVaTen, (java.sql.Date) ngaySinh, tieuSu);
                ketQua.add(tg);
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
    public tacGia selectById(tacGia t) {
        tacGia ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM tacgia WHERE matacgia =?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());
            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4: kết quả
            while(rs.next()) {
                String maTacGia = rs.getString("matacgia");
                String hoVaTen = rs.getString("hovaten");
                Date ngaySinh = rs.getDate("ngaysinh");
                String tieuSu = rs.getString("tieusu");

                ketQua = new tacGia(maTacGia, hoVaTen, (java.sql.Date) ngaySinh, tieuSu);
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
    public int insert(tacGia t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO tacgia (matacgia, hovaten, ngaysinh, tieusu) "+
                    " VALUES (?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());
            st.setString(2, t.getHoVaTen());
            st.setDate(3, t.getNgaySinh());
            st.setString(4, t.getTieuSu());

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
    public int insertAll(ArrayList<tacGia> arr) {
        int dem = 0;
        for (tacGia tacGia : arr) {
            dem+=this.insert(tacGia);
        }
        return dem;
    }

    @Override
    public int delete(tacGia t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from tacgia "+
                    " WHERE matacgia=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());

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
    public int deleteAll(ArrayList<tacGia> arr) {
        int dem = 0;
        for (tacGia tacGia : arr) {
            dem+=this.delete(tacGia);
        }
        return dem;
    }

    @Override
    public int update(tacGia t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBC.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE tacgia "+
                    " SET " +
                    " hovaten=?"+
                    ", ngaysinh=?"+
                    ", tieusu=?"+
                    " WHERE matacgia=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getHoVaTen());
            st.setDate(2, t.getNgaySinh());
            st.setString(3, t.getTieuSu());
            st.setString(4, t.getMaTacGia());
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
        tacGiaDAO tgd = new tacGiaDAO();
//		ArrayList<tacGia> kq = tgd.selectAll();
//		for (tacGia tacGia : kq) {
//			System.out.println(tacGia.toString());
//		}
//
//
//		tacGia tg = tgd.selectById(new tacGia("TG01", "", null, ""));
//		System.out.println(tg);

		tacGia tg_new = new tacGia("TG04", "David", new java.sql.Date(2000-1900, 05, 03), "");
		tgd.insert(tg_new);

//		TacGia tg_new = new TacGia("TG10", "David", new Date(2000-1900, 10, 15), "");
//		tgd.delete(tg_new);


//        TacGia tg = tgd.selectById(new TacGia("TG1", "", null, ""));
//        System.out.println(tg);
//        tg.setTieuSu("TIỂU SỬ ĐÃ BỊ THAY ĐỔI");
//
//        tgd.update(tg);
    }

}


