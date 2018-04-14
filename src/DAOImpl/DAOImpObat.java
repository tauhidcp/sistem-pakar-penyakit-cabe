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
import model.m_obat;
import DAO.DAOObat;

/**
 *
 * @author tauhid
 */
public class DAOImpObat implements DAOObat{
    
    Connection kon;
    JFUtama utama;
    
    public DAOImpObat(JFUtama utama){
        
        this.utama = utama;
    }

    @Override
    public List<m_obat>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_obat> lis = null;
        
        try{
            
          String sql = "select * from obat order by id asc";

          lis = new ArrayList<m_obat>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_obat fi = new m_obat();
                   fi.setId(rslt.getInt("id"));
                   fi.setNama(rslt.getString("nama_obat"));
                   fi.setDeskripsi(rslt.getString("deskripsi"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    public void add(m_obat u){

        kon = new koneksi().connection();
        
        String nama = u.getNama();
        String des = u.getDeskripsi();
        
        try{
            String sql="insert into obat(nama_obat,deskripsi) values(?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,nama);
                stmt.setString(2,des);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }

    public void edit(m_obat u){

        kon = new koneksi().connection();
        
        String nama = u.getNama();
        String des = u.getDeskripsi();
        int id = u.getId();
        
        try{
            String sql="update obat set nama_obat=?, deskripsi=? where id=?";
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
            
            String sql="delete from obat where id="+id;
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Data Obat GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }
}    
