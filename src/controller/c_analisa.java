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
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import model.m_gejala;
import model.m_keputusan;
import model.m_pilihan;
import tablemodel.tm_pilihan;
import view.JFAnalisa;
import view.JFUtama;

/**
 *
 * @author tauhid
 */
public class c_analisa {
    
    JFUtama utama;
    DAOGejala impl;
    DAOPilihan implp;
    List<m_gejala> lis;
    List<m_pilihan> lisp;
    List<m_keputusan> lisk;
    
    public c_analisa(){
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
    
    public String tampilkanPertanyaan(int row){
        lis = impl.getAll();
        String pertanyaan = lis.get(row).getPertanyaan();
        return pertanyaan;
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
    
    public void analisa(JFAnalisa data){
        
        JPanel pPenyakit = data.getPPenyakit();
        JLabel lpenyakit = data.getLPenyakit();
        JLabel lstatus = data.getLStatus();
        JLabel lobat = data.getLObat();
        JPanel ptengah = data.getPTengah();
        JButton bsimpan = data.getBSimpan();
            
        lisk = implp.hasilAnalisa();
        // Ada atau tidak
        if (lisk.size() >= 1){
            // Penyakit
            if (Integer.parseInt(lisk.get(0).getIdhama())==0){
               pPenyakit.setBorder(BorderFactory.createTitledBorder("Penyakit"));
               lpenyakit.setText(lisk.get(0).getNamap());
               lstatus.setText("Penyakit");
            // Hama
            } else if (Integer.parseInt(lisk.get(0).getIdpenyakit())==0){
               pPenyakit.setBorder(BorderFactory.createTitledBorder("Hama"));
               lpenyakit.setText(lisk.get(0).getNamah()); 
               lstatus.setText("Hama");
            }
            lobat.setText(lisk.get(0).getIdobat()+" ("+lisk.get(0).getDeskripsio()+") ");
            bsimpan.setVisible(true);
            bsimpan.setEnabled(true);
            ptengah.updateUI();
        } else {
            pPenyakit.setBorder(BorderFactory.createTitledBorder("Penyakit"));
            lstatus.setText("");
            JOptionPane.showMessageDialog(data, "Hasil analisa tidak ada yang cocok dengan tabel keputusan");
            bsimpan.setVisible(true);
            bsimpan.setEnabled(false);
        }
        
        } 
    
    public void cetak(JFAnalisa data, String dir){
        
        String[] headers = new String[] {"No", "Nama Gejala", "Nilai"};
        lisp = implp.ambilSemua();
        tm_pilihan tm = new tm_pilihan(lisp);
        data.getDataTable().setModel(tm);

        Document document = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(dir+".pdf")));
            document.open();
            String kata = "                                       Hasil Analisa Penyakit Cabe\n\n";
            Paragraph para = new Paragraph(new Phrase(kata.toUpperCase(), new Font(Font.HELVETICA, 14, Font.NORMAL)));
            document.add(para);  
            
            PdfPTable pdfTable = new PdfPTable(headers.length);
            for (int i = 0; i < headers.length; i++) {
                String header = headers[i];
                PdfPCell cell = new PdfPCell();
                cell.setGrayFill(0.9f);
                cell.setPhrase(new Phrase(header, new Font(Font.HELVETICA, 11, Font.BOLD)));
                pdfTable.addCell(cell);
            }
            pdfTable.completeRow();
            int z=1;
            for (int a=0; a<lis.size(); a++){
            
    
            Object obj_1 = getObject(data.getDataTable(), a, 1);
            Object obj_2 = getObject(data.getDataTable(), a, 2);         

            String b = obj_1.toString();
            String c = obj_2.toString();


            pdfTable.addCell(Integer.toString(z));
            pdfTable.addCell(b);
            pdfTable.addCell(c);
            
            z++;
            pdfTable.completeRow();          
            }
            
            document.add(pdfTable);
            
            
            String hasil = "\n                Penyebab Gejala adalah ["+data.getLStatus().getText()+"] : \n";
            Paragraph phasil = new Paragraph(new Phrase(hasil, new Font(Font.HELVETICA, 12, Font.NORMAL)));
            document.add(phasil);            
            String hasilp = "               "+data.getLPenyakit().getText()+" \n\n";
            Paragraph phasil2 = new Paragraph(new Phrase(hasilp, new Font(Font.HELVETICA, 12, Font.NORMAL)));
            document.add(phasil2); 

            String hasilo = "               Obat yang direkomendasikan : \n";
            Paragraph phasilo = new Paragraph(new Phrase(hasilo, new Font(Font.HELVETICA, 12, Font.NORMAL)));
            document.add(phasilo); 
            String hasilo2 = "               "+data.getLObat().getText()+"\n\n";
            Paragraph phasilo2 = new Paragraph(new Phrase(hasilo2, new Font(Font.HELVETICA, 12, Font.NORMAL)));
            document.add(phasilo2);      
            
            document.addTitle("Hasil Analisa");
            document.close();
            JOptionPane.showMessageDialog(data, "Hasil Analisa berhasil dicetak menjadi pdf ke "+dir+".pdf","Berhasil",JOptionPane.INFORMATION_MESSAGE);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }    
    }
    
        public Object getObject(JTable tabel,int idx_baris,int idx_kolom){
	return tabel.getModel().getValueAt(idx_baris, idx_kolom);
    }
}