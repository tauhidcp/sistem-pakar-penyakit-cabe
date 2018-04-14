/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.m_pilihan;

/**
 *
 * @author tauhid
 */

public class tm_pilihan extends AbstractTableModel{
    
    List<m_pilihan> lis;
    
    public tm_pilihan(List<m_pilihan> lis){
    this.lis = lis;
    }
    
    public int getColumnCount(){
        return 3;
    }
    
    public int getRowCount(){
        return lis.size();
    }
    
    public String getColumnName(int column){
    switch (column){
        case 0  : return "ID";
        case 1  : return "Nama Gejala";
        case 2  : return "Nilai";
        default : return null;
    }
    }
    
    public Object getValueAt(int row, int column){
       switch(column){
           case 0  : return lis.get(row).getId();
           case 1  : return lis.get(row).getIdgejala();
           case 2  : return lis.get(row).getNilai();
           default : return null;
       }
    }
}
