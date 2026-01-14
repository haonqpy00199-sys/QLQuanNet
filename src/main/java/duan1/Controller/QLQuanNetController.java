/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1.Controller;

import duan1.entity.PhienSuDung;
import duan1.qlquannet.DangNhap;
import duan1.qlquannet.DoiMatKhauu;
import duan1.qlquannet.QLNhanVien;
import duan1.qlquannet.Welcome;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author pc
 */
public interface QLQuanNetController extends CrudController<PhienSuDung>{
   void selectTimeRange(); // xử lý chọn khoảng thời gian trong cboTimeRanges
     
     default void showJDialog(JDialog dialog) {
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    
    default void showWelcomeJDialog(JFrame frame) {
        this.showJDialog(new Welcome(frame, true));
    }

    default void showLoginJDialog(JFrame frame) {
        this.showJDialog(new DangNhap(frame, true));
    }
    
    default void showChangePasswordJDialog(JFrame frame) {
        this.showJDialog(new DoiMatKhauu(frame, true));
    }
    
    default void showUserManagerJDialog(JFrame frame) {
        this.showJDialog(new QLNhanVien(frame, true));
    }
    
    
}
