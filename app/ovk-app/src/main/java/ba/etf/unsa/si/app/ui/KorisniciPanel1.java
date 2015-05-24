/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.etf.unsa.si.app.ui;

import ba.unsa.etf.si.app.entity.Korisnik;
import ba.unsa.etf.si.app.services.KorisnikService;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Azra
 */
public class KorisniciPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form KorisniciPanel1
     */
    Logger logger;
    public KorisniciPanel1() {
        initComponents();
        //dugme nije enabled dok ne prodju provjere unosa
        //samo username je obavezno polje
        logger = Logger.getAnonymousLogger();
        BtnSaveKorisnik.setEnabled(false);
        status.setText("Oprez: sva polja su obavezna!");
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
        imeTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        prezimeTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        brlicneTxt = new javax.swing.JTextField();
        jmbgTxt = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        usernameTxt1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        dateTxt1 = new org.jdesktop.swingx.JXDatePicker();
        jPanel5 = new javax.swing.JPanel();
        adminTest = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        emailTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        adresaTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        telTxt = new javax.swing.JFormattedTextField();
        BtnSaveKorisnik = new javax.swing.JButton();
        status = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lični podaci", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        imeTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        imeTxt.setForeground(new java.awt.Color(0, 102, 153));
        imeTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                imeTxtFocusLost(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 153));
        jLabel11.setText("Ime");

        prezimeTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        prezimeTxt.setForeground(new java.awt.Color(0, 102, 153));
        prezimeTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                prezimeTxtFocusLost(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 153));
        jLabel12.setText("Prezime");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 153));
        jLabel15.setText("JMBG");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("Broj lične karte");

        brlicneTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        brlicneTxt.setForeground(new java.awt.Color(0, 102, 153));
        brlicneTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                brlicneTxtFocusLost(evt);
            }
        });

        jmbgTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jmbgTxt.setForeground(new java.awt.Color(0, 102, 153));
        jmbgTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jmbgTxtFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jmbgTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(jLabel15)
                        .addComponent(imeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(prezimeTxt)
                        .addComponent(jLabel13)
                        .addComponent(brlicneTxt)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prezimeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jmbgTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brlicneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nalog", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 153));
        jLabel23.setText("Datum zapošljavanja");

        usernameTxt1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        usernameTxt1.setForeground(new java.awt.Color(0, 102, 153));
        usernameTxt1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameTxt1FocusLost(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 153));
        jLabel24.setText("Username");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(usernameTxt1)
                    .addComponent(dateTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin Opcije", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        adminTest.setBackground(new java.awt.Color(255, 255, 255));
        adminTest.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        adminTest.setForeground(new java.awt.Color(0, 102, 153));
        adminTest.setText("Administrator");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminTest)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminTest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kontakt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        emailTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        emailTxt.setForeground(new java.awt.Color(0, 102, 153));
        emailTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailTxtKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 153));
        jLabel16.setText("E-mail");

        adresaTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        adresaTxt.setForeground(new java.awt.Color(0, 102, 153));
        adresaTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                adresaTxtFocusLost(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 153));
        jLabel18.setText("Adresa");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 153));
        jLabel19.setText("Telefon");

        telTxt.setForeground(new java.awt.Color(0, 102, 153));
        try {
            telTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0##/###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        telTxt.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        telTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                telTxtFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(emailTxt)
                    .addComponent(adresaTxt)
                    .addComponent(telTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adresaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        BtnSaveKorisnik.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        BtnSaveKorisnik.setForeground(new java.awt.Color(0, 102, 153));
        BtnSaveKorisnik.setText("SPASI");
        BtnSaveKorisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveKorisnikActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSaveKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel3, jPanel4, jPanel5, jPanel6});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BtnSaveKorisnik))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSaveKorisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveKorisnikActionPerformed
        Korisnik k = new Korisnik();
        KorisnikService dodaj = new KorisnikService();
        k.setAdmin(adminTest.isSelected());
        k.setAdresa(adresaTxt.getText());
        k.setBrojLicne(brlicneTxt.getText());
        k.setDatumZaposljenja(dateTxt1.getDate());
        k.setIme(imeTxt.getText());
        k.setJmbg(jmbgTxt.getText());
        k.setMail(emailTxt.getText());
        k.setPrezime(prezimeTxt.getText());
        k.setTelefon(telTxt.getText());
        k.setUsername(usernameTxt1.getText());
        try{
            String pass = dodaj.createNewKorisnik(k);
            adresaTxt.setText("");
            brlicneTxt.setText("");
            imeTxt.setText("");
            jmbgTxt.setText("");
            emailTxt.setText("");
            prezimeTxt.setText("");
            telTxt.setText("");
            usernameTxt1.setText("");
            JOptionPane.showMessageDialog(null, "Korisnik uspješno kreiran! Password za ovog korisnika je : " + pass);
            BtnSaveKorisnik.setEnabled(false); 
        }
        catch(Exception e){
           //JOptionPane.showMessageDialog(null, e.toString(), "Error",
           //                        JOptionPane.ERROR_MESSAGE);
            logger.log(Level.OFF, "Nisu postavljeni parametri", e);
            status.setText(e.getMessage());
        }
        
        
    }//GEN-LAST:event_BtnSaveKorisnikActionPerformed
    
    //validacija unosa username-a
    
    boolean formatUsername = false;
    
    private void usernameTxt1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTxt1FocusLost
         
        if(usernameTxt1.getText().isEmpty()){
            status.setText("Unesite username korisnika");
            formatUsername = false;
            BtnSaveKorisnik.setEnabled(false);
        }
        else{
            status.setText("");
            formatUsername = true;
        }// TODO add your handling code here:
        
        if(formatUsername && formatLicne && formatMail && pravilanJmbg && ime && prezime && adresa && telefon)
            BtnSaveKorisnik.setEnabled(true);
    }//GEN-LAST:event_usernameTxt1FocusLost

    // validacija formata licne - samo brojevi i velika slova
    
    boolean formatLicne = false;
    
    private void brlicneTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brlicneTxtFocusLost
        if(brlicneTxt.getText().matches("^[A-Z0-9]+$") && brlicneTxt.getText().length() == 9){
            status.setText("");
            formatLicne = true;
        }
        else if(brlicneTxt.getText().isEmpty()){
            status.setText("Unesite broj lične karte");
            formatLicne = false;
            BtnSaveKorisnik.setEnabled(false);
        }
        else if(brlicneTxt.getText().length() != 9){
            status.setText("Broj lične karte mora sadržavati 9 karaktera");
            formatLicne = false;
            BtnSaveKorisnik.setEnabled(false);
        } 
        else {
            status.setText("Broj lične karte nije u pravilnom formatu");
            formatLicne = false;
            BtnSaveKorisnik.setEnabled(false);
        }
        if(formatUsername && formatLicne && formatMail && pravilanJmbg && ime && prezime && adresa && telefon)
            BtnSaveKorisnik.setEnabled(true);
    }//GEN-LAST:event_brlicneTxtFocusLost

  
    
    boolean pravilanJmbg = false;
    
    private void jmbgTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jmbgTxtFocusLost
         if(jmbgTxt.getText().matches("^[0-9]*$") && jmbgTxt.getText().length() == 13){
            status.setText("");
            pravilanJmbg = true;
        }
        else if(jmbgTxt.getText().isEmpty()){
            status.setText("Unesite JMBG korisnika");
            pravilanJmbg = false;
        }
        else if(jmbgTxt.getText().length() != 13){
            status.setText("JMBG mora imati 13 cifara");
            pravilanJmbg = false;
        }
        else{
            status.setText("JMBG nije u pravilnom formatu");
            pravilanJmbg = false;
        }
        
        if(formatUsername && formatLicne && formatMail && pravilanJmbg && ime && prezime && adresa && telefon)
            BtnSaveKorisnik.setEnabled(true);// TODO add your handling code here:
    }//GEN-LAST:event_jmbgTxtFocusLost

    boolean ime = false;
    
    private void imeTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_imeTxtFocusLost
          if(imeTxt.getText().isEmpty()){
            status.setText("Unesite ime korisnika");
            ime  = false;
            BtnSaveKorisnik.setEnabled(false);
        }
        else{
            status.setText("");
            ime = true;
        }// TODO add your handling code here:
        
        if(formatUsername && formatLicne && formatMail && pravilanJmbg && ime && prezime && adresa && telefon)
            BtnSaveKorisnik.setEnabled(true);// TODO add your handling code here:
    }//GEN-LAST:event_imeTxtFocusLost

    boolean prezime = false;
    
    private void prezimeTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prezimeTxtFocusLost
        if(imeTxt.getText().isEmpty()){
            status.setText("Unesite prezime korisnika");
            prezime  = false;
            BtnSaveKorisnik.setEnabled(false);
        }
        else{
            status.setText("");
            prezime = true;
        }// TODO add your handling code here:
        
        if(formatUsername && formatLicne && formatMail && pravilanJmbg && ime && prezime && adresa && telefon)
            BtnSaveKorisnik.setEnabled(true);// TODO add your handling code here:// TODO add your handling code here:
    }//GEN-LAST:event_prezimeTxtFocusLost

    boolean adresa = false;
    
    private void adresaTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adresaTxtFocusLost
         if(adresaTxt.getText().isEmpty()){
            status.setText("Unesite adresu korisnika");
            adresa  = false;
            BtnSaveKorisnik.setEnabled(false);
        }
        else{
            status.setText("");
            adresa = true;
        }// TODO add your handling code here:
        
        if(formatUsername && formatLicne && formatMail && pravilanJmbg && ime && prezime && adresa && telefon)
            BtnSaveKorisnik.setEnabled(true);// TODO add your handling code here:
    }//GEN-LAST:event_adresaTxtFocusLost

    boolean telefon = false;
    
    private void telTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telTxtFocusLost
         if(telTxt.getText().equals("0  /   -    ")){
            status.setText("Unesite telefonski broj korisnika");
            telefon  = false;
            BtnSaveKorisnik.setEnabled(false);
        }// TODO add your handling code here:
        else{
            status.setText("");
            telefon = true;
        }// TODO add your handling code here:
        
        if(formatUsername && formatLicne && formatMail && pravilanJmbg && ime && prezime && adresa && telefon)
            BtnSaveKorisnik.setEnabled(true);
    }//GEN-LAST:event_telTxtFocusLost

      //regex za e-mail
    boolean formatMail = false;
    private void emailTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTxtKeyTyped
         if(emailTxt.getText().matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
            status.setText("");
            formatMail = true;
       }
       else if(emailTxt.getText().isEmpty()){
            status.setText("Unesite e-mail korisnika");
            formatMail = false;
            BtnSaveKorisnik.setEnabled(false);
       }
       else{
            status.setText("E-mail nije u pravilnom formatu");
            formatMail = false;
            BtnSaveKorisnik.setEnabled(false);
       }
       
       if(formatUsername && formatLicne && formatMail && pravilanJmbg && ime && prezime && adresa && telefon)
            BtnSaveKorisnik.setEnabled(true);// TODO add your handling code here:
    }//GEN-LAST:event_emailTxtKeyTyped

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSaveKorisnik;
    private javax.swing.JCheckBox adminTest;
    private javax.swing.JTextField adresaTxt;
    private javax.swing.JTextField brlicneTxt;
    private org.jdesktop.swingx.JXDatePicker dateTxt1;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField imeTxt;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jmbgTxt;
    private javax.swing.JTextField prezimeTxt;
    private javax.swing.JTextField status;
    private javax.swing.JFormattedTextField telTxt;
    private javax.swing.JTextField usernameTxt1;
    // End of variables declaration//GEN-END:variables
}
