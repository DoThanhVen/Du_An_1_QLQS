/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JPanel;

import Class.PhatQuanPhuc;
import DAO.PhatQuanPhucDAO;
import Helper.DateHelper;
import Helper.DialogHelper;
import Helper.JDBCHelper;
import JavaClass.Button;
import Search.SearchOptinEvent;
import Search.SearchOption;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class PhatQuanPhucJPanel extends javax.swing.JPanel {
    
    PhatQuanPhucDAO phatqpDAO = new PhatQuanPhucDAO();
    List<PhatQuanPhuc> List = new ArrayList<>();

    /**
     * Creates new form PhatQuanPhuc
     */
    public PhatQuanPhucJPanel() {
        initComponents();
        Edit();
        fillCombobox();
        addQuanNhan();
        fillTable();
    }
    
    void Edit() {
        scrollTable.setVerticalScrollBar(new JavaClass.ScrollBar());
        scrollTable.getVerticalScrollBar().setBackground(Color.WHITE);
        scrollTable.getViewport().setBackground(Color.WHITE);
        tblPhatQuanPhuc.getColumnModel().getColumn(0).setPreferredWidth(35);
        tblPhatQuanPhuc.getColumnModel().getColumn(1).setPreferredWidth(130);
        tblPhatQuanPhuc.getColumnModel().getColumn(2).setPreferredWidth(130);
        button1.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        button1.setFont(new Font("sansserif", 1, 12));
        button1.setText("Trở lại");
        btnThemQuanPhuc.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnThemQuanPhuc.setFont(new Font("sansserif", 1, 12));
        btnThemQuanPhuc.setText("Cấp QP");
        btnThemGiayDep.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnThemGiayDep.setFont(new Font("sansserif", 1, 12));
        btnThemGiayDep.setText("Cấp Giày");
        btnMu.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnMu.setFont(new Font("sansserif", 1, 12));
        btnMu.setText("Cấp Mũ");
        btnKhac.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnKhac.setFont(new Font("sansserif", 1, 12));
        btnKhac.setText("Cấp Khác");
        btnSapXep.setStyle(Button.ButtonStyle.DESTRUCTIVE);
        btnSapXep.setFont(new Font("sansserif", 1, 12));
        btnSapXep.setText("Sắp Xếp");
//Thanh tìm kiếm
        txtSearch.addOption(new SearchOption("mã quân nhân...", new ImageIcon(getClass().getResource("/Image/Icon/shield-plus-solid-24.png"))));
        txtSearch.addOption(new SearchOption("tên quân nhân...", new ImageIcon(getClass().getResource("/Image/Icon/user-detail-solid-24.png"))));
        txtSearch.addOption(new SearchOption("mã quân phục...", new ImageIcon(getClass().getResource("/Image/Icon/shield-plus-solid-24.png"))));
        txtSearch.addOption(new SearchOption("tên quân phục...", new ImageIcon(getClass().getResource("/Image/Icon/iconmonstr-clothing-12-24.png"))));
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                txtSearch.setHint("Tìm kiếm " + option.getName());
            }
        });
        txtSearch.setSelectedIndex(0);
    }
    
    void showForm(Component com
    ) {
        panelBorder1.removeAll();
        panelBorder1.setLayout(new BorderLayout());
        panelBorder1.add(com);
        panelBorder1.repaint();
        panelBorder1.revalidate();
    }
    
    void fillCombobox() {
        try {
            String sql = "Select * FROM QuanPhuc";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("TenQuanPhuc").contains("Quần")
                        || rs.getString("TenQuanPhuc").contains("Áo")
                        || rs.getString("TenQuanPhuc").contains("Quân Phục")) {
                    cboQuanPhuc.addItem(rs.getString("TenQuanPhuc"));
                } else if (rs.getString("TenQuanPhuc").contains("Giày") || rs.getString("TenQuanPhuc").contains("Dép")) {
                    cboGiay.addItem(rs.getString("TenQuanPhuc"));
                } else if (rs.getString("TenQuanPhuc").contains("Mũ")) {
                    cboMu.addItem(rs.getString("TenQuanPhuc"));
                } else {
                    cboKhac.addItem(rs.getString("TenQuanPhuc"));
                }
            }
        } catch (Exception e) {
        }
    }
    
    void addQuanNhan() {
        try {
            String sql = "Select * FROM QuanNhan";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("MaDinhDanh").equalsIgnoreCase(SizeQuanPhucJPanel.maQuanNhan)) {
                    lblQuanNhan.setText("Quân Nhân: " + rs.getString("HoTen"));
                    break;
                }
            }
        } catch (Exception e) {
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
        scrollTable = new javax.swing.JScrollPane();
        tblPhatQuanPhuc = new JavaClass.TableQuanPhuc();
        button1 = new JavaClass.Button();
        cboQuanPhuc = new JavaClass.Combobox();
        cboGiay = new JavaClass.Combobox();
        cboMu = new JavaClass.Combobox();
        cboKhac = new JavaClass.Combobox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnThemQuanPhuc = new JavaClass.Button();
        btnThemGiayDep = new JavaClass.Button();
        btnMu = new JavaClass.Button();
        btnKhac = new JavaClass.Button();
        lblQuanNhan = new javax.swing.JLabel();
        btnSapXep = new JavaClass.Button();
        txtSearch = new Search.TextFieldSearchOption();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPhatQuanPhuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã QN", "Họ & Tên", "Mã QP", "Tên Quân Phục", "Ngày Nhận", "Ngày Phát Tiếp", "Đơn Vị"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTable.setViewportView(tblPhatQuanPhuc);

        panelBorder1.add(scrollTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 276, 826, 211));

        button1.setText("button1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelBorder1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, -1));

        cboQuanPhuc.setLabeText("");
        panelBorder1.add(cboQuanPhuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 220, -1));

        cboGiay.setLabeText("");
        panelBorder1.add(cboGiay, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 220, -1));

        cboMu.setLabeText("");
        panelBorder1.add(cboMu, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 220, -1));

        cboKhac.setLabeText("");
        panelBorder1.add(cboKhac, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 220, -1));

        jLabel1.setText("Quân Phục:");
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jLabel2.setText("Giày, Dép:");
        panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        jLabel3.setText("Mũ:");
        panelBorder1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        jLabel4.setText("Khác:");
        panelBorder1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        btnThemQuanPhuc.setText("button2");
        btnThemQuanPhuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemQuanPhucActionPerformed(evt);
            }
        });
        panelBorder1.add(btnThemQuanPhuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 55, 80, -1));

        btnThemGiayDep.setText("button3");
        btnThemGiayDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGiayDepActionPerformed(evt);
            }
        });
        panelBorder1.add(btnThemGiayDep, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 95, 80, -1));

        btnMu.setText("button4");
        btnMu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuActionPerformed(evt);
            }
        });
        panelBorder1.add(btnMu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 135, 80, -1));

        btnKhac.setText("button5");
        btnKhac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhacActionPerformed(evt);
            }
        });
        panelBorder1.add(btnKhac, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 175, 80, -1));

        lblQuanNhan.setText("Quân Nhân: ");
        panelBorder1.add(lblQuanNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btnSapXep.setText("button2");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });
        panelBorder1.add(btnSapXep, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 80, -1));

        txtSearch.setColorOverlay1(new java.awt.Color(130, 148, 96));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        panelBorder1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void XepTheoMa() {
        try {
            String sql = "Select NhanQuanPhuc.MaBienNhan,QuanNhan.MaDinhDanh,QuanNhan.HoTen,NhanQuanPhuc.NgayNhan,NhanQuanPhuc.NgayCapTiep,\n"
                    + "QuanPhuc.MaQuanPhuc,QuanPhuc.TenQuanPhuc,DaiDoi.TenDaiDoi \n"
                    + "FROM NhanQuanPhuc INNER JOIN QuanNhan On NhanQuanPhuc.MaDinhDanh = QuanNhan.MaDinhDanh \n"
                    + "INNER JOIN QuanPhuc ON NhanQuanPhuc.MaQuanPhuc = QuanPhuc.MaQuanPhuc \n"
                    + "INNER JOIN DaiDoi ON DaiDoi.MaDaiDoi = QuanNhan.DonVi";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                List.add(new PhatQuanPhuc(rs.getString(2), rs.getString(6), rs.getString(3), rs.getString(7), rs.getString(8), rs.getInt(1), rs.getDate(4), rs.getDate(5)));
            }
            Comparator<PhatQuanPhuc> comp = new Comparator<PhatQuanPhuc>() {
                public int compare(PhatQuanPhuc gb1, PhatQuanPhuc gb2) {
                    return gb1.getMaQuanNhan().toUpperCase().compareTo(gb2.getMaQuanNhan().toUpperCase());
                }
            };
            Collections.sort(List, comp);
            DefaultTableModel model = (DefaultTableModel) tblPhatQuanPhuc.getModel();
            model.setRowCount(0);
            for (PhatQuanPhuc qp : List) {
                Object[] row = new Object[]{qp.getMaBienNhan(), qp.getMaQuanNhan(), qp.getHoTen(), qp.getMaQuanPhuc(), qp.getTenQuanPhuc(), qp.getNgayNhan(), qp.getNgayCapTiep(), qp.getTenDaiDoi()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblPhatQuanPhuc.getModel();
        model.setRowCount(0);
        try {
            String sql = "Select NhanQuanPhuc.MaBienNhan,QuanNhan.MaDinhDanh,QuanNhan.HoTen,NhanQuanPhuc.NgayNhan,NhanQuanPhuc.NgayCapTiep,\n"
                    + "QuanPhuc.MaQuanPhuc,QuanPhuc.TenQuanPhuc,DaiDoi.TenDaiDoi \n"
                    + "FROM NhanQuanPhuc INNER JOIN QuanNhan On NhanQuanPhuc.MaDinhDanh = QuanNhan.MaDinhDanh \n"
                    + "INNER JOIN QuanPhuc ON NhanQuanPhuc.MaQuanPhuc = QuanPhuc.MaQuanPhuc \n"
                    + "INNER JOIN DaiDoi ON DaiDoi.MaDaiDoi = QuanNhan.DonVi";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                Object[] row = new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(6), rs.getString(7), rs.getDate(4), rs.getDate(5), rs.getString(8)};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        showForm(new SizeQuanPhucJPanel());
    }//GEN-LAST:event_button1ActionPerformed
    void checkInsertQuanPhuc() {
        String maQuanPhuc = "", maDonVi = "";
        try {
            String sql = "Select * FROM QuanPhuc";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                if (cboQuanPhuc.getSelectedItem().toString().equalsIgnoreCase(rs.getString("TenQuanPhuc"))) {
                    maQuanPhuc = rs.getString("MaQuanPhuc");
                    break;
                }
            }
            try {
                String sqlMaDV = "SELECT QuanNhan.DonVi FROM SizeQuanPhuc INNER JOIN QuanNhan\n"
                        + "ON SizeQuanPhuc.MaDinhDanh = QuanNhan.MaDinhDanh\n"
                        + "WHERE SizeQuanPhuc.MaDinhDanh = '" + SizeQuanPhucJPanel.maQuanNhan + "'";
                ResultSet rsMaDV = JDBCHelper.executeQuery(sqlMaDV);
                while (rsMaDV.next()) {
                    maDonVi = rsMaDV.getString(1);
                    break;
                }
                try {
                    String sqlCheck = "EXEC sp_ThongKeQuanPhucDaiDoi '" + maQuanPhuc + "','" + maDonVi + "'";
                    ResultSet rst = JDBCHelper.executeQuery(sqlCheck);
                    while (rst.next()) {
                        if (rst.getInt("Tong") <= rst.getInt("DaPhat")) {
                            DialogHelper.alert(this, "Quân phục đã phát hết");
                        } else {
                            insertQuanPhuc();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void insertQuanPhuc() {
        int year = -1;
        try {
            PhatQuanPhuc model = new PhatQuanPhuc();
            model.setMaQuanNhan(SizeQuanPhucJPanel.maQuanNhan);
            String maQuanPhuc = "";
            String sql = "Select * FROM QuanPhuc";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                if (cboQuanPhuc.getSelectedItem().toString().equalsIgnoreCase(rs.getString("TenQuanPhuc"))) {
                    maQuanPhuc = rs.getString("MaQuanPhuc");
                    year = rs.getInt("ThoiGianCap");
                    break;
                }
            }
            int check = 0;
            String sqlCheck = "Select * FROM NhanQuanPhuc";
            ResultSet rst = JDBCHelper.executeQuery(sqlCheck);
            while (rst.next()) {
                if (rst.getString("MaQuanPhuc").equalsIgnoreCase(maQuanPhuc) && rst.getString("MaDinhDanh").equalsIgnoreCase(SizeQuanPhucJPanel.maQuanNhan)) {
                    check++;
                    break;
                }
            }
            if (check != 0) {
                DialogHelper.alert(this, "Thêm trùng lặp");
            } else {
                model.setMaQuanPhuc(maQuanPhuc);
//Lấy số năm kế tiếp cần phát
                model.setNgayNhan(new java.sql.Date(DateHelper.now().getTime()));
                model.setNgayCapTiep(new java.sql.Date(DateHelper.add(year).getTime()));
                try {
                    phatqpDAO.insert(model);
                    DialogHelper.alert(this, "Thêm thành công!");
                    fillTable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void btnThemQuanPhucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemQuanPhucActionPerformed
        // TODO add your handling code here:
        checkInsertQuanPhuc();
    }//GEN-LAST:event_btnThemQuanPhucActionPerformed
    void checkInsertGiay() {
        String maQuanPhuc = "", maDonVi = "";
        try {
            String sql = "Select * FROM QuanPhuc";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                if (cboGiay.getSelectedItem().toString().equalsIgnoreCase(rs.getString("TenQuanPhuc"))) {
                    maQuanPhuc = rs.getString("MaQuanPhuc");
                    break;
                }
            }
            try {
                String sqlMaDV = "SELECT QuanNhan.DonVi FROM SizeQuanPhuc INNER JOIN QuanNhan\n"
                        + "ON SizeQuanPhuc.MaDinhDanh = QuanNhan.MaDinhDanh\n"
                        + "WHERE SizeQuanPhuc.MaDinhDanh = '" + SizeQuanPhucJPanel.maQuanNhan + "'";
                ResultSet rsMaDV = JDBCHelper.executeQuery(sqlMaDV);
                while (rsMaDV.next()) {
                    maDonVi = rsMaDV.getString(1);
                    break;
                }
                try {
                    String sqlCheck = "EXEC sp_ThongKeQuanPhucDaiDoi '" + maQuanPhuc + "','" + maDonVi + "'";
                    ResultSet rst = JDBCHelper.executeQuery(sqlCheck);
                    while (rst.next()) {
                        if (rst.getInt("Tong") <= rst.getInt("DaPhat")) {
                            DialogHelper.alert(this, "Quân phục đã phát hết");
                        } else {
                            insertGiay();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void insertGiay() {
        int year = -1;
        try {
            PhatQuanPhuc model = new PhatQuanPhuc();
            model.setMaQuanNhan(SizeQuanPhucJPanel.maQuanNhan);
            String maQuanPhuc = "";
            String sql = "Select * FROM QuanPhuc";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                if (cboGiay.getSelectedItem().toString().equalsIgnoreCase(rs.getString("TenQuanPhuc"))) {
                    maQuanPhuc = rs.getString("MaQuanPhuc");
                    year = rs.getInt("ThoiGianCap");
                    break;
                }
            }
            int check = 0;
            String sqlCheck = "Select * FROM NhanQuanPhuc";
            ResultSet rst = JDBCHelper.executeQuery(sqlCheck);
            while (rst.next()) {
                if (rst.getString("MaQuanPhuc").equalsIgnoreCase(maQuanPhuc) && rst.getString("MaDinhDanh").equalsIgnoreCase(SizeQuanPhucJPanel.maQuanNhan)) {
                    check++;
                    break;
                }
            }
            if (check != 0) {
                DialogHelper.alert(this, "Thêm trùng lặp");
            } else {
                model.setMaQuanPhuc(maQuanPhuc);
//Lấy số năm kế tiếp cần phát
                model.setNgayNhan(new java.sql.Date(DateHelper.now().getTime()));
                model.setNgayCapTiep(new java.sql.Date(DateHelper.add(year).getTime()));
                try {
                    phatqpDAO.insert(model);
                    DialogHelper.alert(this, "Thêm thành công!");
                    fillTable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void btnThemGiayDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGiayDepActionPerformed
        // TODO add your handling code here:
        checkInsertGiay();
    }//GEN-LAST:event_btnThemGiayDepActionPerformed
    void checkInsertMu() {
        String maQuanPhuc = "", maDonVi = "";
        try {
            String sql = "Select * FROM QuanPhuc";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                if (cboMu.getSelectedItem().toString().equalsIgnoreCase(rs.getString("TenQuanPhuc"))) {
                    maQuanPhuc = rs.getString("MaQuanPhuc");
                    break;
                }
            }
            try {
                String sqlMaDV = "SELECT QuanNhan.DonVi FROM SizeQuanPhuc INNER JOIN QuanNhan\n"
                        + "ON SizeQuanPhuc.MaDinhDanh = QuanNhan.MaDinhDanh\n"
                        + "WHERE SizeQuanPhuc.MaDinhDanh = '" + SizeQuanPhucJPanel.maQuanNhan + "'";
                ResultSet rsMaDV = JDBCHelper.executeQuery(sqlMaDV);
                while (rsMaDV.next()) {
                    maDonVi = rsMaDV.getString(1);
                    break;
                }
                try {
                    String sqlCheck = "EXEC sp_ThongKeQuanPhucDaiDoi '" + maQuanPhuc + "','" + maDonVi + "'";
                    ResultSet rst = JDBCHelper.executeQuery(sqlCheck);
                    while (rst.next()) {
                        if (rst.getInt("Tong") <= rst.getInt("DaPhat")) {
                            DialogHelper.alert(this, "Quân phục đã phát hết");
                        } else {
                            insertMu();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void insertMu() {
        int year = -1;
        try {
            PhatQuanPhuc model = new PhatQuanPhuc();
            model.setMaQuanNhan(SizeQuanPhucJPanel.maQuanNhan);
            String maQuanPhuc = "";
            String sql = "Select * FROM QuanPhuc";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                if (cboMu.getSelectedItem().toString().equalsIgnoreCase(rs.getString("TenQuanPhuc"))) {
                    maQuanPhuc = rs.getString("MaQuanPhuc");
                    year = rs.getInt("ThoiGianCap");
                    break;
                }
            }
            int check = 0;
            String sqlCheck = "Select * FROM NhanQuanPhuc";
            ResultSet rst = JDBCHelper.executeQuery(sqlCheck);
            while (rst.next()) {
                if (rst.getString("MaQuanPhuc").equalsIgnoreCase(maQuanPhuc) && rst.getString("MaDinhDanh").equalsIgnoreCase(SizeQuanPhucJPanel.maQuanNhan)) {
                    check++;
                    break;
                }
            }
            if (check != 0) {
                DialogHelper.alert(this, "Thêm trùng lặp");
            } else {
                model.setMaQuanPhuc(maQuanPhuc);
//Lấy số năm kế tiếp cần phát
                model.setNgayNhan(new java.sql.Date(DateHelper.now().getTime()));
                model.setNgayCapTiep(new java.sql.Date(DateHelper.add(year).getTime()));
                try {
                    phatqpDAO.insert(model);
                    DialogHelper.alert(this, "Thêm thành công!");
                    fillTable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void btnMuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuActionPerformed
        // TODO add your handling code here:
        checkInsertMu();
    }//GEN-LAST:event_btnMuActionPerformed
    void checkInsertKhac() {
        String maQuanPhuc = "", maDonVi = "";
        try {
            String sql = "Select * FROM QuanPhuc";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                if (cboKhac.getSelectedItem().toString().equalsIgnoreCase(rs.getString("TenQuanPhuc"))) {
                    maQuanPhuc = rs.getString("MaQuanPhuc");
                    break;
                }
            }
            try {
                String sqlMaDV = "SELECT QuanNhan.DonVi FROM SizeQuanPhuc INNER JOIN QuanNhan\n"
                        + "ON SizeQuanPhuc.MaDinhDanh = QuanNhan.MaDinhDanh\n"
                        + "WHERE SizeQuanPhuc.MaDinhDanh = '" + SizeQuanPhucJPanel.maQuanNhan + "'";
                ResultSet rsMaDV = JDBCHelper.executeQuery(sqlMaDV);
                while (rsMaDV.next()) {
                    maDonVi = rsMaDV.getString(1);
                    break;
                }
                try {
                    String sqlCheck = "EXEC sp_ThongKeQuanPhucDaiDoi '" + maQuanPhuc + "','" + maDonVi + "'";
                    ResultSet rst = JDBCHelper.executeQuery(sqlCheck);
                    while (rst.next()) {
                        if (rst.getInt("Tong") <= rst.getInt("DaPhat")) {
                            DialogHelper.alert(this, "Quân phục đã phát hết");
                        } else {
                            insertKhac();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    void insertKhac() {
        int year = -1;
        try {
            PhatQuanPhuc model = new PhatQuanPhuc();
            model.setMaQuanNhan(SizeQuanPhucJPanel.maQuanNhan);
            String maQuanPhuc = "";
            String sql = "Select * FROM QuanPhuc";
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                if (cboKhac.getSelectedItem().toString().equalsIgnoreCase(rs.getString("TenQuanPhuc"))) {
                    maQuanPhuc = rs.getString("MaQuanPhuc");
                    year = rs.getInt("ThoiGianCap");
                    break;
                }
            }
            int check = 0;
            String sqlCheck = "Select * FROM NhanQuanPhuc";
            ResultSet rst = JDBCHelper.executeQuery(sqlCheck);
            while (rst.next()) {
                if (rst.getString("MaQuanPhuc").equalsIgnoreCase(maQuanPhuc) && rst.getString("MaDinhDanh").equalsIgnoreCase(SizeQuanPhucJPanel.maQuanNhan)) {
                    check++;
                    break;
                }
            }
            if (check != 0) {
                DialogHelper.alert(this, "Thêm trùng lặp");
            } else {
                model.setMaQuanPhuc(maQuanPhuc);
//Lấy số năm kế tiếp cần phát
                model.setNgayNhan(new java.sql.Date(DateHelper.now().getTime()));
                model.setNgayCapTiep(new java.sql.Date(DateHelper.add(year).getTime()));
                try {
                    phatqpDAO.insert(model);
                    DialogHelper.alert(this, "Thêm thành công!");
                    fillTable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void btnKhacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhacActionPerformed
        // TODO add your handling code here:
        checkInsertKhac();
    }//GEN-LAST:event_btnKhacActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        // TODO add your handling code here:
        List.removeAll(List);
        XepTheoMa();
    }//GEN-LAST:event_btnSapXepActionPerformed
    void loadData(String where) {
        DefaultTableModel model = (DefaultTableModel) tblPhatQuanPhuc.getModel();
        model.setRowCount(0);
        try {
            String sql = "Select NhanQuanPhuc.MaBienNhan,QuanNhan.MaDinhDanh,QuanNhan.HoTen,NhanQuanPhuc.NgayNhan,NhanQuanPhuc.NgayCapTiep,\n"
                    + "QuanPhuc.MaQuanPhuc,QuanPhuc.TenQuanPhuc,DaiDoi.TenDaiDoi \n"
                    + "FROM NhanQuanPhuc INNER JOIN QuanNhan On NhanQuanPhuc.MaDinhDanh = QuanNhan.MaDinhDanh\n"
                    + "INNER JOIN DaiDoi ON DaiDoi.MaDaiDoi = QuanNhan.DonVi\n"
                    + "INNER JOIN QuanPhuc ON QuanPhuc.MaQuanPhuc = NhanQuanPhuc.MaQuanPhuc " + where;
            ResultSet rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                Object[] row = new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(6), rs.getString(7), rs.getDate(4), rs.getDate(5), rs.getString(8)};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        if (txtSearch.isSelected()) {
            int option = txtSearch.getSelectedIndex();
            String text = "%" + txtSearch.getText() + "%";
            if (txtSearch.getText().equals("")) {
                fillTable();
            }
            if (option == 0) {
                loadData("Where QuanNhan.MaDinhDanh LIKE N'" + text + "'");
            } else if (option == 1) {
                loadData("Where QuanNhan.HoTen LIKE N'" + text + "'");
            } else if (option == 2) {
                loadData("Where QuanPhuc.MaQuanPhuc LIKE " + "N'" + text + "'");
            } else {
                loadData("Where QuanPhuc.TenQuanPhuc LIKE " + "N'" + text + "'");
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JavaClass.Button btnKhac;
    private JavaClass.Button btnMu;
    private JavaClass.Button btnSapXep;
    private JavaClass.Button btnThemGiayDep;
    private JavaClass.Button btnThemQuanPhuc;
    private JavaClass.Button button1;
    private JavaClass.Combobox cboGiay;
    private JavaClass.Combobox cboKhac;
    private JavaClass.Combobox cboMu;
    private JavaClass.Combobox cboQuanPhuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblQuanNhan;
    private JPanel.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollTable;
    private JavaClass.TableQuanPhuc tblPhatQuanPhuc;
    private Search.TextFieldSearchOption txtSearch;
    // End of variables declaration//GEN-END:variables
}
