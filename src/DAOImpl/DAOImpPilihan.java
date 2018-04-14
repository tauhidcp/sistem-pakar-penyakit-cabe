/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import DAO.DAOPilihan;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.m_keputusan;
import model.m_pilihan;
import view.JFUtama;

/**
 *
 * @author tauhid
 */
public class DAOImpPilihan implements DAOPilihan{
    
    Connection kon;
    JFUtama utama;
    
    public DAOImpPilihan(JFUtama utama){
        
        this.utama = utama;
    }

    @Override
    public List<m_pilihan>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_pilihan> lis = null;
        
        try{
            
          String sql = "select * from tmp_pilihan order by id asc";

          lis = new ArrayList<m_pilihan>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_pilihan fi = new m_pilihan();
                   fi.setId(rslt.getInt("id"));
                   fi.setIdgejala(rslt.getString("id_gejala"));
                   fi.setNilai(rslt.getString("nilai"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }

    public List<m_pilihan>ambilSemua(){
        
        kon = new koneksi().connection();
        
        List<m_pilihan> lis = null;
        
        try{
            
           String sql = "SELECT gejala.nama_gejala as ngejala, tmp_pilihan.nilai as nilai " +
                       "FROM (tmp_pilihan " +
                       "INNER JOIN gejala ON gejala.id=tmp_pilihan.id_gejala)";


          lis = new ArrayList<m_pilihan>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_pilihan fi = new m_pilihan();
                   fi.setIdgejala(rslt.getString("ngejala"));
                   fi.setNilai(rslt.getString("nilai"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    public void add(m_pilihan u){

        kon = new koneksi().connection();
        
        String idgejala = u.getIdgejala();
        String nilai = u.getNilai();
        
        try{
            String sql="insert into tmp_pilihan(id_gejala,nilai) values(?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,idgejala);
                stmt.setString(2,nilai);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }   
    
    public void remove(){
        
        kon = new koneksi().connection();
        
        try{
            
            String sql="truncate tmp_pilihan";
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Tabel tmp_pilihan GAGAL dikosongkan!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }        

    public void simpan(m_keputusan u){

        kon = new koneksi().connection();

        String idp = u.getIdpenyakit();
        String idh = u.getIdhama();
        String ido = u.getIdobat();
        String nilai = "";
        
        try{
            String sql = "SELECT * from tmp_pilihan";
            Statement stm=kon.createStatement();
            ResultSet rsl=stm.executeQuery(sql);
            while(rsl.next()){
                if (!nilai.isEmpty()){
                nilai = nilai +"-"+ rsl.getString("nilai");
                }else { nilai = rsl.getString("nilai");}
            }
        } catch(Exception e){
        }
        
        try{
            
            String sql="insert into tabel_keputusan(nilai_gejala,id_penyakit,id_hama,id_obat) values(?,?,?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,nilai);
                stmt.setString(2,idp);
                stmt.setString(3,idh);
                stmt.setString(4,ido);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
        
        remove();
    }   
    
    public List<m_keputusan>hasilAnalisa(){
        
        kon = new koneksi().connection();
        
        List<m_keputusan> lis = null;
        
        String nilai = "";
        
        try{
            String sql = "SELECT * from tmp_pilihan";
            Statement stm=kon.createStatement();
            ResultSet rsl=stm.executeQuery(sql);
            while(rsl.next()){
                if (!nilai.isEmpty()){
                nilai = nilai +"-"+ rsl.getString("nilai");
                }else { nilai = rsl.getString("nilai");}
            }
        } catch(Exception e){
        }
        
        try{
            
          String sql = "SELECT tabel_keputusan.id_penyakit as id_penyakit, tabel_keputusan.id_hama as id_hama, penyakit.nama_penyakit as namap, hama.nama_hama as namah, obat.nama_obat as namao, obat.deskripsi as deskripsio " +
                       "FROM (((tabel_keputusan " +
                       "INNER JOIN penyakit ON penyakit.id=tabel_keputusan.id_penyakit) " +
                       "INNER JOIN obat ON obat.id=tabel_keputusan.id_obat) " +
                       "INNER JOIN hama ON hama.id=tabel_keputusan.id_hama) where tabel_keputusan.nilai_gejala='"+nilai+"'";

          lis = new ArrayList<m_keputusan>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_keputusan fi = new m_keputusan();
                   fi.setIdhama(rslt.getString("id_hama"));
                   fi.setIdpenyakit(rslt.getString("id_penyakit"));
                   fi.setNamap(rslt.getString("namap"));
                   fi.setNamah(rslt.getString("namah"));
                   fi.setIdobat(rslt.getString("namao"));
                   fi.setDeskripsio(rslt.getString("deskripsio"));
                   lis.add(fi);   
               }

        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    public void hapus(String id){
        
        kon = new koneksi().connection();
        
        
        try{
            
            String sql="delete from tmp_pilihan where id_gejala="+id;
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Data tmp_pilihan GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }   
}


