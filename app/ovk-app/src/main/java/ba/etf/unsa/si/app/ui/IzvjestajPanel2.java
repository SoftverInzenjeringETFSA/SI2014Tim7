/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.etf.unsa.si.app.ui;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ba.unsa.etf.si.app.dao.IzvjestajiDAO;
import ba.unsa.etf.si.app.dao.PotrosacDAO;
import ba.unsa.etf.si.app.entity.Izvjestaji;
import ba.unsa.etf.si.app.entity.Parametri;
import ba.unsa.etf.si.app.entity.Potrosac;
import ba.unsa.etf.si.app.entity.Racuni;
import ba.unsa.etf.si.app.services.IzvjestajService;
import ba.unsa.etf.si.app.services.ParametriService;
import ba.unsa.etf.si.app.services.PotrosacService;

import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author Azra
 */
public class IzvjestajPanel2 extends javax.swing.JPanel {

    /**
     * Creates new form IzvjestajPanel2
     */
    public IzvjestajPanel2() {
    	addComponentListener(new ComponentAdapter() {
    		@Override
    		public void componentShown(ComponentEvent arg0) {
    	        DefaultListModel model = new DefaultListModel();
    	        IzvjestajService serviceIzvjestaja = new IzvjestajService();
    	        List<Izvjestaji> listIzvjestaja = serviceIzvjestaja.vratiSveIzvjestaje();
    	        jList1.setModel(model);
    	        
    	        for (Izvjestaji p : listIzvjestaja) {      
    	                model.addElement(p.getId());
    	        }
    		}
    	});
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
        jButton1 = new javax.swing.JButton();
        jButton1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseReleased(MouseEvent arg0) {
        		try
        		{
        			if(jList1.isSelectionEmpty()==true)
            	{
            		throw new IllegalArgumentException("Niste izabrali izvjestaj!");
            	}
        			lblAhaaaaaaaaaa.setText("");
            		label.setText("");
            		label_2.setText("");
            		label_4.setText("");
            		label_5.setText("");
            		label_7.setText("");
            		label_9.setText("");
            		label_10.setText("");
            		label_3.setText("");
            		label_6.setText("");
            		label_8.setText("");
            		label_11.setText("");
            		lblSasaa.setText("");
        		int id = Integer.valueOf(jList1.getSelectedValue().toString());
        		IzvjestajService izvjestaj = new IzvjestajService();
        		Izvjestaji neki = izvjestaj.vratiSveIzvjestajeZaId(id);
        		
        		label.setText(neki.getId().toString());
        	
        		label_4.setText(neki.getPotrosnjaPausalacaVoda().toString());
        		label_5.setText(neki.getPotrosnjaPausalacaKanalizacija().toString());
        		label_9.setText(neki.getPotrosnjaOstalihVoda().toString());
        		label_10.setText(neki.getPotrosnjaOstalihKanalizacija().toString());
        		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
           	   //get current date time with Date()
        		
        		String odDatuma = dateFormat.format(neki.getDatumOd());
        		String doDatuma = dateFormat.format(neki.getDatumDo());
        		
        		lblAhaaaaaaaaaa.setText(odDatuma + " - " + doDatuma);
        		
        		

        		IzvjestajService svipotrosaci = new IzvjestajService();
        		List<Racuni> svi = svipotrosaci.nadjiListuRacuna(neki.getDatumOd(), neki.getDatumDo());
        		int pausalniukupno=0;
        		int pausalniSaKanalizacijom=0;
        		int obicniSaKanalizacijom = 0;
        		Double zaradaPausalciVoda=0.0;
        		Double zaradaPausalciKanalizacija=0.0;
        		Double zaradaOstaliVoda=0.0;
        		Double zaradaOstaliKanalizacija=0.0;
        		int pausalniBrojClanova = 0;
        		int brojClanova=0;
        		List<Potrosac> listasvih = new ArrayList();
        		Boolean b = false;
        		
        		for (int i=0; i<svi.size(); i++)
                {
                	String provjera = svi.get(i).getPotrosac().getKategorija();
                	Double kanalizacija = svi.get(i).getPotrosnjaZaKoristenjeKanalizacije();
                	Double voda = svi.get(i).getPotrosnjaZaKoristenjeVoda();
                	
                	for(int j=0;j<listasvih.size();j++)
                	{
                		if(listasvih.get(j).equals(svi.get(i).getPotrosac()))
                		{
                			if(provjera.equals("Pausalac"))
                			{
                        		pausalniBrojClanova=pausalniBrojClanova+ Integer.valueOf(svi.get(i).getPotrosac().getBrojClanova());
                			}
                			else
                			{
                        		brojClanova=brojClanova+Integer.valueOf(svi.get(i).getPotrosac().getBrojClanova());
                			}
                			b=true;
                			break;
                		}
                	}
                	if(b==true)
                	{
                		b=false;
                		continue;
                	}
                	if(provjera.equals("Pausalac"))
                	{
                		if(svi.get(i).getPotrosac().getUsluga()==true)
                		{
                			pausalniSaKanalizacijom++;
                		}
                		listasvih.add(svi.get(i).getPotrosac());
                	}
                	else
                	{
                		if(svi.get(i).getPotrosac().getUsluga()==true)
                		{
                			obicniSaKanalizacijom++;
                		}
                		listasvih.add(svi.get(i).getPotrosac());
                	}
                	
            		int ostalipotrosaci=0;
                	for(int k=0;k<listasvih.size();k++)
                	{
                		if(listasvih.get(k).getKategorija().equals("Pausalac"))
                		{
                			pausalniukupno++;
                		}
                		else
                		{
                			ostalipotrosaci++;
                		}
                	}
                	
        		ParametriService parametri = new ParametriService();
        		Parametri para = parametri.dajParametre();
        		
        		double pomocna = neki.getPotrosnjaPausalacaVoda()*(para.getPvnZaKoristenjeVoda()+para.getPvnZaZastituVoda() + para.getCijenaVodePoKubiku()) + neki.getPotrosnjaPausalacaKanalizacija()*para.getCijenaKanalizacijePoKubiku() + pausalniukupno*para.getFiksnaCijena();
        		zaradaPausalciVoda= pomocna * (1+para.getStopaPdv()/100.0);
        		zaradaPausalciVoda=(double)Math.round(zaradaPausalciVoda * 100000) / 100000;
        		
        		double zarada = neki.getPotrosnjaOstalihVoda()*(para.getPvnZaKoristenjeVoda() + para.getPvnZaZastituVoda() + para.getCijenaVodePoKubiku()) + neki.getPotrosnjaOstalihKanalizacija()*para.getCijenaKanalizacijePoKubiku() + ostalipotrosaci*para.getFiksnaCijena();        	
        		zaradaOstaliVoda = 	zarada * (1+para.getStopaPdv()/100.0);
        		zaradaOstaliVoda = (double)Math.round(zaradaOstaliVoda * 100000) / 100000;  		
        		
        		double aha = zaradaPausalciVoda + zaradaOstaliVoda;
        		aha=(double)Math.round(aha * 100000) / 100000;
        		
        		if(neki.getBrojPausalaca()==0)
        		{
        			label_3.setText(String.valueOf(0));
        			label_6.setText(String.valueOf(0));
        			zaradaPausalciVoda=0.0;
        		}
        		else
        		{
            		label_3.setText(String.valueOf(pausalniSaKanalizacijom));
            		label_6.setText(String.valueOf(String.valueOf(zaradaPausalciVoda)));
        		}
        		if(neki.getBrojOstalih()==0)
        		{
            		label_8.setText(String.valueOf(0));
            		label_11.setText(String.valueOf(0));
            		zaradaOstaliVoda=0.0;
        		}
        		else
        		{
            		label_8.setText(String.valueOf(obicniSaKanalizacijom));
            		label_11.setText(String.valueOf(String.valueOf(zaradaOstaliVoda)));
        		}

        		lblSasaa.setText(String.valueOf(String.valueOf(aha)));
        		label_2.setText(neki.getBrojPausalaca().toString());
        		label_7.setText(neki.getBrojOstalih().toString());
        		
        		
        	}}
        	catch(Exception exception)
        	{
        		JOptionPane.showMessageDialog(null, exception.getMessage(),"Greska!",JOptionPane.ERROR_MESSAGE);
        	}
        		
    	        }
        });
        jButton2 = new javax.swing.JButton();
        jButton2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseReleased(MouseEvent e) {
        		
        		try
        		{
        			if(jList1.isSelectionEmpty()==true)
            	{
            		throw new IllegalArgumentException("Niste izabrali izvjestaj!");
            	}
        		int id = Integer.valueOf(jList1.getSelectedValue().toString());
        		IzvjestajService izvjestaj = new IzvjestajService();
        		Izvjestaji neki = izvjestaj.vratiSveIzvjestajeZaId(id);
        		izvjestaj.obrisiIzvjestaj(neki);
        		jList1.removeAll();
                DefaultListModel model = new DefaultListModel();
                IzvjestajService serviceIzvjestaja = new IzvjestajService();
                List<Izvjestaji> listIzvjestaja = serviceIzvjestaja.vratiSveIzvjestaje();
                jList1.setModel(model);
                
                for (Izvjestaji p : listIzvjestaja) {      
                        model.addElement(p.getId());
                }
                label.setText("");
        		label_2.setText("");
        		label_4.setText("");
        		label_5.setText("");
        		label_7.setText("");
        		label_9.setText("");
        		label_10.setText("");
        		label_3.setText("");
        		label_6.setText("");
        		label_8.setText("");
        		label_11.setText("");
        		lblSasaa.setText("");
        		jList1.clearSelection();
        		
                JOptionPane.showMessageDialog(null, "Uspjesno brisanje izvještaja!");
        	}
        	catch(Exception exception)
        	{
        		JOptionPane.showMessageDialog(null, exception.getMessage(),"Greska!",JOptionPane.ERROR_MESSAGE);
        	}
        		
        	}
        });
        

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista izvještaja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N

        jList1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jList1.setForeground(new java.awt.Color(0, 102, 153));
        jList1.setModel(new AbstractListModel() {
        	String[] values = new String[] {};
        	public int getSize() {
        		return values.length;
        	}
        	public Object getElementAt(int index) {
        		return values[index];
        	}
        });
        jList1.setToolTipText("");
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 153));
        jButton1.setText("PRIKAŽI");

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 153));
        jButton2.setText("IZBRIŠI");
        
        lblIdIzvjestaja = new JLabel("ID Izvještaja:");
        
        lblNewLabel = new JLabel("Sa kanalizacijom:");
        
        lblPotrosnjaVode = new JLabel("Ukupno:");
        
        lblKanalizacija = new JLabel("Potr. kanalizacije:");
        
        lblPausalci = new JLabel("Broj Pausalaca:");
        
        JLabel lblPotrSaKanalizacijom = new JLabel("Potrosnja vode:");
        
        label_1 = new JLabel("Broj Ostali:");
        
        lblSaKanalizacijom = new JLabel("Sa kanalizacijom:");
        
        lblPotrosnjaVode_1 = new JLabel("Potrosnja vode:");
        
        lblPotrKanalizacije = new JLabel("Potr. kanalizacije:");
        
        lblZaradaVoda = new JLabel("Ukupno:");
        
        lblUkupnaZarada = new JLabel("Ukupna zarada:");
        
        label = new JLabel("");
        
        label_2 = new JLabel("");
        
        label_3 = new JLabel("");
        
        label_4 = new JLabel("");
        
        label_5 = new JLabel("");
        
        label_6 = new JLabel("");
        
        label_7 = new JLabel("");
        
        label_8 = new JLabel("");
        
        label_9 = new JLabel("");
        
        label_10 = new JLabel("");
        
        label_11 = new JLabel("");
        
        lblSasaa = new JLabel("");
        
        lblPeriod = new JLabel("Period:");
        
        lblAhaaaaaaaaaa = new JLabel("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(14)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel)
        						.addComponent(lblPotrSaKanalizacijom, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblIdIzvjestaja)
        						.addComponent(lblPausalci, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblKanalizacija, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPotrosnjaVode, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblSaKanalizacijom, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPotrosnjaVode_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPotrKanalizacije, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblZaradaVoda, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblUkupnaZarada, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPeriod, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(label, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
        						.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        						.addComponent(label_3, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        						.addComponent(label_4, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        						.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        						.addComponent(label_6, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        						.addComponent(label_7, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        						.addComponent(label_8, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        						.addComponent(label_9, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        						.addComponent(label_10, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        						.addComponent(label_11, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
        						.addComponent(lblSasaa, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
        					.addGap(11))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addGap(66)
        					.addComponent(lblAhaaaaaaaaaa, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        					.addGap(59))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jButton1)
        						.addComponent(jButton2)))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(label)
        							.addGap(17)
        							.addComponent(label_2)
        							.addGap(6)
        							.addComponent(label_3)
        							.addGap(3)
        							.addComponent(label_4)
        							.addGap(6)
        							.addComponent(label_5)
        							.addGap(6)
        							.addComponent(label_6)
        							.addGap(11)
        							.addComponent(label_7)
        							.addGap(6)
        							.addComponent(label_8)
        							.addGap(6)
        							.addComponent(label_9)
        							.addGap(6)
        							.addComponent(label_10)
        							.addGap(6)
        							.addComponent(label_11)
        							.addGap(18)
        							.addComponent(lblSasaa))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(lblIdIzvjestaja)
        							.addGap(17)
        							.addComponent(lblPausalci)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblNewLabel)
        							.addGap(3)
        							.addComponent(lblPotrSaKanalizacijom)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblKanalizacija)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblPotrosnjaVode)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(label_1)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblSaKanalizacijom)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblPotrosnjaVode_1)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblPotrKanalizacije)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblZaradaVoda)
        							.addGap(18)
        							.addComponent(lblUkupnaZarada)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblAhaaaaaaaaaa)
        						.addComponent(lblPeriod))))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblNewLabel, lblPotrosnjaVode, lblKanalizacija, lblPausalci});
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrikaziIzvjestajActionPerformed(java.awt.event.ActionEvent evt) {   
     //dynamic report
               /* JasperReportBuilder report = DynamicReports.report();
                //add title
                TextFieldBuilder<String> title1 = DynamicReports.cmp.text("  International Technical University\n");
                report.title(title1);
                TextFieldBuilder<String> title2 = DynamicReports.cmp.text("  Zmaja od Bosne bb, Kampus Univerziteta u Sarajevu, 71 000 Sarajevo\n");
                report.title(title2);
                TextFieldBuilder<String> title3 = DynamicReports.cmp.text("  Tel: ++387 33 250 700\n\n\n\n");
                report.title(title3);*/
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private JLabel lblIdIzvjestaja;
    private JLabel lblNewLabel;
    private JLabel lblPotrosnjaVode;
    private JLabel lblKanalizacija;
    private JLabel lblPausalci;
    private JLabel label_1;
    private JLabel lblSaKanalizacijom;
    private JLabel lblPotrosnjaVode_1;
    private JLabel lblPotrKanalizacije;
    private JLabel lblZaradaVoda;
    private JLabel lblUkupnaZarada;
    private JLabel label;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private JLabel label_6;
    private JLabel label_7;
    private JLabel label_8;
    private JLabel label_9;
    private JLabel label_10;
    private JLabel label_11;
    private JLabel lblSasaa;
    private JLabel lblPeriod;
    private JLabel lblAhaaaaaaaaaa;
}
