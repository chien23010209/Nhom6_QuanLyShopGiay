/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlyshopgiay.entity;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "KhachHang")
@XmlAccessorType(XmlAccessType.FIELD)
public class KhachHang implements Serializable {
    private static final long serialVersionUID = 1L;

    private String maKhachHang;   // VD: KH001
    private String tenKhachHang;
    private String soDienThoai;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(String maKH, String ten, String sdt, String diaChi) {
        this.maKhachHang = maKH;
        this.tenKhachHang = ten;
        this.soDienThoai = sdt;
        this.diaChi = diaChi;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
