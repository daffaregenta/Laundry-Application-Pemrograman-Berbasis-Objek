/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
/**
 *
 * @author Daffa Regenta
 */
public class Admin extends Person {
    private String Username;
    private String Password;

    public Admin(String Username, String Password, String Name, String PhoneNumber, String Address) {
        super(Name, PhoneNumber, Address);
         setUsername(Username);
        setPassword(Password);
    }
    
     public Admin(String Username, String Password) {
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

