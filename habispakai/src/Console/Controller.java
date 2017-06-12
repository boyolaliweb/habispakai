/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import View.Admin;
import View.EditUser;
import View.InputBarang;
import View.InputUser;
import View.Login;
import View.MenuUser;
import View.panelContainer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Aplikasi;
import model.User;


/**
 *
 * @author The Keong's
 */
public class Controller extends MouseAdapter implements ActionListener{
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    private Aplikasi model;
    private panelContainer view;
    private String currentView;
    private JPanel mainPanel;
    private boolean posisi;
    private User tmpUser;
    
    private Login L;
    private Admin ad;
    private InputUser iu;
    private EditUser eu;
    private MenuUser mu;
    
    public Controller(Aplikasi Model){
        this.model = Model;
        this.view = new panelContainer();
        
        L = new Login();
        ad = new Admin();
        iu = new InputUser();
        eu = new EditUser();
        mu = new MenuUser();
        
        L.addListener(this);
        iu.addListener(this);
        ad.addListener(this);
        ad.addAdapter(this);
        eu.addListener(this);
        
        
        mainPanel = view.getMainPanel();
        mainPanel.add(L,"0");
        mainPanel.add(ad,"1");
        mainPanel.add(iu,"2");
        mainPanel.add(eu,"3");
        mainPanel.add(mu,"4");
        currentView = "0";
        
        view.getCardLayout().show(mainPanel, currentView);
        view.setVisible(true);
                                               
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if(source.equals(ad.getTuser()) && ad.getUser()>=0 && Integer.parseInt(ad.getUser2()) != 1){
            tmpUser = model.cariUser2(Integer.parseInt(ad.getUser2()));
        } else if(source.equals(ad.getTuser()) && ad.getUser()>=0){
            tmpUser = model.cariUser3(ad.getUser());
        }else
            tmpUser = null;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
       if (currentView.equals("0")){
           if(source.equals(L.btnMasuk())){
                if (L.getIdLogin().equals("")||L.getPassLogin().equals("")){
                        JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong", "Peringatan", JOptionPane.ERROR_MESSAGE); 
                    } else if (L.getIdLogin().equals("admin") && L.getPassLogin().equals("admin")){
                        currentView="1";
                        ad.setListUser(model.getListOutUser());
                        view.getCardLayout().show(mainPanel, currentView);
                    }else if (model.cariUser(Integer.parseInt(L.getIdLogin()), L.getPassLogin())!=null){
                        currentView="4";
                        view.getCardLayout().show(mainPanel, currentView);
                    } else
                         JOptionPane.showMessageDialog(null, "User tidak ada atau username dan pass salah", "Peringatan", JOptionPane.ERROR_MESSAGE);
            }
        } else if (currentView.equals("1")){
            if(source.equals(ad.getUtambah())){
                currentView="2";
                view.getCardLayout().show(mainPanel, currentView);
            }else if (source.equals(ad.Lopress())){
                currentView="0";
                L.refresh();
                view.getCardLayout().show(mainPanel, currentView);
            }else if (source.equals(ad.getUhapus())){
                if(tmpUser==null){
                   JOptionPane.showMessageDialog(null, "Pilih Data Yang akan di Hapus", "Peringatan", JOptionPane.ERROR_MESSAGE);
               } else
                   JOptionPane.showMessageDialog(null, "Data Dengan Nama "+tmpUser.getNama()+" Berhasil di Hapus");
                   model.removeUser(tmpUser);
                   ad.setListUser(model.getListOutUser());
            }else if (source.equals(ad.getUedit())){
                if(tmpUser==null){
                   JOptionPane.showMessageDialog(null, "Pilih Data Yang akan di Ubah", "Peringatan", JOptionPane.ERROR_MESSAGE);
               }else{
                    currentView="3";
                    eu.setPass(tmpUser.getPass());
                    eu.setEmail(tmpUser.getEmail());
                    eu.setNama(tmpUser.getNama());
                    view.getCardLayout().show(mainPanel, currentView);
                }
            }else if(source.equals(ad.getUcari())){
                if(ad.getUcari().equals("")){
                   JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
               }else if (model.cariUser2(Long.parseLong(ad.getCari()))==null){
                   JOptionPane.showMessageDialog(null, "Data Dengan ID User "+ad.getCari()+" Tidak ditemukan", "Peringatan", JOptionPane.ERROR_MESSAGE);
               }else{
                   tmpUser=model.cariUser2(Long.parseLong(ad.getCari()));
                   ad.setListUser(model.getListOutUser2(tmpUser));
               }
            }else if(source.equals(ad.getlcari())){
                if(ad.getTanggal()==null&&ad.getlId().equals("")){
                   JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (ad.getTanggal()==null && model.getListLog(null, Long.parseLong(ad.getlId()))==null){
                   JOptionPane.showMessageDialog(null, "Data Dengan ID User "+ad.getlId()+" Tidak ditemukan", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (ad.getTanggal()==null && !ad.getlId().equals("")){
                   ad.setListLog(model.getListLog(null,Long.parseLong(ad.getlId())));
                }else if(model.getListLog(ad.getTanggal(), 0)==null){
                   JOptionPane.showMessageDialog(null, "Data Dengan Tanggal "+ad.getTanggal()+" Tidak ditemukan", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (ad.getTanggal()!=null && ad.getlId().equals("")){
                    ad.setListLog(model.getListLog(ad.getTanggal(),0));
               }else
                   JOptionPane.showMessageDialog(null, "PILIH SALAH SATU METODE PENCARIAN", "Peringatan", JOptionPane.ERROR_MESSAGE);
               
            }
        }else if (currentView.equals("2")){
            String s = "";
            if(source.equals(iu.getBuat())){
                if (iu.getNama().equals("")||iu.getEmsil().equals("")){
                    JOptionPane.showMessageDialog(null, "Inputan tidak boleh ada yang kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else
                   s = model.insertUser(iu.getNama(), iu.getEmsil());
                   iu.refresh();
                   JOptionPane.showMessageDialog(null, "Pendaftaran Berhasil \n"+s);
            } else if(source.equals(iu.getBack())){
                currentView="1";
                ad.setListUser(model.getListOutUser());
                view.getCardLayout().show(mainPanel, currentView);
            }
        } else if(currentView.equals("3")){
            if (source.equals(eu.getBack())){
                currentView = "1";
                ad.setListUser(model.getListOutUser());
                view.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(eu.getSubmit())){
                tmpUser.setNama(eu.getEnama());
                tmpUser.setEmail(eu.getEemail());
                tmpUser.setPass(eu.getEpass());
                model.editUser(tmpUser, "admin");
                eu.refresh();
                JOptionPane.showMessageDialog(null, "Data User Berhasil di Sunting");
            }
        }
    }
    
    
}
