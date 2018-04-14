/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.m_user;

/**
 *
 * @author tauhid
 */

public class tm_user extends AbstractTableModel{
    
    List<m_user> lis;
    
    public tm_user(List<m_user> lis){
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
        case 1  : return "Username";
        case 2  : return "Password";
        default : return null;
    }
    }
    
    public Object getValueAt(int row, int column){
       switch(column){
           case 0  : return lis.get(row).getId();
           case 1  : return lis.get(row).getUser();
           case 2  : return lis.get(row).getPass();
           default : return null;
       }
    }
}