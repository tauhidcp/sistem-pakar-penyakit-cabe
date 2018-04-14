/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOObat;
import DAOImpl.DAOImpObat;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_obat;
import tablemodel.tm_obat;
import view.JFAddObat;
import view.JFUtama;
import view.PDataObat;

/**
 *
 * @author tauhid
 */
public class c_obat {
    
    JFUtama utama;
    PDataObat obat;
    DAOObat impl;
    List<m_obat> lis;
    
    public c_obat(PDataObat obat, JFUtama utama){
        this.utama = utama;
        this.obat = obat;
        impl = new DAOImpObat(this.utama);
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_obat tm = new tm_obat(lis);
        obat.getDataTable().setModel(tm);
        obat.getJmlData().setText("Jumlah Obat : "+Integer.toString(lis.size())+" Buah");
    }    
    
    public void delete(String id){           
        impl.remove(id);
    }
        
    public void insert(JFAddObat data){
        
        if (!data.getNama().getText().trim().isEmpty()
                && !data.getDes().getText().trim().isEmpty()){
            
            m_obat u = new m_obat();
            u.setNama(data.getNama().getText());
            u.setDeskripsi(data.getDes().getText().trim());
            impl.add(u);
            JOptionPane.showMessageDialog(data, "Data Obat Berhasil disimpan!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void update(JFAddObat data){
        
        if (!data.getNama().getText().trim().isEmpty()
                && !data.getDes().getText().trim().isEmpty()){
            
            m_obat u = new m_obat();
            u.setNama(data.getNama().getText());
            u.setDeskripsi(data.getDes().getText().trim());
            u.setId(Integer.parseInt(data.getID().getText().trim()));
            impl.edit(u);
            JOptionPane.showMessageDialog(data, "Data Obat Berhasil diperbarui!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
}
