/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.etf.unsa.si.app.ui;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import ba.unsa.etf.si.app.entity.Ocitanja;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.services.OcitanjaService;
import ba.unsa.etf.si.app.services.PotrosacService;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Azra
 */
public class OcitanjaPanel3 extends javax.swing.JPanel {

    /**
     * Creates new form OcitanjaPanel3
     */
    public OcitanjaPanel3() {
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
        jList1 = new javax.swing.JList();
        jLabel16 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        DefaultListModel model = new DefaultListModel();
        PotrosacService servicePotrosaca = new PotrosacService();
        List<Potrosac> listPotrosaca = servicePotrosaca.dajSvePotrosace();
        String sifra = "";
        jList1.setModel(model);
        
        for (Potrosac p : listPotrosaca) {      
        	if(String.valueOf(p.getSifraVodomjera()).contains(sifra)){
                model.addElement(p.getSifraVodomjera());
        	}
        }
        
        jTextField7.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent arg0) {
        		
        		TxtSifraVodomjeraBrisanjeKeyReleased(arg0);
        		
        	}
        });
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseReleased(MouseEvent arg0) {
        		
        		BtnIzbrisiOcitanjeActionPerformed(arg0);
        	}
        });

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Odabir vodomjera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        jScrollPane1.setViewportView(jList1);

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 153));
        jLabel16.setText("po šifri ");

        jTextField7.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField7)
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
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Izbriši očitanje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setText("Period (mm/yyyy)");

        jFormattedTextField4.setForeground(new java.awt.Color(0, 102, 153));
        try {
            jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/20##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextField4.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 153));
        jButton1.setText("IZBRIŠI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void BtnIzbrisiOcitanjeActionPerformed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSpasiNovoOcitanjeActionPerformed
        try{
        	if(jList1.isSelectionEmpty()==true)
        	{
        		throw new IllegalArgumentException("Niste izabrali vodomjer!");
        	}
        	
        	
            int sifraVodomjera = Integer.valueOf(jList1.getSelectedValue().toString());
            OcitanjaService oS = new OcitanjaService();
            List<Ocitanja> o = oS.getId(sifraVodomjera);
            
            String[] x = jFormattedTextField4.getText().split("/");
            if(x[0].trim().length()==0 || x[1].trim().length()==2)
            {
            	throw new IllegalArgumentException("Niste unijeli datum ispravno!");
            }
            if(Integer.valueOf(x[0])>12||Integer.valueOf(x[0])<0){
                throw new IllegalArgumentException("Nepostojeci mjesec");
            }
            int i = Integer.valueOf(x[0]);
            int j = Integer.valueOf(x[1]);
            
            Boolean pomocna=true;
            
            for (Ocitanja tmp : o) 
            {
            	int a = tmp.getMjesec();
            	int b = tmp.getGodina();
            	
            	if(a==i && b==j)
            	{
            		pomocna=false;
            		oS.deleteOcitanja(tmp);
            		JOptionPane.showMessageDialog(null, "Uspjesno brisanje izabranog ocitanja !");
            	}
            }
            if(pomocna==true)
            {
            	throw new IllegalArgumentException("Ne postoji ocitanje sa zadanim datumom!");
            }
            jList1.removeAll();
            jFormattedTextField4.setText("");
            jTextField7.setText("");
            
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e.getMessage(),"Greska!",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void TxtSifraVodomjeraBrisanjeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSifraVodomjeraPretragaKeyReleased
        DefaultListModel model = new DefaultListModel();
        jList1.setModel(model);
        jList1.removeAll();
        model.removeAllElements();
    try{
        PotrosacService servicePotrosaca = new PotrosacService();
        List<Potrosac> listPotrosaca = servicePotrosaca.dajSvePotrosace();
        List<Potrosac> modelListPotrosaca = new ArrayList<Potrosac>();
        String sifra = jTextField7.getText();
        for (Potrosac listPotrosaca1 : listPotrosaca) {
            if(String.valueOf(listPotrosaca1.getSifraVodomjera()).contains(sifra)){
                modelListPotrosaca.add(listPotrosaca1);
            }
        }
        for (Potrosac p : modelListPotrosaca) {
            model.addElement(p.getSifraVodomjera());
        }
        
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage(),"Greska!",JOptionPane.ERROR_MESSAGE);
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
