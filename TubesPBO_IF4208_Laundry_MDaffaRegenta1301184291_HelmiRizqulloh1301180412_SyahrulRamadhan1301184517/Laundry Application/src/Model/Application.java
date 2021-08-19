/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Database;
import java.util.ArrayList;
/**
 *
 * @author Daffa Regenta
 */
public class Application {
    private Database db;
    
    public Application() {
       
        db = new Database();
        db.connect();
    }
    
     public boolean loginUser(String username , String password) {
        boolean cek = false;
        Karyawan a = new Karyawan(username,password);
        cek = db.loginCustomer(a);
        if (cek == true) {
            cek = true;
        }
        else {
            cek = false;
        }
        return cek;
    }
     
      public boolean loginAdmin(String username , String password) {
        boolean cek = false;
        Admin a = new Admin(username,password);
        cek = db.loginAdmin(a);
        if (cek == true) {
            cek = true;
        }
        else {
            cek = false;
        }
        return cek;
    }
    
    
    
    public void RegisterCostumer(String Name, String PhoneNumber, String Address, String Username, String Password) {
        Karyawan user = new Karyawan(Name, PhoneNumber, Address, Username, Password);
        db.RegisterCustomer(user);
    }
}
