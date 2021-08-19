/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Karyawan;
import Model.Database;
import Model.Application;
import View.*;
import View.MenuRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Daffa Regenta
 */
public class ControllerRegister implements ActionListener {
    Application model;
    MenuRegister viewRegister;
    Database db;
    Karyawan Cust;
    ControllerLogin CL;

    public ControllerRegister(Application model) {
        db = new Database();
        this.model = model;
        viewRegister = new MenuRegister();
        viewRegister.addActionListener(this);
        viewRegister.setVisible(true);
    }

 
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean cek;
        Object source = ae.getSource();
        if (source.equals(viewRegister.getBtnRegister())){
            String name = viewRegister.getTfNameCostumer();
            String phoneNumber = viewRegister.getTfPhoneNumber();
            String address = viewRegister.getTfAddress();
            String Username = viewRegister.getTfUsername();
            String Password = viewRegister.getTfPassword();
            
        if (name.isEmpty() || phoneNumber.isEmpty() || address.isEmpty() || Username.isEmpty() || Password.isEmpty()){
           viewRegister.showMessage("Data Kosong", "Error", 0);
            }else{
                //db.createCustomer(new Karyawan(name,phoneNumber,address,Username,Password));
               // viewRegister.showMessage("Data Berhasil Ditambah", "Success", 1);
               model.RegisterCostumer(name, phoneNumber,address,Username,Password); 
                }
        }
         if (source.equals(viewRegister.getBtnBack())) {
            viewRegister.dispose();
            Application l = new Application();
            CL = new ControllerLogin(l);
            CL.actionPerformed(ae);
            
        }
    }  
}
