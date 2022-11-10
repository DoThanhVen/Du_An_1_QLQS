/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.SizeQuanPhuc;
import Helper.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SizeQuanPhucDAO {

    public void insert(SizeQuanPhuc model) {
        String sql = "INSERT INTO SizeQuanPhuc (MaDinhDanh,SizeQuanPhuc,SizeGiay,SizeMu) VALUES (?, ?, ?, ?)";
        JDBCHelper.executeUpdate(sql,
                model.getMaDinhDanh(),
                model.getSizeQuanPhuc(),
                model.getSizeGiay(),
                model.getSizeMu());
    }

    public void update(SizeQuanPhuc model) {
        String sql = "UPDATE SizeQuanPhuc SET SizeQuanPhuc = ?,SizeGiay = ?,SizeMu = ? WHERE MaDinhDanh=?";
        JDBCHelper.executeUpdate(sql,
                model.getSizeQuanPhuc(),
                model.getSizeGiay(),
                model.getSizeMu(),
                model.getMaDinhDanh());
    }

    public void delete(String id) {
        String sql = "DELETE FROM SizeQuanPhuc WHERE MaDinhDanh=?";
        JDBCHelper.executeUpdate(sql, id);
    }

    public List<SizeQuanPhuc> select() {
        String sql = "SELECT * FROM SizeQuanPhuc";
        return select(sql);
    }

    private List<SizeQuanPhuc> select(String sql, Object... args) {
        List<SizeQuanPhuc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SizeQuanPhuc model = readFromResultSet(rs);
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

    private SizeQuanPhuc readFromResultSet(ResultSet rs) throws SQLException {
        SizeQuanPhuc model = new SizeQuanPhuc();
        return model;
    }

}
