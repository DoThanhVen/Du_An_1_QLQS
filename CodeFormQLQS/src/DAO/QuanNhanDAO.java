/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Admin
 */
import Helper.JDBCHelper;
import Class.QuanNhan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuanNhanDAO {

    public void insert(QuanNhan model) {
        String sql = "INSERT INTO QuanNhan (MaDinhDanh,HoTen, ChucVu, DonVi, NgaySinh, GioiTinh, NhapNgu,HinhAnh) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        JDBCHelper.executeUpdate(sql,
                model.getHoTen(),
                model.getCapBac(),
                model.getDonVi(),
                model.getNgaySinh(),
                model.isGioiTinh(),
                model.getNhapNgu(),
                model.getHinhAnh());
    }

    public void update(QuanNhan model) {
        String sql = "UPDATE QuanNhan SET HoTen=?,ChucVu=?,DonVi=?, NgaySinh=?, GioiTinh=?, NhapNgu=?,HinhAnh=? WHERE MaDinhDanh=?";
        JDBCHelper.executeUpdate(sql,
                model.getHoTen(),
                model.getCapBac(),
                model.getDonVi(),
                model.getNgaySinh(),
                model.isGioiTinh(),
                model.getNhapNgu(),
                model.getHinhAnh(),
                model.getMaQN());
    }

    public void delete(String id) {
        String sql = "DELETE FROM QuanNhan WHERE MaDinhDanh=?";
        JDBCHelper.executeUpdate(sql, id);
    }

    public List<QuanNhan> select() {
        String sql = "SELECT * FROM QuanNhan";
        return select(sql);
    }

    public List<QuanNhan> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM QuanNhan WHERE MaDinhDanh LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public QuanNhan findById(String maQN) {
        String sql = "SELECT * FROM QuanNhan WHERE MaDinhDanh=?";
        List<QuanNhan> list = select(sql, maQN);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<QuanNhan> select(String sql, Object... args) {
        List<QuanNhan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    QuanNhan model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private QuanNhan readFromResultSet(ResultSet rs) throws SQLException {
        QuanNhan model = new QuanNhan();
        return model;
    }

}
