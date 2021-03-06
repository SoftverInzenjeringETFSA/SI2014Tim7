/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.etf.unsa.si.app.ui;

import ba.etf.unsa.si.app.comparator.KorisnikComparator;
import ba.etf.unsa.si.app.globals.CurrentlyLoggedIn;
import ba.etf.unsa.si.app.renderer.KorisnikRenderer;
import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.services.KorisnikService;

import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Azra
 */
public class KorisniciPanel3 extends javax.swing.JPanel {

    /**
     * Creates new form KorisniciPanel3
     */
    public KorisniciPanel3() {
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
        listaZaBrisanje = new javax.swing.JList();
        jLabel16 = new javax.swing.JLabel();
        pretragaKorisnikaZaBrisanje = new javax.swing.JTextField();
        obrisiBtn = new javax.swing.JButton();
        status = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Odabir korisnika", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        listaZaBrisanje.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        listaZaBrisanje.setForeground(new java.awt.Color(0, 102, 153));
        listaZaBrisanje.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaZaBrisanjeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaZaBrisanje);

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 153));
        jLabel16.setText("Username");

        pretragaKorisnikaZaBrisanje.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        pretragaKorisnikaZaBrisanje.setForeground(new java.awt.Color(0, 102, 153));
        pretragaKorisnikaZaBrisanje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pretragaKorisnikaZaBrisanjeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(pretragaKorisnikaZaBrisanje)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(5, 5, 5)
                .addComponent(pretragaKorisnikaZaBrisanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        obrisiBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        obrisiBtn.setForeground(new java.awt.Color(0, 102, 153));
        obrisiBtn.setText("IZBRIŠI");
        obrisiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obrisiBtnActionPerformed(evt);
            }
        });

        status.setEditable(false);
        status.setBackground(new java.awt.Color(255, 255, 255));
        status.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        status.setForeground(new java.awt.Color(255, 51, 51));
        status.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        status.setBorder(null);
        status.setOpaque(false);
        status.setSelectionColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(status)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obrisiBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(obrisiBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pretragaKorisnikaZaBrisanjeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pretragaKorisnikaZaBrisanjeKeyReleased
        
        status.setText("");
        KorisnikService servicePretraga = new KorisnikService();
        List<Korisnik> korisnikLista = servicePretraga.searchByUsername(pretragaKorisnikaZaBrisanje.getText());
        DefaultListModel<Korisnik> model = new DefaultListModel<Korisnik>();
        model.removeAllElements();
        Collections.sort(korisnikLista,new KorisnikComparator());
        
        ListCellRenderer x = new KorisnikRenderer();
        for (Korisnik k : korisnikLista) {
            model.addElement(k);
        }    
        listaZaBrisanje.setCellRenderer(x);
        listaZaBrisanje.setModel(model);
        
        if(pretragaKorisnikaZaBrisanje.getText().isEmpty() || pretragaKorisnikaZaBrisanje.getText().replaceAll("\\s","").length() == 0 ){
            DefaultListModel listModel = (DefaultListModel) listaZaBrisanje.getModel();
            listModel.removeAllElements();
        }
    }//GEN-LAST:event_pretragaKorisnikaZaBrisanjeKeyReleased

    private void obrisiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obrisiBtnActionPerformed
        if(listaZaBrisanje.getSelectedValue() == null){
            status.setText("Niste odabrali korisnika");
        }
        else{
            
            try{
            String username  = listaZaBrisanje.getSelectedValue().toString();
            KorisnikService servicePretraga = new KorisnikService();
            Korisnik k = (Korisnik) listaZaBrisanje.getSelectedValue();
            if(CurrentlyLoggedIn.korisnik.getAdmin() != null && !CurrentlyLoggedIn.korisnik.getAdmin()){
                status.setText("Samo administrator može izbrisati korisnički nalog");
            	return;
            }
            if(k.getUsername().equals(CurrentlyLoggedIn.korisnik.getUsername())){
                status.setText("Ne možete vršiti tu opciju nad svojim korisničkim nalogom");
            	return;
            }
            if("admin".equals(k.getUsername())){
                status.setText("Ne možete mijenjati tog korisnika!");
            	return;
            }
            servicePretraga.deleteKorisnik(k);
            pretragaKorisnikaZaBrisanje.setText("");
            status.setText("");
            DefaultListModel listModel = (DefaultListModel) listaZaBrisanje.getModel();
            listModel.removeAllElements();
            JOptionPane.showMessageDialog(null,"Uspješno ste obrisali korisnika ");
            }
            catch(Exception e){
                //JOptionPane.showMessageDialog(null, e.getMessage(),"Greska!",
                //        JOptionPane.ERROR_MESSAGE);
                status.setText(e.getMessage());
            }
        }    
       
    }//GEN-LAST:event_obrisiBtnActionPerformed

    private void listaZaBrisanjeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaZaBrisanjeValueChanged
        status.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_listaZaBrisanjeValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listaZaBrisanje;
    private javax.swing.JButton obrisiBtn;
    private javax.swing.JTextField pretragaKorisnikaZaBrisanje;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}
