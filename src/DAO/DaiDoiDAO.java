/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Class.DaiDoi;
import Helper.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DaiDoiDAO {

    public void insert(DaiDoi model) {
        String sql = "INSERT INTO DaiDoi (MaDaiDoi,TenDaiDoi) VALUES (?, ?)";
        JDBCHelper.executeUpdate(sql,
                model.getMaDaiDoi(),
                model.getTenDaiDoi());
    }

    public void update(DaiDoi model) {
        String sql = "UPDATE DaiDoi SET TenDaiDoi  = ? WHERE MaDaiDoi = ?";
        JDBCHelper.executeUpdate(sql,
                model.getTenDaiDoi(),
                model.getMaDaiDoi());
    }

    public void delete(String id) {
        String sql = "DELETE FROM DaiDoi WHERE MaDaiDoi = ?";
        JDBCHelper.executeUpdate(sql, id);
    }

    public List<DaiDoi> select() {
        String sql = "SELECT * FROM DaiDoi";
        return select(sql);
    }

    private List<DaiDoi> select(String sql, Object... args) {
        List<DaiDoi> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JDBCHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DaiDoi model = readFromResultSet(rs);
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

    private DaiDoi readFromResultSet(ResultSet rs) throws SQLException {
        DaiDoi model = new DaiDoi();
        return model;
    }
}
