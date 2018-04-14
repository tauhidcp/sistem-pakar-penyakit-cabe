/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOGejala;
import DAOImpl.DAOImpGejala;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_gejala;
import tablemodel.tm_gejala;
import view.JFAddGejala;
import view.JFUtama;
import view.PDataGejala;

/**
 *
 * @author tauhid
 */
public class c_gejala {
    
    JFUtama utama;
    PDataGejala gejala;
    DAOGejala impl;
    List<m_gejala> lis;
    
    public c_gejala(PDataGejala gejala, JFUtama utama){
        this.utama = utama;
        this.gejala = gejala;
        impl = new DAOImpGejala(this.utama);
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_gejala tm = new tm_gejala(lis);
        gejala.getDataTable().setModel(tm);
        gejala.getJmlData().setText("Jumlah Gejala : "+Integer.toString(lis.size())+" Buah");
    }    
    
    public void delete(String id){           
        impl.remove(id);
    }
        
    public void insert(JFAddGejala data){
        
        if (!data.getNama().getText().trim().isEmpty()
                && !data.getDes().getText().trim().isEmpty()){
            
            m_gejala u = new m_gejala();
            u.setNama(data.getNama().getText());
            u.setPertanyaan(data.getPer().getText().trim());
            u.setDetail(data.getDes().getText().trim());
            impl.add(u);
            JOptionPane.showMessageDialog(data, "Data Gejala Berhasil disimpan!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void update(JFAddGejala data){
        
        if (!data.getNama().getText().trim().isEmpty()
                && !data.getDes().getText().trim().isEmpty()){
            
            m_gejala u = new m_gejala();
            u.setNama(data.getNama().getText());
            u.setPertanyaan(data.getPer().getText().trim());
            u.setDetail(data.getDes().getText().trim());
            u.setId(Integer.parseInt(data.getID().getText().trim()));
            impl.edit(u);
            JOptionPane.showMessageDialog(data, "Data Gejala Berhasil diperbarui!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
}
