/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_keputusan;
import model.m_pilihan;

/**
 *
 * @author tauhid
 */

public interface DAOPilihan {
    
    public List<m_pilihan>getAll();
    
    public List<m_pilihan>ambilSemua();
    
    public List<m_keputusan>hasilAnalisa();
    
    public void add(m_pilihan mi);
    
    public void simpan(m_keputusan mi);

    public void hapus(String id);
    
    public void remove();
    
}

