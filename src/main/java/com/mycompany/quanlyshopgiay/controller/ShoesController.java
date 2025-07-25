package com.mycompany.quanlyshopgiay.controller;

import com.mycompany.quanlyshopgiay.action.ManagerShoes;
import com.mycompany.quanlyshopgiay.entity.Shoes;
import com.mycompany.quanlyshopgiay.view.MainView;
import com.mycompany.quanlyshopgiay.view.ShoesView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ShoesController {
    private ShoesView view;
    private ManagerShoes model;
    private NumberFormat formatter = NumberFormat.getInstance(new Locale("vi", "VN"));

    public ShoesController(ShoesView view) {
        this.view = view;
        this.model = new ManagerShoes();
        addListeners();
        showShoesList();
        
    }
    
    private void addListeners() {
        view.addAddListener(new AddListener());
        view.addEditListener(new EditListener());
        view.addDeleteListener(new DeleteListener());
        view.addClearListener(new ClearListener());
        view.addSearchListener(new SearchListener());
        view.addCancelSearchListener(new CancelSearchListener());
        view.addSortListener(new SortListener());
        view.addListSelectionListener(new TableSelectionListener());
        view.addBackListener(new BackListener());

    }
    private void showShoesList() {
        List<Shoes> listGiay = model.getList();
        view.showShoesList(listGiay);
        view.addListSelectionListener(new TableSelectionListener()); // <- thêm dòng này
        view.showStatistic(listGiay.size(), model.getMaxPrice(), model.getMinPrice(), formatter);
    }



    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Shoes s = view.getShoeFromInput();
            if (s == null) {
                view.showMessage("Vui lòng nhập đầy đủ và đúng thông tin sản phẩm.");
                return;
            }
            s.setMaGiay(model.generateNextID()); // Gán mã giày tự động
            model.add(s);
            view.showShoesList(model.getListGiay());
            view.addListSelectionListener(new TableSelectionListener()); // thêm dòng này
            view.clearInput();
            view.showMessage("✔️ Thêm sản phẩm thành công!");
            view.showStatistic(model.getList().size(), model.getMaxPrice(), model.getMinPrice(), formatter);
        }
    }


    class EditListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Shoes s = view.getShoeFromInput();
            if (s == null) {
                view.showMessage("Vui lòng chọn sản phẩm cần sửa và nhập đầy đủ thông tin.");
                return;
            }
            model.edit(s);
           view.showShoesList(model.getListGiay());
           view.addListSelectionListener(new TableSelectionListener());
            view.clearInput();
            view.showMessage("Cập nhật sản phẩm thành công!");
        }
    }

    class DeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String id = view.getSelectedShoeID();
            if (id == null) {
                view.showMessage("Vui lòng chọn sản phẩm cần xóa.");
                return;
            }
            Shoes s = model.findByID(id);
            if (s != null && model.delete(s)) {
                view.showShoesList(model.getListGiay());
                view.addListSelectionListener(new TableSelectionListener());
                view.clearInput();
                view.showMessage("Xóa sản phẩm thành công!");
            } else {
                view.showMessage("Không thể xóa sản phẩm.");
            }
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.clearInput();
        }
    }

    class SearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String keyword = view.getSearchKeyword();
            Double min = view.getSearchMinPrice();
            Double max = view.getSearchMaxPrice();

            List<Shoes> result = model.search(keyword, min, max);
            view.showShoesList(result);
            view.showMessage("Tìm thấy " + result.size() + " sản phẩm phù hợp.");
        }
    }

    class CancelSearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.clearSearchFields();
            view.showShoesList(model.getListGiay());
            view.addListSelectionListener(new TableSelectionListener());
        }
    }

    class SortListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int option = view.getSortOption();
            List<Shoes> list = model.getListGiay();
            switch (option) {
                case 0 -> list.sort(Comparator.comparing(Shoes::getMaGiay));   // ID
                case 1 -> list.sort(Comparator.comparing(Shoes::getTenGiay));  // Tên
                case 2 -> list.sort(Comparator.comparing(Shoes::getHang));     // Hãng
                case 3 -> list.sort(Comparator.comparingDouble(Shoes::getGia)); // Giá
                case 4 -> list.sort(Comparator.comparingInt(Shoes::getSoLuongTon)); // Số lượng tồn
                case 5 -> list.sort(Comparator.comparing(Shoes::getNgayNhap)); // Ngày nhập

            }
            view.showShoesList(list);
        }
    }

    class TableSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            try {
                Shoes s = view.getSelectedShoeFromTable();
                if (s != null) view.fillForm(s);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
   
        
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.dispose(); // Đóng hẳn ShoesView

            MainView mainView = new MainView(); // Tạo MainView mới
            mainView.setVisible(true);          // Hiển thị lại MainView

            new MainController(mainView);       // Gán controller nếu cần
        }
    }

}
