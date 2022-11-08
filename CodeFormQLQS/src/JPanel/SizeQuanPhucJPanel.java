/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JPanel;

import Class.QuanNhan;
import Class.SizeQuanPhuc;
import DAO.QuanNhanDAO;
import DAO.SizeQuanPhucDAO;
import Helper.DialogHelper;
import Helper.JDBCHelper;
import JavaClass.Button;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class SizeQuanPhucJPanel extends javax.swing.JPanel {

    QuanNhanDAO qnDAO = new QuanNhanDAO();
    SizeQuanPhucDAO sizeDAO = new SizeQuanPhucDAO();
    List<QuanNhan> List = new ArrayList<>();
    int indexTable = -1;
    public static String maQuanNhan = "";

    /**
     * Creates new form PhatQuanPhucJPanel
     */
    public SizeQuanPhucJPanel() {
        initComponents();
        setTable();
        fillTableQuanNhan();
        getValues();
    }

    void delete(String ma) {
        try {
            qnDAO.delete(ma);
            fillTableQuanNhan();
            DialogHelper.alert(this, "Xóa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void insert() {
        SizeQuanPhuc model = new SizeQuanPhuc();
        model.setMaDinhDanh(FormQuanNhan.maQuanNhan);
        model.setSizeQuanPhuc(cboSizeQuanPhuc.getSelectedItem().toString());
        model.setSizeGiay(Float.parseFloat(cboSizeGiay.getSelectedItem().toString()));
        model.setSizeMu(Float.parseFloat(cboSizeMu.getSelectedItem().toString()));
        try {
            sizeDAO.insert(model);
            fillTableQuanNhan();
            DialogHelper.alert(this, "Xác thực size quân phục thành công!");
        } catch (Exception e) {
        }
    }

    void showSizeQuanPhuc() {
        DialogHelper.alert(this, "<html><strong style='font-size:20px'>Chiều dài quân phục:</strong>\n"
                + "<html><strong style='color:red;'>Chiều Cao (cm)| Chiều Rộng (cm)| Cân Nặng (kg) |   Size   </strong></html>\n"
                + "          62                        37                       40-47                   S     \n"
                + "          66                        40                       48-57                   M     \n"
                + "          69                        43                       58-67                   L     \n"
                + "          72                        46                       68-77                   XL     \n"
                + "          74                        48                       78-85                   XXL    \n"
                + "          76                        50                       86-94                   XXXL    \n"
        );
    }

    void showSizeGiay() {
        DialogHelper.alert(this, "<html><strong style='font-size:20px'>Chiều dài giày:</strong>\n"
                + "<html><strong style='color:red'>Bảng quy đổi size giày nam</strong>&emsp&emsp&emsp&emsp<strong style='color:red'>|&emsp;&emsp;Bảng quy đổi size giày nữ</strong>\n"
                + "<html><strong style='color:red'>Chiều Dài Chân (cm)&emsp&emsp&emsp|&emsp;Size&emsp|&emsp;&emsp;Chiều Dài Chân (cm)&emsp|&emsp;&ensp;Size</strong>\n"
                + "          23.5                                     39                               20.8                          34-35\n"
                + "          24.1                                     39-40                            21.3                          35\n"
                + "          24.4                                     40                               21.6                          35-36\n"
                + "          24.8                                     40-41                            22.2                          36\n"
                + "          25.4                                     41                               22.5                          36-37\n"
                + "          25.7                                     41-42                            23                            37\n"
                + "          26                                       42                               23.5                          37-38\n"
                + "          26.7                                     42-43                            23.8                          38\n"
                + "          27                                       43                               24.1                          38-39\n"
                + "          27.3                                     43-44                            24.6                          39\n"
                + "          27.9                                     44                               25.1                          39-40\n"
                + "          28.3                                     44-45                            25.4                          40\n"
                + "          28.6                                     45                               25.9                          40-41\n"
                + "          29.4                                     46                               26.2                          41\n"
                + "          30.2                                     47                               26.7                          41-42\n"
                + "          31                                       48                               27.1                          42\n"
                + "          31.8                                     49                               27.6                          42-43");
    }

    void getValues() {
        try {
            int index = -1, check = 0;
            String sql = "select SizeQuanPhuc.MaDinhDanh,QuanNhan.HoTen,SizeQuanPhuc.SizeQuanPhuc,SizeQuanPhuc.SizeGiay,SizeQuanPhuc.SizeMu\n"
                    + "from SizeQuanPhuc inner join QuanNhan on SizeQuanPhuc.MaDinhDanh = QuanNhan.MaDinhDanh";
            String name = "";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                index++;
                if (rs.getString(1).equalsIgnoreCase(FormQuanNhan.maQuanNhan)) {
                    check++;
                    break;
                }
            }
            String sqlFindName = "Select * FROM QuanNhan";
            ResultSet rst = JDBCHelper.executeQuery(sqlFindName);
            while (rst.next()) {
                if (rst.getString("MaDinhDanh").equalsIgnoreCase(FormQuanNhan.maQuanNhan)) {
                    name = rst.getString("HoTen");
                    break;
                }
            }
            if (check != 0) {
                tblSizeQuanPhuc.setRowSelectionInterval(index, index);
                lblQuanNhan.setText("Quân Nhân: " + name);
            } else {
                lblQuanNhan.setText("Quân Nhân: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setTable() {
        scrollTable.setVerticalScrollBar(new JavaClass.ScrollBar());
        scrollTable.getVerticalScrollBar().setBackground(Color.WHITE);
        scrollTable.getViewport().setBackground(Color.WHITE);
        tblSizeQuanPhuc.getColumnModel().getColumn(0).setPreferredWidth(35);
        tblSizeQuanPhuc.getColumnModel().getColumn(1).setPreferredWidth(120);
        button1.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        button1.setFont(new Font("sansserif", 1, 12));
        button1.setText("Trở lại");
        btnThem.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnThem.setFont(new Font("sansserif", 1, 12));
        btnThem.setText("Thêm");
        btnSua.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnSua.setFont(new Font("sansserif", 1, 12));
        btnSua.setText("Sửa");
        btnXoa.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnXoa.setFont(new Font("sansserif", 1, 12));
        btnXoa.setText("Xóa");
        button5.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        button5.setFont(new Font("sansserif", 1, 12));
        button5.setText("Cấp QP");
    }

    void fillTableQuanNhan() {
        DefaultTableModel model = (DefaultTableModel) tblSizeQuanPhuc.getModel();
        model.setRowCount(0);
        try {
            String sql = "select SizeQuanPhuc.MaDinhDanh,QuanNhan.HoTen,SizeQuanPhuc.SizeQuanPhuc,SizeQuanPhuc.SizeGiay,SizeQuanPhuc.SizeMu\n"
                    + "from SizeQuanPhuc inner join QuanNhan on SizeQuanPhuc.MaDinhDanh = QuanNhan.MaDinhDanh";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                Object[] row = new Object[]{rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5)};
                model.addRow(row);
            }
        } catch (SQLException e) {
            DialogHelper.alert(this, "Lỗi truy vấn quân nhân! " + e);

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
        button1 = new JavaClass.Button();
        scrollTable = new javax.swing.JScrollPane();
        tblSizeQuanPhuc = new JavaClass.TableQuanPhuc();
        lblQuanNhan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboSizeGiay = new JavaClass.Combobox();
        cboSizeMu = new JavaClass.Combobox();
        cboSizeQuanPhuc = new JavaClass.Combobox();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnThem = new JavaClass.Button();
        btnSua = new JavaClass.Button();
        btnXoa = new JavaClass.Button();
        button5 = new JavaClass.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setPreferredSize(new java.awt.Dimension(850, 500));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setText("button1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelBorder1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 36, 90, -1));

        tblSizeQuanPhuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Quân Nhân", "Tên Quân Nhân", "Size Quân Phục", "Size Giày", "Size Mũ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSizeQuanPhuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSizeQuanPhucMouseClicked(evt);
            }
        });
        scrollTable.setViewportView(tblSizeQuanPhuc);

        panelBorder1.add(scrollTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 830, 280));

        lblQuanNhan.setText("Quân Nhân:");
        panelBorder1.add(lblQuanNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, -1, -1));

        jLabel1.setText("Size Quân Phục:");
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        jLabel2.setText("Size Giày:");
        panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel3.setText("Size Mũ:");
        panelBorder1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon/Numbered list.png"))); // NOI18N
        jLabel5.setText("Size Quân Phục");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        panelBorder1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 25, -1, -1));

        cboSizeGiay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45" }));
        cboSizeGiay.setLabeText("");
        panelBorder1.add(cboSizeGiay, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 220, 40));

        cboSizeMu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62" }));
        cboSizeMu.setLabeText("");
        panelBorder1.add(cboSizeMu, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 114, 220, 40));

        cboSizeQuanPhuc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S", "M", "L", "XL", "XXL", "XXXl" }));
        cboSizeQuanPhuc.setLabeText("");
        panelBorder1.add(cboSizeQuanPhuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 220, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon/Numbered list.png"))); // NOI18N
        jLabel4.setText("Size Giày");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        panelBorder1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 75, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon/Numbered list.png"))); // NOI18N
        jLabel6.setText("Size Mũ");
        panelBorder1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, -1, -1));

        btnThem.setText("button2");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        panelBorder1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 80, -1));

        btnSua.setText("button3");
        panelBorder1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 80, -1));

        btnXoa.setText("button4");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        panelBorder1.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 80, -1));

        button5.setText("button5");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        panelBorder1.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        showForm(new FormQuanNhan());
    }//GEN-LAST:event_button1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        showSizeQuanPhuc();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        showSizeGiay();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void tblSizeQuanPhucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeQuanPhucMouseClicked
        // TODO add your handling code here:
        indexTable = tblSizeQuanPhuc.getSelectedRow();
        lblQuanNhan.setText("Quân Nhân: " + tblSizeQuanPhuc.getValueAt(indexTable, 1).toString());
        for (int i = 0; i < cboSizeQuanPhuc.getItemCount(); i++) {
            if (cboSizeQuanPhuc.getItemAt(i).toString().equalsIgnoreCase(tblSizeQuanPhuc.getValueAt(indexTable, 2).toString())) {
                cboSizeQuanPhuc.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < cboSizeGiay.getItemCount(); i++) {
            if (cboSizeGiay.getItemAt(i).toString().equalsIgnoreCase(tblSizeQuanPhuc.getValueAt(indexTable, 3).toString())) {
                cboSizeGiay.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < cboSizeMu.getItemCount(); i++) {
            if (cboSizeMu.getItemAt(i).toString().equalsIgnoreCase(tblSizeQuanPhuc.getValueAt(indexTable, 4).toString())) {
                cboSizeMu.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_tblSizeQuanPhucMouseClicked

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        indexTable = tblSizeQuanPhuc.getSelectedRow();
        if (indexTable == -1) {
            DialogHelper.alert(this, "Vui lòng chọn quân nhân cần cấp quân phục!");
        } else {
            maQuanNhan = tblSizeQuanPhuc.getValueAt(indexTable, 0).toString();
            indexTable = -1;
            showForm(new PhatQuanPhucJPanel());
        }
    }//GEN-LAST:event_button5ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        indexTable = tblSizeQuanPhuc.getSelectedRow();
        if (indexTable == -1) {
            DialogHelper.alert(this, "Vui lòng chọn quân nhân cần xóa!");
        } else {
            delete(tblSizeQuanPhuc.getValueAt(indexTable, 0).toString());
            indexTable = -1;
        }
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JavaClass.Button btnSua;
    private JavaClass.Button btnThem;
    private JavaClass.Button btnXoa;
    private JavaClass.Button button1;
    private JavaClass.Button button5;
    private JavaClass.Combobox cboSizeGiay;
    private JavaClass.Combobox cboSizeMu;
    private JavaClass.Combobox cboSizeQuanPhuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblQuanNhan;
    private JPanel.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTable;
    private JavaClass.TableQuanPhuc tblSizeQuanPhuc;
    // End of variables declaration//GEN-END:variables
}
