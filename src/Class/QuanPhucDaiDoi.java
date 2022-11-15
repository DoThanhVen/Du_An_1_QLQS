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
    private int soLuongNhap, soLuongPhat, soLuongCon, ID;

    public QuanPhucDaiDoi() {
    }

    public QuanPhucDaiDoi(String maDaiDoi, String maQuanPhuc, int soLuongNhap, int soLuongPhat, int soLuongCon) {
        this.maDaiDoi = maDaiDoi;
        this.maQuanPhuc = maQuanPhuc;
        this.soLuongNhap = soLuongNhap;
        this.soLuongPhat = soLuongPhat;
        this.soLuongCon = soLuongCon;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public int getSoLuongPhat() {
        return soLuongPhat;
    }

    public void setSoLuongPhat(int soLuongPhat) {
        this.soLuongPhat = soLuongPhat;
    }

    public int getSoLuongCon() {
        return soLuongCon;
    }

    public void setSoLuongCon(int soLuongCon) {
        this.soLuongCon = soLuongCon;
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

}
