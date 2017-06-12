/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Database.Database;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author The Keong's
 */
public class Aplikasi {
    ArrayList<User> tUser;
    Database d;

    public Aplikasi() {
        tUser = new ArrayList();
        d = new Database();
        tUser = d.readUser();
    }
    
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
        for(int i = 0;i<tUser.size();i++){
            if (tUser.get(i).getId()>n){
                n=tUser.get(i).getId();
            }
        }
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
    
    public void editUser(User u, String user_id){
        d.editUser(u, user_id);
    }
}
