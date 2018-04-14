/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.m_keputusan;

/**
 *
 * @author tauhid
 */

public class tm_keputusan extends AbstractTableModel{
    
    List<m_keputusan> lis;
    
    public tm_keputusan(List<m_keputusan> lis){
    this.lis = lis;
    }
    
    public int getColumnCount(){
        return 5;
    }
    
    public int getRowCount(){
        return lis.size();
    }
    
    public String getColumnName(int column){
    switch (column){
        case 0  : return "ID";
        case 1  : return "Nilai Gejala";
        case 2  : return "Nama Penyakit";
        case 3  : return "Nama Hama";
        case 4  : return "Nama Obat";
        default : return null;
    }
    }
    
    public Object getValueAt(int row, int column){
       switch(column){
           case 0  : return lis.get(row).getId();
           case 1  : return lis.get(row).getNilaigejala();
           case 2  : return lis.get(row).getIdpenyakit();
           case 3  : return lis.get(row).getIdhama();
           case 4  : return lis.get(row).getIdobat();
           default : return null;
       }
    }
}
