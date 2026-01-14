/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.dao.impl;

/**
 *
 * @author Mc Tech
 */


import duan1.dao.LoaiMayDAO;
import duan1.entity.LoaiMay;
import duan1.util.XJdbc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoaiMayDAOImpl implements LoaiMayDAO {

    @Override
    public void insert(LoaiMay loaiMay) {
        String sql = "INSERT INTO LoaiMay (MaLoai, TenLoai, DonGia) VALUES (?, ?)";
        try (Connection con = XJdbc.openConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, loaiMay.getMaLoai());
            ps.setString(2, loaiMay.getTenLoai());
            ps.setDouble(3, loaiMay.getDonGia());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(LoaiMay loaiMay) {
        String sql = "UPDATE LoaiMay SET TenLoai = ?, DonGia = ? WHERE MaLoai = ?";
        try (Connection con = XJdbc.openConnection();  
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, loaiMay.getTenLoai());
            ps.setDouble(2, loaiMay.getDonGia());
            ps.setInt(3, loaiMay.getMaLoai());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int maLoai) {
        String sql = "DELETE FROM LoaiMay WHERE MaLoai = ?";
        try (Connection con = XJdbc.openConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maLoai);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LoaiMay findById(int maLoai) {
        String sql = "SELECT * FROM LoaiMay WHERE MaLoai = ?";
        try (Connection con = XJdbc.openConnection(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maLoai);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new LoaiMay(
                        rs.getInt("MaLoai"),
                        rs.getString("TenLoai"),
                        rs.getInt("DonGia")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<LoaiMay> findAll() {
        List<LoaiMay> list = new ArrayList<>();
        String sql = "SELECT * FROM LoaiMay";
        try (Connection con = XJdbc.openConnection(); 
             Statement st = con.createStatement(); 
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new LoaiMay(
                    rs.getInt("MaLoai"),
                    rs.getString("TenLoai"),
                    rs.getInt("DonGia")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

