/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class NhapQuanPhuc {

    private String maQuanPhuc, tenQuanPhuc;
    private int soLuong, maBienNhan;
    private Date ngayNhap;

    public NhapQuanPhuc() {
    }

    public NhapQuanPhuc(String maQuanPhuc, String tenQuanPhuc, int soLuong, Date ngayNhap) {
        this.maQuanPhuc = maQuanPhuc;
        this.tenQuanPhuc = tenQuanPhuc;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getMaBienNhan() {
        return maBienNhan;
    }

    public void setMaBienNhan(int maBienNhan) {
        this.maBienNhan = maBienNhan;
    }

    public String getMaQuanPhuc() {
        return maQuanPhuc;
    }

    public void setMaQuanPhuc(String maQuanPhuc) {
        this.maQuanPhuc = maQuanPhuc;
    }

    public String getTenQuanPhuc() {
        return tenQuanPhuc;
    }

    public void setTenQuanPhuc(String tenQuanPhuc) {
        this.tenQuanPhuc = tenQuanPhuc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
