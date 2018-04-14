/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.m_gejala;

/**
 *
 * @author tauhid
 */

public class tm_gejala extends AbstractTableModel{
    
    List<m_gejala> lis;
    
    public tm_gejala(List<m_gejala> lis){
    this.lis = lis;
    }
    
    public int getColumnCount(){
        return 4;
    }
    
    public int getRowCount(){
        return lis.size();
    }
    
    public String getColumnName(int column){
    switch (column){
        case 0  : return "ID";
        case 1  : return "Nama Gejala";
        case 2  : return "Pertanyaan";
        case 3  : return "Detail Gejala";
        default : return null;
    }
    }
    
    public Object getValueAt(int row, int column){
       switch(column){
           case 0  : return lis.get(row).getId();
           case 1  : return lis.get(row).getNama();
           case 2  : return lis.get(row).getPertanyaan();
           case 3  : return lis.get(row).getDetail();
           default : return null;
       }
    }
}
