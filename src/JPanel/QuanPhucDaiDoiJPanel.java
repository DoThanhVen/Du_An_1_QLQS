/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JPanel;

import Class.QuanPhucDaiDoi;
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
public class QuanPhucDaiDoiJPanel extends javax.swing.JPanel {

    QuanPhucDaiDoiDAO qpddDAO = new QuanPhucDaiDoiDAO();
    private int indexTable = -1, indexCBO = -1;

    /**
     * Creates new form QuanTrangDaiDoiJPanel
     */
    public QuanPhucDaiDoiJPanel() {
        initComponents();
        addItem();
        fillTable();
        Edit();
    }

    void Edit() {
        button1.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        button1.setFont(new Font("sansserif", 1, 12));
        button1.setText("Trở lại");
        button2.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        button2.setFont(new Font("sansserif", 1, 12));
        button2.setText("Thêm");
        button3.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        button3.setFont(new Font("sansserif", 1, 12));
        button3.setText("Sửa");
        txtSoLuongNhap.setHint("Số lượng");
        txtTenQuanPhuc.setHint("Tên quân phục");
    }

    void Load() {
        txtSoLuongCo.setText("");
        txtTenQuanPhuc.setText("");
        txtSoLuongNhap.setText("");
        tblQuanPhuc.removeAll();
        indexCBO = -1;
        indexTable = -1;
    }

    void addItem() {
        QuanPhucDaiDoi model = new QuanPhucDaiDoi();
        try {
            String sql = "SELECT QuanPhuc.MaQuanPhuc,QuanPhuc.TenQuanPhuc FROM QuanPhuc\n"
                    + "EXCEPT\n"
                    + "SELECT QuanPhuc.MaQuanPhuc,QuanPhuc.TenQuanPhuc FROM QuanPhuc LEFT JOIN QuanPhucDaiDoi\n"
                    + "ON QuanPhuc.MaQuanPhuc = QuanPhucDaiDoi.MaQuanPhuc  WHERE QuanPhucDaiDoi.MaDaiDoi = '" + DaiDoiJPanel.maDaiDoi + "'";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                model.setMaDaiDoi(DaiDoiJPanel.maDaiDoi);
                model.setMaQuanPhuc(rs.getString("MaQuanPhuc"));
                model.setSoLuongNhap(0);
                qpddDAO.insert(model);
            }
        } catch (Exception e) {
        }
    }

//    void addTable() {
//        DefaultTableModel model = (DefaultTableModel) tblQuanPhuc.getModel();
//        model.setRowCount(0);
//        try {
//            String sql = "Select * FROM QuanPhuc";
//            ResultSet rs = JDBCHelper.executeQuery(sql);
//            while (rs.next()) {
//                    String sqlFill = "EXEC sp_ThongKeQuanPhucDaiDoi '" + rs.getString("MaQuanPhuc") + "','" + DaiDoiJPanel.maDaiDoi + "'";
//                    ResultSet rst = JDBCHelper.executeQuery(sqlFill);
//                    while (rst.next()) {
//                        Object[] row = {DaiDoiJPanel.maDaiDoi, rs.getString("MaQuanPhuc"), rs.getString("TenQuanPhuc"),
//                            rst.getInt(1), rst.getInt(2), rs.getInt(3)};
//                        model.addRow(row);
//                    }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    void fillCombobox() {
        try {
            String sql = "EXEC sp_ThongKeSoLuongQuanPhucNhapVao";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                txtTenQuanPhuc.setText(rs.getString(2));
            }
        } catch (Exception e) {
        }
    }

    void fillTable() {
        lblDaiDoi.setText("Đại Đội: " + DaiDoiJPanel.tenDaiDoi);
        DefaultTableModel model = (DefaultTableModel) tblQuanPhuc.getModel();
        model.setRowCount(0);
        try {
            String sql = "Select QuanPhucDaiDoi.MaQuanPhuc,\n"
                    + "QuanPhuc.TenQuanPhuc\n"
                    + "FROM QuanPhucDaiDoi INNER JOIN QuanPhuc\n"
                    + "On QuanPhucDaiDoi.MaQuanPhuc = QuanPhuc.MaQuanPhuc \n"
                    + "WHERE QuanPhucDaiDoi.MaDaiDoi = '" + DaiDoiJPanel.maDaiDoi + "'"
                    + "GROUP BY QuanPhucDaiDoi.MaQuanPhuc,QuanPhuc.TenQuanPhuc";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                String sqlLoadData = "EXEC sp_ThongKeQuanPhucDaiDoi '" + rs.getString(1) + "','" + DaiDoiJPanel.maDaiDoi + "'";
                ResultSet rst = JDBCHelper.executeQuery(sqlLoadData);
                while (rst.next()) {
                    Object[] row = {DaiDoiJPanel.maDaiDoi, rs.getString(1), rs.getString(2), rst.getInt(1), rst.getInt(2), rst.getInt(3)};
                    model.addRow(row);
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
        tblQuanPhuc = new JavaClass.TableQuanPhuc();
        button1 = new JavaClass.Button();
        lblDaiDoi = new javax.swing.JLabel();
        txtSoLuongCo = new JavaClass.SearchText();
        txtSoLuongNhap = new JavaClass.SearchText();
        button2 = new JavaClass.Button();
        button3 = new JavaClass.Button();
        jLabel1 = new javax.swing.JLabel();
        txtTenQuanPhuc = new JavaClass.SearchText();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblQuanPhuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Đại Đội", "Mã Quân Phuc", "Tên Quân Phục", "Số Lượng Nhập", "Đã Phát", "Còn Lại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQuanPhuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanPhucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQuanPhuc);

        panelBorder1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 152, 810, 330));

        button1.setText("button1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelBorder1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, -1));

        lblDaiDoi.setText("Đại Đội: ");
        panelBorder1.add(lblDaiDoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtSoLuongCo.setEditable(false);
        panelBorder1.add(txtSoLuongCo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 70, -1));
        panelBorder1.add(txtSoLuongNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 70, -1));

        button2.setText("button2");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        panelBorder1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 80, -1));

        button3.setText("button3");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        panelBorder1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 80, -1));

        jLabel1.setText("Có:");
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, -1, -1));

        txtTenQuanPhuc.setEditable(false);
        panelBorder1.add(txtTenQuanPhuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 220, -1));

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
    void showForm(Component com
    ) {
        panelBorder1.removeAll();
        panelBorder1.setLayout(new BorderLayout());
        panelBorder1.add(com);
        panelBorder1.repaint();
        panelBorder1.revalidate();
    }
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        showForm(new DaiDoiJPanel());
    }//GEN-LAST:event_button1ActionPerformed

    private void tblQuanPhucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanPhucMouseClicked
        // TODO add your handling code here:
        indexTable = tblQuanPhuc.getSelectedRow();
        int soLuongCo = -1;
        try {
            if (indexTable == -1) {
                DialogHelper.alert(this, "Vui lòng chọn quân phục cần thêm!");
            } else {
                txtTenQuanPhuc.setText(tblQuanPhuc.getValueAt(indexTable, 2).toString());
                try {
                    String sql = "EXEC sp_ThongKeQuanPhucConLai '" + tblQuanPhuc.getValueAt(indexTable, 1).toString() + "'";
                    ResultSet rs = JDBCHelper.executeQuery(sql);
                    while (rs.next()) {
                        txtSoLuongCo.setText(String.valueOf(rs.getInt(1)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblQuanPhucMouseClicked
    void checkInsert(int index) {
        if (txtSoLuongNhap.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập số lượng cần nhập!");
            txtSoLuongNhap.requestFocus();
        } else if (!txtSoLuongNhap.getText().matches("\\d{1,}")) {
            DialogHelper.alert(this, "Số lượng nhập không hợp lệ!");
            txtSoLuongNhap.requestFocus();
        } else {
            int check = 0;
            try {
                String sql = "EXEC sp_ThongKeQuanPhucConLai '" + tblQuanPhuc.getValueAt(index, 1).toString() + "'";
                ResultSet rs = JDBCHelper.executeQuery(sql);
                while (rs.next()) {
                    if (rs.getInt(1) < Integer.parseInt(txtSoLuongNhap.getText())) {
                        check++;
                    }
                }
                if (check != 0) {
                    DialogHelper.alert(this, "Số lượng nhập không hợp lệ!");
                    txtSoLuongNhap.requestFocus();
                } else {
                    insert(index);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void insert(int index) {
        QuanPhucDaiDoi model = new QuanPhucDaiDoi();
        model.setMaDaiDoi(DaiDoiJPanel.maDaiDoi);
        model.setMaQuanPhuc(tblQuanPhuc.getValueAt(index, 1).toString());
        model.setSoLuongNhap(Integer.parseInt(txtSoLuongNhap.getText()));
        try {
            qpddDAO.insert(model);
            Load();
            fillTable();
            DialogHelper.alert(this, "Thêm thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        indexTable = tblQuanPhuc.getSelectedRow();
        if (indexTable == -1) {
            DialogHelper.alert(this, "Vui lòng chọn quân phục cần thêm!");
        } else {
            checkInsert(indexTable);
        }
    }//GEN-LAST:event_button2ActionPerformed
    void checkUpdate(int index) {
        if (txtSoLuongNhap.getText().equals("")) {
            DialogHelper.alert(this, "Vui lòng nhập số lượng cần cập nhật!");
            txtSoLuongNhap.requestFocus();
        } else if (!txtSoLuongNhap.getText().matches("\\d{1,}")) {
            DialogHelper.alert(this, "Số lượng nhập không hợp lệ!");
            txtSoLuongNhap.requestFocus();
        } else {
            int checkKho = 0, checkDung = 0;
            try {
                String sql = "EXEC sp_ThongKeQuanPhucConLai '" + tblQuanPhuc.getValueAt(index, 1).toString() + "'";
                ResultSet rs = JDBCHelper.executeQuery(sql);
                while (rs.next()) {
                    if ((rs.getInt(1) + Integer.parseInt(tblQuanPhuc.getValueAt(index, 3).toString())) < Integer.parseInt(txtSoLuongNhap.getText())) {
                        checkKho++;
                    }
                    if (Integer.parseInt(txtSoLuongNhap.getText()) < Integer.parseInt(tblQuanPhuc.getValueAt(index, 4).toString())) {
                        checkDung++;
                    }
                }
                if (checkKho != 0) {
                    DialogHelper.alert(this, "Số lượng trong kho không đủ!");
                    txtSoLuongNhap.requestFocus();
                } else if (checkDung != 0) {
                    DialogHelper.alert(this, "Số lượng dùng không đủ!");
                    txtSoLuongNhap.requestFocus();
                } else {
                    update(index);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void update(int index) {
        QuanPhucDaiDoi model = new QuanPhucDaiDoi();
        model.setMaDaiDoi(DaiDoiJPanel.maDaiDoi);
        model.setMaQuanPhuc(tblQuanPhuc.getValueAt(index, 1).toString());
        model.setSoLuongNhap(Integer.parseInt(txtSoLuongNhap.getText()));
        try {
            String sql = "Select ID FROM QuanPhucDaiDoi WHERE MaQuanPhuc = '" + tblQuanPhuc.getValueAt(index, 1).toString() + "'"
                    + "AND MaDaiDoi = '" + tblQuanPhuc.getValueAt(index, 0).toString() + "'";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                model.setID(rs.getInt(1));
            }
            try {
                qpddDAO.update(model);
                Load();
                fillTable();
                DialogHelper.alert(this, "Chỉnh sửa thành công!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        indexTable = tblQuanPhuc.getSelectedRow();
        if (indexTable == -1) {
            DialogHelper.alert(this, "Vui lòng chọn quân phục cần chỉnh sửa!");
        } else {
            checkUpdate(indexTable);
        }
    }//GEN-LAST:event_button3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JavaClass.Button button1;
    private JavaClass.Button button2;
    private JavaClass.Button button3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDaiDoi;
    private JPanel.PanelBorder panelBorder1;
    private JavaClass.TableQuanPhuc tblQuanPhuc;
    private JavaClass.SearchText txtSoLuongCo;
    private JavaClass.SearchText txtSoLuongNhap;
    private JavaClass.SearchText txtTenQuanPhuc;
    // End of variables declaration//GEN-END:variables
}
