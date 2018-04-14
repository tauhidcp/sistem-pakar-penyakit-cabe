/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_keputusan;

/**
 *
 * @author tauhid
 */

public interface DAOKeputusan {
    
    public List<m_keputusan>getAll();
    
    public void remove(String id);
    
}
