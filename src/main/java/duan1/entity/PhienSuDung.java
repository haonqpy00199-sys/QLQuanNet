/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author pc
 */
public class PhienSuDung {
    private int maPhien;
    private Timestamp TGBatDau;
    private Timestamp TGKetThuc;
    private int MaMay;
    private int TongTien;
    private String TenDangNhap;

    public PhienSuDung() {
    }

    public PhienSuDung(int maPhien, Timestamp TGBatDau, Timestamp TGKetThuc, int MaMay, int TongTien, String TenDangNhap) {
        this.maPhien = maPhien;
        this.TGBatDau = TGBatDau;
        this.TGKetThuc = TGKetThuc;
        this.MaMay = MaMay;
        this.TongTien = TongTien;
        this.TenDangNhap = TenDangNhap;
    }

    public int getMaPhien() {
        return maPhien;
    }

    public void setMaPhien(int maPhien) {
        this.maPhien = maPhien;
    }

    public Timestamp getTGBatDau() {
        return TGBatDau;
    }

    public void setTGBatDau(Timestamp TGBatDau) {
        this.TGBatDau = TGBatDau;
    }

    public Timestamp getTGKetThuc() {
        return TGKetThuc;
    }

    public void setTGKetThuc(Timestamp TGKetThuc) {
        this.TGKetThuc = TGKetThuc;
    }

    public int getMaMay() {
        return MaMay;
    }

    public void setMaMay(int MaMay) {
        this.MaMay = MaMay;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }
    
    
}