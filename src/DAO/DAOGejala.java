/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_gejala;

/**
 *
 * @author tauhid
 */

public interface DAOGejala {
    
    public List<m_gejala>getAll();
    
    public void add(m_gejala mi);
    
    public void edit(m_gejala mi);
    
    public void remove(String id);
    
}

