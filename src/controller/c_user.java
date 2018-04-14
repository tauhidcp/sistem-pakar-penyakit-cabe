/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOUser;
import DAOImpl.DAOImpUser;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_user;
import tablemodel.tm_user;
import view.JFAddPengguna;
import view.JFUtama;
import view.PDataPengguna;

/**
 *
 * @author tauhid
 */
public class c_user {
    
    JFUtama utama;
    PDataPengguna user;
    DAOUser impl;
    List<m_user> lis;
    
    public c_user(PDataPengguna user, JFUtama utama){
        this.utama = utama;
        this.user = user;
        impl = new DAOImpUser(this.utama);
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_user tm = new tm_user(lis);
        user.getDataTable().setModel(tm);
        user.getJmlUser().setText("Jumlah Pengguna : "+Integer.toString(lis.size())+" Buah");
    }    
    
    public void delete(String id){           
        impl.remove(id);
    }
        
    public void insert(JFAddPengguna data){
        
        if (!data.getUser().getText().trim().isEmpty()
                && !data.getPass().getText().trim().isEmpty()){
            
            m_user u = new m_user();
            u.setUser(data.getUser().getText());
            u.setPass(data.getPass().getText().trim());
            impl.add(u);
            JOptionPane.showMessageDialog(data, "Data Pengguna Berhasil disimpan!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void update(JFAddPengguna data){
        
        if (!data.getUser().getText().trim().isEmpty()
                && !data.getPass().getText().trim().isEmpty()){
            
            m_user u = new m_user();
            u.setId(Integer.parseInt(data.getID().getText()));
            u.setUser(data.getUser().getText());
            u.setPass(data.getPass().getText().trim());
            impl.edit(u);
            JOptionPane.showMessageDialog(data, "Data Pengguna Berhasil diperbarui!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
}
