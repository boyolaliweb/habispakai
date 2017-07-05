/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;

/**
 *
 * @author The Keong's
 */
public class Login extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    public Login() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Masuk = new javax.swing.JButton();
        idLogin = new javax.swing.JTextField();
        passLogin = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(68, 68, 68));
        setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DISKOMINFO BOYOLALI");
        add(jLabel1);
        jLabel1.setBounds(200, 60, 245, 22);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel2.setText("ID Pegawai ");
        add(jLabel2);
        jLabel2.setBounds(210, 260, 70, 20);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel3.setText("Password");
        add(jLabel3);
        jLabel3.setBounds(210, 300, 60, 20);

        Masuk.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 11)); // NOI18N
        Masuk.setText("Login");
        Masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MasukActionPerformed(evt);
            }
        });
        add(Masuk);
        Masuk.setBounds(360, 340, 80, 23);

        idLogin.setForeground(new java.awt.Color(255, 255, 255));
        idLogin.setCaretColor(new java.awt.Color(255, 255, 255));
        idLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idLoginActionPerformed(evt);
            }
        });
        add(idLogin);
        idLogin.setBounds(280, 260, 160, 20);

        passLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passLoginActionPerformed(evt);
            }
        });
        add(passLogin);
        passLogin.setBounds(280, 300, 160, 20);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apllikasi Inventaris Barang");
        add(jLabel4);
        jLabel4.setBounds(180, 30, 280, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/7451 [Converted].png"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(180, 90, 280, 320);
    }// </editor-fold>//GEN-END:initComponents

    private void MasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MasukActionPerformed

    private void passLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passLoginActionPerformed

    private void idLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Masuk;
    private javax.swing.JTextField idLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField passLogin;
    // End of variables declaration//GEN-END:variables
    
    public String getIdLogin(){
        return idLogin.getText();
    }
    
    public String getPassLogin(){
        return passLogin.getText();
    }
    
    public Object btnMasuk(){
        return Masuk;
    }
    public void reset(){
        idLogin.setText("");
        passLogin.setText("");
    }
    public void addListener(ActionListener e){
        Masuk.addActionListener(e);
    }
    public void refresh(){
        idLogin.setText("");
        passLogin.setText("");
    }
}
