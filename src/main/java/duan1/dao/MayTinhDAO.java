/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.dao;

import duan1.entity.MayTinh;

/**
 *
 * @author pc
 */
public interface MayTinhDAO extends CrudDAO<MayTinh, Integer>{

    public void insert(MayTinh may);

    public boolean xoaMay(int maMay);

    public void updateTrangThai(int maMay, int i);
    
}
