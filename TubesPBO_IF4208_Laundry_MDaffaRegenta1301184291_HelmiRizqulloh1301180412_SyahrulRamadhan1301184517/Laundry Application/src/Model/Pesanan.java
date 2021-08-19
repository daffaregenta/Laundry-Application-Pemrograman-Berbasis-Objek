/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Daffa Regenta
 */
public class Pesanan {
    private String idlaundry;
    private String nama;
    private String notelp;
    private String alamat;
    private String jcucian;
    private String service;
    private String rett;
    private int berat;
    private int harga;

    public Pesanan(String idlaundry, String nama, String notelp, String alamat, String jcucian,String service,String rett, int berat, int harga) {
        this.idlaundry = idlaundry;
        this.nama = nama;
        this.notelp = notelp;
        this.alamat = alamat;
        this.jcucian = jcucian;
        this.service = service;
        this.rett = rett;
        this.berat = berat;
        this.harga = harga;
    }

    public String getIdlaundry() {
        return idlaundry;
    }

    public void setIdlaundry(String idlaundry) {
        this.idlaundry = idlaundry;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJcucian() {
        return jcucian;
    }

    public void setJcucian(String jcucian) {
        this.jcucian = jcucian;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRett() {
        return rett;
    }

    public void setRett(String rett) {
        this.rett = rett;
    }
    
    
}
