package com.mycompany.quanlyshopgiay.action;

import com.mycompany.quanlyshopgiay.entity.Shoes;
import com.mycompany.quanlyshopgiay.entity.ShoesXML;
import com.mycompany.quanlyshopgiay.utils.FileUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerShoes {
    private static final String FILE_NAME = "dataShoes.xml";
    private List<Shoes> listGiay;

    public ManagerShoes() {
        listGiay = readListGiay();
        if (listGiay == null) {
            listGiay = new ArrayList<>();
        }
    }

    public List<Shoes> getList() {
        return listGiay;
    }

    private List<Shoes> readListGiay() {
        ShoesXML wrapper = (ShoesXML) FileUtils.readXMLFile(FILE_NAME, ShoesXML.class);
        return (wrapper != null && wrapper.getDanhSachGiay() != null)
                ? wrapper.getDanhSachGiay()
                : new ArrayList<>();
    }

    public void writeListGiay(List<Shoes> list) {
        ShoesXML wrapper = new ShoesXML();
        wrapper.setDanhSachGiay(list);
        FileUtils.writeXMLtoFile(FILE_NAME, wrapper);
    }

    public String generateNextID() {
        int index = 1;
        while (true) {
            String candidate = String.format("G%03d", index);
            boolean exists = listGiay.stream().anyMatch(g -> g.getMaGiay().equals(candidate));
            if (!exists) return candidate;  // Nếu chưa tồn tại thì dùng
            index++;
        }
    }


    public void add(Shoes g) {
        if (isDuplicateID(g.getMaGiay())) {
            throw new IllegalArgumentException("❌ Mã giày đã tồn tại: " + g.getMaGiay());
        }
        listGiay.add(g);
        writeListGiay(listGiay);
    }


    public void edit(Shoes updated) {
        for (int i = 0; i < listGiay.size(); i++) {
            if (listGiay.get(i).getMaGiay().equals(updated.getMaGiay())) {
                listGiay.set(i, updated);
                writeListGiay(listGiay);
                break;
            }
        }
    }

    public boolean delete(Shoes g) {
        boolean removed = listGiay.removeIf(item -> item.getMaGiay().equals(g.getMaGiay()));
        if (removed) {
            writeListGiay(listGiay);
        }
        return removed;
    }

    public List<Shoes> getListGiay() {
        return listGiay;
    }

    public Shoes findByID(String maGiay) {
        for (Shoes g : listGiay) {
            if (g.getMaGiay().equals(maGiay)) {
                return g;
            }
        }
        return null;
    }

    public boolean isDuplicateID(String maGiay) {
        return listGiay.stream().anyMatch(g -> g.getMaGiay().equalsIgnoreCase(maGiay));
    }

    public String getNextID() {
        return generateNextID();
    }

    public void update(Shoes g) {
        edit(g);
    }

    public void delete(String id) {
        listGiay.removeIf(g -> g.getMaGiay().equals(id));
        writeListGiay(listGiay);
    }

    public List<Shoes> search(String keyword, Double minPrice, Double maxPrice) {
        String lowerKeyword = (keyword != null) ? keyword.toLowerCase() : "";

        return listGiay.stream()
            .filter(g -> 
                (lowerKeyword.isEmpty()
                    || g.getTenGiay().toLowerCase().contains(lowerKeyword)
                    || g.getHang().toLowerCase().contains(lowerKeyword)
                    || g.getMauSac().toLowerCase().contains(lowerKeyword)
                    || g.getMaGiay().toLowerCase().contains(lowerKeyword)
                )
            )
            .filter(g -> minPrice == null || g.getGia() >= minPrice)
            .filter(g -> maxPrice == null || g.getGia() <= maxPrice)
            .collect(Collectors.toList());
    }


    public void sortByPriceDescending() {
        listGiay.sort((g1, g2) -> Double.compare(g2.getGia(), g1.getGia()));
        writeListGiay(listGiay);
    }

    public double getMaxPrice() {
        return listGiay.stream().mapToDouble(Shoes::getGia).max().orElse(0);
    }

    public double getMinPrice() {
        return listGiay.stream().mapToDouble(Shoes::getGia).min().orElse(0);
    }
}
