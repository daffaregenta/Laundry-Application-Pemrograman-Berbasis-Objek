/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Daffa Regenta
 */
public class Database {
    /*private String server = "jdbc:mysql://localhost/laundry";//nama database
    private String dbuser = "root";
    private String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;
    private ResultSet rs = null;
    private ArrayList<Costumerz> karyawan = new ArrayList<>(); */
    Connection connection;
  
    private ArrayList<Pesanan> pesanan = new ArrayList<>();
    
   public Database(){
        loadBuku();
    }
   
   
    public void connect() { //method untuk mengkoneksikan database 
         try{
            String url = "jdbc:mysql://localhost:3306/laundry";
            String username = "root";
            String pass = "";
            connection = (Connection) DriverManager.getConnection(url, username, pass);
            System.out.println("Connected to Database");    
        }
        catch (SQLException ex) {
            System.out.println("Connection Error");
            ex.printStackTrace();
        }
    }
     public void disconnect(){
        try {
            connection.close();
            Statement stmt = connection.createStatement();
              stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean manipulate(String query){
        boolean cek = false;
       // int row;
        try {
            int row;
            Statement stmt = connection.createStatement();
            row = stmt.executeUpdate(query);
            if (row > 0) cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cek;
    }
    
   /* public ResultSet getData(String str) { //string disini merupakan query
        try{
            rs = statement.executeQuery(str);
        }catch(Exception e){
            System.out.println("Error 2: " + e.getMessage());
        }
        return rs;
    }
    
    public void query(String str) { //string disini merupakan query
        try{
            statement.executeUpdate(str);
        }catch(Exception e){
            System.out.println("Error 3: " + e.getMessage());
        }
    }
    
    public void close(){
        try {
            connection.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error 4: "+e.getMessage());
        }
    }
    
    public boolean manipulate(String query){
        boolean cek = false;
        int row;
        try {
            row = statement.executeUpdate(query);
            if (row > 0)cek = true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cek;
    }
    
     public void createCostumer (Costumerz c){
        connect();
        String query = "insert into Costumer (Name, PhoneNumber, Address, Username, Password) values ('"+c.getName()+"','"+c.getPhoneNumber()+"','"+c.getAddress()+"','"+c.getUsername()+"','"+c.getPassword()+"')";
         if (manipulate(query)) karyawan.add(c);
         close();
     }
     
     public boolean loginCheckCust(String Username, String Password){
         connect();
        boolean check = false;
        String query = "SELECT * FROM karyawan";
        try{
             rs = statement.executeQuery(query);
             while(rs.next()){
                 if(rs.getString("Username").equals(Username) && rs.getString("Password").equals(Password)){
                     check = true;
                     break;
                 }
             }

        } catch(SQLException ex){
                        System.out.println("Error 3: " + ex.getMessage());

        }
        close();
        return check;
     }
     
     public boolean loginCheckAdmin(String Username, String Password){
        connect();
        boolean check = false;
        String query = "SELECT * FROM admin";
        try{
             rs = statement.executeQuery(query);
             while(rs.next()){
                 if(rs.getString("Username").equals(Username) && rs.getString("Password").equals(Password)){
                     check = true;
                     break;
                 }
             }

        } catch(SQLException ex){
                        System.out.println("Error 3: " + ex.getMessage());

        }
        close();
        return check;
     }*/
    
    public boolean cekDuplikatKodePesanan(String kode){
        boolean cek = false;
        for (Pesanan b : pesanan) {
            if (b.getIdlaundry().equals(kode)) {
                cek = true;
                break;
            }
        }
        return cek;
    }
    
    public void addPesanan(Pesanan b){
        connect();
        String query = "INSERT INTO pesanan VALUES (";
        query += "'" + b.getIdlaundry() + "',";
        query += "'" + b.getNama()+ "',";
        query += "'" + b.getNotelp() + "',";
        query += "'" + b.getAlamat() + "',";
        query += "'" + b.getJcucian() + "',";
        query += "'" + b.getService() + "',";
        query += "'" + b.getRett() + "',";
        query += "'" + b.getBerat() + "',";
        query += "'" + b.getHarga() + "')";
        
        if (manipulate(query)) pesanan.add(b);
        //disconnect();
    }
    
      public boolean loginAdmin(Admin a) {
        boolean cek = false;
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM admin WHERE username='"+a.getUsername()+"'AND password = '"+a.getPassword()+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(a.getUsername().equals(rs.getString("Username"))&& a.getPassword().equals(rs.getString("Password"))) {
                    cek = true;
                    
                    System.out.println("Good");
                    
            }
                else {
                  cek = false;
                }
            }
            if (cek == true) {
                JOptionPane.showMessageDialog(null, "Anda Berhasil Login Sebagai Admin !");
            }
            else {
                JOptionPane.showMessageDialog(null, "Sayang sekali Gagal Login :(\ncek kembali username & passwordnya");
            }
       
            }catch (Exception ex) {
            System.out.println("Connection Error");
            ex.printStackTrace();
        }
        return cek;
       
    }
    
     public boolean loginCustomer(Karyawan a) {
        boolean cek = false;
        try {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM karyawan WHERE username='"+a.getUsername()+"'AND password = '"+a.getPassword()+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if(a.getUsername().equals(rs.getString("Username"))&& a.getPassword().equals(rs.getString("Password"))) {
                    cek = true;
                    
                    System.out.println("Good");
                    
            }
                else {
                  cek = false;
                }
            }
            if (cek == true) {
                JOptionPane.showMessageDialog(null, "Login Berhasil :)");
            }
            else {
                JOptionPane.showMessageDialog(null, "Gagal Login :(\nCek kembali Username & Passwordnya");
            }
       
            }catch (Exception ex) {
            System.out.println("Connection Error");
            ex.printStackTrace();
        }
        return cek;
    }
    
    public void RegisterCustomer(Karyawan a) {
        try {
            String query = "insert into karyawan values('"+a.getName()+"','"+a.getPhoneNumber()+"','"+a.getAddress()+"','"+a.getUsername()+"','"+a.getPassword()+"');";
            Statement s = connection.createStatement();
            s.execute(query);
            System.out.println("Register Berhasil");
            JOptionPane.showMessageDialog(null, "Selamat anda berhasil Register :) !!\nSilahkan Login !!");
            
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Register :(, Coba lagi");
            System.out.println("Register Gagal");
        }
       
    }
    
     public void loadBuku(){
        connect();
       // String query = "SELECT * FROM pesanan";
        try {
            Statement stmt = connection.createStatement();
            //rs = stmt.executeQuery(query);
            String query = "SELECT * FROM pesanan";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                pesanan.add(new Pesanan(rs.getString("idlaundry"), 
                        rs.getString("nama"), rs.getString("notelp"), 
                        rs.getString("alamat"),rs.getString("jcucian"),rs.getString("service"),rs.getString("rett"),rs.getInt("berat"), rs.getInt("harga")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
       // disconnect();
    }

    public ArrayList<Pesanan> getPesanan() {
        return pesanan;
    }
    
    
    public void delPesanan(String kode){
        connect();
        String query = "DELETE FROM pesanan WHERE idlaundry='"+ kode+"';";
        if (manipulate(query)) {
            for (Pesanan b : pesanan) {
                if (b.getIdlaundry().equals(kode)) {
                    pesanan.remove(b);
                    break;
                }
            }
        }
        //disconnect();
    }
    
    public void updatePesanan(Pesanan b){
        connect();
        String query = "UPDATE pesanan SET";
        query += " idlaundry='" + b.getIdlaundry() + "',";
        query += " nama='" + b.getNama() + "',";
        query += " notelp='" + b.getNotelp() + "',";
        query += " alamat='" + b.getAlamat() + "',";
        query += " jcucian='" + b.getJcucian() + "',";
         query += " service='" + b.getService() + "',";
          query += " rett='" + b.getRett() + "',";
        query += " berat='" + b.getBerat() + "',";
        query += " harga='" + b.getHarga() + "'";
        query += " WHERE idlaundry='" + b.getIdlaundry() + "';";
        if (manipulate(query)) {
            for (Pesanan b1 : pesanan) {
                if (b1.getIdlaundry().equals(b.getIdlaundry())) {
                    b1.setIdlaundry(b.getIdlaundry());
                    b1.setNama(b.getNama());
                    b1.setNotelp(b.getNotelp());
                    b1.setAlamat(b.getAlamat());
                    b1.setJcucian(b.getJcucian());   
                    b1.setBerat(b.getBerat());
                    b1.setHarga(b.getHarga());
                      
                    break;
                }
            }
        }
        //disconnect();
    }
    
  
     
    
}
