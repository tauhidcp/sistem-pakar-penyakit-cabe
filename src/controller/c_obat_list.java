/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOObat;
import DAOImpl.DAOImpObat;
import java.util.List;
import model.m_obat;
import tablemodel.tm_obat;
import view.JFObat;
import view.JFUtama;

/**
 *
 * @author tauhid
 */
public class c_obat_list {
    
    JFUtama utama;
    JFObat obat;
    DAOObat impl;
    List<m_obat> lis;
    
    public c_obat_list(JFObat obat){
        this.utama = utama;
        this.obat = obat;
        impl = new DAOImpObat(this.utama);
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_obat tm = new tm_obat(lis);
        obat.getDataTable().setModel(tm);
    }    
}
