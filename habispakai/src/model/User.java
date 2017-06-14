/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author The Keong's
 */
public class User {
    private long id;
    private String nama;
    private String pass;
    private String email;
    private int del;

    public User(long id) {
        this.id = id;
    }

    public User(long id, String nama, String pass, String email, int del) {
        this.id = id;
        this.nama = nama;
        this.pass = pass;
        this.email = email;
        this.del = del;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }
   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
