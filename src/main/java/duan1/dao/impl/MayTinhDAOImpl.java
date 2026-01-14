/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.dao.impl;

import duan1.dao.MayTinhDAO;
import duan1.entity.MayTinh;
import duan1.util.XJdbc;
import duan1.util.XQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public  class MayTinhDAOImpl implements MayTinhDAO {

    // Thêm máy mới
    String sqlCreate = "INSERT INTO [QLQuanNet].[dbo].[MayTinh] ([MaMay], [MaLoai], [TrangThai]) VALUES (?, ?, ?)";

    String sqlUpdate = "UPDATE [QLQuanNet].[dbo].[MayTinh] "
            + "SET [MaLoai] = ?, [TrangThai] = ?, [ThoiGianBatDau] = ? "
            + "WHERE [MaMay] = ?";
    // Xóa máy
    String sqlDelete = "DELETE FROM [QLQuanNet].[dbo].[MayTinh] WHERE [MaMay] = ?";

    // Tìm tất cả máy
    String sqlFindAll = "SELECT * FROM [QLQuanNet].[dbo].[MayTinh]";

    // Tìm theo mã máy
    String sqlFindByID = "SELECT * FROM [QLQuanNet].[dbo].[MayTinh] WHERE [MaMay] = ?";

    // Tìm theo mã loại máy
    String sqlFindByMaLoai = "SELECT * FROM [QLQuanNet].[dbo].[MayTinh] WHERE [MaLoai] = ?";

    // Tìm theo trạng thái máy (0: tắt, 1: đang sử dụng, v.v.)
    String sqlFindByTrangThai = "SELECT * FROM [QLQuanNet].[dbo].[MayTinh] WHERE [TrangThai] = ?";

    @Override
    public MayTinh create(MayTinh entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(MayTinh entity) {
        XQuery.update(
                "UPDATE [QLQuanNet].[dbo].[MayTinh] SET [MaLoai] = ?, [TrangThai] = ? WHERE [MaMay] = ?",
                entity.getMaLoai(),
                entity.getTrangThai(),
                entity.getMaMay()
        );
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MayTinh> findAll() {
        List<MayTinh> list = new ArrayList<>();
        String sql = "SELECT * FROM MayTinh";
        try (
                Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                MayTinh may = new MayTinh();
                may.setMaMay(rs.getInt("MaMay"));
                may.setMaLoai(rs.getInt("MaLoai"));
                may.setTrangThai(rs.getInt("TrangThai"));
                list.add(may);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MayTinh findByID(Integer id) {
        String sql = "SELECT * FROM MayTinh WHERE MaMay = ?";
        try (
                Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
            int MaMay = 0;
            stmt.setInt(1, MaMay);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                MayTinh may = new MayTinh();
                may.setMaMay(rs.getInt("MaMay"));
                may.setMaLoai(rs.getInt("MaLoai"));
                may.setTrangThai(rs.getInt("TrangThai"));
                return may;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> layDanhSachMay() {
        List<String> danhSachMay = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=TenCSDL;user=sa;password=123");
            String sql = "SELECT MaMay FROM MayTinh";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSachMay.add(rs.getString("MaMay"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachMay;
    }

    @Override
    public void insert(MayTinh may) {
        String sql = "INSERT INTO MayTinh (MaMay, MaLoai, TrangThai) VALUES (?, ?, ?)";
        try (
                Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, may.getMaMay());
            stmt.setInt(2, may.getMaLoai());
            stmt.setInt(3, may.getTrangThai());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi thêm máy: " + e.getMessage()); // ✅ Có thông báo cụ thể
        }
    }

    @Override
    public boolean xoaMay(int maMay) {
        String sql = "DELETE FROM MayTinh WHERE MaMay = ?";
        try (Connection conn = XJdbc.openConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maMay);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateTrangThai(int maMay, int trangThai) {
        String sql = "UPDATE MayTinh SET TrangThai = ? WHERE MaMay = ?";
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, trangThai); // ✅ Dùng tham số truyền vào
            ps.setInt(2, maMay);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
