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
    
}
