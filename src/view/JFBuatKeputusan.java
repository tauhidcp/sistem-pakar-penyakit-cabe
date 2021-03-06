/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.c_buat_aturan;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author tauhid
 */
public class JFBuatKeputusan extends javax.swing.JFrame {

    /**
     * Creates new form JFBuatKeputusan
     */
    c_buat_aturan caturan;
    JFUtama utama;
    
    public JFBuatKeputusan() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(getRootPane());
        this.setAlwaysOnTop(true);
        this.setTitle("Form Pembuatan Keputusan");
        
        lidhama.setVisible(false);
        lidobat.setVisible(false);
        lidpenyakit.setVisible(false);
        idgejala.setVisible(false);
        
        caturan = new c_buat_aturan();
        if (caturan.jmlDataGejala()>0){
        LGejala.setText(caturan.tampilkanGejala(0));
        idgejala.setText(Integer.toString(caturan.ambilID(0)));
        int jmlx = caturan.jmlDataPilihan()==0 ? 1 : caturan.jmlDataPilihan();
        linfo_pertanyaan.setText("Gejala ke "+Integer.toString(jmlx)+" dari "+caturan.jmlDataGejala());
        caturan.kosongkanPilihan();
        jBLanjut.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Data Gejala Kosong!");
            jBLanjut.setEnabled(false);
            jBDetail.setEnabled(false);
        }
        
    }

    
    public JScrollPane getScrollObat(){ return jScrollPane6; }
    public JScrollPane getScrollPenyakitHama(){ return jScrollPane4; }
   
    public JLabel getLPenyakit(){ return LPenyakit; }
    public JLabel getLObat(){ return LObat; }
    
    public JLabel getIdObat(){ return lidobat; }
    public JLabel getIdPenyakit(){ return lidpenyakit; }
    public JLabel getIdHama(){ return lidhama; }
            
    public JPanel getPTengah(){
    return panel_tengah;
    }
    
    public JPanel getPPenyakit(){
    return panelPenyakit;
    }
    
    public JPanel getPObat(){
    return panelObat;
    }
    
    public JPanel getPNilai(){
    return panelNilai;
    }
    
    public JPanel getPGejala(){
    return panelGejala;
    }
    
    public JPanel getPGejalaNilai(){
    return panelGejalaDanNilai;
    }
    
    public JPanel getPPenyakitObat(){
    return panelPenyakitDanObat;
    }
    
    public JButton getBSimpan(){
    return jbSimpan;
    }

    public JButton getBKembali(){
    return jBKembali;
    } 
    
    public JButton getBUlang(){ return jBUlang; }
    public JButton getBLanjut(){ return jBLanjut; }
    public JButton getBDetail(){ return jBDetail; }
    
    public JLabel getGejala(){ return LGejala; }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panel_tengah = new javax.swing.JPanel();
        panelGejalaDanNilai = new javax.swing.JPanel();
        panelNilai = new javax.swing.JPanel();
        jrYa = new javax.swing.JRadioButton();
        jrTidak = new javax.swing.JRadioButton();
        panelGejala = new javax.swing.JPanel();
        panel_info = new javax.swing.JPanel();
        linfo_pertanyaan = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LGejala = new javax.swing.JLabel();
        idgejala = new javax.swing.JLabel();
        panelPenyakitDanObat = new javax.swing.JPanel();
        panelObat = new javax.swing.JPanel();
        jbPilihObat = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        LObat = new javax.swing.JLabel();
        panelPenyakit = new javax.swing.JPanel();
        jbPilihPenyakit = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        LPenyakit = new javax.swing.JLabel();
        panelPenyebab = new javax.swing.JPanel();
        jbPilihPenyebab = new javax.swing.JButton();
        jrPenyakit = new javax.swing.JRadioButton();
        jrHama = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lidpenyakit = new javax.swing.JLabel();
        lidobat = new javax.swing.JLabel();
        lidhama = new javax.swing.JLabel();
        panel_bawah = new javax.swing.JPanel();
        jBUlang = new javax.swing.JButton();
        jBKembali = new javax.swing.JButton();
        jBDetail = new javax.swing.JButton();
        jbSimpan = new javax.swing.JButton();
        jBLanjut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(450, 310));

        panel_tengah.setMinimumSize(new java.awt.Dimension(260, 130));
        panel_tengah.setPreferredSize(new java.awt.Dimension(305, 200));
        panel_tengah.setLayout(new java.awt.BorderLayout());

        panelGejalaDanNilai.setPreferredSize(new java.awt.Dimension(459, 200));
        panelGejalaDanNilai.setLayout(new java.awt.BorderLayout());

        panelNilai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nilai", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        panelNilai.setPreferredSize(new java.awt.Dimension(459, 70));

        buttonGroup1.add(jrYa);
        jrYa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrYa.setText("Ya");
        panelNilai.add(jrYa);

        buttonGroup1.add(jrTidak);
        jrTidak.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jrTidak.setText("Tidak");
        panelNilai.add(jrTidak);

        panelGejalaDanNilai.add(panelNilai, java.awt.BorderLayout.CENTER);

        panelGejala.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gejala", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        panelGejala.setPreferredSize(new java.awt.Dimension(22, 140));
        panelGejala.setLayout(new java.awt.BorderLayout());

        panel_info.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_info.setMaximumSize(new java.awt.Dimension(300, 32767));
        panel_info.setMinimumSize(new java.awt.Dimension(300, 0));
        panel_info.setPreferredSize(new java.awt.Dimension(300, 30));

        linfo_pertanyaan.setText("Gejala ke 1 dari ..");
        panel_info.add(linfo_pertanyaan);

        panelGejala.add(panel_info, java.awt.BorderLayout.PAGE_END);

        LGejala.setBackground(new java.awt.Color(255, 255, 255));
        LGejala.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        LGejala.setText("-");
        jScrollPane2.setViewportView(LGejala);

        panelGejala.add(jScrollPane2, java.awt.BorderLayout.CENTER);
        panelGejala.add(idgejala, java.awt.BorderLayout.LINE_END);

        panelGejalaDanNilai.add(panelGejala, java.awt.BorderLayout.PAGE_START);

        panel_tengah.add(panelGejalaDanNilai, java.awt.BorderLayout.PAGE_END);

        panelPenyakitDanObat.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        panelPenyakitDanObat.setLayout(new java.awt.BorderLayout());

        panelObat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pilih Obat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        panelObat.setPreferredSize(new java.awt.Dimension(459, 100));
        panelObat.setLayout(new java.awt.BorderLayout());

        jbPilihObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/folder_explore.png"))); // NOI18N
        jbPilihObat.setText("Pilih Obat...");
        jbPilihObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPilihObatActionPerformed(evt);
            }
        });
        panelObat.add(jbPilihObat, java.awt.BorderLayout.PAGE_END);

        LObat.setBackground(new java.awt.Color(255, 255, 255));
        LObat.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        LObat.setText("Obat belum ditentukan");
        jScrollPane6.setViewportView(LObat);

        panelObat.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        panelPenyakitDanObat.add(panelObat, java.awt.BorderLayout.CENTER);

        panelPenyakit.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Penyakit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        panelPenyakit.setMaximumSize(new java.awt.Dimension(2147483647, 100));
        panelPenyakit.setPreferredSize(new java.awt.Dimension(22, 100));
        panelPenyakit.setLayout(new java.awt.BorderLayout());

        jbPilihPenyakit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/folder_explore.png"))); // NOI18N
        jbPilihPenyakit.setText("Pilih Penyakit...");
        jbPilihPenyakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPilihPenyakitActionPerformed(evt);
            }
        });
        panelPenyakit.add(jbPilihPenyakit, java.awt.BorderLayout.PAGE_END);

        jScrollPane4.setMaximumSize(new java.awt.Dimension(32767, 100));

        LPenyakit.setBackground(new java.awt.Color(255, 255, 255));
        LPenyakit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        LPenyakit.setText("Penyakit belum ditentukan");
        jScrollPane4.setViewportView(LPenyakit);

        panelPenyakit.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        panelPenyakitDanObat.add(panelPenyakit, java.awt.BorderLayout.PAGE_START);

        panelPenyebab.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Penyebab", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        panelPenyebab.setPreferredSize(new java.awt.Dimension(22, 100));
        panelPenyebab.setLayout(new java.awt.BorderLayout());

        jbPilihPenyebab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/terima.png"))); // NOI18N
        jbPilihPenyebab.setText("Pilih Penyebab");
        jbPilihPenyebab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPilihPenyebabActionPerformed(evt);
            }
        });
        panelPenyebab.add(jbPilihPenyebab, java.awt.BorderLayout.PAGE_END);

        buttonGroup2.add(jrPenyakit);
        jrPenyakit.setText("Penyakit");
        panelPenyebab.add(jrPenyakit, java.awt.BorderLayout.PAGE_START);

        buttonGroup2.add(jrHama);
        jrHama.setText("Hama");
        panelPenyebab.add(jrHama, java.awt.BorderLayout.LINE_START);

        panelPenyakitDanObat.add(panelPenyebab, java.awt.BorderLayout.PAGE_START);

        panel_tengah.add(panelPenyakitDanObat, java.awt.BorderLayout.LINE_END);

        getContentPane().add(panel_tengah, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(305, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Form Pembuatan Keputusan");
        jPanel2.add(jLabel1);
        jPanel2.add(lidpenyakit);
        jPanel2.add(lidobat);
        jPanel2.add(lidhama);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        panel_bawah.setPreferredSize(new java.awt.Dimension(305, 40));

        jBUlang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/arrow_undo.png"))); // NOI18N
        jBUlang.setText("Ulang");
        jBUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUlangActionPerformed(evt);
            }
        });
        panel_bawah.add(jBUlang);

        jBKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/arrow_left.png"))); // NOI18N
        jBKembali.setText("Kembali");
        jBKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBKembaliActionPerformed(evt);
            }
        });
        panel_bawah.add(jBKembali);

        jBDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/book_open.png"))); // NOI18N
        jBDetail.setText("Detail Gejala");
        jBDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDetailActionPerformed(evt);
            }
        });
        panel_bawah.add(jBDetail);

        jbSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/simpan.png"))); // NOI18N
        jbSimpan.setText("Simpan Keputusan");
        jbSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSimpanActionPerformed(evt);
            }
        });
        panel_bawah.add(jbSimpan);

        jBLanjut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/arrow_right.png"))); // NOI18N
        jBLanjut.setText("Lanjut");
        jBLanjut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLanjutActionPerformed(evt);
            }
        });
        panel_bawah.add(jBLanjut);

        getContentPane().add(panel_bawah, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUlangActionPerformed
        // TODO add your handling code here:
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        caturan = new c_buat_aturan();
        LGejala.setText(caturan.tampilkanGejala(0));
        idgejala.setText(Integer.toString(caturan.ambilID(0)));
        caturan.kosongkanPilihan();
        getPTengah().remove(getPPenyakitObat());
        getPTengah().add(getPGejalaNilai());
        jBLanjut.setEnabled(true);
        jBDetail.setVisible(true);
        jBKembali.setVisible(true);
        getBSimpan().setVisible(false);
        getBUlang().setVisible(false);
        getBKembali().setEnabled(false);
        lidhama.setText("");
        lidobat.setText("");
        lidpenyakit.setText("");
        LObat.setText("Obat Belum ditentukan");
        LPenyakit.setText("Penyakit Belum ditentukan");
        panelPenyakitDanObat.remove(panelPenyakit); 
        panelPenyakitDanObat.add(panelPenyebab); 
        linfo_pertanyaan.setText("Gejala ke "+Integer.toString(caturan.jmlDataPilihan()+1)+" dari "+caturan.jmlDataGejala());
        panel_tengah.updateUI();
    }//GEN-LAST:event_jBUlangActionPerformed

    private void jBKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBKembaliActionPerformed
        // TODO add your handling code here:
        caturan.hapusPilihan(idgejala.getText());
        int jmlx = caturan.jmlDataPilihan()==0 ? 1 : caturan.jmlDataPilihan();
        linfo_pertanyaan.setText("Gejala ke "+Integer.toString(jmlx)+" dari "+caturan.jmlDataGejala());
        if (caturan.jmlDataPilihan()==0){
            jBKembali.setEnabled(false); 
        } else {
        LGejala.setText(caturan.tampilkanGejala(caturan.jmlDataPilihan()-1));
        idgejala.setText(Integer.toString(caturan.ambilID(caturan.jmlDataPilihan()-1)));
        jScrollPane2.updateUI();
        }
    }//GEN-LAST:event_jBKembaliActionPerformed

    private void jBDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDetailActionPerformed
        // TODO add your handling code here:
        new JFDetailPertanyaan(caturan.jmlDataPilihan()).setVisible(true);
    }//GEN-LAST:event_jBDetailActionPerformed

    private void jbSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSimpanActionPerformed
        // TODO add your handling code here:
        caturan.insert(this);
    }//GEN-LAST:event_jbSimpanActionPerformed

    private void jBLanjutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLanjutActionPerformed
        // TODO add your handling code here:
       String pilihan = null;
       if (jrYa.isSelected()==false && jrTidak.isSelected()==false){
         JOptionPane.showMessageDialog(this, "Pilih Ya atau Tidak!");
       } else {
           // Simpan Pilihan
           if(jrYa.isSelected()){ pilihan = "1"; }else if (jrTidak.isSelected()){ pilihan = "0"; } 
           buttonGroup1.clearSelection();
           buttonGroup2.clearSelection();
           caturan.addPilihan(idgejala.getText(), pilihan);
           jrTidak.repaint();
           caturan = new c_buat_aturan();
           if (caturan.jmlDataPilihan()==caturan.jmlDataGejala()){
                 panel_tengah.remove(panelGejalaDanNilai);
                 panel_tengah.add(panelPenyakitDanObat);
                 jBDetail.setVisible(false);
                 jBKembali.setEnabled(true);
                 jbSimpan.setVisible(true);
                 jBLanjut.setEnabled(false);
                 jBKembali.setVisible(false);
                 jBUlang.setVisible(true);
                 panel_tengah.updateUI();
            } else { 
              LGejala.setText(caturan.tampilkanGejala(caturan.jmlDataPilihan()));
              idgejala.setText(Integer.toString(caturan.ambilID(caturan.jmlDataPilihan())));
              linfo_pertanyaan.setText("Gejala ke "+Integer.toString(caturan.jmlDataPilihan()+1)+" dari "+caturan.jmlDataGejala());
              getBKembali().setEnabled(true);
              jScrollPane2.updateUI();
            }
       }
    }//GEN-LAST:event_jBLanjutActionPerformed

    private void jbPilihPenyakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPilihPenyakitActionPerformed
        // TODO add your handling code here:
        if (jbPilihPenyakit.getText()=="Pilih Penyakit..."){
        new JFPenyakit(this).setVisible(true);
        } else if (jbPilihPenyakit.getText()=="Pilih Hama..."){
            new JFHama(this).setVisible(true);
        }
    }//GEN-LAST:event_jbPilihPenyakitActionPerformed

    private void jbPilihObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPilihObatActionPerformed
        // TODO add your handling code here:
        new JFObat(this).setVisible(true);
    }//GEN-LAST:event_jbPilihObatActionPerformed

    private void jbPilihPenyebabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPilihPenyebabActionPerformed
        // TODO add your handling code here:
       
       if (jrHama.isSelected()){
           
            panelPenyakitDanObat.setLayout(new BorderLayout());
            panelPenyakitDanObat.remove(panelPenyebab); 
            panelPenyakitDanObat.remove(panelObat);
            panelPenyakit.setBorder(BorderFactory.createTitledBorder("Pilih Hama"));
            LPenyakit.setText("Hama Belum ditentukan");
            jbPilihPenyakit.setText("Pilih Hama...");
            panelPenyakitDanObat.add(panelPenyakit,BorderLayout.PAGE_START);
            panelPenyakitDanObat.add(panelObat,BorderLayout.PAGE_END);
            panelPenyakitDanObat.updateUI();
       
            } else if (jrPenyakit.isSelected()){
                
                panelPenyakitDanObat.setLayout(new BorderLayout());
                panelPenyakitDanObat.remove(panelPenyebab);  
                panelPenyakitDanObat.remove(panelObat);
                panelPenyakit.setBorder(BorderFactory.createTitledBorder("Pilih Penyakit"));
                LPenyakit.setText("Penyakit Belum ditentukan");
                jbPilihPenyakit.setText("Pilih Penyakit...");
                panelPenyakitDanObat.add(panelPenyakit,BorderLayout.PAGE_START);
                panelPenyakitDanObat.add(panelObat,BorderLayout.PAGE_END);
                panelPenyakitDanObat.updateUI();
                
       } else {
           JOptionPane.showMessageDialog(this, "Pilih penyebab terlebih dahulu!");
       }
    }//GEN-LAST:event_jbPilihPenyebabActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LGejala;
    private javax.swing.JLabel LObat;
    private javax.swing.JLabel LPenyakit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel idgejala;
    private javax.swing.JButton jBDetail;
    private javax.swing.JButton jBKembali;
    private javax.swing.JButton jBLanjut;
    private javax.swing.JButton jBUlang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton jbPilihObat;
    private javax.swing.JButton jbPilihPenyakit;
    private javax.swing.JButton jbPilihPenyebab;
    private javax.swing.JButton jbSimpan;
    private javax.swing.JRadioButton jrHama;
    private javax.swing.JRadioButton jrPenyakit;
    private javax.swing.JRadioButton jrTidak;
    private javax.swing.JRadioButton jrYa;
    private javax.swing.JLabel lidhama;
    private javax.swing.JLabel lidobat;
    private javax.swing.JLabel lidpenyakit;
    private javax.swing.JLabel linfo_pertanyaan;
    private javax.swing.JPanel panelGejala;
    private javax.swing.JPanel panelGejalaDanNilai;
    private javax.swing.JPanel panelNilai;
    private javax.swing.JPanel panelObat;
    private javax.swing.JPanel panelPenyakit;
    private javax.swing.JPanel panelPenyakitDanObat;
    private javax.swing.JPanel panelPenyebab;
    private javax.swing.JPanel panel_bawah;
    private javax.swing.JPanel panel_info;
    private javax.swing.JPanel panel_tengah;
    // End of variables declaration//GEN-END:variables
}
