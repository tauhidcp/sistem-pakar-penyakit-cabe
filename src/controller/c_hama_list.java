/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOHama;
import DAOImpl.DAOImpHama;
import java.util.List;
import model.m_hama;
import tablemodel.tm_hama;
import view.JFHama;
import view.JFUtama;

/**
 *
 * @author tauhid
 */
public class c_hama_list {
    
    JFUtama utama;
    JFHama hama;
    DAOHama impl;
    List<m_hama> lis;
    
    public c_hama_list(JFHama hama){
        this.hama = hama;
        impl = new DAOImpHama(this.utama);
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_hama tm = new tm_hama(lis);
        hama.getDataTable().setModel(tm);
    }    
    
}
