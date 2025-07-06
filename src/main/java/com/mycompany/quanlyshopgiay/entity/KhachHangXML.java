package com.mycompany.quanlyshopgiay.entity;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "DanhSachKhachHang")
@XmlAccessorType(XmlAccessType.FIELD)
public class KhachHangXML implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "KhachHang")
    private List<KhachHang> danhSachKhachHang;

    public List<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }

    public void setDanhSachKhachHang(List<KhachHang> danhSachKhachHang) {
        this.danhSachKhachHang = danhSachKhachHang;
    }
}
