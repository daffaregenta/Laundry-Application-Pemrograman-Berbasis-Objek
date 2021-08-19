/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Application;
import View.MenuLogin;
import View.MenuKaryawan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Daffa Regenta
 */
public class ControllerLogin implements ActionListener {

    private MenuLogin view;
    Application model;
    ControllerMenuAdmin CMA;
    ControllerRegister CC;
    ControllerMenuKaryawan CMU;
    
    public ControllerLogin(Application model) {
        this.model = model;
        //db = new Database();
        view = new MenuLogin();

        view.addActionListener(this);
        view.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        boolean cek;
        Object source = e.getSource();
        if (source.equals(view.getBtnAdminLogin())) {
            String username = view.getTfLgUname();
            String password = view.getTfPwLogin();
            cek = model.loginAdmin(username, password);
            if (cek == true) {
                view.dispose();
                Application a = new Application();
               CMA = new ControllerMenuAdmin(a);
                CMA.actionPerformed(e);
                System.out.println("Login sebagai admin");
            }
            else {
                
            }
            
        }
        if (source.equals(view.getBtnRegister())) {
            view.dispose();
            Application r = new Application();
            CC = new ControllerRegister(r);
            CC.actionPerformed(e);
            System.out.println("Register costumer");
        }
        /*if (source.equals(view.getBtnUserLogin())) {
            view.dispose();
            Application r = new Application();
           
            System.out.println("Masuk ke menu user");
        }*/
        if (source.equals(view.getBtnUserLogin())) {
            //view.dispose();
             String username = view.getTfLgUname();
            String password = view.getTfPwLogin();
            cek = model.loginUser(username, password);
            if (cek == true) {
                view.dispose();
                Application b = new Application();
                 CMU = new ControllerMenuKaryawan(b);
                  CMU.actionPerformed(e);
                //MUC = new menuUser_Controller(b);
                //MUC.actionPerformed(e);
                System.out.println("Login User");
            }
            else {
                
            }
            
        }
    }
}
