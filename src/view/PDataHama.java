/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.c_hama;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author tauhid
 */
public class PDataHama extends javax.swing.JPanel {

    JFUtama utama;
    c_hama chama;
    /**
     * Creates new form PDataPenyakit
     */
    public PDataHama(JFUtama utama) {
        initComponents();
        this.utama = utama;
    }

        public JTable getDataTable(){
        return tabel_data;
    }
    
    public JLabel getJmlData(){
        return ljumlahdata;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InternalFrame = new javax.swing.JInternalFrame();
        Panel_Tengah = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        btn_tutup = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_data = new javax.swing.JTable();
        panel_bawah = new javax.swing.JPanel();
        ljumlahdata = new javax.swing.JLabel();

        InternalFrame.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        InternalFrame.setTitle("Data Hama Cabe");
        InternalFrame.setToolTipText("");
        InternalFrame.setVisible(true);

        Panel_Tengah.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/tmbah.png"))); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_tutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/cancel.png"))); // NOI18N
        btn_tutup.setText("Tutup");
        btn_tutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tutupActionPerformed(evt);
            }
        });

        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/hapus.png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/application_edit.png"))); // NOI18N
        btn_ubah.setText("Ubah");
        btn_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_TengahLayout = new javax.swing.GroupLayout(Panel_Tengah);
        Panel_Tengah.setLayout(Panel_TengahLayout);
        Panel_TengahLayout.setHorizontalGroup(
            Panel_TengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TengahLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_tambah)
                .addGap(11, 11, 11)
                .addComponent(btn_ubah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_hapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_tutup)
                .addContainerGap())
        );
        Panel_TengahLayout.setVerticalGroup(
            Panel_TengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TengahLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_TengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(btn_tutup)
                    .addComponent(btn_hapus)
                    .addComponent(btn_ubah))
                .addContainerGap())
        );

        tabel_data.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        tabel_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel_data);

        panel_bawah.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_bawah.setMaximumSize(new java.awt.Dimension(850, 32771));
        panel_bawah.setPreferredSize(new java.awt.Dimension(644, 30));

        ljumlahdata.setText("Jumlah Hama : ");
        panel_bawah.add(ljumlahdata);

        javax.swing.GroupLayout InternalFrameLayout = new javax.swing.GroupLayout(InternalFrame.getContentPane());
        InternalFrame.getContentPane().setLayout(InternalFrameLayout);
        InternalFrameLayout.setHorizontalGroup(
            InternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
            .addComponent(Panel_Tengah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel_bawah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        InternalFrameLayout.setVerticalGroup(
            InternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InternalFrameLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_bawah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Tengah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InternalFrame)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InternalFrame)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        new JFAddHama(this,utama).setVisible(true);
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_tutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tutupActionPerformed
        // TODO add your handling code here:
        utama.getBack().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_tutupActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        if (tabel_data.getSelectedRow()>=0){
            int dialogResult = JOptionPane.showConfirmDialog (this, "Anda Yakin Akan Menghapus Hama Ini?","Peringatan",JOptionPane.WARNING_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION){
                chama = new c_hama(this, this.utama);
                String id = tabel_data.getValueAt(tabel_data.getSelectedRow(),0).toString();
                chama.delete(id);
                chama.isiTabel();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih Data Hama Pada Tabel Sebelum Hapus","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
        // TODO add your handling code here:
        if (tabel_data.getSelectedRow()>=0){
            JFAddHama user = new JFAddHama(this,this.utama);
            user.setAlwaysOnTop(true);
            user.setTitle("Form Ubah Data Hama");
            user.getJudul().setText("Form Edit Data Hama");
            user.getButton().setText("Update Hama");
            user.getID().setVisible(false);
            user.getID().setText(tabel_data.getValueAt(tabel_data.getSelectedRow(),0).toString());
            user.getNama().setText((String) tabel_data.getValueAt(tabel_data.getSelectedRow(),1));
            user.getDes().setText((String) tabel_data.getValueAt(tabel_data.getSelectedRow(),2));
            user.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih Data Hama Pada Tabel Sebelum Edit","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_ubahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame InternalFrame;
    private javax.swing.JPanel Panel_Tengah;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_tutup;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ljumlahdata;
    private javax.swing.JPanel panel_bawah;
    private javax.swing.JTable tabel_data;
    // End of variables declaration//GEN-END:variables
}