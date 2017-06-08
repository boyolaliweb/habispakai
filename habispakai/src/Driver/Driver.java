/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Database.Database;
import java.sql.SQLException;




/**
 *
 * @author The Keong's
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Database d = new Database();
        int id = 25;
        String even = "qwre";
        String u = "1234565";
        
        d.insertUser(id, even, even, even, u);
        
    }
    
}
