/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlyshopgiay.controller;

import com.mycompany.quanlyshopgiayt.action.ManagerSpecialPerson;
import com.mycompany.quanlyshopgiay.entity.SpecialPerson;
import com.mycompany.quanlyshopgiay.view.LoginView;
import com.mycompany.quanlyshopgiay.view.MainView;
import com.mycompany.quanlyshopgiay.view.ManagerView;
import com.mycompany.quanlyshopgiay.view.ResidentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author PC
 */
public class MainController 
{
    private LoginView loginView;
    private ManagerView managerView;
    private ResidentView residentView;
    private MainView mainView;
    
    public MainController(MainView view)
    {
        this.mainView = view;
        view.addChooseSpecialPersonListener(new ChooseSpecialPersonListener());
        view.addChooseResidentsListener(new ChooseResidentListener());
    }
    public void showMainView() 
    {
        mainView.setVisible(true);
    }
    class ChooseSpecialPersonListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            managerView = new ManagerView();
            SpecialPersonController managerController = new SpecialPersonController(managerView);
            managerController.showManagerView();
            mainView.setVisible(false);
        }
    }
    
    class ChooseResidentListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            residentView = new ResidentView();
            ResidentController residentController = new ResidentController(residentView);
            residentController.showManagerView();
            mainView.setVisible(false);
        }
    }
}
