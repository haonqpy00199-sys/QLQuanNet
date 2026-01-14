/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class XIcon {
    /**
     * Đọc icon từ resource hoặc file
     * @param path đường dẫn file, đường dẫn resource hoặc tên resource
     * @return ImageIcon
     */
    public static ImageIcon getIcon(String path) {
    if (!path.contains("/") && !path.contains("\\")) { 
        return XIcon.getIcon("/poly/cafe/icons/" + path);
    }

    if (path.startsWith("/")) {
        URL url = XIcon.class.getResource(path);
        if (url != null) {
            return new ImageIcon(url);
        } else {
            System.err.println("Không tìm thấy icon: " + path);
            return new ImageIcon();
        }
    }

    return new ImageIcon(path);
}

    /**
     * Đọc icon theo kích thước
     * @param path đường dẫn file hoặc tài nguyên
     * @param width chiều rộng
     * @param height chiều cao
     * @return Icon
     */
    public static ImageIcon getIcon(String path, int width, int height) {
        Image image = getIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    /**
     * Thay đổi icon của JLabel
     * @param label JLabel cần thay đổi
     * @param path đường dẫn file hoặc tài nguyên
     */
    public static void setIcon(JLabel label, String path) {
        label.setIcon(XIcon.getIcon(path, label.getWidth(), label.getHeight()));
    }
    /**
     * Thay đổi icon của JLabel
     * @param label JLabel cần thay đổi
     * @param file file icon
     */
    public static void setIcon(JLabel label, File file) {
        XIcon.setIcon(label, file.getAbsolutePath());
    }
    /**
     * Sao chép file vào thư mục với tên file mới là duy nhất
     * @param fromFile file cần sao chép
     * @param folder thư mục đích
     * @return File đã sao chép
     */
    public static File copyTo(File fromFile, String folder) {
        String fileExt = fromFile.getName().substring(fromFile.getName().lastIndexOf("."));
        File toFile = new File(folder, XStr.getKey() + fileExt);
        toFile.getParentFile().mkdirs();
        try {
            Files.copy(fromFile.toPath(), toFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return toFile;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static File copyTo(File fromFile) {
        return copyTo(fromFile, "files");
    }

}
