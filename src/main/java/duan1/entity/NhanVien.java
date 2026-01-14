/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

/**
 *
 * @author pc
 */
public class NhanVien {

    private String TenDangNhap;
    private String MatKhau;
    private String HoTen;
    private boolean TrangThai;
    private String Hinh;
    private boolean chucVu;

    public NhanVien() {
    }

    public NhanVien(String TenDangNhap, String MatKhau, String HoTen, boolean TrangThai, String Hinh, boolean chucVu) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.TrangThai = TrangThai;
        this.Hinh = Hinh;
        this.chucVu = chucVu;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public boolean isChucVu() {
        return chucVu;
    }

    public void setChucVu(boolean ChucVu) {
        this.chucVu = chucVu;
    }

    

    public static class Builder {

        private String tenDangNhap;
        private String matKhau;
        private String hoTen;
        private boolean trangThai;
        private String hinh = "photo.png";
        private boolean chucVu;

        public Builder tenDangNhap(String tenDangNhap) {
            this.tenDangNhap = tenDangNhap;
            return this;
        }

        public Builder matKhau(String matKhau) {
            this.matKhau = matKhau;
            return this;
        }

        public Builder hoTen(String hoTen) {
            this.hoTen = hoTen;
            return this;
        }

        public Builder trangThai(boolean trangThai) {
            this.trangThai = trangThai;
            return this;
        }

        public Builder hinh(String hinh) {
            this.hinh = (hinh != null) ? hinh : "photo.jpg";
            return this;
        }

        public Builder chucVu(boolean chucVu) {
            this.chucVu = chucVu;
            return this;
        }

        public NhanVien build() {
            NhanVien nhanvien = new NhanVien(tenDangNhap, matKhau, hoTen, trangThai, hinh, chucVu);
            nhanvien.setHinh(hinh);
            return nhanvien;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

}