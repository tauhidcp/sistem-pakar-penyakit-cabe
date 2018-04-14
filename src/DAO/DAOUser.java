/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_user;

/**
 *
 * @author tauhid
 */

public interface DAOUser {
    
    public List<m_user>getAll();
    
    public List<m_user>prosesLogin(String user, String pass);
    
    public void add(m_user mi);
    
    public void edit(m_user mi);
    
    public void remove(String id);
    
}
