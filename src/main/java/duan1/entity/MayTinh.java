/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.entity;

import java.time.LocalTime;

/**
 *
 * @author pc
 */
public class MayTinh {

    private int MaMay;
    private int MaLoai;
    private int TrangThai;
    private LocalTime thoiGianBatDau; // Phải có trường này

    public MayTinh() {
    }
    
    

    public MayTinh(int MaMay, int MaLoai, int TrangThai) {
        this.MaMay = MaMay;
        this.MaLoai = MaLoai;
        this.TrangThai = TrangThai;
    }

    public int getMaMay() {
        return MaMay;
    }

    public void setMaMay(int MaMay) {
        this.MaMay = MaMay;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int MaLoai) {
        this.MaLoai = MaLoai;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public LocalTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    
}
