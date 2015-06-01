/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.etf.unsa.si.app.ui;

import ba.etf.unsa.si.app.comparator.PotrosacComparator;
import ba.etf.unsa.si.app.globals.CurrentlyLoggedIn;
import ba.etf.unsa.si.app.renderer.PotrosacRenderer;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.services.PotrosacService;

import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Azra
 */
public class PotrosacPanel3 extends javax.swing.JPanel {

    /**
     * Creates new form PotrosacPanel3
     */
    public PotrosacPanel3() {
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
        listaPretraga = new javax.swing.JList();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        imePretraga = new javax.swing.JTextField();
        jmbgPretraga = new javax.swing.JFormattedTextField();
        prezimePretraga = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        izbrisiBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Odabir potrošača", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        listaPretraga.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        listaPretraga.setForeground(new java.awt.Color(0, 102, 153));
        jScrollPane1.setViewportView(listaPretraga);

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 153));
        jLabel15.setText("po JMBG");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 153));
        jLabel16.setText("po imenu");

        imePretraga.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        imePretraga.setForeground(new java.awt.Color(0, 102, 153));
        imePretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                imePretragaKeyReleased(evt);
            }
        });

        jmbgPretraga.setForeground(new java.awt.Color(0, 102, 153));
        jmbgPretraga.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        jmbgPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jmbgPretragaKeyReleased(evt);
            }
        });

        prezimePretraga.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        prezimePretraga.setForeground(new java.awt.Color(0, 102, 153));
        prezimePretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prezimePretragaKeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 153));
        jLabel18.setText("po prezimenu");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(imePretraga)
                    .addComponent(jmbgPretraga)
                    .addComponent(prezimePretraga)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(5, 5, 5)
                .addComponent(imePretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(5, 5, 5)
                .addComponent(prezimePretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jmbgPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        izbrisiBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        izbrisiBtn.setForeground(new java.awt.Color(0, 102, 153));
        izbrisiBtn.setText("IZBRIŠI / OBNOVI");
        izbrisiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izbrisiBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(izbrisiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(izbrisiBtn)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imePretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imePretragaKeyReleased
        updateListu();
        if(imePretraga.getText().isEmpty() || imePretraga.getText().replaceAll("\\s","").length() == 0 ){
            listaPretraga.clearSelection();
            DefaultListModel listModel = (DefaultListModel) listaPretraga.getModel();
            listModel.removeAllElements();
        }
    }//GEN-LAST:event_imePretragaKeyReleased

    private void jmbgPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmbgPretragaKeyReleased
        updateListu();
        if(jmbgPretraga.getText().isEmpty() || jmbgPretraga.getText().replaceAll("\\s","").length() == 0 ){
            listaPretraga.clearSelection();
            DefaultListModel listModel = (DefaultListModel) listaPretraga.getModel();
            listModel.removeAllElements();
        }
    }//GEN-LAST:event_jmbgPretragaKeyReleased
    
    private void updateListu(){
        PotrosacService servis = new PotrosacService();
        List<Potrosac> listaPotrosac = servis.searchByCriteria(imePretraga.getText(), "", jmbgPretraga.getText());
        DefaultListModel<Potrosac> model = new DefaultListModel<Potrosac>();
        model.removeAllElements();
        Collections.sort(listaPotrosac,new PotrosacComparator());
        
        ListCellRenderer x = new PotrosacRenderer();
        for (Potrosac p : listaPotrosac) {
            model.addElement(p);
        }    
        listaPretraga.setCellRenderer(x);
        listaPretraga.setModel(model);   
    }
    private void izbrisiBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izbrisiBtnActionPerformed
        PotrosacService servicePretraga = new PotrosacService();
        Potrosac p = (Potrosac) listaPretraga.getSelectedValue();
        if(CurrentlyLoggedIn.korisnik.getAdmin() != null && !CurrentlyLoggedIn.korisnik.getAdmin()){
        	JOptionPane.showMessageDialog(null,"Samo administrator može izbrisati potrošača.");
        	return;
        }
        
        String msg = "";
        if(p.getHidden()){
            msg = "obnovili potrošački račun.";
        }
        else{
            msg = "obrisali potrošački račun.";
        }
        try{
            servicePretraga.deletePotrosac(p);
            JOptionPane.showMessageDialog(null,"Uspješno ste " + msg);
            imePretraga.setText("");
            prezimePretraga.setText("");
            jmbgPretraga.setText("");
            listaPretraga.clearSelection();
            DefaultListModel listModel = (DefaultListModel) listaPretraga.getModel();
            listModel.removeAllElements();         
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Greška!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_izbrisiBtnActionPerformed

    private void prezimePretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prezimePretragaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_prezimePretragaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField imePretraga;
    private javax.swing.JButton izbrisiBtn;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jmbgPretraga;
    private javax.swing.JList listaPretraga;
    private javax.swing.JTextField prezimePretraga;
    // End of variables declaration//GEN-END:variables
}
