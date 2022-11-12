/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Admin
 */
public class QuanPhucDaiDoi {

    private String maDaiDoi, maQuanPhuc;
    private int soLuong;

    public QuanPhucDaiDoi() {
    }

    public QuanPhucDaiDoi(String maDaiDoi, String maQuanPhuc, int soLuong) {
        this.maDaiDoi = maDaiDoi;
        this.maQuanPhuc = maQuanPhuc;
        this.soLuong = soLuong;
    }

    public String getMaDaiDoi() {
        return maDaiDoi;
    }

    public void setMaDaiDoi(String maDaiDoi) {
        this.maDaiDoi = maDaiDoi;
    }

    public String getMaQuanPhuc() {
        return maQuanPhuc;
    }

    public void setMaQuanPhuc(String maQuanPhuc) {
        this.maQuanPhuc = maQuanPhuc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
