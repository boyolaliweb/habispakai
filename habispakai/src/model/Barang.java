/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author The Keong's
 */
public class Barang {
    private int id;
    private String nama;
    private String warna;
    private String type;
    private String satuan;
    private int masapakai;
    private String ket;
    private int del;
 

    public Barang(int id, String nama, String warna, String type, String satuan, int masapakai, String ket, int del) {
        this.id = id;
        this.nama = nama;
        this.warna = warna;
        this.type = type;
        this.satuan = satuan;
        this.masapakai = masapakai;
        this.ket = ket;
        this.del = del;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public int getMasapakai() {
        return masapakai;
    }

    public void setMasapakai(int masapakai) {
        this.masapakai = masapakai;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    
    
}
