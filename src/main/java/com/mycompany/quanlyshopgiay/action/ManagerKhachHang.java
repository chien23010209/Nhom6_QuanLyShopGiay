package com.mycompany.quanlyshopgiayt.action;

import com.mycompany.quanlyshopgiay.entity.KhachHang;
import com.mycompany.quanlyshopgiay.entity.KhachHangXML;
import com.mycompany.quanlyshopgiay.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Quản lý thông tin khách hàng, thao tác với file "dataKhachHang.xml"
 */
public class ManagerKhachHang {
    private static final String FILE_NAME = "dataKhachHang.xml";
    private List<KhachHang> list;

    public ManagerKhachHang() {
        list = read();
        if (list == null) list = new ArrayList<>();
    }

    // Đọc danh sách khách hàng từ file XML
    public List<KhachHang> read() {
        KhachHangXML wrapper = (KhachHangXML) FileUtils.readXMLFile(FILE_NAME, KhachHangXML.class);
        return (wrapper != null) ? wrapper.getKhachHangs() : new ArrayList<>();
    }

    // Ghi danh sách khách hàng vào file XML
    public void write(List<KhachHang> list) {
        KhachHangXML wrapper = new KhachHangXML();
        wrapper.setKhachHangs(list);
        FileUtils.writeXMLtoFile(FILE_NAME, wrapper);
    }

    // Tạo mã khách hàng tự động: KH001, KH002,...
    private String generateNextID() {
        int max = 0;
        for (KhachHang kh : list) {
            String num = kh.getMaKH().replace("KH", "");
            max = Math.max(max, Integer.parseInt(num));
        }
        return String.format("KH%03d", max + 1);
    }

    // Thêm khách hàng mới
    public void add(KhachHang kh) {
        kh.setMaKH(generateNextID());
        list.add(kh);
        write(list);
    }

    // Sửa thông tin khách hàng
    public void edit(KhachHang kh) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaKH().equals(kh.getMaKH())) {
                list.set(i, kh);
                write(list);
                break;
            }
        }
    }

    // Xóa khách hàng khỏi danh sách
    public boolean delete(KhachHang kh) {
        boolean removed = list.removeIf(x -> x.getMaKH().equals(kh.getMaKH()));
        if (removed) write(list);
        return removed;
    }

    // Trả về danh sách khách hàng
    public List<KhachHang> getList() {
        return list;
    }
}
