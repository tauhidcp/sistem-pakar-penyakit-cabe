/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOHama;
import DAOImpl.DAOImpHama;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_hama;
import tablemodel.tm_hama;
import view.JFAddHama;
import view.JFUtama;
import view.PDataHama;

/**
 *
 * @author tauhid
 */
public class c_hama {
    
    JFUtama utama;
    PDataHama hama;
    DAOHama impl;
    List<m_hama> lis;
    
    public c_hama(PDataHama hama, JFUtama utama){
        this.utama = utama;
        this.hama = hama;
        impl = new DAOImpHama(this.utama);
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_hama tm = new tm_hama(lis);
        hama.getDataTable().setModel(tm);
        hama.getJmlData().setText("Jumlah Hama : "+Integer.toString(lis.size())+" Buah");
    }    
    
    public void delete(String id){           
        impl.remove(id);
    }
        
    public void insert(JFAddHama data){
        
        if (!data.getNama().getText().trim().isEmpty()
                && !data.getDes().getText().trim().isEmpty()){
            
            m_hama u = new m_hama();
            u.setNama(data.getNama().getText());
            u.setDeskripsi(data.getDes().getText().trim());
            impl.add(u);
            JOptionPane.showMessageDialog(data, "Data Hama Berhasil disimpan!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void update(JFAddHama data){
        
        if (!data.getNama().getText().trim().isEmpty()
                && !data.getDes().getText().trim().isEmpty()){
            
            m_hama u = new m_hama();
            u.setNama(data.getNama().getText());
            u.setDeskripsi(data.getDes().getText().trim());
            u.setId(Integer.parseInt(data.getID().getText().trim()));
            impl.edit(u);
            JOptionPane.showMessageDialog(data, "Data Hama Berhasil diperbarui!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
}
