/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

/**
 *
 * @author Admin
 */
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DialogHelper {

    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent,message,
                "Hệ thống quản lý quân sự", JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, "<html><strong><i>"+ message+"</i></strong></html>",
                "Hệ thống quản lý quân sự",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    public static String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, "<html><strong><i>"+ message+"</i></strong></html>",
                "Hệ thống quản lý quân sự", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void alert(JPanel jPanel1, Exception e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
