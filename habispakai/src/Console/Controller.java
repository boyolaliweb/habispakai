/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Console;

import View.Admin;
import View.DetailNota;
import View.EditUser;
import View.Editbarang;
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
import model.Barang;
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
    private User tmpUser2;
    private Barang tmpBarang;
    private Barang tmpBarang2;
    private String idNota;
    private String idUser;
    
    private Login L;
    private Admin ad;
    private InputUser iu;
    private EditUser eu;
    private MenuUser mu;
    private InputBarang ib;
    private Editbarang eb;
    private DetailNota dn;
    
    public Controller(Aplikasi Model){
        this.model = Model;
        this.view = new panelContainer();
        view.pack();
        view.setResizable(false);
        view.setTitle("Inventaris Barang Diskominfo Boyolali");
        L = new Login();
        ad = new Admin();
        iu = new InputUser();
        eu = new EditUser();
        mu = new MenuUser();
        ib = new InputBarang();
        eb = new Editbarang();
        dn = new DetailNota();
        
        L.addListener(this);
        iu.addListener(this);
        ad.addListener(this);
        ad.addAdapter(this);
        eu.addListener(this);
        ib.addListener(this);
        mu.addListener(this);
        mu.addAdapter(this);
        eb.addListener(this);
        dn.addListener(this);
        
        
        mainPanel = view.getMainPanel();
        mainPanel.add(L,"0");
        mainPanel.add(ad,"1");
        mainPanel.add(iu,"2");
        mainPanel.add(eu,"3");
        mainPanel.add(mu,"4");
        mainPanel.add(ib,"5");
        mainPanel.add(eb,"6");
        mainPanel.add(dn,"7");
        currentView = "0";
        view.getCardLayout().show(mainPanel, currentView);
        view.setVisible(true);
                                               
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if(source.equals(mu.getTBarang())&& mu.getBarang()>=0 && Integer.parseInt(mu.getBarang2())!= 1001){
            tmpBarang = model.cariBarang(Integer.parseInt(mu.getBarang2()));
        }else if (source.equals(mu.getTBarang()) && mu.getBarang()>=0){
            tmpBarang = model.cariBarang2(mu.getBarang());  
        }else
            tmpBarang = null;
        if(source.equals(ad.getTBarang())&& ad.getBarang()>=0 && Integer.parseInt(ad.getBarang2())!= 1001){
            tmpBarang2 = model.cariBarang(Integer.parseInt(ad.getBarang2()));
        }else if (source.equals(ad.getTBarang()) && ad.getBarang()>=0){
            tmpBarang2 = model.cariBarang2(ad.getBarang());
        }else
            tmpBarang2 = null;
        if(source.equals(ad.getTuser()) && ad.getUser()>=0 && Integer.parseInt(ad.getUser2()) != 1){
            tmpUser = model.cariUser2(Integer.parseInt(ad.getUser2()));
        } else if(source.equals(ad.getTuser()) && ad.getUser()>=0){
            tmpUser = model.cariUser3(ad.getUser());
        }else{
            tmpUser = null;
        }
        if(source.equals(ad.getTNota()) && ad.getNota()>=0 ){
            idNota = ad.getNota2();
            idUser = ad.getNota3();
        }else{
            idNota = null;
            idUser = null;
        }
        
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
                        ad.setListBarang(model.getListOutBarang());
                        tmpUser2 = new User(999999999);
                        view.getCardLayout().show(mainPanel, currentView);
                    }else if (model.cariUser(Integer.parseInt(L.getIdLogin()), L.getPassLogin())!=null){
                        currentView="4";
                        mu.setListBarang(model.getListOutBarang());
                        tmpUser2=model.cariUser(Integer.parseInt(L.getIdLogin()), L.getPassLogin());
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
                }else if (ad.getTanggal()==null && model.getListLog(null, Long.parseLong(ad.getlId()),ad.lKet())==null){
                   JOptionPane.showMessageDialog(null, "Data Dengan ID User "+ad.getlId()+" Tidak ditemukan", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (ad.getTanggal()==null && !ad.getlId().equals("")){
                   ad.setListLog(model.getListLog(null,Long.parseLong(ad.getlId()),ad.lKet()));
                }else if(model.getListLog(ad.getTanggal(), 0,ad.lKet())==null){
                   JOptionPane.showMessageDialog(null, "Data Dengan Tanggal "+ad.getTanggal()+" Tidak ditemukan", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (ad.getTanggal()!=null && ad.getlId().equals("")){
                    ad.setListLog(model.getListLog(ad.getTanggal(),0,ad.lKet()));
               }else
                   JOptionPane.showMessageDialog(null, "PILIH SALAH SATU METODE PENCARIAN", "Peringatan", JOptionPane.ERROR_MESSAGE);
            }else if(source.equals(ad.getNCari())){
                if(ad.getNotaTanggal()==null&&ad.getNId().equals("")){
                   JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (ad.getNotaTanggal()==null && model.getListNota(null, Long.parseLong(ad.getNId()),ad.getNKet())==null){
                   JOptionPane.showMessageDialog(null, "Data Dengan ID User "+ad.getNId()+" Tidak ditemukan\nCoba Ubah Transaksi", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (ad.getNotaTanggal()==null && !ad.getNId().equals("")){
                   ad.setListNota(model.getListNota(null,Long.parseLong(ad.getNId()),ad.getNKet()));
                }else if(model.getListNota(ad.getNotaTanggal(), 0,ad.getNKet())==null){
                   JOptionPane.showMessageDialog(null, "Data Dengan Tanggal "+ad.getTanggal()+" Tidak ditemukan", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (ad.getNotaTanggal()!=null && ad.getNId().equals("")){
                    ad.setListNota(model.getListNota(ad.getNotaTanggal(),0,ad.getNKet()));
               }else
                   JOptionPane.showMessageDialog(null, "PILIH SALAH SATU METODE PENCARIAN", "Peringatan", JOptionPane.ERROR_MESSAGE);
            }else if(source.equals(ad.getBtambah())){
                currentView = "5";
                ib.refresh();
                view.getCardLayout().show(mainPanel, currentView);
            }else if(source.equals(ad.getBdetail())){
                if(tmpBarang2==null){
                   JOptionPane.showMessageDialog(null, "Pilih Data Yang akan di Lihat", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else{
                    String s = "Id      : "+tmpBarang2.getId()+"\nNama   : "+tmpBarang2.getNama()+"\nMerk     : "+
                            tmpBarang2.getWarna()+"\nType/Resi   : "+tmpBarang2.getType()+"\nSatuan       : "+
                            tmpBarang2.getSatuan()+"\nMasa Pakai : "+tmpBarang2.getMasapakai()+
                            " Tahun\nKeterangan : "+tmpBarang2.getKet();
                    JOptionPane.showMessageDialog(null, s);
                }  
            }else if(source.equals(ad.getBhapus())){
                if(tmpBarang2==null){
                   JOptionPane.showMessageDialog(null, "Pilih Data Yang akan di Hapus", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else
                    JOptionPane.showMessageDialog(null, "Data Dengan Nama "+tmpBarang2.getNama()+" Berhasil di Hapus");
                    model.removeBarang(tmpBarang2, Long.toString(tmpUser2.getId()));
                    ad.setListBarang(model.getListOutBarang());
            }else if(source.equals(ad.getBcari())){
                if(ad.getBnama().equals("")){
                   JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
               }else if (model.cariBarang3(ad.getBnama())==null){
                   JOptionPane.showMessageDialog(null, "Data Dengan Nama "+ad.getBnama()+" Tidak ditemukan", "Peringatan", JOptionPane.ERROR_MESSAGE);
               }else{
                   tmpBarang2=model.cariBarang3(ad.getBnama());
                   ad.setListBarang(model.getListOutBarang2(tmpBarang2));
                   ad.refresh();
               }
            }else if(source.equals(ad.getBedit())){
                if(tmpBarang2==null){
                   JOptionPane.showMessageDialog(null, "Pilih Data Yang akan di Ubah", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else
                    currentView="6";
                    eb.setENamaBrg(tmpBarang2.getNama());
                    eb.setEMerk(tmpBarang2.getWarna());
                    eb.setESatuan(tmpBarang2.getSatuan());
                    eb.setEket(tmpBarang2.getKet());
                    eb.setEmasa(Integer.toString(tmpBarang2.getMasapakai()));
                    eb.setEtype(tmpBarang2.getType());
                    tmpBarang = tmpBarang2;
                    view.getCardLayout().show(mainPanel, currentView);
            }else if(source.equals(ad.getNDetail())){
                if(idNota==null){
                   JOptionPane.showMessageDialog(null, "Pilih Data Yang akan di Ubah", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else{
                    model.loadTransaksi(idNota);
                    currentView="7";
                    dn.setUser(idUser);
                    dn.setSubtotal(model.getTotalTransaksi2());
                    dn.setListTransaksi(model.getListTransaksi2());
                    view.getCardLayout().show(mainPanel, currentView);
                }
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
        } else if(currentView.equals("4")){
            if(source.equals(mu.getTambah())){
                currentView = "5";
                ib.refresh();
                view.getCardLayout().show(mainPanel, currentView);
            }else if(source.equals(mu.getLopress())){
                currentView="0";
                L.refresh();
                view.getCardLayout().show(mainPanel, currentView);
            }else if(source.equals(mu.getDetail())){
                if(tmpBarang==null){
                   JOptionPane.showMessageDialog(null, "Pilih Data Yang akan di Lihat", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else{
                    System.out.println(mu.getBarang2());
                    String s = "Id      : "+tmpBarang.getId()+"\nNama   : "+tmpBarang.getNama()+"\nMerk     : "+
                            tmpBarang.getWarna()+"\nType/Resi   : "+tmpBarang.getType()+"\nSatuan       : "+
                            tmpBarang.getSatuan()+"\nMasa Pakai : "+tmpBarang.getMasapakai()+
                            " Tahun\nKeterangan : "+tmpBarang.getKet();
                    JOptionPane.showMessageDialog(null, s);
                }  
            }else if(source.equals(mu.getHapus())){
                if(tmpBarang==null){
                   JOptionPane.showMessageDialog(null, "Pilih Data Yang akan di Hapus", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else
                    JOptionPane.showMessageDialog(null, "Data Dengan Nama "+tmpBarang.getNama()+" Berhasil di Hapus");
                    model.removeBarang(tmpBarang, Long.toString(tmpUser2.getId()));
                    mu.setListBarang(model.getListOutBarang());
            }else if(source.equals(mu.getSrc())){
                if(mu.getSrcNama().equals("")){
                   JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
               }else if (model.cariBarang3(mu.getSrcNama())==null){
                   JOptionPane.showMessageDialog(null, "Data Dengan Nama "+mu.getSrcNama()+" Tidak ditemukan", "Peringatan", JOptionPane.ERROR_MESSAGE);
               }else{
                   tmpBarang=model.cariBarang3(mu.getSrcNama());
                   mu.setListBarang(model.getListOutBarang2(tmpBarang));
                   mu.refresh();
               }
            }else if(source.equals(mu.getEdit())){
                if(tmpBarang==null){
                   JOptionPane.showMessageDialog(null, "Pilih Data Yang akan di Ubah", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else
                    currentView="6";
                    eb.setENamaBrg(tmpBarang.getNama());
                    eb.setEMerk(tmpBarang.getWarna());
                    eb.setESatuan(tmpBarang.getSatuan());
                    eb.setEket(tmpBarang.getKet());
                    eb.setEmasa(Integer.toString(tmpBarang.getMasapakai()));
                    eb.setEtype(tmpBarang.getType());
                    view.getCardLayout().show(mainPanel, currentView);
            }else if (source.equals(mu.getPubah())){
                if (mu.getPassL().equals("")||mu.getPassN().equals("")||mu.getCpass().equals("")){
                    JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (!tmpUser2.getPass().equals(mu.getPassL())){
                    JOptionPane.showMessageDialog(null, "Password Lama Salah", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (!mu.getPassN().equals(mu.getCpass())){
                    JOptionPane.showMessageDialog(null, "Confrim Password Salah", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else {
                    model.editPass(tmpUser2.getPass(), mu.getPassN(),tmpUser2.getId());
                    tmpUser2.setPass(mu.getPassN());
                    JOptionPane.showMessageDialog(null, "Password Berhasil di Ubah");
                }
            }else if (source.equals(mu.tTambah())){
                if (mu.tNamaBrg().equals("")||mu.tHarga().equals("")||mu.tQty().equals("")){
                    JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if(model.cariBarang3(mu.tNamaBrg())==null){
                    JOptionPane.showMessageDialog(null, "Nama Barang tidak ditemukan, Harap Menambahkan Barang", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else {
                    model.insertTransaksi(mu.tNamaBrg(), Integer.parseInt(mu.tQty()), mu.tHarga(), Long.toString(tmpUser2.getId()));
                    mu.setListTransaksi(model.getListTransaksi());
                    mu.setSubtotal(model.getTotalTransaksi());
                }
            }else if(source.equals(mu.tSimpan())){
                if (model.sizeTransaksi() == 0){
                    JOptionPane.showMessageDialog(null, "Masukan Barang yang mau ditransaksi", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else{
                    model.insertNota(Long.toString(tmpUser2.getId()));
                    mu.refresh();
                    JOptionPane.showMessageDialog(null, "Transaksi Berhasil disimpan");
                }
            }else if (source.equals(mu.tkTambah())){
                if (mu.tkNamaBrg().equals("")||mu.tkHarga().equals("")||mu.tkQty().equals("")){
                    JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if(model.cariBarang3(mu.tkNamaBrg())==null){
                    JOptionPane.showMessageDialog(null, "Nama Barang tidak ditemukan, Harap Menambahkan Barang", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if(!model.cekStok(mu.tkNamaBrg(), Integer.parseInt(mu.tkQty())).equals("")){
                    JOptionPane.showMessageDialog(null, model.cekStok(mu.tkNamaBrg(), Integer.parseInt(mu.tkQty())), "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else {
                    model.insertTransaksi2(mu.tkNamaBrg(), Integer.parseInt(mu.tkQty()), mu.tkHarga(), Long.toString(tmpUser2.getId()));
                    mu.setListTkTransaksi(model.getListTransaksi());
                    mu.setTkSubtotal(model.getTotalTransaksi());
                }
            }else if(source.equals(mu.tkSimpan())){
                if (model.sizeTransaksi() == 0){
                    JOptionPane.showMessageDialog(null, "Masukan Barang yang mau ditransaksi", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else{
                    model.insertNota2(Long.toString(tmpUser2.getId()));
                    mu.refresh();
                    JOptionPane.showMessageDialog(null, "Transaksi Berhasil disimpan");
                }
            }
            
        } else if(currentView.equals("5")){
            String v = null;
            if(source.equals(ib.getBack())){
                if (tmpUser2.getId()==999999999){
                    currentView="1";
                    ad.setListBarang(model.getListOutBarang());
                    view.getCardLayout().show(mainPanel, currentView);
                }else{
                    currentView="4";
                    view.getCardLayout().show(mainPanel, currentView);
                }
            } else if(source.equals(ib.getBuat())){
                if (ib.getINamabrg().equals("")||ib.getIKeterangan().equals("")||ib.getIMasa().equals("")||ib.getIMerk().equals("")||ib.getISatuan().equals("")||ib.getIType().equals("")){
                    JOptionPane.showMessageDialog(null, "Inputan tidak boleh ada yang kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else
                   v = model.insertBarang(ib.getINamabrg(), ib.getIMerk(), ib.getIType(), ib.getISatuan(), Integer.parseInt(ib.getIMasa()), ib.getIKeterangan(), Long.toString(tmpUser2.getId()));
                   ib.refresh();
                   JOptionPane.showMessageDialog(null, "Barang Berhasil ditambahkan \n"+v);
                   mu.setListBarang(model.getListOutBarang());
            }
        } else if(currentView.equals("6")){
            
            if(source.equals(eb.getBack())){
                if (tmpUser2.getId()==999999999){
                    currentView="1";
                    view.getCardLayout().show(mainPanel, currentView);
                }else{
                    currentView="4";
                    view.getCardLayout().show(mainPanel, currentView);
                }
            }else if(source.equals(eb.getSubmit())){
                if (tmpBarang == null){
                JOptionPane.showMessageDialog(null, "Pilih Data Yang akan di Ubah", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else
                    tmpBarang.setNama(eb.getENamabrg());
                    tmpBarang.setKet(eb.getEket());
                    tmpBarang.setMasapakai(Integer.parseInt(eb.getEmasa()));
                    tmpBarang.setSatuan(eb.getEsatuan());
                    tmpBarang.setType(eb.getEType());
                    tmpBarang.setWarna(eb.getEMerk());
                    model.editBarang(tmpBarang, Long.toString(tmpUser2.getId()));
                    JOptionPane.showMessageDialog(null, "Data Barang Berhasil di Sunting");
                    eb.refresh();
                    tmpBarang = null;
            }
        }else if(currentView.equals("7")){
            if(source.equals(dn.getBtnKembali())){
                currentView="1";
                ad.setListUser(model.getListOutUser());
                ad.setListBarang(model.getListOutBarang());
                tmpUser2 = new User(999999999);
                view.getCardLayout().show(mainPanel, currentView);
            }
                
        }
    }
        
}
