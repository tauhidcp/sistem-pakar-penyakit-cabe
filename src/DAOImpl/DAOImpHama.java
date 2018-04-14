/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import view.JFUtama;
import model.m_hama;
import DAO.DAOHama;

/**
 *
 * @author tauhid
 */
public class DAOImpHama implements DAOHama{
    
    Connection kon;
    JFUtama utama;
    
    public DAOImpHama(JFUtama utama){
        
        this.utama = utama;
    }

    @Override
    public List<m_hama>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_hama> lis = null;
        
        try{
            
          String sql = "select * from hama where id!='0' order by id asc";

          lis = new ArrayList<m_hama>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_hama fi = new m_hama();
                   fi.setId(rslt.getInt("id"));
                   fi.setNama(rslt.getString("nama_hama"));
                   fi.setDeskripsi(rslt.getString("deskripsi"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    public void add(m_hama u){

        kon = new koneksi().connection();
        
        String nama = u.getNama();
        String des = u.getDeskripsi();
        
        try{
            String sql="insert into hama(nama_hama,deskripsi) values(?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,nama);
                stmt.setString(2,des);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }

    public void edit(m_hama u){

        kon = new koneksi().connection();
        
        String nama = u.getNama();
        String des = u.getDeskripsi();
        int id = u.getId();
        
        try{
            String sql="update hama set nama_hama=?, deskripsi=? where id=?";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,nama);
                stmt.setString(2,des);
                stmt.setInt(3,id);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }    
    
    public void remove(String id){
        
        kon = new koneksi().connection();
        
        try{
            
            String sql="delete from hama where id="+id;
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Data Hama GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }
}    
