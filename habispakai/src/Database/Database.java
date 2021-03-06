/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static java.lang.Math.toIntExact;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Barang;
import model.Transaksi;
import model.User;

/**
 *
 * @author The Keong's
 */
public class Database {
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
    private String dbUser = "root";
    private String dbPass = "";
    private Statement stmt = null;
    private Connection con = null;
    private ResultSet rs = null;
    
    /*public Database() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12183731", "sql12183731", "xDeeKjpRMB");
        } catch (Exception e) {
            System.out.println("joss");
            System.out.println(e);
        }
    }*/
    
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
    public long makeidUser() {
        String s = "select id from user";
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
    public int makeidBarang() {
        String s = "select id from barang";
        ResultSet rs = getData(s);
        int d = 0;
        try {
                while(rs.next()){
                        d = rs.getInt("id");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return d;
    }
    public void ubahPass(String passL,String passN,long id){
        String s = "update user set pass = '"+passN+"' where id = '"+id+"';";
        String x = "INSERT INTO `log` (`id`, `id_user`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"','"+id+"', 'Edit Password dari "+passL+" ke "+passN+"','"+id+" 0', NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
    public void insertUser(long id,String nama,String pass,String email,String user_id){
        String s = "INSERT INTO `user` (`id`, `nama`, `pass`, `email`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +id+"', '"+nama+"', '"+pass+"', '"+email+"','0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        String x = "INSERT INTO `log` (`id`,`id_user`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"','"+id+"', 'insert User dengan id "+id+" nama "+nama+" 0', '"+user_id+"', NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void removeUser(long id,String user_id){
       String s = "Update User set del = 1,del_on = NOW(),modified_by = '"+user_id+"', modified_on = NOW() where id = '"+id+"';";
       String x = "INSERT INTO `log` (`id`, `id_user`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"','"+id+"', 'Hapus User dengan id "+id+" 0', '"+user_id+"', NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
    
    public void insertBarang(int id, String nama, String merk, String type, String satuan,int masapakai,String ket,String user_id){
        String s = "INSERT INTO `barang` (`id`, `nama`, `merk`, `type/seri`, `satuan`, `masa_pakai`, `ket`, `del`, `del_on`, `mod_by`, `mod_on`) VALUES ('"+
                id+"', '"+nama+"', '"+merk+"', '"+type+"', '"+satuan+"', '"+masapakai+"', '"+ket+"', '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000')";
        String v = "INSERT INTO `stok` (`id_barang`, `stok`) VALUES ('"+id+"', '0')";
        String x = "INSERT INTO `log` (`id`, `id_user`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"','"+id+"', 'insert Barang dengan id "+id+" 1', '"+user_id+"', NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
            query(v);
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
    
    public void removeBarang(int id, String User_id){
        String s = "update barang set del = 1,del_on = NOW(),mod_by = '"+User_id+"',mod_on = NOW() where id = '"+id+"';";
        String x = "INSERT INTO `log` (`id`, `id_user`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"','"+id+"', 'Hapus Barang dengan id "+id+" 1', '"+User_id+"', NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public ArrayList<Barang> readBarang(){
        ArrayList<Barang> dBarang = new ArrayList();
        String s = "select `id`, `nama`, `merk`, `type/seri`, `satuan`, `masa_pakai`, `ket`, `del` from `barang`";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                Barang b;
                if (rs.getInt("del")== 0){
                    b = new Barang(rs.getInt("id"), rs.getString("nama"), rs.getString("merk"), rs.getString("type/seri"), rs.getString("satuan"), rs.getInt("masa_pakai"), rs.getString("ket"), rs.getInt("del"));
                    dBarang.add(b);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dBarang;
    }
    
    public ArrayList<User> readUser(){
        ArrayList<User> dUser = new ArrayList();
        String s = "select id, nama, pass, email, del from user";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                User u;
                if (rs.getInt("del")== 0){
                    u = new User(rs.getLong("id"),rs.getString("nama"),rs.getString("pass"),rs.getString("email"), rs.getInt("del"));
                    dUser.add(u);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dUser;
    }
    
    public void editUser(User u,String user_id){
        String s = "Update User set nama = '"+u.getNama()+"', pass = '"+u.getPass()+"', email = '"+
                u.getEmail()+"', modified_by = '"+user_id+"', modified_on = NOW() where id = "+u.getId()+";";
        String x = "INSERT INTO `log` (`id`, `id_user`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"','"+u.getId()+"', 'Edit User dengan id "+u.getId()+" nama  "+
                u.getNama()+" pass "+u.getPass()+" email "+u.getEmail()+" 0', '"+user_id+"', NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
    public void editBarang(Barang b,String user_id){
        String s = "Update barang set nama = '"+b.getNama()+"', merk = '"+b.getWarna()+"', `type/seri` = '"+
                b.getType()+"', satuan = '"+b.getSatuan()+"', masa_pakai = '"+b.getMasapakai()+"', ket = '"+b.getKet()+"', mod_by = '"+user_id+"', mod_on = NOW() where id = '"+
                b.getId()+"';";
        String x = "INSERT INTO `log` (`id`, `id_user`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"','"+b.getId()+"', 'Edit Barang dengan id "+b.getId()+" nama  "+
                b.getNama()+" merk "+b.getWarna()+" type/seri "+b.getType()+" satuan = "+b.getSatuan()+
                " masa_pakai = "+b.getMasapakai()+" ket = "+b.getKet()+" 1', '"+user_id+
                "', NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }
    public String[][] readLog(java.util.Date tgl, int i){
        int n = 0;
        long x = makeidLog();
        String out[][] = new String[(int) x][5];
        String s = "select id, id_user, even, user_id, time from log";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                if (df.format(rs.getDate("time")).equals(df.format(tgl)) && Integer.parseInt(rs.getString("even").substring(rs.getString("even").length() - 1, rs.getString("even").length())) == i){
                    out[n][0] = Long.toString(rs.getLong("id"));
                    out[n][1] = Long.toString(rs.getLong("id_user"));
                    out[n][2] = rs.getString("even");
                    out[n][3] = rs.getString("user_id");
                    out[n][4] = rs.getString("time");
                    n++;
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    public String[][] readNota(java.util.Date tgl,String i){
        int n = 0;
        long x = makeidNota();
        String out[][] = new String[(int) x][5];
        String s = "select id, total_barang, total_harga, waktu_trx, user_id from nota";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                if (df.format(rs.getDate("waktu_trx")).equals(df.format(tgl)) && rs.getString("total_barang").substring(0,1).equals(i)){
                    out[n][0] = Long.toString(rs.getLong("id"));
                    out[n][1] = rs.getString("total_barang").substring(1);
                    out[n][2] = rs.getString("total_harga");
                    out[n][3] = rs.getString("waktu_trx");
                    out[n][4] = rs.getString("user_id");
                    n++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    public String[][] readNota2(long id, String i){
        int n = 0;
        Long[] z = null;
        long x = makeidNota();
        String out[][] = new String[toIntExact(x)][5];
        String s = "select id, total_barang, total_harga, waktu_trx, user_id from nota";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                if (rs.getLong("id")==id && rs.getString("total_barang").substring(0, 1).equals(i)){
                    out[n][0] = Long.toString(rs.getLong("id"));
                    out[n][1] = rs.getString("total_barang").substring(1);
                    out[n][2] = rs.getString("total_harga");
                    out[n][3] = rs.getString("waktu_trx");
                    out[n][4] = rs.getString("user_id");
                    n++;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return out;
    }
    public String[][] readNota3(java.util.Date tgl,java.util.Date tgl2){
        int n = 0;
        long x = makeidNota();
        String out[][] = new String[(int) x][5];
        String s = "select `id`, `total_barang`, `total_harga`, `waktu_trx`, `user_id` from `nota` where `waktu_trx` BETWEEN '"+df2.format(tgl)+"' AND '"+df2.format(tgl2)+"';";
        //String s = "select `id`, `total_barang`, `total_harga`, `waktu_trx`, `user_id` from `nota` where `waktu_trx` BETWEEN '2017-07-05 17:51:02' AND '2017-07-09 17:27:04';";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                    out[n][0] = Long.toString(rs.getLong("id"));
                    out[n][1] = rs.getString("total_barang").substring(1);
                    out[n][2] = rs.getString("total_harga");
                    out[n][3] = rs.getString("waktu_trx");
                    out[n][4] = rs.getString("user_id");
                    n++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    public String[][] readNota4(java.util.Date tgl){
        int n = 0;
        long x = makeidNota();
        String out[][] = new String[(int) x][5];
        String s = "select id, total_barang, total_harga, waktu_trx, user_id from nota";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                if (df.format(rs.getDate("waktu_trx")).equals(df.format(tgl))){
                    out[n][0] = Long.toString(rs.getLong("id"));
                    out[n][1] = rs.getString("total_barang").substring(1);
                    out[n][2] = rs.getString("total_harga");
                    out[n][3] = rs.getString("waktu_trx");
                    out[n][4] = rs.getString("user_id");
                    n++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    public String[][] readNota5(java.util.Date tgl,java.util.Date tgl2,String i){
        int n = 0;
        long x = makeidNota();
        String out[][] = new String[(int) x][5];
        String s = "select `id`, `total_barang`, `total_harga`, `waktu_trx`, `user_id` from `nota` where `waktu_trx` BETWEEN '"+df2.format(tgl)+"' AND '"+df2.format(tgl2)+"';";
        //String s = "select `id`, `total_barang`, `total_harga`, `waktu_trx`, `user_id` from `nota` where `waktu_trx` BETWEEN '2017-07-05 17:51:02' AND '2017-07-09 17:27:04';";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                if (rs.getString("total_barang").substring(0,1).equals(i)){
                    out[n][0] = Long.toString(rs.getLong("id"));
                    out[n][1] = rs.getString("total_barang").substring(1);
                    out[n][2] = rs.getString("total_harga");
                    out[n][3] = rs.getString("waktu_trx");
                    out[n][4] = rs.getString("user_id");
                    n++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    public boolean cekidNota(long id, String i){
        String s = "select id, total_barang, user_id from nota";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                if (rs.getLong("id")==id && rs.getString("total_barang").substring(0, 1).equals(i))
                    return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public String cekidNota2(long id){
        String s = "select id, total_barang, user_id from nota";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                if (rs.getLong("id")==id)
                    return rs.getString("total_barang").substring(0, 1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public boolean cekidLog(long id,int i){
        String s = "select id, id_user, even, user_id, time from log";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                if (rs.getLong("id_user")==id && Integer.parseInt(rs.getString("even").substring(rs.getString("even").length() - 1, rs.getString("even").length())) == i)
                    return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public String[][] readLog2(long id,int i){
        int n = 0;
        long x = makeidLog();
        String z = Long.toString(x);
        String out[][] = new String[Integer.parseInt(z)][5];
        String s = "select id, id_user, even, user_id, time from log";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
                if (i == 0){
                    if ((rs.getLong("id_user")== id && Integer.parseInt(rs.getString("even").substring(rs.getString("even").length() - 1, rs.getString("even").length())) == i ) || rs.getString("user_id").equals(Long.toString(id))){
                        out[n][0] = Long.toString(rs.getLong("id"));
                        out[n][1] = Long.toString(rs.getLong("id_user"));
                        out[n][2] = rs.getString("even");
                        out[n][3] = rs.getString("user_id");
                        out[n][4] = rs.getString("time");
                        n++;
                    }
                } else {
                    if ((rs.getLong("id_user")== id && Integer.parseInt(rs.getString("even").substring(rs.getString("even").length() - 1, rs.getString("even").length())) == i )){
                        out[n][0] = Long.toString(rs.getLong("id"));
                        out[n][1] = Long.toString(rs.getLong("id_user"));
                        out[n][2] = rs.getString("even");
                        out[n][3] = rs.getString("user_id");
                        out[n][4] = rs.getString("time");
                        n++;
                    }
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    public int makeidTransaksi() {
        String s = "select id from transaksi";
        ResultSet rs = getData(s);
        int d = 0;
        try {
                while(rs.next()){
                        d = rs.getInt("id");
                }
            } catch (SQLException ex) {
                System.out.println("1");
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return d;
    }
    
    public int makeidNota() {
        String s = "select id from nota";
        ResultSet rs = getData(s);
        int d = 0;
        try {
                while(rs.next()){
                        d = rs.getInt("id");
                }
            } catch (SQLException ex) {
                System.out.println("1");
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return d;
    }
    public int cekStok(long id){
        String s = "select id_barang, stok from stok";
        ResultSet rs = getData(s);
        int i = 0;
        try {
            while(rs.next()){
                if (rs.getLong("id_Barang")==id)
                    i = rs.getInt("stok");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    public void insertNota(int total_barang,String total_harga,String id){
        String s = "INSERT INTO `nota` (`id`, `total_barang`, `total_harga`, `waktu_trx`, `user_id`, `del`, `del_on`, `mod_by`, `mod_on`) "
                + "VALUES ('"+(makeidNota()+1)+"', '+"+total_barang+"', '"+total_harga+"', NOW(), '"+id+"', '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000')";
        String x = "INSERT INTO `log` (`id`, `id_user`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"','"+(makeidNota()+1)+"', 'insert Nota dengan id "+(makeidNota()+1)+" 2', '"+id+"',NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void insertNota2(int total_barang,String total_harga,String id){
        String s = "INSERT INTO `nota` (`id`, `total_barang`, `total_harga`, `waktu_trx`, `user_id`, `del`, `del_on`, `mod_by`, `mod_on`) "
                + "VALUES ('"+(makeidNota()+1)+"', '-"+total_barang+"', '"+total_harga+"', NOW(), '"+id+"', '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000')";
        String x = "INSERT INTO `log` (`id`, `id_user`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"','"+(makeidNota()+1)+"', 'insert Nota dengan id "+(makeidNota()+1)+" 2', '"+id+"',NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void insertTransaksi(int barang_id,String user_id,int qty,String harga){
        String s = "INSERT INTO `transaksi` (`id`, `id_nota`, `barang_id`, `qty`, `harga`, `del`, `del_on`, `mod_by`, `mod_on`)"
                + " VALUES ('"+(makeidTransaksi()+1)+"', '"+(makeidNota()+1)+"', '"+barang_id+"', '+"+qty+"', '"+harga+"', '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000')";
        String x = "INSERT INTO `log` (`id`, `id_user`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"','"+(makeidTransaksi()+1)+"', 'insert Transaksi dengan id "+(makeidTransaksi()+1)+" 3', '"+user_id+"',NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void insertTransaksi2(int barang_id,String user_id,int qty,String harga){
        String s = "INSERT INTO `transaksi` (`id`, `id_nota`, `barang_id`, `qty`, `harga`, `del`, `del_on`, `mod_by`, `mod_on`)"
                + " VALUES ('"+(makeidTransaksi()+1)+"', '"+(makeidNota()+1)+"', '"+barang_id+"', '-"+qty+"', '"+harga+"', '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000')";
        String x = "INSERT INTO `log` (`id`, `id_user`, `even`, `user_id`, `time`, `del`, `del_on`, `modified_by`, `modified_on`) VALUES ('"
                +(makeidLog()+1)+"','"+(makeidTransaksi()+1)+"', 'insert Transaksi dengan id "+(makeidTransaksi()+1)+" 3', '"+user_id+"',NOW(), '0', '0000-00-00 00:00:00.000000', '', '0000-00-00 00:00:00.000000');";
        try {
            query(s);
            query(x);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public ArrayList<Transaksi> readTransaksi(String id){
        ArrayList<Transaksi> dTransaksi = new ArrayList();
        String s = "select * from transaksi where id_nota = '"+id+"';";
        ResultSet rs = getData(s);
        try {
            while(rs.next()){
               
                    String v = "select nama, merk from barang where id = '"+rs.getString("barang_id")+"';";
                    ResultSet rv = getData(v);
                    rv.next();
                    Transaksi t;
                    t = new Transaksi(rs.getLong("barang_id"),rv.getString("nama"),rv.getString("merk"),Integer.parseInt(rs.getString("qty").substring(1)),rs.getString("harga"));
                    dTransaksi.add(t);
                
        }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return dTransaksi;
    }
    public void setStok(int qty,long barang_id){
        String v = "update stok set stok = '"+(cekStok(barang_id)+qty)+"' where id_barang = '"+barang_id+"';";
        try {
            query(v);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public void setStok2(int qty,long barang_id){
        String v = "update stok set stok = '"+(cekStok(barang_id)-qty)+"' where id_barang = '"+barang_id+"';";
        try {
            query(v);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
