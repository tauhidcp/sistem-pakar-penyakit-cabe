/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOKeputusan;
import DAOImpl.DAOImpKeputusan;
import java.util.List;
import model.m_keputusan;
import tablemodel.tm_keputusan;
import view.JFUtama;
import view.PTabelKeputusan;

/**
 *
 * @author tauhid
 */
public class c_keputusan {
    
    JFUtama utama;
    PTabelKeputusan tkeputusan;
    DAOKeputusan impl;
    List<m_keputusan> lis;
    
    public c_keputusan(PTabelKeputusan tkeputusan, JFUtama utama){
        this.utama = utama;
        this.tkeputusan = tkeputusan;
        impl = new DAOImpKeputusan(this.utama);
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_keputusan tm = new tm_keputusan(lis);
        tkeputusan.getDataTable().setModel(tm);
        tkeputusan.getJmlData().setText("Jumlah Keputusan : "+Integer.toString(lis.size())+" Buah");
    }    
    
    public void delete(String id){           
        impl.remove(id);
    }
        
}

