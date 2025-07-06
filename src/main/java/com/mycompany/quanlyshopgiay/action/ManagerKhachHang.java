package com.mycompany.quanlyshopgiay.action;

import com.mycompany.quanlyshopgiay.entity.KhachHang;
import com.mycompany.quanlyshopgiay.entity.KhachHangXML;
import com.mycompany.quanlyshopgiay.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Quản lý khách hàng và hóa đơn của họ, thao tác với file "dataKhachHang.xml"
 */
public class ManagerKhachHang {
    private static final String FILE_NAME = "dataKhachHang.xml";
    private List<KhachHang> list;

    public ManagerKhachHang() {
        list = read();
        if (list == null) list = new ArrayList<>();
    }

    // Đọc toàn bộ dữ liệu khách hàng và hóa đơn từ file XML
    public List<KhachHang> read() {
        KhachHangXML wrapper = (KhachHangXML) FileUtils.readXMLFile(FILE_NAME, KhachHangXML.class);
        return (wrapper != null) ? wrapper.getDanhSachKhachHang() : new ArrayList<>();
    }

    // Ghi danh sách khách hàng (kèm hóa đơn) vào file XML
    public void write(List<KhachHang> list) {
        KhachHangXML wrapper = new KhachHangXML();
        wrapper.setDanhSachKhachHang(list);
        FileUtils.writeXMLtoFile(FILE_NAME, wrapper);
    }

    // Tạo mã khách hàng tự động: KH001, KH002,...
    private String generateNextCustomerID() {
        int max = 0;
        for (KhachHang kh : list) {
            try {
                String num = kh.getMaKhachHang().replace("KH", "");
                max = Math.max(max, Integer.parseInt(num));
            } catch (Exception e) {
                // Bỏ qua lỗi định dạng
            }
        }
        return String.format("KH%03d", max + 1);
    }

    // Tạo mã hóa đơn mới duy nhất: HD001, HD002,...
    private String generateNextInvoiceID() {
        int max = 0;
        for (KhachHang kh : list) {
            if (kh.getDanhSachHoaDon() != null) {
                for (KhachHang.HoaDon hd : kh.getDanhSachHoaDon()) {
                    try {
                        String num = hd.getMaHD().replace("HD", "");
                        max = Math.max(max, Integer.parseInt(num));
                    } catch (Exception e) {
                        // Bỏ qua lỗi định dạng
                    }
                }
            }
        }
        return String.format("HD%03d", max + 1);
    }

    // Thêm khách hàng mới
    public void addCustomer(KhachHang kh) {
        kh.setMaKhachHang(generateNextCustomerID());
        if (kh.getDanhSachHoaDon() == null) {
            kh.setDanhSachHoaDon(new ArrayList<>());
        }
        list.add(kh);
        write(list);
    }

    // Sửa thông tin khách hàng
    public void editCustomer(KhachHang kh) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaKhachHang().equals(kh.getMaKhachHang())) {
                list.set(i, kh);
                write(list);
                break;
            }
        }
    }

    // Xóa khách hàng khỏi danh sách
    public boolean deleteCustomer(KhachHang kh) {
        boolean removed = list.removeIf(x -> x.getMaKhachHang().equals(kh.getMaKhachHang()));
        if (removed) write(list);
        return removed;
    }

    // Thêm hóa đơn cho 1 khách hàng theo mã KH
    public boolean addInvoiceToCustomer(String maKH, KhachHang.HoaDon hoaDon) {
        for (KhachHang kh : list) {
            if (kh.getMaKhachHang().equals(maKH)) {
                if (kh.getDanhSachHoaDon() == null) {
                    kh.setDanhSachHoaDon(new ArrayList<>());
                }
                hoaDon.setMaHD(generateNextInvoiceID());
                kh.getDanhSachHoaDon().add(hoaDon);
                write(list);
                return true;
            }
        }
        return false;
    }

    // Sửa hóa đơn trong khách hàng
    public boolean editInvoice(KhachHang.HoaDon updatedHoaDon) {
        for (KhachHang kh : list) {
            List<KhachHang.HoaDon> hoaDons = kh.getDanhSachHoaDon();
            if (hoaDons != null) {
                for (int i = 0; i < hoaDons.size(); i++) {
                    if (hoaDons.get(i).getMaHD().equals(updatedHoaDon.getMaHD())) {
                        hoaDons.set(i, updatedHoaDon);
                        write(list);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Xóa hóa đơn khỏi 1 khách hàng
    public boolean deleteInvoice(String maHD) {
        for (KhachHang kh : list) {
            List<KhachHang.HoaDon> hoaDons = kh.getDanhSachHoaDon();
            if (hoaDons != null) {
                boolean removed = hoaDons.removeIf(hd -> hd.getMaHD().equals(maHD));
                if (removed) {
                    write(list);
                    return true;
                }
            }
        }
        return false;
    }

    // Trả về danh sách toàn bộ khách hàng (có hóa đơn bên trong)
    public List<KhachHang> getList() {
        return list;
    }

    // Tìm khách hàng theo mã
    public KhachHang findByID(String maKH) {
        for (KhachHang kh : list) {
            if (kh.getMaKhachHang().equalsIgnoreCase(maKH)) {
                return kh;
            }
        }
        return null;
    }
}
