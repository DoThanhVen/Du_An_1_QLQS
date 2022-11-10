/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.NhapQuanPhuc;
import Helper.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhapQuanPhucDAO {

    public void insert(NhapQuanPhuc model) {
        String sql = "INSERT INTO NhapQuanPhuc (MaQuanPhuc,SoLuong) VALUES (?, ?)";
        JDBCHelper.executeUpdate(sql,
                model.getMaQuanPhuc(),
                model.getSoLuong());
    }

    public void update(NhapQuanPhuc model) {
        String sql = "UPDATE NhapQuanPhuc SET MaQuanPhuc  = ?, SoLuong = ? WHERE MaBienNhan = ?";
        JDBCHelper.executeUpdate(sql,
                model.getMaQuanPhuc(),
                model.getSoLuong(),
                model.getMaBienNhan());
    }

    public void delete(int id) {
        String sql = "DELETE FROM NhapQuanPhuc WHERE MaBienNhan = ?";
        JDBCHelper.executeUpdate(sql, id);
    }

    public List<NhapQuanPhuc> select() {
        String sql = "SELECT * FROM NhapQuanPhuc";
        return select(sql);
    }

    private List<NhapQuanPhuc> select(String sql, Object... args) {
        List<NhapQuanPhuc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhapQuanPhuc model = readFromResultSet(rs);
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

    private NhapQuanPhuc readFromResultSet(ResultSet rs) throws SQLException {
        NhapQuanPhuc model = new NhapQuanPhuc();
        return model;
    }
}
