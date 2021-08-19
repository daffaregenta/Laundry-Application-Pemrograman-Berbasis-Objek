/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daffa Regenta
 */
public class Karyawan extends Person {
    private String Username;
    private String Password;

    public Karyawan(String Name, String PhoneNumber, String Address, String Username, String Password) {
        super(Name, PhoneNumber, Address);
       setUsername(Username);
       setPassword(Password);
    }

   

    public Karyawan (String Username, String Password) {
        
        setUsername(Username);
        setPassword(Password);
        
    }
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
   
    
}
