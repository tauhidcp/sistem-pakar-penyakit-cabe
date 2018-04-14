/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOGejala;
import DAO.DAOPilihan;
import DAOImpl.DAOImpPilihan;
import DAOImpl.DAOImpGejala;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_gejala;
import model.m_keputusan;
import model.m_pilihan;
import view.JFBuatKeputusan;
import view.JFUtama;

/**
 *
 * @author tauhid
 */
public class c_buat_aturan {
    
    JFUtama utama;
    DAOGejala impl;
    DAOPilihan implp;
    List<m_gejala> lis;
    List<m_pilihan> lisp;
    List<m_keputusan> lisk;
    
    public c_buat_aturan(){
        this.utama = utama;
        impl = new DAOImpGejala(this.utama);
        implp = new DAOImpPilihan(this.utama);
    }
    
    public int jmlDataPilihan(){
        lisp = implp.getAll();
        return lisp.size();
    }    
    
    public int jmlDataGejala(){
        lis = impl.getAll();
        return lis.size();
    } 

    public String tampilkanGejala(int row){
        lis = impl.getAll();
        String gejala = lis.get(row).getNama();
        return gejala;
    }
        
    public int ambilID(int row){
        lis = impl.getAll();
        int idx = lis.get(row).getId();
        return idx;
    }
    
    public void kosongkanPilihan(){
    
    implp.remove();
    }
    
    public String tampilkanDetail(int row){
        lis = impl.getAll();
        String detail = lis.get(row).getDetail();
        return detail;
    }
    
    public void addPilihan(String id, String pilihan){
            
        m_pilihan u = new m_pilihan();
            
        u.setIdgejala(id);
        u.setNilai(pilihan);
            
        implp.add(u);
    }
    
    public void hapusPilihan(String id){
        
        implp.hapus(id);
    }
    
    public void insert(JFBuatKeputusan data){
        
        lisk = implp.hasilAnalisa();
        
        if (lisk.size()==0){
            
            String idhama = null;
            String idpenyakit = null;

            if (data.getIdHama().getText().trim().isEmpty() && data.getIdPenyakit().getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(data, "Hama atau Penyakit belum ditentukan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
            } else if (data.getIdObat().getText().trim().isEmpty()){ 
                JOptionPane.showMessageDialog(data, "Obat belum ditentukan!!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
            } else {    

                if (data.getIdHama().getText().isEmpty()){ 
                    idhama = "0";
                } else { idhama = data.getIdHama().getText(); }

                if (data.getIdPenyakit().getText().isEmpty()){ 
                    idpenyakit = "0";
                } else { idpenyakit = data.getIdPenyakit().getText(); }

                m_keputusan u = new m_keputusan();

                u.setIdhama(idhama);
                u.setIdobat(data.getIdObat().getText());
                u.setIdpenyakit(idpenyakit);

                implp.simpan(u);

                JOptionPane.showMessageDialog(data, "Data Keputusan Berhasil disimpan!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        }
        } else {
            JOptionPane.showMessageDialog(data, "Aturan sudah tersimpan sebelumnya!","Sukses",JOptionPane.WARNING_MESSAGE);
        }
    }
        
}


