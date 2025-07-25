package com.mycompany.quanlyshopgiay.controller;

import com.mycompany.quanlyshopgiay.action.ManagerKhachHang;
import com.mycompany.quanlyshopgiay.entity.KhachHang;
import com.mycompany.quanlyshopgiay.entity.KhachHang.HoaDon;
import com.mycompany.quanlyshopgiay.view.MainView;
import com.mycompany.quanlyshopgiay.view.TransactionView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.*;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

public class KhachHangController {

    static void showManagerView() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private TransactionView view;
    private ManagerKhachHang manager;
    private NumberFormat currencyFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
    private boolean suppressSelectionEvent = false;


    public KhachHangController(TransactionView view) {
        this.view = view;
        this.manager = new ManagerKhachHang();

        addListeners();
        showCustomerList();
        
        String maHD = manager.generateNextInvoiceID();
        view.setInvoiceID(maHD);
        
        String maKH = manager.generateNextCustomerID();
        view.setCustomerID(maKH);

        
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

    private void showCustomerList() {
        List<KhachHang> list = manager.getList();
        view.showCustomerList(list);
        view.showStatistics(list);
    }

    private String formatCurrency(long amount) {
        return currencyFormat.format(amount);
    }
    
    public String generateNextInvoiceID() {
        int max = 0;
        List<KhachHang> listKhachHang = manager.getList(); // 🔧 LẤY DANH SÁCH ĐÚNG
        for (KhachHang kh : listKhachHang) {
            for (KhachHang.HoaDon hd : kh.getDanhSachHoaDon()) {
                try {
                    String so = hd.getMaHD().replaceAll("[^0-9]", "");
                    int num = Integer.parseInt(so);
                    if (num > max) max = num;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return String.format("HD%03d", max + 1);  // VD: HD006
    }
    public String generateNextCustomerID() {
        int max = 0;
        for (KhachHang kh : manager.getList()) {
            try {
                String so = kh.getMaKhachHang().replaceAll("[^0-9]", "");
                int num = Integer.parseInt(so);
                if (num > max) max = num;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return String.format("KH%03d", max + 1); // VD: KH007
    }





    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // 1. Lấy thông tin khách hàng (bao gồm cả hóa đơn đầu tiên)
            KhachHang kh = view.getCustomerInfoFromInput();
            HoaDon hd = view.getInvoiceInfoFromInput();

            if (kh == null || hd == null) {
                view.showMessage("⚠️ Vui lòng điền đầy đủ thông tin khách hàng và hóa đơn!");
                return;
            }

            if (!kh.getSoDienThoai().matches("\\d{10,11}")) {
                view.showMessage("⚠️ Số điện thoại phải gồm 10-11 chữ số!");
                return;
            }

            // Kiểm tra KH đã tồn tại chưa
            KhachHang khCu = manager.findByID(kh.getMaKhachHang());

            if (khCu == null) {
                // Mới → thêm KH và hóa đơn đầu tiên
                kh.setDanhSachHoaDon(new ArrayList<>());
                kh.themHoaDon(hd);
                manager.addCustomer(kh);
                System.out.println("✅ Đã thêm KH mới: " + kh.getMaKhachHang());
                view.showMessage("✅ Đã thêm khách hàng và hóa đơn!");
            } else {
                // Đã tồn tại → chỉ thêm hóa đơn mới
                boolean ok = manager.addInvoiceToCustomer(khCu.getMaKhachHang(), hd);
                if (ok) {
                    System.out.println("✅ Đã thêm HĐ cho KH: " + khCu.getMaKhachHang());
                    view.showMessage("✅ Đã thêm hóa đơn cho khách hàng hiện có!");
                } else {
                    view.showMessage("⚠️ Không thể thêm hóa đơn!");
                }
            }

            // Làm mới giao diện và reload danh sách
            view.clearCustomerForm();
            showCustomerList();
            
            String newMaHD = manager.generateNextInvoiceID(); // 🔧 THÊM DÒNG NÀY
            view.setInvoiceID(newMaHD);                       // 🔧 GÁN MÃ MỚI
            String newMaKH = manager.generateNextCustomerID();
            view.setCustomerID(newMaKH);
            
//            view.addListSelectionListener(new TableSelectionListener());

            


        }
    }


    public class EditListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            KhachHang khForm = view.getCustomerInfoFromInput();     // Dữ liệu mới từ form
            HoaDon hdForm = view.getInvoiceInfoFromInput();         // Hóa đơn mới
            KhachHang khBang = view.getSelectedCustomerFromTable(); // KH đang chọn từ bảng

            if (khForm == null || hdForm == null || khBang == null) {
                view.showMessage("⚠️ Vui lòng chọn dòng giao dịch để sửa!");
                return;
            }

            // ✅ Gán lại đúng mã KH và mã HĐ để không bị thay đổi mã
            khForm.setMaKhachHang(khBang.getMaKhachHang());
            hdForm.setMaHD(khBang.getDanhSachHoaDon().get(0).getMaHD());

            // ✅ Gán lại danh sách hóa đơn mới vào KH mới
            List<HoaDon> hoaDons = new ArrayList<>();
            hoaDons.add(hdForm);
            khForm.setDanhSachHoaDon(hoaDons);

            // ✅ Ghi đè KH mới vào danh sách (update đúng vị trí)
            manager.updateCustomer(khForm);         // Thay thế trong list
            manager.reload();       // Ghi ra XML ngay sau đó ✅

            // ✅ Làm mới bảng + xóa form + xóa dòng chọn
            suppressSelectionEvent = true;
            view.clearCustomerForm();
            view.showCustomerList(manager.getList());
            view.getCustomerTable().clearSelection();
            suppressSelectionEvent = false;

            view.showMessage("✔️ Đã sửa thông tin khách hàng và hóa đơn thành công!");
        }
    }





    class DeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            KhachHang kh = view.getSelectedCustomerFromTable();
            HoaDon hd = view.getInvoiceInfoFromInput();

            if (kh == null || hd == null) {
                view.showMessage("⚠️ Vui lòng chọn dòng giao dịch để xóa!");
                return;
            }

            KhachHang khCu = manager.findByID(kh.getMaKhachHang());
            if (khCu == null) {
                view.showMessage("❌ Không tìm thấy khách hàng tương ứng để xóa hóa đơn.");
                return;
            }

            // Tìm và xóa hóa đơn trong danh sách của khách hàng
            boolean removed = khCu.getDanhSachHoaDon().removeIf(h -> h.getMaHD().equals(hd.getMaHD()));

            if (removed) {
                // Nếu KH không còn hóa đơn → xóa luôn khách hàng
                if (khCu.getDanhSachHoaDon().isEmpty()) {
                    manager.deleteCustomer(khCu);
                }
                manager.write(manager.getList());
                view.showMessage("🗑️ Đã xóa hóa đơn thành công!");
                
                suppressSelectionEvent = true;
                view.clearCustomerForm();
                showCustomerList();
                suppressSelectionEvent = false;
            } else {
                view.showMessage("⚠️ Không tìm thấy hóa đơn để xóa.");
            }
        }
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.dispose(); // đóng TransactionView

            MainView main = new MainView();
            new MainController(main); // Gắn lại controller cho MainView
            main.setVisible(true); // mở lại MainView
        }
    }




    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.clearCustomerForm();  // xoá hết

            String maHD = manager.generateNextInvoiceID();
            String maKH = manager.generateNextCustomerID();

            view.setInvoiceID(maHD);   // Gán cho txtMaHD
            view.setCustomerID(maKH);  // Gán cho txtMaKH ✅
            }
    }


    class SearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            manager.reload();  
            String keyword = view.getSearchKeyword().trim().toLowerCase();
            String minStr = view.getMinAmount().trim();
            String maxStr = view.getMaxAmount().trim();

            List<KhachHang> result = new ArrayList<>(manager.getList());

            // Lọc theo tên / SĐT gần đúng
            if (!keyword.isEmpty()) {
                result = result.stream()
                        .filter(kh -> kh.getTenKhachHang().toLowerCase().contains(keyword)
                                || kh.getSoDienThoai().contains(keyword))
                        .collect(Collectors.toList());
            }

            // Lọc theo khoảng số tiền
            if (!minStr.isEmpty() && !maxStr.isEmpty()) {
                try {
                    long min = Long.parseLong(minStr.replaceAll("[.,]", ""));
                    long max = Long.parseLong(maxStr.replaceAll("[.,]", ""));

                    result = result.stream()
                            .filter(kh -> kh.getDanhSachHoaDon().stream()
                                    .anyMatch(hd -> {
                                        try {
                                            long tong = Long.parseLong(hd.getTongTien().replaceAll("[.,]", ""));
                                            return tong >= min && tong <= max;
                                        } catch (NumberFormatException ex) {
                                            return false;
                                        }
                                    }))
                            .collect(Collectors.toList());
                } catch (NumberFormatException ex) {
                    view.showMessage("⚠️ Vui lòng nhập đúng khoảng số tiền hợp lệ!");
                    return;
                }
            }

            view.showCustomerList(result);
            if (result.isEmpty()) {
                view.showMessage("❗Không tìm thấy kết quả phù hợp.");
            }
        }
    }

    class CancelSearchListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            manager.reload();  
            showCustomerList();
            view.clearSearchFields();
        }
    }

    class SortListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            manager.reload();  
            int option = view.getSortOption();
            List<KhachHang> list = new ArrayList<>(manager.getList());

            switch (option) {
                case 1 -> list.sort(Comparator.comparing(KhachHang::getTenKhachHang));
                case 2 -> list.sort(Comparator.comparing(KhachHang::getSoDienThoai));
                case 3 -> list.sort(Comparator.comparingLong(kh ->
                        kh.getDanhSachHoaDon().stream()
                                .mapToLong(hd -> {
                                    try {
                                        return Long.parseLong(hd.getTongTien().replaceAll("[.,]", ""));
                                     } catch (NumberFormatException ex) {
                                        return 0;
                                    }
                                }).sum()));
                default -> {
                    view.showMessage("⚠️ Vui lòng chọn tiêu chí sắp xếp!");
                    return;
                }
            }

            view.showCustomerList(list);
        }
    }

    class TableSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            manager.reload();  
            if (e.getValueIsAdjusting() || suppressSelectionEvent) return;


            KhachHang kh = view.getSelectedCustomerFromTable();
            if (kh != null) {
                view.setCustomerInfoToForm(kh);

                // Hiển thị danh sách hóa đơn đã định dạng tiền
                kh.getDanhSachHoaDon().forEach(hd -> {
                    try {
                        long tien = Long.parseLong(hd.getTongTien().replaceAll("[.,]", ""));
                        hd.setTongTien(formatCurrency(tien));
                    } catch (NumberFormatException ignored) {}
                });
            }
        }
    }

}
