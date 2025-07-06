package com.mycompany.quanlyshopgiay.entity;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Lớp đại diện cho một đối tượng giày trong hệ thống quản lý giày
 * Dùng để ánh xạ với cấu trúc file XML "dataShoes.xml"
 */

@XmlRootElement(name = "Giay")
@XmlAccessorType(XmlAccessType.FIELD)
public class Giay implements Serializable {
    private static final long serialVersionUID = 1L;

    private String maGiay;        // Mã giày (ví dụ: G001)
    private String tenGiay;       // Tên sản phẩm (VD: Nike Air Force 1)
    private String hang;          // Thương hiệu (VD: Nike, Adidas,...)
    private int size;             // Size giày
    private String mauSac;        // Màu sắc giày (VD: Trắng, Đỏ/Đen,...)
    private double gia;           // Giá bán
    private Date ngayNhap;        // Ngày nhập hàng
    private int soLuongTon;       // Số lượng tồn kho
    private String hinhAnh;       // Đường dẫn hình ảnh (tương đối)

    public Giay() {
    }

    public Giay(String maGiay, String tenGiay, String hang, int size, String mauSac,
                double gia, Date ngayNhap, int soLuongTon, String hinhAnh) {
        this.maGiay = maGiay;
        this.tenGiay = tenGiay;
        this.hang = hang;
        this.size = size;
        this.mauSac = mauSac;
        this.gia = gia;
        this.ngayNhap = ngayNhap;
        this.soLuongTon = soLuongTon;
        this.hinhAnh = hinhAnh;
    }

    // Getters & Setters

    public String getMaGiay() {
        return maGiay;
    }

    public void setMaGiay(String maGiay) {
        this.maGiay = maGiay;
    }

    public String getTenGiay() {
        return tenGiay;
    }

    public void setTenGiay(String tenGiay) {
        this.tenGiay = tenGiay;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
