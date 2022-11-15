/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.QuanPhucDaiDoi;
import Helper.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QuanPhucDaiDoiDAO {

    public void insert(QuanPhucDaiDoi model) {
        String sql = "INSERT INTO QuanPhucDaiDoi (MaDaiDoi,MaQuanPhuc,SoLuong) VALUES (?, ?, ?)";
        JDBCHelper.executeUpdate(sql,
                model.getMaDaiDoi(),
                model.getMaQuanPhuc(),
                model.getSoLuongNhap()
        );
    }

    public void update(QuanPhucDaiDoi model) {
        String sql = "UPDATE QuanPhucDaiDoi SET MaQuanPhuc  = ?,SoLuong = ?, MaDaiDoi = ? WHERE ID = ?";
        JDBCHelper.executeUpdate(sql,
                model.getMaQuanPhuc(),
                model.getSoLuongNhap(),
                model.getMaDaiDoi(),
                model.getID());
    }

    public List<QuanPhucDaiDoi> select() {
        String sql = "SELECT * FROM QuanPhucDaiDoi";
        return select(sql);
    }

    private List<QuanPhucDaiDoi> select(String sql, Object... args) {
        List<QuanPhucDaiDoi> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    QuanPhucDaiDoi model = readFromResultSet(rs);
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

    private QuanPhucDaiDoi readFromResultSet(ResultSet rs) throws SQLException {
        QuanPhucDaiDoi model = new QuanPhucDaiDoi();
        return model;
    }
}
