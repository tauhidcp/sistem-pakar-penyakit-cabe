/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_penyakit;

/**
 *
 * @author tauhid
 */

public interface DAOPenyakit {
    
    public List<m_penyakit>getAll();
    
    public void add(m_penyakit mi);
    
    public void edit(m_penyakit mi);
    
    public void remove(String id);
    
}

