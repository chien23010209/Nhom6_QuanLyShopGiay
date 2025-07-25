/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlyshopgiay.controller;

import com.mycompany.quanlyshopgiay.action.ManagerKhachHang;
import com.mycompany.quanlyshopgiay.action.ManagerShoes;
import com.mycompany.quanlyshopgiay.entity.Shoes;
import com.mycompany.quanlyshopgiay.view.LoginView;
import com.mycompany.quanlyshopgiay.view.MainView;
import com.mycompany.quanlyshopgiay.view.ShoesView;
import com.mycompany.quanlyshopgiay.view.TransactionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class MainController {
    private MainView mainView;

    public MainController(MainView view) {
        this.mainView = view;

        // Gắn sự kiện
        view.addCustomerListener(new CustomerButtonListener());
        view.addShoesListener(new ShoesButtonListener());
        view.addLogoutListener(new LogoutButtonListener());
    }

    public void showMainView() {
        mainView.setVisible(true);
    }

   class CustomerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ManagerShoes managerShoes = new ManagerShoes();
            ManagerKhachHang managerKhachHang = new ManagerKhachHang();

            TransactionView view = new TransactionView(managerShoes, managerKhachHang); // gọi constructor có đủ tham số
            new KhachHangController(view); // gắn controller để xử lý logic

            view.setVisible(true);
            mainView.setVisible(false); // ẩn MainView nếu muốn
        }
    }



    class ShoesButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ShoesView view = new ShoesView();
            new ShoesController(view);
            view.setVisible(true);
            mainView.setVisible(false);
        }
    }

    class LogoutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(mainView, "Đăng xuất thành công!");
            mainView.dispose();
        }
    }
}
