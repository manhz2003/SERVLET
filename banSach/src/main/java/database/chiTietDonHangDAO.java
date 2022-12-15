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
        return null;
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
