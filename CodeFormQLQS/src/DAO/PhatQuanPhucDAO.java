/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.PhatQuanPhuc;
import Helper.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PhatQuanPhucDAO {

    public void insert(PhatQuanPhuc model) {
        String sql = "INSERT INTO NhanQuanPhuc (MaDinhDanh,MaQuanPhuc,NgayNhan,NgayCapTiep) VALUES (?, ?, ?, ?)";
        JDBCHelper.executeUpdate(sql,
                model.getMaQuanNhan(),
                model.getMaQuanPhuc(),
                model.getNgayNhan(),
                model.getNgayCapTiep());
    }

    public void update(PhatQuanPhuc model) {
        String sql = "UPDATE NhanQuanPhuc SET MaDinhDanh = ?, MaQuanPhuc = ?, NgayNhan = ?, NgayCapTiep = ? WHERE MaBienNhan=?";
        JDBCHelper.executeUpdate(sql,
                model.getMaQuanNhan(),
                model.getMaQuanPhuc(),
                model.getNgayNhan(),
                model.getNgayCapTiep(),
                model.getMaBienNhan());
    }

    public void delete(int id) {
        String sql = "DELETE FROM PhatQuanPhuc WHERE MaBienNhan=?";
        JDBCHelper.executeUpdate(sql, id);
    }

    public List<PhatQuanPhuc> select() {
        String sql = "SELECT * FROM PhatQuanPhuc";
        return select(sql);
    }

    private List<PhatQuanPhuc> select(String sql, Object... args) {
        List<PhatQuanPhuc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhatQuanPhuc model = readFromResultSet(rs);
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

    private PhatQuanPhuc readFromResultSet(ResultSet rs) throws SQLException {
        PhatQuanPhuc model = new PhatQuanPhuc();
        return model;
    }
}
