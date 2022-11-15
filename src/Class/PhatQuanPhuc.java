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
public class PhatQuanPhuc {

    private String maQuanNhan, maQuanPhuc, hoTen, tenQuanPhuc, tenDaiDoi;
    private int maBienNhan;
    private Date ngayNhan, ngayCapTiep;

    public PhatQuanPhuc() {
    }

    public PhatQuanPhuc(String maQuanNhan, String maQuanPhuc, String hoTen, String tenQuanPhuc, String tenDaiDoi, int maBienNhan, Date ngayNhan, Date ngayCapTiep) {
        this.maQuanNhan = maQuanNhan;
        this.maQuanPhuc = maQuanPhuc;
        this.hoTen = hoTen;
        this.tenQuanPhuc = tenQuanPhuc;
        this.tenDaiDoi = tenDaiDoi;
        this.maBienNhan = maBienNhan;
        this.ngayNhan = ngayNhan;
        this.ngayCapTiep = ngayCapTiep;
    }

    public String getTenDaiDoi() {
        return tenDaiDoi;
    }

    public void setTenDaiDoi(String tenDaiDoi) {
        this.tenDaiDoi = tenDaiDoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenQuanPhuc() {
        return tenQuanPhuc;
    }

    public void setTenQuanPhuc(String tenQuanPhuc) {
        this.tenQuanPhuc = tenQuanPhuc;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public Date getNgayCapTiep() {
        return ngayCapTiep;
    }

    public void setNgayCapTiep(Date ngayCapTiep) {
        this.ngayCapTiep = ngayCapTiep;
    }

    public int getMaBienNhan() {
        return maBienNhan;
    }

    public void setMaBienNhan(int maBienNhan) {
        this.maBienNhan = maBienNhan;
    }

    public String getMaQuanNhan() {
        return maQuanNhan;
    }

    public void setMaQuanNhan(String maQuanNhan) {
        this.maQuanNhan = maQuanNhan;
    }

    public String getMaQuanPhuc() {
        return maQuanPhuc;
    }

    public void setMaQuanPhuc(String maQuanPhuc) {
        this.maQuanPhuc = maQuanPhuc;
    }

}
