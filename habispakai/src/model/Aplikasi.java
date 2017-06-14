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
    Database d;

    public Aplikasi() {
        tUser = new ArrayList();
        tBarang = new ArrayList();
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
    public String[][] getListLog(java.util.Date tgl,long id){
        if (tgl!=null){
            return d.readLog(tgl);
        }
        else if (d.cekidLog(id) && id!=0){
            return d.readLog2(id);
        }
        return null;
    }
    
    //-----------------------------User----------------------------//
    
    public String insertBarang(String nama, String merk, String type, String satuan,int masapakai,String Ket,String user_id){
        if (user_id.equals("999999999")){
            user_id = "admin";
        }
        int n = 0;
        n=d.makeidBarang();
        if (n>1000){
            n++;
        }else
            n = 1001;
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
}
