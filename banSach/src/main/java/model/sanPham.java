package model;

public class sanPham {
    private String maSanPham;
    private String tenSanPham;
    private tacGia tacGia;
    private int namXuatBan;
    private double giaNhap;
    private double giaGoc;
    private double giaBan;
    private int soLuong;
    private theLoai theLoai;
    private String ngonNgu;
    private String moTa;

    public sanPham(String maSanPham, String tenSanPham, model.tacGia tacGia, int namXuatBan, double giaNhap, double giaGoc, double giaBan, int soLuong, model.theLoai theLoai, String ngonNgu, String moTa) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.giaNhap = giaNhap;
        this.giaGoc = giaGoc;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.theLoai = theLoai;
        this.ngonNgu = ngonNgu;
        this.moTa = moTa;
    }

    public sanPham() {
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public model.tacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(model.tacGia tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(double giaGoc) {
        this.giaGoc = giaGoc;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public model.theLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(model.theLoai theLoai) {
        this.theLoai = theLoai;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
