/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Database;
import Model.Pesanan;
import View.MenuLogin;
import View.MenuKaryawan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author Daffa Regenta
 */
public class ControllerMenuKaryawan implements ActionListener {
    
    MenuKaryawan view;
    Application model;
    Database db;
    ControllerLogin CL;
    int hargaa;
    int hargaa1,hargaa2;

    int tottal;
    ControllerMenuKaryawan CMU;
  

    public ControllerMenuKaryawan(Application model) {
        db = new Database();
        this.model = model;
        view = new MenuKaryawan();
        view.addActionListener(this);
        view.setVisible(true);
         loadTable();
         
    }
    
     public void loadTable(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Laundry", "Nama", "No Telp", "Alamat", "Jenis Cucian","Service","Retrieval","Berat","Harga"}, 0);
        ArrayList<Pesanan> pesanan = db.getPesanan();
        for (Pesanan b : pesanan) {
            model.addRow(new Object[]{b.getIdlaundry(), b.getNama(), b.getNotelp(), b.getAlamat(),b.getJcucian(),b.getService(),b.getRett(),b.getBerat(), b.getHarga()});
        }
        view.setTbPesanan(model);
    }
     
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnExit())) {
            view.dispose();
            System.out.println("berhasil di add");
            CL = new ControllerLogin(model);
            CL.actionPerformed(e);
        }if (source.equals(view.getBtnHitung())) {
            //view.dispose();
            btnbtnHitungActionPerformed();
            loadTable();
        }if (source.equals(view.getBtnSubmit())) {
            //view.dispose();
            btnTambahActionPerformed();
            loadTable();
        }
    }
    
      
   public void btnTambahActionPerformed(){
        String kode = view.getjIdlaundry();
        String nama = view.getjNama();
        String notelp = view.getjNotelp();
        String alamat = view.getjAlamat();
        String cucian = view.getPick();
        String service = view.getService();
        String Rett = view.getRet();
        String berat = view.getTfBerat();
        String harga = view.getTfTotal();
        if (kode.isEmpty() || nama.isEmpty() || notelp.isEmpty() || alamat.isEmpty() || cucian.isEmpty() || berat.isEmpty() || harga.isEmpty()){
            view.showMessage("Data Kosong", "Error", 0);
        }else{
            if (db.cekDuplikatKodePesanan(kode)){
                view.showMessage("Pesanan Sudah Ada", "Error", 0);
            }else{
                db.addPesanan(new Pesanan(kode,nama,notelp,alamat,cucian,service,Rett,Integer.parseInt(berat),Integer.parseInt(harga)));
                view.Reset();
                view.showMessage("Data Berhasil Ditambah", "Success", 1);
            }
        }
    }
   
   public void btnbtnHitungActionPerformed(){
        String kode = view.getjIdlaundry();
        String nama = view.getjNama();
        String notelp = view.getjNotelp();
        String alamat = view.getjAlamat();
        String cucian = view.getPick();
        String service = view.getService();
        String Rett = view.getRet();
        String berat = view.getTfBerat();
        String harga = view.getTfTotal();
        
        System.out.println(Rett);
        if ("Delivery".equals(Rett)){
            hargaa2 = 3000;
            tottal= hargaa * Integer.parseInt(berat) + hargaa1 + hargaa2;
        }else if ("Pickup".equals(Rett)){
            hargaa2 = 0;
            tottal= hargaa * Integer.parseInt(berat) + hargaa1 + hargaa2;
        }
          
        System.out.println(""+hargaa2);
          
         if (cucian  == "Pakaian") {
             hargaa = 6000;
             tottal= hargaa * Integer.parseInt(berat) + hargaa1 + hargaa2;
        } else if (cucian == "Sprei") {
             hargaa = 8000;
             tottal= hargaa * Integer.parseInt(berat) + hargaa1 + hargaa2;
        } else if (cucian == "Tas") {
             hargaa = 7000;
             tottal= hargaa * Integer.parseInt(berat) + hargaa1 + hargaa2;
        } else if (cucian == "Sepatu") {
             hargaa = 12000;
             tottal= hargaa * Integer.parseInt(berat) + hargaa1 + hargaa2;
        }
         
       /*  if (service  == "Express (1 day)") {
             hargaa1 = 3000;
             tottal= hargaa * Integer.parseInt(berat) + hargaa1 + hargaa2;
        }  else if (cucian == "Reguler(3 days)") {
             hargaa1 = 0;
             tottal= hargaa * Integer.parseInt(berat) + hargaa1 + hargaa2;
        }*/
       
        if ("Express (1 day)".equals(service)){
            hargaa1 = 3000;
            tottal= hargaa * Integer.parseInt(berat) + hargaa1 + hargaa2;
        }else if ("Reguler(3 days)".equals(service)){
            hargaa1 = 0;
            tottal= hargaa * Integer.parseInt(berat) + hargaa1 + hargaa2;
        }
          
         
       
         
        // tottal= hargaa * Integer.parseInt(berat) + hargaa1 + hargaa2;
         
         String tottall = Integer.toString(tottal); 
         view.setTfTotal(tottall);
         
        }
   
   
    }
