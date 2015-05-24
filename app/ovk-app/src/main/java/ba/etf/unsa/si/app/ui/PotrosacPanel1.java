/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.etf.unsa.si.app.ui;

import ba.unsa.etf.si.app.dao.PotrosacDAO;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.services.PotrosacService;
import javax.swing.JOptionPane;

/**
 *
 * @author Azra
 */
public class PotrosacPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form Panel
     */
    public PotrosacPanel1() {
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

        tipPotrosaca = new javax.swing.ButtonGroup();
        tipUsluge = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        porodica = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        tipPausalac = new javax.swing.JRadioButton();
        tipVodomjer = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        uslugaVoda = new javax.swing.JRadioButton();
        uslugaKanalizacija = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        aktivnost = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        sifraVodomjera = new javax.swing.JTextField();
        jpanellicnipodaci = new javax.swing.JPanel();
        ime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        prezime = new javax.swing.JTextField();
        adresa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        telefon = new javax.swing.JFormattedTextField();
        jmbg = new javax.swing.JFormattedTextField();
        spasiButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(500, 450));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Podaci o usluzi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 153));
        jLabel11.setText("Broj članova domaćinstva");

        porodica.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        porodica.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 153));
        jLabel12.setText("Tip potrošača");

        tipPausalac.setBackground(new java.awt.Color(255, 255, 255));
        tipPotrosaca.add(tipPausalac);
        tipPausalac.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        tipPausalac.setForeground(new java.awt.Color(102, 102, 102));
        tipPausalac.setSelected(true);
        tipPausalac.setText("paušalni");

        tipVodomjer.setBackground(new java.awt.Color(255, 255, 255));
        tipPotrosaca.add(tipVodomjer);
        tipVodomjer.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        tipVodomjer.setForeground(new java.awt.Color(102, 102, 102));
        tipVodomjer.setText("s vodomjerom");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("Usluga");

        uslugaVoda.setBackground(new java.awt.Color(255, 255, 255));
        tipUsluge.add(uslugaVoda);
        uslugaVoda.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        uslugaVoda.setForeground(new java.awt.Color(102, 102, 102));
        uslugaVoda.setSelected(true);
        uslugaVoda.setText("voda");

        uslugaKanalizacija.setBackground(new java.awt.Color(255, 255, 255));
        tipUsluge.add(uslugaKanalizacija);
        uslugaKanalizacija.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        uslugaKanalizacija.setForeground(new java.awt.Color(102, 102, 102));
        uslugaKanalizacija.setText("voda i kanalizacija");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 153));
        jLabel14.setText("Aktivnost");

        aktivnost.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        aktivnost.setForeground(new java.awt.Color(0, 102, 153));
        aktivnost.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "aktivan", "neaktivan" }));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 153));
        jLabel15.setText("Šifra vodomjera");

        sifraVodomjera.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        sifraVodomjera.setForeground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(porodica, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(aktivnost, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipVodomjer)
                            .addComponent(tipPausalac)
                            .addComponent(uslugaVoda)
                            .addComponent(uslugaKanalizacija)))
                    .addComponent(jLabel15)
                    .addComponent(sifraVodomjera, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(porodica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipPausalac)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipVodomjer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sifraVodomjera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uslugaVoda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uslugaKanalizacija)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aktivnost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jpanellicnipodaci.setBackground(new java.awt.Color(255, 255, 255));
        jpanellicnipodaci.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lični podaci", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        ime.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        ime.setForeground(new java.awt.Color(0, 102, 153));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("Ime");

        prezime.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        prezime.setForeground(new java.awt.Color(0, 102, 153));

        adresa.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        adresa.setForeground(new java.awt.Color(0, 102, 153));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 153));
        jLabel7.setText("Prezime");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setText("Adresa");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setText("Telefon");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 153));
        jLabel10.setText("JMBG");

        telefon.setForeground(new java.awt.Color(0, 102, 153));
        try {
            telefon.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0##/###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telefon.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jmbg.setForeground(new java.awt.Color(0, 102, 153));
        try {
            jmbg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jmbg.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        javax.swing.GroupLayout jpanellicnipodaciLayout = new javax.swing.GroupLayout(jpanellicnipodaci);
        jpanellicnipodaci.setLayout(jpanellicnipodaciLayout);
        jpanellicnipodaciLayout.setHorizontalGroup(
            jpanellicnipodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanellicnipodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanellicnipodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(ime)
                    .addComponent(prezime)
                    .addComponent(adresa)
                    .addComponent(telefon, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jmbg))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jpanellicnipodaciLayout.setVerticalGroup(
            jpanellicnipodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanellicnipodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jmbg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        spasiButton.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        spasiButton.setForeground(new java.awt.Color(0, 102, 153));
        spasiButton.setText("SPASI");
        spasiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spasiButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spasiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpanellicnipodaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel1, jpanellicnipodaci});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpanellicnipodaci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(spasiButton)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jpanellicnipodaci});

    }// </editor-fold>//GEN-END:initComponents

    private void spasiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spasiButtonActionPerformed
        try{
        Potrosac p = new Potrosac();
        PotrosacService servis = new PotrosacService();
        p.setIme(ime.getText());
        p.setAdresa(adresa.getText());
        switch(aktivnost.getSelectedIndex()){
            case 0 :         
                p.setAktivnost(true);
                break;
            case 1 :
                p.setAktivnost(false);
        }
        p.setBrojClanova(porodica.getValue().toString());
        p.setHidden(false);
        p.setJmbg(jmbg.getText());
        p.setPrezime(prezime.getText());
        p.setTelefon(telefon.getText());
        if(tipPausalac.isSelected()){
            p.setKategorija("Pausalac");
        }
        else {
            p.setKategorija("Sa vodomjerom");
            try{
                p.setSifraVodomjera(Integer.valueOf(sifraVodomjera.getText()));
            }
            catch(Exception e){
                throw new IllegalArgumentException("Sifra vodomjera mora biti unesena za odabranu kategoriju");
            }
        }
        
        if(uslugaVoda.isSelected()){
            p.setUsluga(Boolean.FALSE);
        }
        else{
            p.setUsluga(Boolean.TRUE);
        }
            servis.createNewPotrosac(p);
            
            JOptionPane.showMessageDialog(null,"Dodavanje novog potrosaca je uspjesno");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error",
                                    JOptionPane.ERROR_MESSAGE);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_spasiButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresa;
    private javax.swing.JComboBox aktivnost;
    private javax.swing.JTextField ime;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField jmbg;
    private javax.swing.JPanel jpanellicnipodaci;
    private javax.swing.JSpinner porodica;
    private javax.swing.JTextField prezime;
    private javax.swing.JTextField sifraVodomjera;
    private javax.swing.JButton spasiButton;
    private javax.swing.JFormattedTextField telefon;
    private javax.swing.JRadioButton tipPausalac;
    private javax.swing.ButtonGroup tipPotrosaca;
    private javax.swing.ButtonGroup tipUsluge;
    private javax.swing.JRadioButton tipVodomjer;
    private javax.swing.JRadioButton uslugaKanalizacija;
    private javax.swing.JRadioButton uslugaVoda;
    // End of variables declaration//GEN-END:variables
}
