/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import EventMenu.*;
import Helper.DialogHelper;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import JPanel.*;
import JavaClass.ModelMenu;
import Menu.GradientDropdownMenu;
import Menu.MenuEvent;
import com.sun.org.apache.bcel.internal.generic.F2D;
import com.sun.prism.paint.Gradient;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import Search.SearchOptinEvent;
import Search.SearchOption;
import java.awt.Component;
import javaswingdev.ModelMenuItem;
import javax.swing.Icon;

/**
 *
 * @author Admin
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        GradientDropdownMenu menu = new GradientDropdownMenu();
        ImageIcon iconHome = new ImageIcon(getClass().getResource("/Image/Icon/Home.png"));
        menu.setGradientColor(new Color(130, 148, 96), new Color(130, 148, 96));
        menu.setBackground(new Color(130, 148, 96));
        menu.addItem("Trang Chủ");
        menu.addItem("Quản Lý", "Đại Đội", "Vũ Trang", "Quân Nhân", "Quân Phục");
        menu.addItem("Thống Kê", "Số Lượng Quân Nhân", "Quân Phục Nhập Vào", "Quân Phục Đã Phát", "Quân Phục Còn Lại", "Nhận Quân Phục");
        menu.addItem("Kết Thúc");
        menu.addItem("Trợ Giúp", "Đổi Mật Khẩu", "Hướng Dẫn");
        menu.applay(this);
        menu.addEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex, boolean menuItem) {
                if (menuItem) {
                    if (index == 0 && subIndex == 0) {
                        showForm(new FormHome());
                    } else if (index == 1 && subIndex == 1) {
                        showForm(new DaiDoiJPanel());
                    } else if (index == 1 && subIndex == 2) {
                        System.out.println("Vũ Trang");
                    } else if (index == 1 && subIndex == 3) {
                        showForm(new FormQuanNhan());
                    } else if (index == 1 && subIndex == 4) {
                        showForm(new FormQuanPhuc());
                    } else if (index == 2 && subIndex == 1) {
                        showForm(new ThongKeQuanNhanJPanel());
                    } else if (index == 2 && subIndex == 2) {
                        showForm(new NhapQuanPhucJPanel());
                    } else if (index == 2 && subIndex == 3) {
                        showForm(new ThongKeQuanPhucDaPhatJPanel());
                    } else if (index == 2 && subIndex == 4) {
                        showForm(new ThongKeQuanPhucConLaiJPanel());
                    } else if (index == 2 && subIndex == 5) {
                        showForm(new SizeQuanPhucJPanel());
                    } else if (index == 3 && subIndex == 0) {
                        if (DialogHelper.confirm(pnlMain, "Bạn có muốn thoát không?")) {
                            System.exit(0);
                        }
                    } else if (index == 4 && subIndex == 1) {
                        System.out.println("Đổi mật khẩu");
                    } else {
                        System.out.println("Hướng dẫn");
                    }
                }
            }
        });
        showForm(new FormHome());
    }

    public void showForm(Component com) {
        pnlMain.removeAll();
        pnlMain.add(com);
        pnlMain.repaint();
        pnlMain.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(0, 171, 179));
        pnlMain.setPreferredSize(new java.awt.Dimension(850, 500));
        pnlMain.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
