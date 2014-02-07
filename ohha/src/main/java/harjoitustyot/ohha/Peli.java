/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import java.util.Scanner;

/**
 *Kokoaa yhden pelin oleelliset komponentit eli Pelaajat ja Pelilaudan. 
 * Suorittaa pelivuorot
 * @author 513228
 */
public class Peli {
    private final Pelaaja pelaajaRisti;
    private final Pelaaja pelaajaNolla;
    private Pelilauta pelilauta;
    private String vuoro="Risti";

/**
 * Konstruktori luo Pelaajat ja Pelilaudan
 * HUOM! tulee lopullisessa versiossa saamaan Pelaajat ja pelilaudan koon parametreina
 */
    public Peli() {
        this.pelaajaRisti=new Pelaaja ("Ilkka", "Risti");
        this.pelaajaNolla=new Pelaaja ("Antti", "Nolla");
        this.pelilauta=new Pelilauta (7, 7);
    }

    public void vaihdaVuoro (){
        if (this.vuoro.equals("Risti")) this.vuoro="Nolla";
        else this.vuoro="Risti";
    }
    
    public String toString() {
        return this.pelilauta.toString() + this.pelaajaRisti + "\r\n" + this.pelaajaNolla;
    }
    /**
     * Suorittaa yhden vuoron aikaiset toimenpiteet ja vaihtaa vuoroja
     * Käyttää Pelilautaa merkkien asettamiseen laudalla ja pelin loppumisen selvittämiseen
     * Suorittaa niin kauan kunnes peli loppuu
     */
    public void suoritaVuoroja() {        
        Scanner lukija = new Scanner(System.in);
        Pelaaja vuorossa;
        Boolean kesken = true;
        while (kesken==true) {
            if (this.vuoro.equals("Risti"))
                vuorossa = this.pelaajaRisti;
            else vuorossa = this.pelaajaNolla;
            boolean tulos = false;
            int leveys=0, korkeus=0;
            while (tulos==false) {
                System.out.print(vuoro + ": " + vuorossa.annaNimi() + ", anna leveys:");
                leveys = Integer.parseInt(lukija.nextLine());
                System.out.print("Anna korkeus:");
                korkeus = Integer.parseInt(lukija.nextLine());
                tulos = pelilauta.asetaMerkki(leveys, korkeus, vuoro);        
            }
            System.out.println(this.pelilauta.toString());
            
            if (this.pelilauta.etsiSuorat(leveys, korkeus).size()>=pelilauta.annaSuoranKoko())
                kesken=false;
            if (this.pelilauta.annaMaxKoko()==this.pelilauta.annaMerkkilkm())
                kesken=false;
                                
            else this.vaihdaVuoro();
            
        }        

    }

}

