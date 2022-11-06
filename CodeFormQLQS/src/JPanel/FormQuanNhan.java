/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JPanel;

import Class.QuanNhan;
import DAO.QuanNhanDAO;
import Helper.DialogHelper;
import Helper.JDBCHelper;
import JavaClass.Button;
import JavaClass.ModelMenu;
import JavaClass.ScrollBar;
import JavaClass.StatusType;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import Search.SearchOptinEvent;
import Search.SearchOption;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.BorderFactory;

/**
 *
 * @author Admin
 */
public class FormQuanNhan extends javax.swing.JPanel {
    
    QuanNhanDAO qnDAO = new QuanNhanDAO();
    int indexTable = -1;
    
    public static String maQuanNhan = "";

    /**
     * Creates new form FormQuanNhan
     */
    public FormQuanNhan() {
        initComponents();
        fillTableQuanNhan();
        setSizeTable();
        addSearchItem();
        txtHoTen.setHint("Tên Quân Nhân");
        txtDonVi.setHint("Địa Chỉ");
        txtNgaySinh.setHint("Ngày Sinh");
        txtNgayNhapNgu.setHint("Ngày Nhập Ngũ");
        txtDonVi.setHint("Địa Chỉ");
        txtMaQN.setHint("Mã QN");
    }
    
    void addSearchItem() {
        txtSearch.addOption(new SearchOption("mã quân nhân...", new ImageIcon(getClass().getResource("/Image/Icon/shield-plus-solid-24.png"))));
        txtSearch.addOption(new SearchOption("tên quân nhân...", new ImageIcon(getClass().getResource("/Image/Icon/user-detail-solid-24.png"))));
        txtSearch.addOption(new SearchOption("cấp bậc...", new ImageIcon(getClass().getResource("/Image/Icon/objects-vertical-bottom-regular-24.png"))));
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                txtSearch.setHint("Tìm kiếm " + option.getName());
            }
        });
        txtSearch.setSelectedIndex(0);
        button1.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        button1.setFont(new Font("sansserif", 1, 12));
        button1.setText("Thêm");
        button2.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        button2.setFont(new Font("sansserif", 1, 12));
        button2.setText("Sửa");
        button3.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        button3.setFont(new Font("sansserif", 1, 12));
        button3.setText("Xóa");
        button4.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        button4.setFont(new Font("sansserif", 1, 12));
        button4.setText("Mới");
        button5.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        button5.setFont(new Font("sansserif", 1, 12));
        button5.setText("Size Equip");
    }
    
    void setSizeTable() {
        lblImage.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        scrollTable.setVerticalScrollBar(new JavaClass.ScrollBar());
        scrollTable.getVerticalScrollBar().setBackground(Color.WHITE);
        scrollTable.getViewport().setBackground(Color.WHITE);
        tblQuanNhan.getColumnModel().getColumn(0).setPreferredWidth(35);
        tblQuanNhan.getColumnModel().getColumn(1).setPreferredWidth(130);
        tblQuanNhan.getColumnModel().getColumn(2).setPreferredWidth(80);
    }
    
    void loadData(String where) {
        DefaultTableModel model = (DefaultTableModel) tblQuanNhan.getModel();
        model.setRowCount(0);
        try {
            String sql = "SELECT * FROM QuanNhan " + where;
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                char[] charArrayName = rs.getString("HoTen").toCharArray();
                boolean foundSpaceName = true;
                //sử dụng vòng lặp for để duyệt các phần tử trong charArray
                for (int i = 0; i < charArrayName.length; i++) {
                    // nếu phần tử trong mảng là một chữ cái
                    if (Character.isLetter(charArrayName[i])) {
                        // kiểm tra khoảng trắng có trước chữ cái
                        if (foundSpaceName) {
                            //đổi chữ cái thành chữ in hoa bằng phương thức toUpperCase()
                            charArrayName[i] = Character.toUpperCase(charArrayName[i]);
                            foundSpaceName = false;
                        }
                    } else {
                        foundSpaceName = true;
                    }
                }
                String fullName = String.valueOf(charArrayName);
                String gt = "";
                if (rs.getBoolean("GioiTinh")) {
                    gt = "Nam";
                } else {
                    gt = "Nữ";
                }
                Object[] row = new Object[]{rs.getString("MaDinhDanh").toUpperCase(),
                    fullName,
                    rs.getString("ChucVu"),
                    rs.getString("DonVi"),
                    rs.getDate("NgaySinh"),
                    gt,
                    rs.getDate("NhapNgu")};
                tblQuanNhan.addRow(row);
            }
        } catch (SQLException e) {
            DialogHelper.alert(this, "Lỗi truy vấn quân nhân! " + e);
            
        }
    }
    
    void fillTableQuanNhan() {
        DefaultTableModel model = (DefaultTableModel) tblQuanNhan.getModel();
        model.setRowCount(0);
        try {
            String sql = "SELECT * FROM QuanNhan";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                char[] charArrayName = rs.getString("HoTen").toCharArray();
                boolean foundSpaceName = true;
                //sử dụng vòng lặp for để duyệt các phần tử trong charArray
                for (int i = 0; i < charArrayName.length; i++) {
                    // nếu phần tử trong mảng là một chữ cái
                    if (Character.isLetter(charArrayName[i])) {
                        // kiểm tra khoảng trắng có trước chữ cái
                        if (foundSpaceName) {
                            //đổi chữ cái thành chữ in hoa bằng phương thức toUpperCase()
                            charArrayName[i] = Character.toUpperCase(charArrayName[i]);
                            foundSpaceName = false;
                        }
                    } else {
                        foundSpaceName = true;
                    }
                }
                String fullName = String.valueOf(charArrayName);
                String gt = "";
                if (rs.getBoolean("GioiTinh")) {
                    gt = "Nam";
                } else {
                    gt = "Nữ";
                }
                Object[] row = new Object[]{rs.getString("MaDinhDanh").toUpperCase(),
                    fullName,
                    rs.getString("ChucVu"),
                    rs.getString("DonVi"),
                    rs.getDate("NgaySinh"),
                    gt,
                    rs.getDate("NhapNgu")};
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelBorder2 = new JPanel.PanelBorder();
        scrollTable = new javax.swing.JScrollPane();
        tblQuanNhan = new JavaClass.TableQuanNhan();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new Search.TextFieldSearchOption();
        txtHoTen = new JavaClass.SearchText();
        txtDonVi = new JavaClass.SearchText();
        txtNgaySinh = new JavaClass.SearchText();
        cboChucVu = new JavaClass.Combobox();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtNgayNhapNgu = new JavaClass.SearchText();
        button1 = new JavaClass.Button();
        lblImage = new javax.swing.JLabel();
        button2 = new JavaClass.Button();
        button3 = new JavaClass.Button();
        button4 = new JavaClass.Button();
        txtMaQN = new JavaClass.SearchText();
        button5 = new JavaClass.Button();

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder2.setPreferredSize(new java.awt.Dimension(709, 312));
        panelBorder2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollTable.setBorder(null);
        scrollTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblQuanNhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã QN", "Họ & Tên", "Cấp Bậc", "ĐV", "Ngày Sinh", "GT", "Nhập Ngũ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQuanNhan.setOpaque(false);
        tblQuanNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanNhanMouseClicked(evt);
            }
        });
        tblQuanNhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblQuanNhanKeyReleased(evt);
            }
        });
        scrollTable.setViewportView(tblQuanNhan);

        panelBorder2.add(scrollTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 826, 250));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("QUÂN NHÂN");
        panelBorder2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, -1, -1));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        panelBorder2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 200, -1));
        panelBorder2.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 180, -1));
        panelBorder2.add(txtDonVi, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 180, -1));
        panelBorder2.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 180, -1));

        cboChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Đại tướng", "Thượng tướng", "Trung tướng", "Thiếu tướng ", "Đại tá", "Thượng tá", "Trung tá", "Thiếu tá", "Đại úy", "Thượng úy ", "Trung úy", "Thiếu úy", "Thượng sĩ", "Trung sĩ", "Hạ sĩ", "Học viên", "Binh nhất", "Binh nhì" }));
        cboChucVu.setLabeText("");
        panelBorder2.add(cboChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 185, 40));

        rdoNam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        panelBorder2.add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        rdoNu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        panelBorder2.add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Giới tính:");
        panelBorder2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));
        panelBorder2.add(txtNgayNhapNgu, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 180, -1));

        button1.setText("button1");
        panelBorder2.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 90, -1));
        panelBorder2.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 120, 150));

        button2.setText("button2");
        panelBorder2.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 90, -1));

        button3.setText("button3");
        panelBorder2.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 90, -1));

        button4.setText("button4");
        panelBorder2.add(button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 90, -1));

        txtMaQN.setForeground(new java.awt.Color(255, 0, 0));
        txtMaQN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelBorder2.add(txtMaQN, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 190, 50, -1));

        button5.setText("button5");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        panelBorder2.add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        if (txtSearch.isSelected()) {
            int option = txtSearch.getSelectedIndex();
            String text = "%" + txtSearch.getText() + "%";
            if (txtSearch.getText().equals("")) {
                fillTableQuanNhan();
            }
            if (option == 0) {
                loadData("Where MaDinhDanh LIKE " + "'" + text + "'");
            } else if (option == 1) {
                loadData("Where HoTen LIKE " + "N'" + text + "'");
            } else {
                loadData("Where ChucVu LIKE " + "N'" + text + "'");
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblQuanNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanNhanMouseClicked
        // TODO add your handling code here:
        indexTable = tblQuanNhan.getSelectedRow();
        if (tblQuanNhan.getValueAt(indexTable, 5).toString().equalsIgnoreCase("nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        for (int i = 0; i < cboChucVu.getItemCount(); i++) {
            if (cboChucVu.getItemAt(i).toString().equalsIgnoreCase(tblQuanNhan.getValueAt(indexTable, 2).toString())) {
                cboChucVu.setSelectedIndex(i);
                break;
            }
        }
        txtMaQN.setText(tblQuanNhan.getValueAt(indexTable, 0).toString());
        txtHoTen.setText(tblQuanNhan.getValueAt(indexTable, 1).toString());
        txtDonVi.setText(tblQuanNhan.getValueAt(indexTable, 3).toString());
        txtNgayNhapNgu.setText(tblQuanNhan.getValueAt(indexTable, 6).toString());
        txtNgaySinh.setText(tblQuanNhan.getValueAt(indexTable, 4).toString());
    }//GEN-LAST:event_tblQuanNhanMouseClicked

    private void tblQuanNhanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblQuanNhanKeyReleased
        // TODO add your handling code here:
        indexTable = tblQuanNhan.getSelectedRow();
        if (tblQuanNhan.getValueAt(indexTable, 5).toString().equalsIgnoreCase("nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        for (int i = 0; i < cboChucVu.getItemCount(); i++) {
            if (cboChucVu.getItemAt(i).toString().equalsIgnoreCase(tblQuanNhan.getValueAt(indexTable, 2).toString())) {
                cboChucVu.setSelectedIndex(i);
                break;
            }
        }
        txtMaQN.setText(tblQuanNhan.getValueAt(indexTable, 0).toString());
        txtHoTen.setText(tblQuanNhan.getValueAt(indexTable, 1).toString());
        txtDonVi.setText(tblQuanNhan.getValueAt(indexTable, 3).toString());
        txtNgayNhapNgu.setText(tblQuanNhan.getValueAt(indexTable, 6).toString());
        txtNgaySinh.setText(tblQuanNhan.getValueAt(indexTable, 4).toString());
    }//GEN-LAST:event_tblQuanNhanKeyReleased

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
            showForm(new SizeQuanPhuc());
    }//GEN-LAST:event_button5ActionPerformed
    void showForm(Component com) {
        panelBorder2.removeAll();
        panelBorder2.setLayout(new BorderLayout());
        panelBorder2.add(com);
        panelBorder2.repaint();
        panelBorder2.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JavaClass.Button button1;
    private JavaClass.Button button2;
    private JavaClass.Button button3;
    private JavaClass.Button button4;
    private JavaClass.Button button5;
    private javax.swing.ButtonGroup buttonGroup1;
    private JavaClass.Combobox cboChucVu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblImage;
    private JPanel.PanelBorder panelBorder2;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JScrollPane scrollTable;
    private JavaClass.TableQuanNhan tblQuanNhan;
    private JavaClass.SearchText txtDonVi;
    private JavaClass.SearchText txtHoTen;
    private JavaClass.SearchText txtMaQN;
    private JavaClass.SearchText txtNgayNhapNgu;
    private JavaClass.SearchText txtNgaySinh;
    private Search.TextFieldSearchOption txtSearch;
    // End of variables declaration//GEN-END:variables
}
