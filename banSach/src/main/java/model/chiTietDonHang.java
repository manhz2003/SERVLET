package model;
public class chiTietDonHang {
    private String maChiTietDonHang;
    private donHang donHang;
    private sanPham sanPham;
    private double soLuong;
    private double giaGoc;
    private double giaBan;
    private double giamGia;
    private double thueVAT;
    private double tongTien;

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public chiTietDonHang(String maChiTietDonHang, model.donHang donHang, model.sanPham sanPham, double soLuong, double giaGoc, double giaBan, double giamGia, double thueVAT, double tongTien) {
        this.maChiTietDonHang = maChiTietDonHang;
        this.donHang = donHang;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.giaGoc = giaGoc;
        this.giaBan = giaBan;
        this.giamGia = giamGia;
        this.thueVAT = thueVAT;
        this.tongTien = tongTien;
    }

    public chiTietDonHang() {
    }

    public String getMaChiTietDonHang() {
        return maChiTietDonHang;
    }

    public void setMaChiTietDonHang(String maChiTietDonHang) {
        this.maChiTietDonHang = maChiTietDonHang;
    }

    public model.donHang getDonHang() {
        return donHang;
    }

    public void setDonHang(model.donHang donHang) {
        this.donHang = donHang;
    }

    public model.sanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(model.sanPham sanPham) {
        this.sanPham = sanPham;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
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

    public double getThueVAT() {
        return thueVAT;
    }

    public void setThueVAT(double thueVAT) {
        this.thueVAT = thueVAT;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaDonHang() {
        return null;
    }

    public String getMaSanPham() {
        return null;
    }

    @Override
    public String toString() {
        return "chiTietDonHang{" +
                "maChiTietDonHang='" + maChiTietDonHang + '\'' +
                ", donHang=" + donHang +
                ", sanPham=" + sanPham +
                ", soLuong=" + soLuong +
                ", giaGoc=" + giaGoc +
                ", giaBan=" + giaBan +
                ", thueVAT=" + thueVAT +
                ", tongTien=" + tongTien +
                '}';
    }
}
