package model;

public class theLoai {
    private String maTheLoai;
    private String tenTheLoai;

    public theLoai(String maTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    public theLoai() {
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai() {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    @Override
    public String toString() {
        return "theLoai{" +
                "maTheLoai='" + maTheLoai + '\'' +
                ", tenTheLoai='" + tenTheLoai + '\'' +
                '}';
    }
}
