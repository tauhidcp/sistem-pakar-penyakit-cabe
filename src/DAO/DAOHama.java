/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_hama;

/**
 *
 * @author tauhid
 */

public interface DAOHama {
    
    public List<m_hama>getAll();
    
    public void add(m_hama mi);
    
    public void edit(m_hama mi);
    
    public void remove(String id);
    
}

