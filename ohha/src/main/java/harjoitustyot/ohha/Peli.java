/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import java.util.Scanner;

/**
 *Kokoaa yhden pelin oleelliset komponentit eli Pelilaudan ja pelin tilanteen. Pelaajat tässä toteutuksessa muuttumattomia.
 * 
 * @author 513228
 */
public class Peli {
    private final Pelaaja pelaajaRisti;
    private final Pelaaja pelaajaNolla;
    private Pelilauta pelilauta;
    private String vuoro="Risti";
    private String tilanne = "Kesken";

/**
 * Konstruktori luo Pelaajat ja Pelilaudan
     * @param leveys on pelilaudan leveys
     * @param korkeus on korkeus
     * @param suorankoko on tavoiteltavan pelissä merkkijonon pituus
 */
    public Peli(int leveys, int korkeus, int suorankoko) {
        this.pelaajaRisti=new Pelaaja ("Ilkka", "Risti");
        this.pelaajaNolla=new Pelaaja ("Antti", "Nolla");
        this.pelilauta=new Pelilauta (leveys, korkeus, suorankoko);
    }
/**
 * Apufunktio vuoron vaihtoon
 * 
 */
    public void vaihdaVuoro (){
        if (this.vuoro.equals("Risti")) this.vuoro="Nolla";
        else this.vuoro="Risti";
    }

    public void asetaTilanne(String tilanne){
        this.tilanne=tilanne;
    }
    
    public Pelilauta annaPelilauta() {
        return this.pelilauta;
    }
    
    public String annaVuoro() {
        return this.vuoro;
    }
    public String annaTilanne() {
        return this.tilanne;
    }
    
    public String toString() {
        return this.pelilauta.toString() + this.pelaajaRisti + "\r\n" + this.pelaajaNolla;
    }

}

