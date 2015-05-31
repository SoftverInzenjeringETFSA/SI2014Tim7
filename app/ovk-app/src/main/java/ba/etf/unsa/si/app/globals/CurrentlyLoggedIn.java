/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba.etf.unsa.si.app.globals;

import ba.unsa.etf.si.app.entity.Korisnik;

/**
 *
 * @author armin
 */
public class CurrentlyLoggedIn {
    public static Korisnik korisnik;
    
    public static void setKorisnik(Korisnik k){
        korisnik = k;
    }
}
