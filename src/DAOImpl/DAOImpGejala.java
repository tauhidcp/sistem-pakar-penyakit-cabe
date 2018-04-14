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
import model.m_gejala;
import DAO.DAOGejala;

/**
 *
 * @author tauhid
 */
public class DAOImpGejala implements DAOGejala{
    
    Connection kon;
    JFUtama utama;
    
    public DAOImpGejala(JFUtama utama){
        
        this.utama = utama;
    }

    @Override
    public List<m_gejala>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_gejala> lis = null;
        
        try{
            
          String sql = "select * from gejala order by id asc";

          lis = new ArrayList<m_gejala>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_gejala fi = new m_gejala();
                   fi.setId(rslt.getInt("id"));
                   fi.setNama(rslt.getString("nama_gejala"));
                   fi.setPertanyaan(rslt.getString("pertanyaan"));
                   fi.setDetail(rslt.getString("detail"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    public void add(m_gejala u){

        kon = new koneksi().connection();
        
        String nama = u.getNama();
        String det = u.getDetail();
        String per = u.getPertanyaan();
        
        try{
            String sql="insert into gejala(nama_gejala,pertanyaan,detail) values(?,?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,nama);
                stmt.setString(2,per);
                stmt.setString(3,det);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }

    public void edit(m_gejala u){

        kon = new koneksi().connection();
        
        String nama = u.getNama();
        String per = u.getPertanyaan();
        String det = u.getDetail();
        int id = u.getId();
        
        try{
            String sql="update gejala set nama_gejala=?, pertanyaan=?, detail=? where id=?";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,nama);
                stmt.setString(2,per);
                stmt.setString(3,det);
                stmt.setInt(4,id);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }    
    
    public void remove(String id){
        
        kon = new koneksi().connection();
        
        try{
            
            String sql="delete from gejala where id="+id;
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Data Gejala GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }
}    

