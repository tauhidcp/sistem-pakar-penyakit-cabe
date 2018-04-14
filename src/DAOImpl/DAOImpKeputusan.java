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
import model.m_keputusan;
import DAO.DAOKeputusan;

/**
 *
 * @author tauhid
 */
public class DAOImpKeputusan implements DAOKeputusan{
    
    Connection kon;
    JFUtama utama;
    
    public DAOImpKeputusan(JFUtama utama){
        
        this.utama = utama;
    }

    @Override
    public List<m_keputusan>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_keputusan> lis = null;
        
        try{
            
          String sql = "SELECT tabel_keputusan.id as no, tabel_keputusan.nilai_gejala as ngejala, " +
                       "penyakit.nama_penyakit as namap, hama.nama_hama as namah, obat.nama_obat as namao " +
                       "FROM (((tabel_keputusan " +
                       "INNER JOIN penyakit ON penyakit.id=tabel_keputusan.id_penyakit) " +
                       "INNER JOIN obat ON obat.id=tabel_keputusan.id_obat) " +
                       "INNER JOIN hama ON hama.id=tabel_keputusan.id_hama)";

          lis = new ArrayList<m_keputusan>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_keputusan fi = new m_keputusan();
                   fi.setId(rslt.getInt("no"));
                   fi.setNilaigejala(rslt.getString("ngejala"));
                   fi.setIdpenyakit(rslt.getString("namap"));
                   fi.setIdhama(rslt.getString("namah"));
                   fi.setIdobat(rslt.getString("namao"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    
    public void remove(String id){
        
        kon = new koneksi().connection();
        
        try{
            
            String sql="delete from tabel_keputusan where id="+id;
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Data Keputusan GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }
}    


