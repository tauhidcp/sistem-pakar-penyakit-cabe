/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOPenyakit;
import DAOImpl.DAOImpPenyakit;
import java.util.List;
import model.m_penyakit;
import tablemodel.tm_penyakit;
import view.JFPenyakit;
import view.JFUtama;

/**
 *
 * @author tauhid
 */
public class c_penyakit_list {
    
    JFUtama utama;
    JFPenyakit penyakit;
    DAOPenyakit impl;
    List<m_penyakit> lis;
    
    public c_penyakit_list(JFPenyakit penyakit){
        this.penyakit = penyakit;
        impl = new DAOImpPenyakit(this.utama);
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_penyakit tm = new tm_penyakit(lis);
        penyakit.getDataTable().setModel(tm);
    }    
    

}