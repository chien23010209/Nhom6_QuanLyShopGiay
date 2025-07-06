package com.mycompany.quanlyshopgiayt.action;

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

    public ManagerGiay() {
        listGiay = readListGiay();
        if (listGiay == null) listGiay = new ArrayList<>();
    }

    // Đọc danh sách giày từ file XML
    public List<Giay> readListGiay() {
        GiayXML wrapper = (GiayXML) FileUtils.readXMLFile(FILE_NAME, GiayXML.class);
        return (wrapper != null) ? wrapper.getGiayList() : new ArrayList<>();
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
            String number = g.getMaGiay().replace("G", "");
            max = Math.max(max, Integer.parseInt(number));
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
        if (removed) writeListGiay(listGiay);
        return removed;
    }

    // Lấy toàn bộ danh sách giày
    public List<Giay> getListGiay() {
        return listGiay;
    }
}
