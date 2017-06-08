/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Database.Database;
import java.util.ArrayList;

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
    public String[][] getListOutUser(){
        String out[][] = new String[tUser.size()][5];
        for (int i = 0;i < tUser.size();i++){
                out[i][0] = Long.toString(tUser.get(i).getId());
                out[i][1] = tUser.get(i).getNama();
                out[i][2] = tUser.get(i).getPass();
                out[i][3] = tUser.get(i).getEmail();
            }
        return out;
    }
}
