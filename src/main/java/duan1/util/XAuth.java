/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.util;

import duan1.entity.NhanVien;

/**
 *
 * @author pc
 */

public class XAuth {

    public static NhanVien nhanvien = NhanVien.builder()
            .tenDangNhap("user1@gmail.com")
            .matKhau("123")
            .trangThai(true)
            .chucVu(true)
            .hoTen("Nguyễn Văn Tèo")
            .hinh("trump.png")
            .build(); // biến user này sẽ được thay thế sau khi đăng nhập

}
