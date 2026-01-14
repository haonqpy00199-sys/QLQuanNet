/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.controller;

import duan1.dao.LoaiMayDAO;
import duan1.dao.impl.LoaiMayDAOImpl;
import duan1.entity.LoaiMay;
import java.util.List;

public class LoaiMayController {
    private LoaiMayDAO loaiMayDAO = new LoaiMayDAOImpl();

    public void addLoaiMay(String tenLoai, int donGia) {
        LoaiMay lm = new LoaiMay(0, tenLoai, donGia);
        loaiMayDAO.insert(lm);
    }

    public void updateLoaiMay(int maLoai, String tenLoai, int donGia) {
        LoaiMay lm = new LoaiMay(maLoai, tenLoai, donGia);
        loaiMayDAO.update(lm);
    }

    public void deleteLoaiMay(int maLoai) {
        loaiMayDAO.delete(maLoai);
    }

    public LoaiMay getLoaiMay(int maLoai) {
        return loaiMayDAO.findById(maLoai);
    }

    public List<LoaiMay> getAllLoaiMay() {
        return loaiMayDAO.findAll();
    }
}

