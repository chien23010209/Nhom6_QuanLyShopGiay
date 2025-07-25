package com.mycompany.quanlyshopgiay.entity;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "KhachHang")

@XmlAccessorType(XmlAccessType.FIELD)
public class KhachHang implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "MaKH")
    private String maKhachHang;

    @XmlElement(name = "TenKH")
    private String tenKhachHang;

    @XmlElement(name = "SDT")
    private String soDienThoai;

    @XmlElement(name = "DiaChi")
    private String diaChi;

    @XmlElementWrapper(name = "DanhSachMuaHang")
    @XmlElement(name = "HoaDon")
    private List<HoaDon> danhSachHoaDon;

    public KhachHang() {}

    public KhachHang(String maKH, String ten, String sdt, String diaChi) {
        this.maKhachHang = maKH;
        this.tenKhachHang = ten;
        this.soDienThoai = sdt;
        this.diaChi = diaChi;
        this.danhSachHoaDon = new ArrayList<>();
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

    public List<HoaDon> getDanhSachHoaDon() {
        if (danhSachHoaDon == null) {
            danhSachHoaDon = new ArrayList<>();
        }
        return danhSachHoaDon;
    }

    public void setDanhSachHoaDon(List<HoaDon> danhSachHoaDon) {
        this.danhSachHoaDon = danhSachHoaDon;
    }

    public void themHoaDon(HoaDon hoaDon) {
        getDanhSachHoaDon().add(hoaDon);
    }

    public boolean suaHoaDon(String maHD, HoaDon hoaDonMoi) {
        for (int i = 0; i < danhSachHoaDon.size(); i++) {
            if (danhSachHoaDon.get(i).getMaHD().equals(maHD)) {
                danhSachHoaDon.set(i, hoaDonMoi);
                return true;
            }
        }
        return false;
    }

    public boolean xoaHoaDon(String maHD) {
        return danhSachHoaDon.removeIf(hd -> hd.getMaHD().equals(maHD));
    }

    public HoaDon timHoaDon(String maHD) {
        for (HoaDon hd : danhSachHoaDon) {
            if (hd.getMaHD().equals(maHD)) {
                return hd;
            }
        }
        return null;
    }

    public String getMaKH() {
        return maKhachHang;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class HoaDon implements Serializable {
        private static final long serialVersionUID = 1L;

        @XmlElement(name = "MaHD")
        private String maHD;

        @XmlElement(name = "MaGiay")
        private String maGiay;

        @XmlElement(name = "SoLuong")
        private int soLuong;
        @XmlSchemaType(name = "date")
        
        @XmlElement(name = "NgayMua")
        private Date ngayMua;


        @XmlElement(name = "TongTien")
        private String tongTien;

        public HoaDon() {}

        public HoaDon(String maHD, String maGiay, Date ngayMua, int soLuong, String tongTien) {
            this.maHD = maHD;
            this.maGiay = maGiay;
            this.ngayMua = ngayMua;
            this.soLuong = soLuong;
            this.tongTien = tongTien;
        }

        public String getMaHD() {
            return maHD;
        }

        public void setMaHD(String maHD) {
            this.maHD = maHD;
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

        public Date getNgayMua() {
            return ngayMua;
        }
        public void setNgayMua(Date ngayMua) {
            this.ngayMua = ngayMua;
        }


        public String getTongTien() {
            return tongTien;
        }

        public void setTongTien(String tongTien) {
            this.tongTien = tongTien;
        }

        public long getTongTienAsLong() {
            try {
                return Long.parseLong(tongTien.replaceAll("[^\\d]", "")); // xóa mọi ký tự không phải số
            } catch (NumberFormatException e) {
                return 0;
            }
        }


        public String getFormattedTongTien() {
            try {
                return NumberFormat.getInstance(new Locale("vi", "VN")).format(getTongTienAsLong());
            } catch (Exception e) {
                return tongTien;
            }
        }

    }
}