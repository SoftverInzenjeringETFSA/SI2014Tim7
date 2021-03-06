/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.etf.unsa.si.app.ui;

import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.services.OcitanjaService;
import ba.unsa.etf.si.app.services.PotrosacService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Azra
 */
public class OcitanjaPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form OcitanjaPanel1
     */
    public OcitanjaPanel1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListOcitanja = new javax.swing.JList();
        jLabel16 = new javax.swing.JLabel();
        TxtSifraVodomjeraPretraga = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TxtDatum = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        TxtstanjeVodomjera = new JTextField();
        BtnSpasiNovoOcitanje = new javax.swing.JButton();
        DefaultListModel model = new DefaultListModel();
        PotrosacService servicePotrosaca = new PotrosacService();
        List<Potrosac> listPotrosaca = servicePotrosaca.dajSvePotrosace();
        ListOcitanja.setModel(model);
        
        for (Potrosac p : listPotrosaca) {      
        		if(p.getKategorija().equals("Pausalac"))
        		{
        			continue;
        		}
        		if(p.getAktivnost()==true && p.getHidden()==false)
        		{
                model.addElement(p.getSifraVodomjera());
        		}
        }

        
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Odabir vodomjera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        jScrollPane1.setViewportView(ListOcitanja);

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 153));
        jLabel16.setText("po šifri ");

        TxtSifraVodomjeraPretraga.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        TxtSifraVodomjeraPretraga.setForeground(new java.awt.Color(0, 102, 153));
        TxtSifraVodomjeraPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtSifraVodomjeraPretragaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(TxtSifraVodomjeraPretraga)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 114, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(5, 5, 5)
                .addComponent(TxtSifraVodomjeraPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Novo očitanje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setText("Period (mm/yyyy)");

        TxtDatum.setForeground(new java.awt.Color(0, 102, 153));
        try {
            TxtDatum.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/20##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TxtDatum.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 153));
        jLabel12.setText("Stanje vodomjera");

        TxtstanjeVodomjera.setForeground(new java.awt.Color(0, 102, 153));
        try {
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(TxtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(TxtstanjeVodomjera, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtstanjeVodomjera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnSpasiNovoOcitanje.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        BtnSpasiNovoOcitanje.setForeground(new java.awt.Color(0, 102, 153));
        BtnSpasiNovoOcitanje.setText("SPASI");
        BtnSpasiNovoOcitanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSpasiNovoOcitanjeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnSpasiNovoOcitanje, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(BtnSpasiNovoOcitanje)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSpasiNovoOcitanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSpasiNovoOcitanjeActionPerformed
        try{
        	if(ListOcitanja.isSelectionEmpty()==true)
        	{
        		throw new IllegalArgumentException("Niste izabrali vodomjer!");
        	}
        	else if(TxtstanjeVodomjera.getText().trim().length()==0)
        	{
        		throw new IllegalArgumentException("Niste unijeli stanje vodomjera!");
        	}
        	try{
        		Double.valueOf(TxtstanjeVodomjera.getText());
        	}
        	catch(Exception e)
        	{
        		throw new IllegalArgumentException("Pogresno stanje vodomjera, niste unijeli brojeve!");
        	}
        	try{
        		Integer.valueOf(ListOcitanja.getSelectedValue().toString());
        	}
        	catch(Exception baci)
        	{
        		throw new IllegalArgumentException("Niste selektovali ispravan vodomjer!");
        	}
        	int sifraVodomjera = Integer.valueOf(ListOcitanja.getSelectedValue().toString());
            Double novoStanje = Double.valueOf(TxtstanjeVodomjera.getText());

            OcitanjaService oS = new OcitanjaService();
            Ocitanja o = new Ocitanja();
            o.setAccess(true);
            o.setPotrosacByIdPotrosaca(oS.getPotrosac(sifraVodomjera));
            o.setPotrosnja(novoStanje);
            o.setSifraVodomjera(sifraVodomjera);

                 // potrebno ispraviti ovo ispod
            String[] x = TxtDatum.getText().split("/");
            x[1]= x[1].replaceAll("\\s","");
            if(x[0].trim().length()==0 || x[0].trim().length()==1 || x[1].trim().length()==2 || x[1].trim().length()==3)
            {
            	throw new IllegalArgumentException("Niste unijeli datum ispravno!");
            }

            if(Integer.valueOf(x[0])>12||Integer.valueOf(x[0])<0){
                throw new IllegalArgumentException("Nepostojeci mjesec!");
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
      	   //get current date time with Date()
      	   	Date date = new Date();
      	   	String sad = dateFormat.format(date);
      	   	String[] pomocna =  sad.split("/");
      	   	int godina = Integer.valueOf(pomocna[0].toString());
      	   	int mjesec = Integer.valueOf(pomocna[1].toString());
      	   	int unesenagodina = Integer.valueOf(x[1].toString());
      	   	int unesenimjesec = Integer.valueOf(x[0].toString());
      	   	
      	   	if((godina<unesenagodina && mjesec<unesenimjesec) || (godina==unesenagodina && mjesec<unesenimjesec) || (godina<unesenagodina && mjesec==unesenimjesec))
      	   	{
      	   	throw new IllegalArgumentException("Unijeli ste datum iz buducnosti!");
      	   	}
      	   	
            o.setMjesec(Integer.valueOf(x[0]));
            o.setGodina(Integer.valueOf(x[1]));
            oS.createNewOcitanja(o);
            
            ListOcitanja.removeAll();
            TxtDatum.setText("");
            TxtSifraVodomjeraPretraga.setText("");
            TxtstanjeVodomjera.setText("");
            ListOcitanja.clearSelection();
            JOptionPane.showMessageDialog(null, "Uspjesno dodavanje ocitanja za uneseni datum!");
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage(),"Greska!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnSpasiNovoOcitanjeActionPerformed

    private void TxtSifraVodomjeraPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSifraVodomjeraPretragaKeyReleased
            DefaultListModel model = new DefaultListModel();
            ListOcitanja.removeAll();
            model.removeAllElements();
            ListOcitanja.setModel(model);
        try{
            PotrosacService servicePotrosaca = new PotrosacService();
            List<Potrosac> listPotrosaca = servicePotrosaca.dajSvePotrosace();
            String sifra = TxtSifraVodomjeraPretraga.getText();
            
            for (Potrosac listPotrosaca1 : listPotrosaca) {
                if(String.valueOf(listPotrosaca1.getSifraVodomjera()).contains(sifra)){
            		if(listPotrosaca1.getKategorija().equals("Pausalac"))
            		{
            			continue;
            		}
            		if(listPotrosaca1.getAktivnost()==true && listPotrosaca1.getHidden()==false)
            		{
                    model.addElement(listPotrosaca1.getSifraVodomjera());
            		}
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Greska!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_TxtSifraVodomjeraPretragaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSpasiNovoOcitanje;
    private javax.swing.JList ListOcitanja;
    private javax.swing.JFormattedTextField TxtDatum;
    private javax.swing.JTextField TxtSifraVodomjeraPretraga;
    private JTextField TxtstanjeVodomjera;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
