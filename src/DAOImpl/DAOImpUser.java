/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import DAO.DAOUser;
import config.koneksi;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.m_user;
import view.JFUtama;

/**
 *
 * @author tauhid
 */
public class DAOImpUser implements DAOUser{
    
    Connection kon;
    JFUtama utama;
    
    public DAOImpUser(JFUtama utama){
        
        this.utama = utama;
    }

    @Override
    public List<m_user>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_user> lis = null;
        
        try{
            
          String sql = "select * from pengguna order by id asc";

          lis = new ArrayList<m_user>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_user fi = new m_user();
                   fi.setId(rslt.getInt("id"));
                   fi.setUser(rslt.getString("username"));
                   fi.setPass(rslt.getString("password"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }

    public List<m_user>prosesLogin(String user, String pass){
        
        kon = new koneksi().connection();
        
        List<m_user> lis = null;
        
        try{
            
          String sql = "select * from pengguna where username='"+user+"' AND password='"+pass+"'";

          lis = new ArrayList<m_user>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_user fi = new m_user();
                   fi.setId(rslt.getInt("id"));
                   fi.setUser(rslt.getString("username"));
                   fi.setPass(rslt.getString("password"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    public void add(m_user u){

        kon = new koneksi().connection();
        
        String nama = u.getUser();
        String pass = get_SHA_512_SecurePassword(u.getPass(),"aplikasi");
        
        try{
            String sql="insert into pengguna(username,password) values(?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,nama);
                stmt.setString(2,pass);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }

    public void edit(m_user u){

        kon = new koneksi().connection();
        
        String nama = u.getUser();
        String pass = get_SHA_512_SecurePassword(u.getPass(),"aplikasi");
        int id = u.getId();
        
        try{
            String sql="update pengguna set username=?, password=? where id=?";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,nama);
                stmt.setString(2,pass);
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
            
            String sql="delete from pengguna where id="+id;
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Pengguna GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }        
    
    public String get_SHA_512_SecurePassword(String passwordToHash, String   salt){
        String generatedPassword = null;
        try {
             MessageDigest md = MessageDigest.getInstance("SHA-512");
            try {
                md.update(salt.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(DAOImpUser.class.getName()).log(Level.SEVERE, null, ex);
            }
             byte[] bytes = null;
            try {
                bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(DAOImpUser.class.getName()).log(Level.SEVERE, null, ex);
            }
             StringBuilder sb = new StringBuilder();
             for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
             }
             generatedPassword = sb.toString();
            } 
           catch (NoSuchAlgorithmException e){
            e.printStackTrace();
           }
        return generatedPassword;
    }
    
}

