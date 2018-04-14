/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_obat;

/**
 *
 * @author tauhid
 */

public interface DAOObat {
    
    public List<m_obat>getAll();
    
    public void add(m_obat mi);
    
    public void edit(m_obat mi);
    
    public void remove(String id);
    
}

