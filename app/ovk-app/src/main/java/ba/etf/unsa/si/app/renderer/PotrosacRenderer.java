/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.etf.unsa.si.app.renderer;

import ba.unsa.etf.si.app.entity.Potrosac;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author armin
 */
public class PotrosacRenderer extends JLabel implements ListCellRenderer<Potrosac> {
    @Override
    public Component getListCellRendererComponent(JList<? extends Potrosac> list, Potrosac potrosac, int index,
        boolean isSelected, boolean cellHasFocus) {
        
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(Color.white);
            setForeground(list.getForeground());
        }
        
        
        setText(potrosac.toString());
        return this;
    }
    public PotrosacRenderer() {
     setOpaque(true);
    }
}