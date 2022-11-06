/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Admin
 */
public class QuanPhuc {

    private int maQP, soLuong;
    private String tenQP;

    public QuanPhuc() {
    }

    public QuanPhuc(int maQP, int soLuong, String tenQP) {
        this.maQP = maQP;
        this.soLuong = soLuong;
        this.tenQP = tenQP;
    }

    public int getMaQP() {
        return maQP;
    }

    public void setMaQP(int maQP) {
        this.maQP = maQP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenQP() {
        return tenQP;
    }

    public void setTenQP(String tenQP) {
        this.tenQP = tenQP;
    }

}
