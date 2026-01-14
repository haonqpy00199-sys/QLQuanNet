/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.dao.impl;

import duan1.dao.NhanVienDAO;
import duan1.entity.NhanVien;
import duan1.util.XJdbc;
import duan1.util.XQuery;
import java.util.List;

/**
 *
 * @author pc
 */
public class NhanVienDAOImpl implements NhanVienDAO{
    
    String sqlCreate = "INSERT INTO [QLQuanNet].[dbo].[NhanVien]([TenDangNhap], [MatKhau], [HoTen], [TrangThai], [Hinh], [ChucVu]) VALUES(?, ?, ?, ?, ?, ?)";
    String sqlUpdate = "UPDATE [QLQuanNet].[dbo].[NhanVien] SET [MatKhau]=?, [HoTen]=?, [TrangThai]=?, [Hinh]=?, [ChucVu]=? WHERE [TenDangNhap]=?";
    String sqlDelete = "DELETE FROM [QLQuanNet].[dbo].[NhanVien] WHERE [TenDangNhap]=?";
    String sqlfindAll = "SELECT * FROM [QLQuanNet].[dbo].[NhanVien]";
    String sqlFindByID = "SELECT * FROM [QLQuanNet].[dbo].[NhanVien] where [TenDangNhap] =?";
    
    // Tìm theo tên đăng nhập (TenDN) - dùng cho login
    String sqlFindByTenDN = "SELECT * FROM [QLQuanNet].[dbo].[NhanVien] WHERE [TenDN] = ?";

    @Override
    public NhanVien create(NhanVien entity) {
        Object[] values = {
            entity.getTenDangNhap(),
            entity.getMatKhau(),
            entity.getHoTen(),
            entity.isTrangThai(),
            entity.getHinh(),
            entity.isChucVu()
        };
        XJdbc.executeUpdate(sqlCreate, values);
        return entity;
    }

    @Override
    public void update(NhanVien entity) {
        Object[] values = {
            entity.getMatKhau(),
            entity.getHoTen(),
            entity.isTrangThai(),
            entity.getHinh(),
            entity.isChucVu(),
            entity.getTenDangNhap()
        };
        XJdbc.executeUpdate(sqlUpdate, values);
    }

    @Override
    public void delete(String id) {
        XJdbc.executeUpdate(sqlDelete, id);
    }

    @Override
    public List<NhanVien> findAll() {
        return XQuery.getBeanList(NhanVien.class, sqlfindAll);
    }

    @Override
    public NhanVien findByID(String id) {
        return XQuery.getSingleBean(NhanVien.class, sqlFindByID, id);
    }
    
}