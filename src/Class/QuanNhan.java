/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import JavaClass.StatusType;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class QuanNhan {

    private String maQN;
    private String hoTen, capBac, donVi,hinhAnh;
    private Date ngaySinh, nhapNgu;
    private boolean gioiTinh;

    public QuanNhan() {
    }

    public QuanNhan(String maQN, String hoTen, String capBac, String donVi, String hinhAnh, Date ngaySinh, Date nhapNgu, boolean gioiTinh) {
        this.maQN = maQN;
        this.hoTen = hoTen;
        this.capBac = capBac;
        this.donVi = donVi;
        this.hinhAnh = hinhAnh;
        this.ngaySinh = ngaySinh;
        this.nhapNgu = nhapNgu;
        this.gioiTinh = gioiTinh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }


    public String getMaQN() {
        return maQN;
    }

    public void setMaQN(String maQN) {
        this.maQN = maQN;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCapBac() {
        return capBac;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNhapNgu() {
        return nhapNgu;
    }

    public void setNhapNgu(Date nhapNgu) {
        this.nhapNgu = nhapNgu;
    }

}
