/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jefri
 */
public class MenuUser extends javax.swing.JPanel {

    /**
     * Creates new form MenuUser
     */
    public MenuUser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Barang = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        Add = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Del = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tBarang = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        SrcNama = new javax.swing.JTextField();
        Src = new javax.swing.JButton();
        Print = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        detail = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tkbarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tkqty = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tkharga = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tkTabel = new javax.swing.JTable();
        tkTambah = new javax.swing.JButton();
        tkSubtotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tkSimpan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Nbarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        tTambah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTransaksi = new javax.swing.JTable();
        tSubtotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tSimpan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        PassB = new javax.swing.JPasswordField();
        pUbah = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PassL = new javax.swing.JPasswordField();
        cPass = new javax.swing.JPasswordField();
        LogOut = new javax.swing.JButton();

        setBackground(new java.awt.Color(68, 68, 68));

        jPanel2.setBackground(new java.awt.Color(23, 171, 99));

        Add.setText("Tambah");

        Edit.setText("Edit");

        Del.setText("Hapus");

        tBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "Merk/Type", "Jumlah", "Harga Satuan", "Nilai Total"
            }
        ));
        jScrollPane1.setViewportView(tBarang);

        jLabel14.setText("Nama barang");

        Src.setText("Cari");

        Print.setText("Cetak");

        jLabel15.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        jLabel15.setText("DAFTAR BARANG");

        detail.setText("Detail");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(detail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Del)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Add))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(SrcNama, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Src, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Print)))
                        .addGap(35, 35, 35)))
                .addGap(75, 75, 75))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SrcNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Src)
                    .addComponent(jLabel14)
                    .addComponent(Print))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add)
                    .addComponent(Edit)
                    .addComponent(Del)
                    .addComponent(detail))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Barang.addTab("Barang", jPanel2);

        jPanel3.setBackground(new java.awt.Color(23, 171, 99));

        jLabel6.setText("Nama Barang      :");

        jLabel7.setText("Jumlah Barang   :");

        jLabel9.setText("Harga Barang     :");

        tkTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "Merk/Type", "Qty", "Harga Satuan", "Total"
            }
        ));
        jScrollPane3.setViewportView(tkTabel);

        tkTambah.setText("Tambah");

        jLabel10.setText("Sub Total    :");

        tkSimpan.setText("Simpan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(tkSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tkTambah)
                    .addComponent(tkSimpan)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(tkbarang))
                                .addComponent(tkqty, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tkharga, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tkbarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tkqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tkharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tkTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tkSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tkSimpan)
                .addGap(25, 25, 25))
        );

        Barang.addTab("Transaksi Keluar", jPanel3);

        jPanel4.setBackground(new java.awt.Color(23, 171, 99));

        jLabel3.setText("Nama Barang       :");

        jLabel4.setText("Jumlah Barang     :");

        jLabel5.setText("Harga Barang      :");

        tTambah.setText("Tambah");

        tTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "Merk/Type", "Qty", "Harga Satuan", "Total"
            }
        ));
        jScrollPane2.setViewportView(tTransaksi);

        jLabel8.setText("Sub Total    :");

        tSimpan.setText("Simpan");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTambah)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(tSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tSimpan)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Nbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(tTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(tSimpan)
                .addGap(26, 26, 26))
        );

        Barang.addTab("Transaksi", jPanel4);

        jPanel1.setBackground(new java.awt.Color(23, 212, 117));

        jLabel16.setText("Password Lama          :");

        jLabel17.setText("Password Baru           :");

        pUbah.setText("Ubah");

        jLabel1.setText("Confrim Password      :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pUbah)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel1))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PassB, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(PassL)
                            .addComponent(cPass))))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(PassL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(PassB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(pUbah)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        Barang.addTab("Ubah Password", jPanel1);

        LogOut.setText("LogOut");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LogOut)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Barang, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LogOut)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JTabbedPane Barang;
    private javax.swing.JButton Del;
    private javax.swing.JButton Edit;
    private javax.swing.JButton LogOut;
    private javax.swing.JTextField Nbarang;
    private javax.swing.JPasswordField PassB;
    private javax.swing.JPasswordField PassL;
    private javax.swing.JButton Print;
    private javax.swing.JButton Src;
    private javax.swing.JTextField SrcNama;
    private javax.swing.JPasswordField cPass;
    private javax.swing.JButton detail;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton pUbah;
    private javax.swing.JTextField qty;
    private javax.swing.JTable tBarang;
    private javax.swing.JButton tSimpan;
    private javax.swing.JTextField tSubtotal;
    private javax.swing.JButton tTambah;
    private javax.swing.JTable tTransaksi;
    private javax.swing.JButton tkSimpan;
    private javax.swing.JTextField tkSubtotal;
    private javax.swing.JTable tkTabel;
    private javax.swing.JButton tkTambah;
    private javax.swing.JTextField tkbarang;
    private javax.swing.JTextField tkharga;
    private javax.swing.JTextField tkqty;
    // End of variables declaration//GEN-END:variables
   public Object getTambah(){
       return Add;
   }
   public Object getTBarang(){
       return tBarang;
   }
   public int getBarang(){
        return tBarang.getSelectedRow();
    }
    public String getBarang2(){
        return tBarang.getValueAt(tBarang.getSelectedRow(),0).toString();
    }
    public String getSrcNama(){
        return SrcNama.getText();
    }
    public Object getSrc(){
        return Src;
    }
   public void setListBarang(String[][] list){
        String[] judul = {"Id","Nama","Merk","Type/Seri","Satuan"};
        String[][] isi = new String[list.length][5];
        for (int i = 0; i < list.length; i++){
            isi[i][0] = list[i][0];
            isi[i][1] = list[i][1];
            isi[i][2] = list[i][2];
            isi[i][3] = list[i][3];
            isi[i][4] = list[i][4];
        }
        DefaultTableModel tableModel = new DefaultTableModel(isi,judul);
        tBarang.setModel(tableModel);
        tBarang.getColumnModel().getColumn(0).setPreferredWidth(20);
    }
   public Object getLopress(){
       return LogOut;
   }
   public Object getDetail(){
       return detail;
   }
   public Object getHapus(){
       return Del;
   }
   public Object getEdit(){
       return Edit;
   }
   public String getPassL(){
       return PassL.getText();
   }
   public String getPassN(){
       return PassB.getText();
   }
   public String getCpass(){
       return cPass.getText();
   }
   public Object getPubah(){
       return pUbah;
   }
   //-----------------------------transaksi---------------------//
   public String tNamaBrg(){
       return Nbarang.getText();
   }
   public String tQty(){
       return qty.getText();
   }
   public String tHarga(){
       return harga.getText();
   }
   public Object tTambah(){
       return tTambah;
   }
   public Object tSimpan(){
       return tSimpan;
   }
   public void setSubtotal(String s){
       tSubtotal.setText(s);
       tSubtotal.enable(false);
   }
   public void setListTransaksi(String[][] list){
        String[] judul = {"Id","Nama","Merk","QTY","Harga Satuan", "Total"};
        String[][] isi = new String[list.length][6];
        for (int i = 0; i < list.length; i++){
            isi[i][0] = list[i][0];
            isi[i][1] = list[i][1];
            isi[i][2] = list[i][2];
            isi[i][3] = list[i][3];
            isi[i][4] = list[i][4];
            isi[i][5] = list[i][5];
        }
        DefaultTableModel tableModel = new DefaultTableModel(isi,judul);
        tTransaksi.setModel(tableModel);
        tTransaksi.getColumnModel().getColumn(0).setPreferredWidth(20);
    }
   //---------------------Transaksi Keluar--------------//
   public String tkNamaBrg(){
       return tkbarang.getText();
   }
   public String tkQty(){
       return tkqty.getText();
   }
   public String tkHarga(){
       return tkharga.getText();
   }
   public Object tkTambah(){
       return tkTambah;
   }
   public Object tkSimpan(){
       return tkSimpan;
   }
   public void setTkSubtotal(String s){
       tkSubtotal.setText(s);
       tkSubtotal.enable(false);
   }
   public void setListTkTransaksi(String[][] list){
        String[] judul = {"Id","Nama","Merk","QTY","Harga Satuan", "Total"};
        String[][] isi = new String[list.length][6];
        for (int i = 0; i < list.length; i++){
            isi[i][0] = list[i][0];
            isi[i][1] = list[i][1];
            isi[i][2] = list[i][2];
            isi[i][3] = list[i][3];
            isi[i][4] = list[i][4];
            isi[i][5] = list[i][5];
        }
        DefaultTableModel tableModel = new DefaultTableModel(isi,judul);
        tkTabel.setModel(tableModel);
        tkTabel.getColumnModel().getColumn(0).setPreferredWidth(20);
    }
   //----------------------Tool---------------------//
   public String[][] setKosong(){
        String[][] isi = new String[1][6];
        isi[0][0] = "";
        isi[0][1] = "";
        isi[0][2] = "";
        isi[0][3] = "";
        isi[0][4] = "";
        isi[0][5] = "";
        return isi;
   }
   public void addListener(ActionListener e){
       LogOut.addActionListener(e);
       Add.addActionListener(e);
       detail.addActionListener(e);
       Del.addActionListener(e);
       Edit.addActionListener(e);
       Src.addActionListener(e);
       pUbah.addActionListener(e);
       tTambah.addActionListener(e);
       tSimpan.addActionListener(e);
       tkTambah.addActionListener(e);
       tkSimpan.addActionListener(e);
   }
   public void addAdapter(MouseAdapter e){
        tBarang.addMouseListener(e);
    }
   public void refresh(){
       SrcNama.setText("");
       Nbarang.setText("");
       qty.setText("");
       harga.setText("");
       setListTransaksi(setKosong());
       tSubtotal.setText("");
       tkSubtotal.setText("");
   }
}
