/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JPanel;

import Class.DaiDoi;
import Class.QuanPhucDaiDoi;
import DAO.DaiDoiDAO;
import DAO.QuanPhucDaiDoiDAO;
import Helper.DialogHelper;
import Helper.JDBCHelper;
import JavaClass.Button;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class DaiDoiJPanel extends javax.swing.JPanel {

    DaiDoiDAO ddDAO = new DaiDoiDAO();
    QuanPhucDaiDoiDAO qpddDAO = new QuanPhucDaiDoiDAO();
    private int indexTable = -1;
    public static String maDaiDoi = "", tenDaiDoi = "";

    /**
     * Creates new form DaiDoiJPanel
     */
    public DaiDoiJPanel() {
        initComponents();
        Edit();
        fillTable();
    }

    void Load() {
        txtMaDaiDoi.setText("");
        txtTenDaiDoi.setText("");
        txtMaDaiDoi.requestFocus();
        indexTable = -1;
    }

    void showForm(Component com
    ) {
        panelBorder1.removeAll();
        panelBorder1.setLayout(new BorderLayout());
        panelBorder1.add(com);
        panelBorder1.repaint();
        panelBorder1.revalidate();
    }

    void Edit() {
        txtMaDaiDoi.setHint("Mã đại đội");
        txtTenDaiDoi.setHint("Tên đại đội");
        btnThem.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnThem.setFont(new Font("sansserif", 1, 12));
        btnThem.setText("Thêm");
        btnSua.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnSua.setFont(new Font("sansserif", 1, 12));
        btnSua.setText("Sửa");
        btnXoa.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnXoa.setFont(new Font("sansserif", 1, 12));
        btnXoa.setText("Xóa");
        btnMoi.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnMoi.setFont(new Font("sansserif", 1, 12));
        btnMoi.setText("Mới");
        btnQuanPhucDoi.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnQuanPhucDoi.setFont(new Font("sansserif", 1, 12));
        btnQuanPhucDoi.setText("Quân Phục");
        btnVuTrangDoi.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnVuTrangDoi.setFont(new Font("sansserif", 1, 12));
        btnVuTrangDoi.setText("Vũ Trang");
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblDaiDoi.getModel();
        model.setRowCount(0);
        try {
            String sql = "Select * FROM DaiDoi";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                Object[] row = {rs.getString("MaDaiDoi"), rs.getString("TenDaiDoi")};
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    void addItem(String maDaiDoi) {
        QuanPhucDaiDoi model = new QuanPhucDaiDoi();
        try {
            String sql = "Select * FROM QuanPhuc";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                model.setMaDaiDoi(maDaiDoi);
                model.setMaQuanPhuc(rs.getString("MaQuanPhuc"));
                model.setSoLuong(0);
                qpddDAO.insert(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void insert() {
        DaiDoi model = new DaiDoi();
        model.setMaDaiDoi(txtMaDaiDoi.getText());
        model.setTenDaiDoi(txtTenDaiDoi.getText());
        try {
            ddDAO.insert(model);
            addItem(txtMaDaiDoi.getText());
            fillTable();
            Load();
            DialogHelper.alert(this, "Thêm đại đội thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void update() {
        indexTable = tblDaiDoi.getSelectedRow();
        try {
            if (indexTable == -1) {
                DialogHelper.alert(this, "Vui lòng chọn đại đội cần chỉnh sửa!");
            } else {
                DaiDoi model = new DaiDoi();
                model.setMaDaiDoi(tblDaiDoi.getValueAt(indexTable, 0).toString());
                model.setTenDaiDoi(txtTenDaiDoi.getText());
                try {
                    ddDAO.update(model);
                    fillTable();
                    Load();
                    DialogHelper.alert(this, "Chỉnh sửa thành công!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void delete() {
        indexTable = tblDaiDoi.getSelectedRow();
        try {
            if (indexTable == -1) {
                DialogHelper.alert(this, "Vui lòng chọn đại đội cần xóa!");
            } else {
                try {
                    ddDAO.delete(tblDaiDoi.getValueAt(indexTable, 0).toString());
                    fillTable();
                    Load();
                    DialogHelper.alert(this, "Xóa thành công!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new JPanel.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDaiDoi = new JavaClass.TableQuanPhuc();
        btnThem = new JavaClass.Button();
        btnSua = new JavaClass.Button();
        btnXoa = new JavaClass.Button();
        btnMoi = new JavaClass.Button();
        txtMaDaiDoi = new JavaClass.SearchText();
        txtTenDaiDoi = new JavaClass.SearchText();
        btnQuanPhucDoi = new JavaClass.Button();
        btnVuTrangDoi = new JavaClass.Button();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDaiDoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Đại Đội", "Tên Đại Đội"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDaiDoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDaiDoiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDaiDoi);

        panelBorder1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 142, 830, 350));

        btnThem.setText("button1");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        panelBorder1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 80, -1));

        btnSua.setText("button2");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        panelBorder1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 80, -1));

        btnXoa.setText("button3");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        panelBorder1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 80, -1));

        btnMoi.setText("button4");
        panelBorder1.add(btnMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 80, -1));
        panelBorder1.add(txtMaDaiDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 210, -1));

        txtTenDaiDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDaiDoiActionPerformed(evt);
            }
        });
        panelBorder1.add(txtTenDaiDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 230, -1));

        btnQuanPhucDoi.setText("button1");
        btnQuanPhucDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanPhucDoiActionPerformed(evt);
            }
        });
        panelBorder1.add(btnQuanPhucDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 80, -1));

        btnVuTrangDoi.setText("button1");
        panelBorder1.add(btnVuTrangDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenDaiDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDaiDoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDaiDoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblDaiDoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDaiDoiMouseClicked
        // TODO add your handling code here:
        indexTable = tblDaiDoi.getSelectedRow();
        txtMaDaiDoi.setText(tblDaiDoi.getValueAt(indexTable, 0).toString());
        txtTenDaiDoi.setText(tblDaiDoi.getValueAt(indexTable, 1).toString());
    }//GEN-LAST:event_tblDaiDoiMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnQuanPhucDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanPhucDoiActionPerformed
        // TODO add your handling code here:
        indexTable = tblDaiDoi.getSelectedRow();
        try {
            if (indexTable == -1) {
                DialogHelper.alert(this, "Vui lòng chọn quân đội cần cấp phát quân phục!");
            } else {
                maDaiDoi = tblDaiDoi.getValueAt(indexTable, 0).toString();
                tenDaiDoi = tblDaiDoi.getValueAt(indexTable, 1).toString();
                indexTable = -1;
                showForm(new QuanPhucDaiDoiJPanel());
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnQuanPhucDoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JavaClass.Button btnMoi;
    private JavaClass.Button btnQuanPhucDoi;
    private JavaClass.Button btnSua;
    private JavaClass.Button btnThem;
    private JavaClass.Button btnVuTrangDoi;
    private JavaClass.Button btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private JPanel.PanelBorder panelBorder1;
    private JavaClass.TableQuanPhuc tblDaiDoi;
    private JavaClass.SearchText txtMaDaiDoi;
    private JavaClass.SearchText txtTenDaiDoi;
    // End of variables declaration//GEN-END:variables
}
