/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Daffa Regenta
 */
public abstract class Person {
    private String Name;
    private String PhoneNumber;
    private String Address;
  

    public Person(String Name, String PhoneNumber, String Address) {
       setName(Name);
       setPhoneNumber(PhoneNumber);
       setAddress(Address);
      
    }
    
     public Person () {
        
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

  
  

}