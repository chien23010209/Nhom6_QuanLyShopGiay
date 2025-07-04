/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlyshopgiayt.action;

import com.mycompany.quanlyshopgiay.entity.HoaDon;
import com.mycompany.quanlyshopgiay.entity.HoaDonXML;
import com.mycompany.quanlyshopgiay.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp quản lý hóa đơn, thao tác với file "dataHoaDon.xml"
 */
public class ManagerHoaDon {
    private static final String FILE_NAME = "dataHoaDon.xml";
    private List<HoaDon> list;

    public ManagerHoaDon() {
        list = read();
        if (list == null) list = new ArrayList<>();
    }

    // Đọc danh sách hóa đơn từ XML
    public List<HoaDon> read() {
        HoaDonXML wrapper = (HoaDonXML) FileUtils.readXMLFile(FILE_NAME, HoaDonXML.class);
        return (wrapper != null) ? wrapper.getHoaDons() : new ArrayList<>();
    }

    // Ghi danh sách hóa đơn vào XML
    public void write(List<HoaDon> list) {
        HoaDonXML wrapper = new HoaDonXML();
        wrapper.setHoaDons(list);
        FileUtils.writeXMLtoFile(FILE_NAME, wrapper);
    }

    // Sinh mã hóa đơn tự động: HD001, HD002,...
    private String generateNextID() {
        int max = 0;
        for (HoaDon hd : list) {
            String num = hd.getMaHD().replace("HD", "");
            max = Math.max(max, Integer.parseInt(num));
        }
        return String.format("HD%03d", max + 1);
    }

    // Thêm hóa đơn mới
    public void add(HoaDon hd) {
        hd.setMaHD(generateNextID());
        list.add(hd);
        write(list);
    }

    // Sửa hóa đơn theo mã
    public void edit(HoaDon hd) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaHD().equals(hd.getMaHD())) {
                list.set(i, hd);
                write(list);
                break;
            }
        }
    }

    // Xóa hóa đơn
    public boolean delete(HoaDon hd) {
        boolean removed = list.removeIf(x -> x.getMaHD().equals(hd.getMaHD()));
        if (removed) write(list);
        return removed;
    }

    // Trả về danh sách hóa đơn
    public List<HoaDon> getList() {
        return list;
    }
}

