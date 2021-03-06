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
import static com.sun.org.apache.xerces.internal.util.XMLChar.trim;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Azra
 */
public class KorisniciPanel2 extends javax.swing.JPanel {

    /**
     * Creates new form KorisniciPanel2
     */
    Date danas;
    public KorisniciPanel2() {
        initComponents();
        danas = new Date();
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
        listKorisnika = new javax.swing.JList();
        jLabel16 = new javax.swing.JLabel();
        userNamePretragaTxt = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        dateTxt = new org.jdesktop.swingx.JXDatePicker();
        jLabel23 = new javax.swing.JLabel();
        passTxt = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        emailTxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        adresaTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        telTxt = new javax.swing.JFormattedTextField();
        btnSpasiIzmjeneKorisnika = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        imeIzmjenaTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        prezimeIzmjenaTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jmbgIzmjenaTxt = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        brLicneTxt = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        adminTestIzmjena = new javax.swing.JCheckBox();
        status = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Odabir korisnika", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        listKorisnika.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        listKorisnika.setForeground(new java.awt.Color(0, 102, 153));
        listKorisnika.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listKorisnikaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listKorisnika);

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 153));
        jLabel16.setText("username");

        userNamePretragaTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        userNamePretragaTxt.setForeground(new java.awt.Color(0, 102, 153));
        userNamePretragaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userNamePretragaTxtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userNamePretragaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(5, 5, 5)
                .addComponent(userNamePretragaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kontakt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 153));
        jLabel21.setText("Datum zapošljavanja");

        userNameTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        userNameTxt.setForeground(new java.awt.Color(0, 102, 153));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 153));
        jLabel22.setText("Username");

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 153));
        jLabel23.setText("Password");

        passTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        passTxt.setForeground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel21)
                        .addComponent(jLabel22)
                        .addComponent(userNameTxt)
                        .addComponent(dateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addComponent(jLabel23)
                    .addComponent(passTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kontakt", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        emailTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        emailTxt.setForeground(new java.awt.Color(0, 102, 153));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 153));
        jLabel17.setText("E-mail");

        adresaTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        adresaTxt.setForeground(new java.awt.Color(0, 102, 153));

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(emailTxt)
                    .addComponent(adresaTxt)
                    .addComponent(telTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adresaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        btnSpasiIzmjeneKorisnika.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSpasiIzmjeneKorisnika.setForeground(new java.awt.Color(0, 102, 153));
        btnSpasiIzmjeneKorisnika.setText("SPASI");
        btnSpasiIzmjeneKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpasiIzmjeneKorisnikaActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lični podaci", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        imeIzmjenaTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        imeIzmjenaTxt.setForeground(new java.awt.Color(0, 102, 153));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 153));
        jLabel11.setText("Ime");

        prezimeIzmjenaTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        prezimeIzmjenaTxt.setForeground(new java.awt.Color(0, 102, 153));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 153));
        jLabel12.setText("Prezime");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 153));
        jLabel15.setText("JMBG");

        jmbgIzmjenaTxt.setEditable(false);
        jmbgIzmjenaTxt.setBackground(new java.awt.Color(255, 255, 255));
        jmbgIzmjenaTxt.setForeground(new java.awt.Color(0, 102, 153));
        try {
            jmbgIzmjenaTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jmbgIzmjenaTxt.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("Broj lične karte");

        brLicneTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        brLicneTxt.setForeground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(imeIzmjenaTxt)
                    .addComponent(prezimeIzmjenaTxt)
                    .addComponent(jmbgIzmjenaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addComponent(brLicneTxt))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imeIzmjenaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prezimeIzmjenaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jmbgIzmjenaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brLicneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin Opcije", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        adminTestIzmjena.setBackground(new java.awt.Color(255, 255, 255));
        adminTestIzmjena.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        adminTestIzmjena.setForeground(new java.awt.Color(0, 102, 153));
        adminTestIzmjena.setText("Administrator");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adminTestIzmjena)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(adminTestIzmjena, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSpasiIzmjeneKorisnika, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(status)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel5, jPanel6});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btnSpasiIzmjeneKorisnika)
                .addGap(1, 1, 1)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
  
    private void listKorisnikaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listKorisnikaValueChanged
            if(listKorisnika.getSelectedIndex() == -1){
                adresaTxt.setText("");
                brLicneTxt.setText("");
                dateTxt.setDate(null);
                emailTxt.setText("");
                imeIzmjenaTxt.setText("");
                jmbgIzmjenaTxt.setText("");
                passTxt.setText("");
                prezimeIzmjenaTxt.setText("");
                telTxt.setText("");
                userNameTxt.setText("");
                adminTestIzmjena.setSelected(false);
            }
            else{
                Korisnik k = (Korisnik) listKorisnika.getSelectedValue();
                adresaTxt.setText(k.getAdresa());
                brLicneTxt.setText(k.getBrojLicne());
                dateTxt.setDate(k.getDatumZaposljenja());
                emailTxt.setText(k.getMail());
                imeIzmjenaTxt.setText(k.getIme());
                jmbgIzmjenaTxt.setText(k.getJmbg());
                passTxt.setText(k.getPassword());
                prezimeIzmjenaTxt.setText(k.getPrezime());
                telTxt.setText(k.getTelefon());
                userNameTxt.setText(k.getUsername());
                adminTestIzmjena.setSelected(k.getAdmin());
            }
            

    }//GEN-LAST:event_listKorisnikaValueChanged

    private void userNamePretragaTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNamePretragaTxtKeyReleased
        KorisnikService servicePretraga = new KorisnikService();
        List<Korisnik> korisnikLista = servicePretraga.searchByUsername(userNamePretragaTxt.getText());
        DefaultListModel<Korisnik> model = new DefaultListModel<Korisnik>();
        model.removeAllElements();
        Collections.sort(korisnikLista,new KorisnikComparator());
        
        ListCellRenderer x = new KorisnikRenderer();
        for (Korisnik k : korisnikLista) {
            model.addElement(k);
        }    
        listKorisnika.setCellRenderer(x);
        listKorisnika.setModel(model);
        
         if(userNamePretragaTxt.getText().isEmpty() || userNamePretragaTxt.getText().replaceAll("\\s","").length() == 0 ){
            listKorisnika.clearSelection();
            DefaultListModel listModel = (DefaultListModel) listKorisnika.getModel();
            listModel.removeAllElements();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_userNamePretragaTxtKeyReleased

    private void btnSpasiIzmjeneKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpasiIzmjeneKorisnikaActionPerformed
    	Korisnik k1 = (Korisnik) listKorisnika.getSelectedValue();
    	if(listKorisnika.getSelectedValue() == null){
            status.setText("Izaberite iz liste korisnika kojeg želite izmijeniti");
        }
       
    	else if(k1.getUsername().equals(CurrentlyLoggedIn.korisnik.getUsername())){
                status.setText("Ne možete vršiti tu opciju nad svojim korisničkim nalogom");
        }
    	else if("admin".equals(k1.getUsername())){
                status.setText("Ne možete mijenjati tog korisnika!");
        }
        else if(imeIzmjenaTxt.getText().isEmpty() || imeIzmjenaTxt.getText().replaceAll("\\s","").length() == 0 ){
          status.setText("Unesite ime korisnika");
        }
        else if(!imeIzmjenaTxt.getText().matches("^[A-Z][-a-zA-ZšđžčćŠĐŽČĆ]+$")){
           status.setText("Ime korisnika nije pravilno unijeto"); 
        }
        else if(prezimeIzmjenaTxt.getText().isEmpty() || prezimeIzmjenaTxt.getText().replaceAll("\\s","").length() == 0 ){
          status.setText("Unesite prezime korisnika");
        }
        else if(!prezimeIzmjenaTxt.getText().matches("^[A-Z][-a-zA-ZšđžčćŠĐŽČĆ]+$")){
           status.setText("Prezime korisnika nije pravilno unijeto"); 
        }
        else if(jmbgIzmjenaTxt.getText().isEmpty() || jmbgIzmjenaTxt.getText().replaceAll("\\s","").length() == 0){
            status.setText("Unesite JMBG korisnika");
        }
        else if(jmbgIzmjenaTxt.getText().length() != 13){
            status.setText("JMBG mora imati 13 cifara");
        }
        else if(!jmbgIzmjenaTxt.getText().matches("^[0-9]*$")){
            status.setText("JMBG nije u pravilnom formatu");
        }
        else if(brLicneTxt.getText().isEmpty() || brLicneTxt.getText().replaceAll("\\s","").length() == 0){
            status.setText("Unesite broj lične karte korisnika");
        }
        else if(brLicneTxt.getText().length() != 9){
            status.setText("Broj lične karte mora sadržavati 9 karaktera");
        }
        else if(!brLicneTxt.getText().matches("^[A-Z0-9]+$")){
            status.setText("Broj lične karte može sadržavati samo velika slova i brojeve");
        }
        else if(userNameTxt.getText().isEmpty() || userNameTxt.getText().replaceAll("\\s","").length() == 0){
            status.setText("Unesite username korisnika");
        }
        else if(!userNameTxt.getText().matches("^[A-Za-z0-9_-]{4,}+$")){
            status.setText("Username mora imati više od 4 karaktera i može sadržavati brojeve, slova i specijalne znakove: _-");
        }
        else if(passTxt.getText().isEmpty() || passTxt.getText().replaceAll("\\s","").length() == 0){
            status.setText("Unesite password korisnika");
        }
        else if(!passTxt.getText().matches("^[A-Za-z0-9_-]{4,}+$")){
            status.setText("Password mora imati više od 4 karaktera i može sadržavati brojeve, slova i specijalne znakove: _-");
        }
        else if(dateTxt.getDate() == null){
            status.setText("Unesite datum zapošljavanja korisnika");
        }
        else if(dateTxt.getDate().after(danas)){
            status.setText("Datum zapošljavanja ne može biti poslije trenutnog datuma");
        }
        else if(adresaTxt.getText().isEmpty() || adresaTxt.getText().replaceAll("\\s","").length() == 0 ){
          status.setText("Unesite adresu korisnika");
        }
        else if(!adresaTxt.getText().matches("^[A-Za-z0-9šđžčćŠĐŽČĆ -]*$")){
           status.setText("Adresa sadrži neispravne karaktere");  
        }
        else if(telTxt.getText().equals("0  /   -    ") || telTxt.getText().replaceAll("\\s","").length() <= 10 ){
            status.setText("Unesite telefonski broj korisnika");
        }
        else if(emailTxt.getText().isEmpty() || emailTxt.getText().replaceAll("\\s","").length() == 0){
            status.setText("Unesite e-mail korisnika");
        }
        else if(!emailTxt.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            status.setText("E-mail nije u pravilnom formatu");
        }
        else {
            status.setText("");
            try{
                if(!"".equals(jmbgIzmjenaTxt.getText())){
                    KorisnikService servicePretraga = new KorisnikService();
                    Korisnik k = (Korisnik) listKorisnika.getSelectedValue();

                    k.setAdresa(adresaTxt.getText());
                    k.setBrojLicne(brLicneTxt.getText());
                    k.setDatumZaposljenja(dateTxt.getDate());
                    k.setMail(emailTxt.getText());
                    k.setIme(imeIzmjenaTxt.getText());
                    k.setPassword(passTxt.getText());
                    k.setPrezime(prezimeIzmjenaTxt.getText());
                    String tel = trim(telTxt.getText());
                    k.setTelefon(tel);
                    k.setUsername(userNameTxt.getText());
                    k.setAdmin(adminTestIzmjena.isSelected());
                    servicePretraga.modifyKorisnik(k);
                    
                    JOptionPane.showMessageDialog(null,"Uspješno ste izmijenili korisnika. ");
                    
                    adresaTxt.setText("");
                    brLicneTxt.setText("");
                    dateTxt.setDate(danas);
                    emailTxt.setText("");
                    imeIzmjenaTxt.setText("");
                    passTxt.setText("");
                    prezimeIzmjenaTxt.setText("");
                    userNameTxt.setText("");
                    adminTestIzmjena.setSelected(false);
                    telTxt.setText("");
                    jmbgIzmjenaTxt.setText("");
                    userNamePretragaTxt.setText("");
                    DefaultListModel listaModel = (DefaultListModel) listKorisnika.getModel();
                    listaModel.removeAllElements();
                }
            }
            catch(Exception e){
               // JOptionPane.showMessageDialog(null, e.getMessage(),"Greska!",
               //        JOptionPane.ERROR_MESSAGE);
                status.setText(e.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnSpasiIzmjeneKorisnikaActionPerformed

   
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox adminTestIzmjena;
    private javax.swing.JTextField adresaTxt;
    private javax.swing.JTextField brLicneTxt;
    private javax.swing.JButton btnSpasiIzmjeneKorisnika;
    private org.jdesktop.swingx.JXDatePicker dateTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField imeIzmjenaTxt;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jmbgIzmjenaTxt;
    private javax.swing.JList listKorisnika;
    private javax.swing.JTextField passTxt;
    private javax.swing.JTextField prezimeIzmjenaTxt;
    private javax.swing.JTextField status;
    private javax.swing.JFormattedTextField telTxt;
    private javax.swing.JTextField userNamePretragaTxt;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
}
