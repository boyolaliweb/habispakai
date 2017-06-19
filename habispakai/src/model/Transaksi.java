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
public class Transaksi {
    private long idBarang;
    private String namaBarang;
    private int Qty;
    private String Harga;
    private String totalHarga;

    public Transaksi(long idBarang, String namaBarang, int Qty, String Harga) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.Qty = Qty;
        this.Harga = Harga;
        this.totalHarga = Long.toString(Qty * Long.parseLong(Harga));
    }

    public long getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(long idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public String getHarga() {
        return Harga;
    }

    public void setHarga(String Harga) {
        this.Harga = Harga;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    
}
