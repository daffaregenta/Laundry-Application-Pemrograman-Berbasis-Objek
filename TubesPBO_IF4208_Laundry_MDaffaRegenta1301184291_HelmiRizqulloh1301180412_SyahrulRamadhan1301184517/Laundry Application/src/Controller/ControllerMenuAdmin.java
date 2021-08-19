/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Model.Application;
import View.MenuAdmin;
import Model.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daffa Regenta
 */
public class ControllerMenuAdmin extends MouseAdapter implements ActionListener {
    private MenuAdmin view;
    private Database db;
    Application model;
    ControllerLogin CL;
    public ControllerMenuAdmin(Application model) {
        this.model = model;
        
        view = new MenuAdmin();
        db = new Database();
        view.addActionListener(this);
        view.addMouseAdapter(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(view.getBtnTambah())) {
            btnTambahActionPerformed();
            loadTable();
        }else if (source.equals(view.getBtnDelete())) {
            btnHapusActionPerformed();
            loadTable();
        }else if (source.equals(view.getBtnReset())) {
            view.Reset();
            loadTable();
        }else if (source.equals(view.getBtnUpdate())) {
           btnUbahActionPerformed();
            loadTable();
        } else if (source.equals(view.getBtnCari())){
            btnCariActionPerformed();
        } if (source.equals(view.getBtnLogOut())){
            view.dispose();
            CL = new ControllerLogin(model);
            CL.actionPerformed(e);  
            
        }
    }
    
   public void btnTambahActionPerformed(){
        String kode = view.getjIdlaundry();
        String nama = view.getjNama();
        String notelp = view.getjNotelp();
        String alamat = view.getjAlamat();
        String cucian = view.getjCucian();
        String service = view.getjService();
        String Rett = view.getjRett();
        String berat = view.getjBerat();
        String harga = view.getjHarga();
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
    
    public void btnHapusActionPerformed(){
        String kode = view.getjIdlaundry();
        db.delPesanan(kode);
        view.Reset();
        view.showMessage("Data Berhasil Dihapus", "Success", 1);
    }
    
    public void btnUbahActionPerformed(){
        String kode = view.getjIdlaundry();
        String nama = view.getjNama();
        String notelp = view.getjNotelp();
        String alamat = view.getjAlamat();
        String cucian = view.getjCucian();
         String service = view.getjService();
        String Rett = view.getjRett();
        String berat = view.getjBerat();
        String harga = view.getjHarga();
         if (kode.isEmpty() || nama.isEmpty() || notelp.isEmpty() || alamat.isEmpty() || cucian.isEmpty() || berat.isEmpty() || harga.isEmpty()){
            view.showMessage("Data Kosong", "Error", 0);
        }else{
              if (!db.cekDuplikatKodePesanan(kode)){
                view.showMessage("Data tidak ditemmukan", "Error", 0);
            }else{
                db.updatePesanan(new Pesanan(kode,nama,notelp,alamat,cucian,service,Rett,Integer.parseInt(berat),Integer.parseInt(harga)));
                view.Reset();
                view.showMessage("Data Berhasil Diubah", "Success", 1);
            }
        }
    }
    
    
     
    public void btnCariActionPerformed(){
        String cari = view.getjDaftarpesanan();
        int index = view.getCategory();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID Laundry", "Nama", "No Telp", "Alamat", "Jenis Cucian","Service","Retrieval","Berat","Harga"}, 0);
        ArrayList<Pesanan> pesanan = db.getPesanan();
        if(index == 0){
            for (Pesanan b : pesanan) {
                if (b.getNama().contains(cari)){
                    model.addRow(new Object[]{b.getIdlaundry(), b.getNama(), b.getNotelp(), b.getAlamat(),b.getJcucian(),b.getService(),b.getRett(),b.getBerat(), b.getHarga()});
                }
            }
        }else if(index == 1){
            for (Pesanan b : pesanan) {
                if (b.getJcucian().contains(cari)){
                    model.addRow(new Object[]{b.getIdlaundry(), b.getNama(), b.getNotelp(), b.getAlamat(),b.getJcucian(),b.getService(),b.getRett(),b.getBerat(), b.getHarga()});
            }
        
        }
        }
        
  
        view.setTbPesanan(model);
    }
    
    
      
    @Override
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if (source.equals(view.getJtbPesanan())){
            int i = view.getSelectedPesanan();
            String kode = view.getJtbPesanan().getModel().getValueAt(i, 0).toString();
            String nama = view.getJtbPesanan().getModel().getValueAt(i, 1).toString();
            String notelp = view.getJtbPesanan().getModel().getValueAt(i, 2).toString();
            String alamat = view.getJtbPesanan().getModel().getValueAt(i, 3).toString();
            String cucian = view.getJtbPesanan().getModel().getValueAt(i, 4).toString();
            String service = view.getJtbPesanan().getModel().getValueAt(i, 5).toString();
            String rett = view.getJtbPesanan().getModel().getValueAt(i, 6).toString();
            String berat = view.getJtbPesanan().getModel().getValueAt(i, 7).toString();
            String harga = view.getJtbPesanan().getModel().getValueAt(i, 8).toString();
            
            view.setjIdlaundry(kode);
            view.setjNama(nama);
            view.setjNotelp(notelp);
            view.setjAlamat(alamat);
            view.setjCucian(cucian);
            view.setjService(service);
            view.setjRett(rett);
            view.setjBerat(berat);
            view.setjHarga(harga);
        }
    }
    
}
