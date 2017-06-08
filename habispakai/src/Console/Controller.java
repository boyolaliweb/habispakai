/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import View.Admin;
import View.InputUser;
import View.Log;
import View.Login;
import View.panelContainer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Aplikasi;

/**
 *
 * @author The Keong's
 */
public class Controller extends MouseAdapter implements ActionListener{
    private Aplikasi model;
    private panelContainer view;
    private String currentView;
    private JPanel mainPanel;
    private boolean posisi;
    
    private Login L;
    private Admin ad;
    
    public Controller(Aplikasi Model){
        this.model = Model;
        this.view = new panelContainer();
        
        L = new Login();
        ad = new Admin();
        
        L.addListener(this);
        
        
        mainPanel = view.getMainPanel();
        mainPanel.add(L,"0");
        mainPanel.add(ad,"1");
        currentView = "0";
        
        view.getCardLayout().show(mainPanel, currentView);
        view.setVisible(true);
                                               
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
                        currentView="1";
                        view.getCardLayout().show(mainPanel, currentView);
                    } else
                         JOptionPane.showMessageDialog(null, "User tidak ada atau username dan pass salah", "Peringatan", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }
    
    
}
