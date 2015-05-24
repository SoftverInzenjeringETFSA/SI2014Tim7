/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.etf.unsa.si.app.renderer;

import ba.unsa.etf.si.app.entity.Korisnik;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author armin
 */
public class KorisnikRenderer extends JLabel implements ListCellRenderer<Korisnik> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Korisnik> list, Korisnik korisnik, int index,
        boolean isSelected, boolean cellHasFocus) {
        
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        
        
        setText(korisnik.toString());
        return this;
    }
    public KorisnikRenderer() {
     setOpaque(true);
    }
}
