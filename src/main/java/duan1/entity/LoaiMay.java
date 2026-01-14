/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

/**
 *
 * @author Mc Tech
 */
public class LoaiMay {
    private int MaLoai;
    private String TenLoai;
    private int DonGia;
    
    public LoaiMay(){
        
    }

    public LoaiMay(int MaLoai, String TenLoai, int DonGia) {
        this.MaLoai = MaLoai;
        this.TenLoai = TenLoai;
        this.DonGia = DonGia;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }
    
    
}
