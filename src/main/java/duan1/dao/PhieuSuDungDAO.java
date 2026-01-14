/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.dao;

import duan1.entity.PhienSuDung;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public interface PhieuSuDungDAO extends CrudDAO<PhienSuDung, Integer> {

    /**
     * Tìm các phiên sử dụng theo khoảng thời gian bắt đầu.
     */
    List<PhienSuDung> findByTimeRange(Date begin, Date end);

    /**
     * Tìm tất cả các phiên sử dụng liên quan đến một máy tính cụ thể.
     */
    List<PhienSuDung> findByMaMay(Integer maMay);

    /**
     * Tìm tất cả các phiên sử dụng được ghi nhận bởi một nhân viên cụ thể.
     */
    List<PhienSuDung> findByMaNV(Integer maNV);

    /**
     * Tìm phiên sử dụng đang hoạt động (chưa kết thúc) theo mã máy.
     */
    PhienSuDung findActiveByMaMay(Integer maMay);

    /**
     * Tìm tất cả các phiên sử dụng đang mở (chưa kết thúc).
     */
    List<PhienSuDung> findAllActive();

    boolean insert(PhienSuDung phieu);
}
