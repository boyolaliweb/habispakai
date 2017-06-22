/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Database.Database;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author The Keong's
 */
public class Aplikasi {
    ArrayList<User> tUser;
    ArrayList<Barang> tBarang;
    ArrayList<Transaksi> tTransaksi;
    ArrayList<Transaksi> tTransaksi2;
    Database d;

    public Aplikasi() {
        tUser = new ArrayList();
        tBarang = new ArrayList();
        tTransaksi = new ArrayList();
        d = new Database();
        tUser = d.readUser();
        tBarang = d.readBarang();
    }
    //-------------------------ADMIN-----------------------///
    public User cariUser(long id,String pass){
        for(int i=0;i<tUser.size();i++){
            if(tUser.get(i).getId()==id && tUser.get(i).getPass().equals(pass)){
                return tUser.get(i);
            }
        }return null;
    }
    public User cariUser2(long id){
        for(int i=0;i<tUser.size();i++){
            if(tUser.get(i).getId()==id ){
                return tUser.get(i);
            }
        }return null;
    }
    public User cariUser3(int i){
        return tUser.get(i);
    }
    public void removeUser(User u){
        d.removeUser(u.getId(), "admin");
        tUser.remove(u);
    }
    public String insertUser(String nama, String email){
        long n = 0;
        /*for(int i = 0;i<tUser.size();i++){
            if (tUser.get(i).getId()>n){
                n=tUser.get(i).getId();
            }
        }*/
        n=d.makeidUser();
        Random rand = new Random();
        int  x = rand.nextInt(50) + 1;
        User u = new User((n+1),nama,Integer.toString(x),email,0);
        tUser.add(u);
        d.insertUser((n+1), nama, Integer.toString(x), email, "admin");
        return "ID : "+(n+1)+"\nPass : "+x;
    }
    
    public String[][] getListOutUser(){
        String out[][] = new String[tUser.size()][5];
        for (int i = 0;i < tUser.size();i++){
            if (tUser.get(i).getDel()==0){
                out[i][0] = Long.toString(tUser.get(i).getId());
                out[i][1] = tUser.get(i).getNama();
                out[i][2] = tUser.get(i).getPass();
                out[i][3] = tUser.get(i).getEmail();
            }
        }
        return out;
    }
    public String[][] getListOutUser2(User u){
        String out[][] = new String[1][4];
        out[0][0] = Long.toString(u.getId());
        out[0][1] = u.getNama();
        out[0][2] = u.getPass();
        out[0][3] = u.getEmail();
        return out;
    }
    
    public void editUser(User u, String user_id){
        d.editUser(u, user_id);
    }
    public String[][] getListLog(java.util.Date tgl,long id,int i){
        if (tgl!=null){
            return d.readLog(tgl,i);
        }
        else if (d.cekidLog(id,i) && id!=0){
            return d.readLog2(id,i);
        }
        return null;
    }
    public String[][] getListNota(java.util.Date tgl,long id,String i){
        if (tgl!=null){
            return d.readNota(tgl,i);
        }
        else if (d.cekidNota(id,i) && id!=0){
            return d.readNota2(id, i);
        }
        return null;
    }
    public void loadTransaksi(String id){
        tTransaksi2 = new ArrayList();
        tTransaksi2 = d.readTransaksi(id);
    }
    public String[][] getListTransaksi2(){
        String out[][] = new String[tTransaksi2.size()][6];
        for (int i = 0;i < tTransaksi2.size();i++){
            out[i][0] = Long.toString(tTransaksi2.get(i).getIdBarang());
            out[i][1] = tTransaksi2.get(i).getNamaBarang();
            out[i][2] = tTransaksi2.get(i).getMerk();
            out[i][3] = Integer.toString(tTransaksi2.get(i).getQty());
            out[i][4] = tTransaksi2.get(i).getHarga();
            out[i][5] = tTransaksi2.get(i).getTotalHarga();
        }
        return out;
    }
    public String getTotalTransaksi2(){
        long n = 0;
        for (int i = 0;i < tTransaksi2.size();i++){
            n = n + Long.parseLong(tTransaksi2.get(i).getTotalHarga());
        }
        return Long.toString(n);
    }
    //-----------------------------User----------------------------//
    
    public String insertBarang(String nama, String merk, String type, String satuan,int masapakai,String Ket,String user_id){
        if (user_id.equals("999999999")){
            user_id = "admin";
        }
        int n = 0;
        n=d.makeidBarang()+1;
        Barang b = new Barang(n, nama, merk, type, satuan, masapakai, Ket, 0);
        d.insertBarang(n, nama, merk, type, satuan, masapakai, Ket, user_id);
        this.tBarang.add(b);
        
        return "ID : "+n+"\nNama : "+nama;
    }
    public String[][] getListOutBarang(){
        String out[][] = new String[tBarang.size()][5];
        for (int i = 0;i < tBarang.size();i++){
            if (tBarang.get(i).getDel()==0){
                out[i][0] = Integer.toString(tBarang.get(i).getId());
                out[i][1] = tBarang.get(i).getNama();
                out[i][2] = tBarang.get(i).getWarna();
                out[i][3] = tBarang.get(i).getType();
                out[i][4] = tBarang.get(i).getSatuan();
            }
        }
        return out;
    }
    public String[][] getListOutBarang2(Barang u){
        String out[][] = new String[1][5];
        out[0][0] = Integer.toString(u.getId());
        out[0][1] = u.getNama();
        out[0][2] = u.getType();
        out[0][3] = u.getType();
        out[0][4] = u.getSatuan();
        return out;
    }
    public Barang cariBarang(long id){
        for(int i=0;i<tBarang.size();i++){
            if(tBarang.get(i).getId()==id ){
                return tBarang.get(i);
            }
        }return null;
    }
    public Barang cariBarang2(int i){
        return tBarang.get(i);
    }
    public Barang cariBarang3(String nama){
        for(int i=0;i<tBarang.size();i++){
            if(tBarang.get(i).getNama().equals(nama)){
                return tBarang.get(i);
            }
        }return null;
    }
    public void removeBarang(Barang b,String user_id){
        if (user_id.equals("999999999")){
            user_id = "admin";
        }
        d.removeBarang(b.getId(), user_id);
        tBarang.remove(b);
    }
    public void editBarang(Barang b, String user_id){
        if (user_id.equals("999999999")){
            user_id = "admin";
        }
        d.editBarang(b, user_id);
    }
    public void editPass(String PassL,String PassN, Long id){
        d.ubahPass(PassL, PassN, id);
    }
    public boolean insertTransaksi(String namaBarang, int Qty, String Harga, String user_id){
        if (cariBarang3(namaBarang) == null){
            return false;
        } 
        d.insertTransaksi(cariBarang3(namaBarang).getId(), user_id, Qty, Harga);
        Transaksi t = new Transaksi(cariBarang3(namaBarang).getId(),namaBarang,cariBarang3(namaBarang).getWarna(),Qty,Harga);
        tTransaksi.add(t);
        return true;
    }
    public boolean insertTransaksi2(String namaBarang, int Qty, String Harga, String user_id){
        if (cariBarang3(namaBarang) == null){
            return false;
        } 
        d.insertTransaksi2(cariBarang3(namaBarang).getId(), user_id, Qty, Harga);
        Transaksi t = new Transaksi(cariBarang3(namaBarang).getId(),namaBarang,cariBarang3(namaBarang).getWarna(),Qty,Harga);
        tTransaksi.add(t);
        return true;
    }
    public String[][] getListTransaksi(){
        String out[][] = new String[tTransaksi.size()][6];
        for (int i = 0;i < tTransaksi.size();i++){
            out[i][0] = Long.toString(tTransaksi.get(i).getIdBarang());
            out[i][1] = tTransaksi.get(i).getNamaBarang();
            out[i][2] = tTransaksi.get(i).getMerk();
            out[i][3] = Integer.toString(tTransaksi.get(i).getQty());
            out[i][4] = tTransaksi.get(i).getHarga();
            out[i][5] = tTransaksi.get(i).getTotalHarga();
        }
        return out;
    }
    public String getTotalTransaksi(){
        long n = 0;
        for (int i = 0;i < tTransaksi.size();i++){
            n = n + Long.parseLong(tTransaksi.get(i).getTotalHarga());
        }
        return Long.toString(n);
    }
    public int sizeTransaksi(){
        return tTransaksi.size();
    }
    public void insertNota(String id){
        d.insertNota(tTransaksi.size(), getTotalTransaksi(), id);
        for (int i = 0;i < tTransaksi.size();i++){
            d.setStok(tTransaksi.get(i).getQty(), tTransaksi.get(i).getIdBarang());
        }
        tTransaksi = new ArrayList();
    }
    public void insertNota2(String id){
        d.insertNota2(tTransaksi.size(), getTotalTransaksi(), id);
        for (int i = 0;i < tTransaksi.size();i++){
            d.setStok2(tTransaksi.get(i).getQty(), tTransaksi.get(i).getIdBarang());
        }
        tTransaksi = new ArrayList();
    }
    public String cekStok(String namaBarang,int Qty){
        if (d.cekStok(cariBarang3(namaBarang).getId()) < Qty){
            return "Stok tidak cukup, jumlah stok saat ini "+d.cekStok(cariBarang3(namaBarang).getId());
        }
        return "";
    }
}
