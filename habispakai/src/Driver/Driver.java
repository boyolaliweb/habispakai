/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Console.Controller;
import Database.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Aplikasi;
import model.User;




/**
 *
 * @author The Keong's
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Aplikasi ap = new Aplikasi();
        new Controller(ap);
        
        //Database d = new Database();
       // d.removeUser(1, "admin");
        //String s = "aaple";
       // s = s.substring(s.length() - 1, s.length());
        //System.out.println(s);
    }
    
}
