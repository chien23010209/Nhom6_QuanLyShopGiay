/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlyshopgiay.entity;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "HoaDon")
@XmlAccessorType(XmlAccessType.FIELD)
public class HoaDon implements Serializable {
    private static final long serialVersionUID = 1L;

    private String maHoaDon;     // VD: HD001
    private String maKhachHang;  // Khách mua
    private String maGiay;       // Sản phẩm được mua
    private int soLuong;
    private double tongTien;
    private Date ngayLap;        // Ngày lập hóa đơn

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String maKH, String maGiay, int soLuong, double tongTien, Date ngayLap) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKH;
        this.maGiay = maGiay;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.ngayLap = ngayLap;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaGiay() {
        return maGiay;
    }

    public void setMaGiay(String maGiay) {
        this.maGiay = maGiay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }
}
