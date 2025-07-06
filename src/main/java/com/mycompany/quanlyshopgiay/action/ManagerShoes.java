package com.mycompany.quanlyshopgiay.action;

import com.mycompany.quanlyshopgiay.entity.Giay;
import com.mycompany.quanlyshopgiay.entity.GiayXML;
import com.mycompany.quanlyshopgiay.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp quản lý giày, thao tác với file XML "dataShoes.xml"
 */
public class ManagerShoes {
    private static final String FILE_NAME = "dataShoes.xml";
    private List<Giay> listGiay;

    public ManagerShoes() {
        listGiay = (List<Giay>) readListGiay();
        if (listGiay == null) {
            listGiay = new ArrayList<>();
        }
    }

    // Đọc danh sách giày từ file XML
    public Object readListGiay() {
        GiayXML wrapper = (GiayXML) FileUtils.readXMLFile(FILE_NAME, GiayXML.class);
        return (wrapper != null && wrapper.getGiayList() != null) ? wrapper.getGiayList() : new ArrayList<>();
    }

    // Ghi danh sách giày vào file XML
    public void writeListGiay(List<Giay> list) {
        GiayXML wrapper = new GiayXML();
        wrapper.setGiayList(list);
        FileUtils.writeXMLtoFile(FILE_NAME, wrapper);
    }

    // Sinh mã giày tự động theo định dạng G001, G002,...
    private String generateNextID() {
        int max = 0;
        for (Giay g : listGiay) {
            try {
                String number = g.getMaGiay().replaceAll("[^0-9]", "");
                max = Math.max(max, Integer.parseInt(number));
            } catch (NumberFormatException e) {
                // Bỏ qua nếu mã giày sai định dạng
            }
        }
        return String.format("G%03d", max + 1);
    }

    // Thêm giày mới vào danh sách
    public void add(Giay g) {
        g.setMaGiay(generateNextID());
        listGiay.add(g);
        writeListGiay(listGiay);
    }

    // Sửa thông tin giày theo mã
    public void edit(Giay updated) {
        for (int i = 0; i < listGiay.size(); i++) {
            if (listGiay.get(i).getMaGiay().equals(updated.getMaGiay())) {
                listGiay.set(i, updated);
                writeListGiay(listGiay);
                break;
            }
        }
    }

    // Xóa giày khỏi danh sách
    public boolean delete(Giay g) {
        boolean removed = listGiay.removeIf(item -> item.getMaGiay().equals(g.getMaGiay()));
        if (removed) {
            writeListGiay(listGiay);
        }
        return removed;
    }

    // Lấy toàn bộ danh sách giày
    public List<Giay> getListGiay() {
        return listGiay;
    }

    // Tìm giày theo mã
    public Giay findByID(String maGiay) {
        for (Giay g : listGiay) {
            if (g.getMaGiay().equals(maGiay)) {
                return g;
            }
        }
        return null;
    }
}
