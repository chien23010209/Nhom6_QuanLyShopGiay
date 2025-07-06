package com.mycompany.quanlyshopgiay.entity;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "DanhSachKhachHang")
@XmlAccessorType(XmlAccessType.FIELD)
public class KhachHangXML {

    @XmlElement(name = "KhachHang")
    private List<KhachHang> danhSachKhachHang;

    public List<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }

    public void setDanhSachKhachHang(List<KhachHang> danhSachKhachHang) {
        this.danhSachKhachHang = danhSachKhachHang;
    }
}
