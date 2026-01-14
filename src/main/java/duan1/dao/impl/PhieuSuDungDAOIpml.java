/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.dao.impl;

import duan1.dao.PhieuSuDungDAO;
import duan1.entity.PhienSuDung;
import duan1.util.XJdbc;
import duan1.util.XQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class PhieuSuDungDAOIpml implements PhieuSuDungDAO {

// Tạo phiên sử dụng mới
    String sqlCreate = "INSERT INTO [QLQuanNet].[dbo].[PhienSuDung] "
            + "([MaPhien], [TGBatDau], [TGKetThuc], [MaMay], [TongTien], [TenDangNhap]) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

// Cập nhật phiên sử dụng
    String sqlUpdate = "UPDATE [QLQuanNet].[dbo].[PhienSuDung] SET "
            + "[TGBatDau] = ?, [TGKetThuc] = ?, [MaMay] = ?, [TongTien] = ?  [TenDangNhap] = ?"
            + "WHERE [MaPhien] = ?";

// Xóa phiên sử dụng
    String sqlDelete = "DELETE FROM [QLQuanNet].[dbo].[PhienSuDung] WHERE [MaPhien] = ?";

// Lấy tất cả phiên sử dụng
    String sqlFindAll = "SELECT * FROM [QLQuanNet].[dbo].[PhienSuDung]";

// Tìm theo mã phiên
    String sqlFindByID = "SELECT * FROM [QLQuanNet].[dbo].[PhienSuDung] WHERE [MaPhien] = ?";

// Tìm các phiên trong khoảng thời gian
    String findByTimeRangeSql = "SELECT * FROM [QLQuanNet].[dbo].[PhienSuDung] "
            + "WHERE [TGBatDau] BETWEEN ? AND ? "
            + "ORDER BY [TGBatDau] DESC";

    @Override
    public PhienSuDung create(PhienSuDung entity) {
        Object[] values = {
            entity.getMaPhien(),
            entity.getTGBatDau(),
            entity.getTGKetThuc(),
            entity.getMaMay(),
            entity.getTongTien(),
            entity.getTenDangNhap()
        };
        XJdbc.executeUpdate(sqlCreate, values);

        return entity;
    }

    @Override
    public void update(PhienSuDung entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PhienSuDung> findAll() {
        return XQuery.getBeanList(PhienSuDung.class, sqlFindAll);
    }

    @Override
    public PhienSuDung findByID(Integer id) {
        return XQuery.getSingleBean(PhienSuDung.class, sqlFindByID, id);
    }

    List<PhienSuDung> allPhien = new ArrayList<>();

    @Override
    public List<PhienSuDung> findByTimeRange(Date begin, Date end) {
        return XQuery.getBeanList(PhienSuDung.class, findByTimeRangeSql, begin, end);
    }

    @Override
    public List<PhienSuDung> findByMaMay(Integer maMay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PhienSuDung> findByMaNV(Integer maNV) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PhienSuDung findActiveByMaMay(Integer maMay) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PhienSuDung> findAllActive() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getNextMaPhien() {
        String sql = "SELECT MAX(MaPhien) FROM PhienSuDung";
        try (Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public boolean insert(PhienSuDung phieu) {
        String sql = "INSERT INTO PhienSuDung (MaPhien, TGBatDau, TGKetThuc, MaMay, TongTien, TenDangNhap) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = XJdbc.openConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {

            int maPhienMoi = getNextMaPhien();
            ps.setInt(1, maPhienMoi);
            ps.setTimestamp(2, phieu.getTGBatDau());
            ps.setTimestamp(3, phieu.getTGKetThuc());
            ps.setInt(4, phieu.getMaMay());
            ps.setInt(5, phieu.getTongTien());
            ps.setString(6, phieu.getTenDangNhap());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
