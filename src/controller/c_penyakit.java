/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOPenyakit;
import DAOImpl.DAOImpPenyakit;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_penyakit;
import tablemodel.tm_penyakit;
import view.JFAddPenyakit;
import view.JFUtama;
import view.PDataPenyakit;

/**
 *
 * @author tauhid
 */
public class c_penyakit {
    
    JFUtama utama;
    PDataPenyakit penyakit;
    DAOPenyakit impl;
    List<m_penyakit> lis;
    
    public c_penyakit(PDataPenyakit penyakit, JFUtama utama){
        this.utama = utama;
        this.penyakit = penyakit;
        impl = new DAOImpPenyakit(this.utama);
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_penyakit tm = new tm_penyakit(lis);
        penyakit.getDataTable().setModel(tm);
        penyakit.getJmlData().setText("Jumlah Penyakit : "+Integer.toString(lis.size())+" Buah");
    }    
    
    public void delete(String id){           
        impl.remove(id);
    }
        
    public void insert(JFAddPenyakit data){
        
        if (!data.getNama().getText().trim().isEmpty()
                && !data.getDes().getText().trim().isEmpty()){
            
            m_penyakit u = new m_penyakit();
            u.setNama(data.getNama().getText());
            u.setDeskripsi(data.getDes().getText().trim());
            impl.add(u);
            JOptionPane.showMessageDialog(data, "Data Penyakit Berhasil disimpan!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void update(JFAddPenyakit data){
        
        if (!data.getNama().getText().trim().isEmpty()
                && !data.getDes().getText().trim().isEmpty()){
            
            m_penyakit u = new m_penyakit();
            u.setNama(data.getNama().getText());
            u.setDeskripsi(data.getDes().getText().trim());
            u.setId(Integer.parseInt(data.getID().getText().trim()));
            impl.edit(u);
            JOptionPane.showMessageDialog(data, "Data Penyakit Berhasil diperbarui!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
}