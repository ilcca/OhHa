/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Poimii kaikkien nappien painallukset, niin pelilaudan ruudukon kuin valikoiden
 * Ohjaa painallusten mukaan eteenpäin
 * Kontrolleri näkyy tässä luokassa
 * @author 513228
 */
public class NapinKuuntelija implements ActionListener {

    private Nappi nappi;
    private LautaKoonValitsinNappi lauta;
    private SuoraKoonValitsinNappi suora;
    private Kontrolleri kontrolleri;
    
    public NapinKuuntelija(Nappi nappi, Kontrolleri kontrolleri) {
        this.nappi=nappi;
        this.kontrolleri=kontrolleri;
    }
    public NapinKuuntelija(LautaKoonValitsinNappi nappi, Kontrolleri kontrolleri) {
        this.lauta=nappi;
        this.kontrolleri=kontrolleri;
    }
    public NapinKuuntelija(SuoraKoonValitsinNappi nappi, Kontrolleri kontrolleri) {
        this.suora=nappi;
        this.kontrolleri=kontrolleri;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (this.nappi!=null && this.nappi.annaTyyppi().equals("Ruutu")) {
            if (this.kontrolleri.annaPeli().annaTilanne()=="Kesken") {
                this.kontrolleri.annaNaytto().poistaValikot();
                this.kontrolleri.kasitteleVastaus(this.nappi.annaX(), this.nappi.annaY());
            }
            else {
                this.kontrolleri.uusiPeli(this.kontrolleri.annaPeli().annaPelilauta().annaLeveys(), this.kontrolleri.annaPeli().annaPelilauta().annaLeveys());
                this.kontrolleri.annaNaytto().paivitaAloitus(this.kontrolleri.annaLautakoot(), this.kontrolleri.annaSuorakoot(), this.kontrolleri);
            }                
        }
        if (this.lauta!=null && this.lauta.annaTyyppi().equals("Lautakoon valitsin")) {
//            System.out.println("Lautakoon valitsin");
            this.kontrolleri.uusiPeli(this.lauta.annaLeveys(), this.lauta.annaKorkeus());
            this.kontrolleri.annaNaytto().paivitaAloitus(this.kontrolleri.annaLautakoot(), this.kontrolleri.annaSuorakoot(), this.kontrolleri);
        }


        if (this.suora!=null && this.suora.annaTyyppi().equals("Suorakoon valitsin")) {
            this.kontrolleri.uusiPeli(this.suora.annaKoko());            
            this.kontrolleri.annaNaytto().paivitaAloitus(this.kontrolleri.annaLautakoot(), this.kontrolleri.annaSuorakoot(), this.kontrolleri);
        }

    }
}