/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quanlyshopgiay.QuanLyShopGiay;

import com.mycompany.quanlyshopgiay.controller.LoginController;
import com.mycompany.quanlyshopgiay.view.LoginView;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class QuanLyShopGiay 
{
    public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
        LoginView loginView = new LoginView();
        LoginController controller = new LoginController(loginView);
        controller.showLoginView();
    });
    }
}

