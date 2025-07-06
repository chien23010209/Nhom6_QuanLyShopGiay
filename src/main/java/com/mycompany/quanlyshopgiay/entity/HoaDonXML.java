/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlyshopgiay.entity;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "DanhSachHoaDon")
@XmlAccessorType(XmlAccessType.FIELD)
public class HoaDonXML {

    @XmlElement(name = "HoaDon")
    private List<HoaDon> danhSachHoaDon;

    public List<HoaDon> getDanhSachHoaDon() {
        return danhSachHoaDon;
    }

    public void setDanhSachHoaDon(List<HoaDon> danhSachHoaDon) {
        this.danhSachHoaDon = danhSachHoaDon;
    }
}
