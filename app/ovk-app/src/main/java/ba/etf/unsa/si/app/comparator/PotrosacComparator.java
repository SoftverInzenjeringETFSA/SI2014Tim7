/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.etf.unsa.si.app.comparator;

import ba.unsa.etf.si.app.entity.Potrosac;
import java.util.Comparator;

/**
 *
 * @author armin
 */
public class PotrosacComparator implements Comparator<Potrosac> {
    @Override
    public int compare(Potrosac o1,Potrosac o2) {
        return o1.getIme().compareTo(o2.getIme());
    }
}
