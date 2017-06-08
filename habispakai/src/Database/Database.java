/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author The Keong's
 */
public class Database {
    private String dbUser = "root";
    private String dbPass = "";
    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;
    
    public Database() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/master_table", dbUser, dbPass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet getData(String SQLString) {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQLString);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public void query(String SQLString) throws SQLException {
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(SQLString);
        } catch (SQLException c) {
            throw new SQLException("Error eksekusi query");
        }
    }
    
    public long makeidLog() {
        String s = "select id from log";
        ResultSet rs = getData(s);
        long d = 0;
        try {
                while(rs.next()){
                        d = rs.getLong("id");
                }
            } catch (SQLException ex) {
                System.out.println("1");
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return d;
    }
    
    public void insertUser(long id,String nama,String pass,String email,String user_id){
        String z = "jajaja";
        String s = "INSERT INTO `user` (`id`, `nama`, `pass`, `email`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +id+"', '"+nama+"', '"+pass+"', '"+email+"','0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        String x = "INSERT INTO `log` (`id`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"', 'insert User dengan id "+id+" nama "+nama+"', '"+user_id+"', NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void removeUser(long id,String user_id){
       String s = "Update User set del = 1,del_on = NOW(),modified_by = "+user_id+", modified_on = NOW() where id = '"+id+"';";
       String x = "INSERT INTO `log` (`id`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"', 'Hapus User dengan id "+id+"', '"+user_id+"', NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
}
