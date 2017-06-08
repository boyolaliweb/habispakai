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
    
    
    
}
