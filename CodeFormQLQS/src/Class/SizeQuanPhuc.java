/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author Admin
 */
public class SizeQuanPhuc {

    private String sizeQuanPhuc, maDinhDanh;
    private Float sizeGiay, sizeMu;

    public SizeQuanPhuc() {
    }

    public SizeQuanPhuc(String sizeQuanPhuc, String maDinhDanh, Float sizeGiay, Float sizeMu) {
        this.sizeQuanPhuc = sizeQuanPhuc;
        this.maDinhDanh = maDinhDanh;
        this.sizeGiay = sizeGiay;
        this.sizeMu = sizeMu;
    }

    public String getMaDinhDanh() {
        return maDinhDanh;
    }

    public void setMaDinhDanh(String maDinhDanh) {
        this.maDinhDanh = maDinhDanh;
    }

    public String getSizeQuanPhuc() {
        return sizeQuanPhuc;
    }

    public void setSizeQuanPhuc(String sizeQuanPhuc) {
        this.sizeQuanPhuc = sizeQuanPhuc;
    }

    public Float getSizeGiay() {
        return sizeGiay;
    }

    public void setSizeGiay(Float sizeGiay) {
        this.sizeGiay = sizeGiay;
    }

    public Float getSizeMu() {
        return sizeMu;
    }

    public void setSizeMu(Float sizeMu) {
        this.sizeMu = sizeMu;
    }

}
