/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.c_obat_list;
import javax.swing.JTable;
import javax.swing.JOptionPane;

/**
 *
 * @author tauhid
 */
public class JFObat extends javax.swing.JFrame {

    JFBuatKeputusan aturan;
    c_obat_list cobat;
    /**
     * Creates new form JFObat
     */
    public JFObat(JFBuatKeputusan aturan) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(getRootPane());
        this.setAlwaysOnTop(true);
        this.setTitle("Pilih Obat Cabe");
        
        cobat = new c_obat_list(this);
        cobat.isiTabel();
        this.aturan = aturan;
    }
    
        public JTable getDataTable(){
        return jTable2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jbCariObat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(337, 275));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(333, 50));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbCariObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/terima.png"))); // NOI18N
        jbCariObat.setText("Pilih Obat");
        jbCariObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCariObatActionPerformed(evt);
            }
        });
        jPanel2.add(jbCariObat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, -1));

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCariObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCariObatActionPerformed
        // TODO add your handling code here:
        if (jTable2.getSelectedRow()>=0){
            aturan.getLObat().setText(jTable2.getValueAt(jTable2.getSelectedRow(),1).toString());
            aturan.getIdObat().setText(jTable2.getValueAt(jTable2.getSelectedRow(),0).toString());
            aturan.getScrollObat().updateUI();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih Data Obat Pada Tabel","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_jbCariObatActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbCariObat;
    // End of variables declaration//GEN-END:variables
}
