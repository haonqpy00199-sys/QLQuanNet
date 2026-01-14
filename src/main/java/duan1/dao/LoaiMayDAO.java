/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.dao;

import duan1.entity.LoaiMay;
import java.util.List;

public interface LoaiMayDAO {
    void insert(LoaiMay loaiMay);
    void update(LoaiMay loaiMay);
    void delete(int maLoai);
    LoaiMay findById(int maLoai);
    List<LoaiMay> findAll();
}
