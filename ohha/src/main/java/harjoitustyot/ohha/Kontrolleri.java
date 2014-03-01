/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import java.util.ArrayList;

/**
 * Koordinoi peli kulkua
 * Luodaan vain kerran peli session aikana
 * Luo ja koordinoi Peliin pelin tilanteen
 * Luo ja piirtaa Nayttoon pelin tilanteen
 * Luokkamuuttujia muuttamalla voi vaikuttaa pelin asetuksiin:
 * erilaiset lautavaihtoehdot
 * pelissa tavoiteltavat suorakokojen vaihtoehdot
 * vaihtoehdot nakyvillä kayttoliittymassa
 * @author 513228
 */

public class Kontrolleri {
    
    private final int[][] lautakoot = new int[][]{{7,7},{14,14},{25,25}};
    private final int[] suorakoot = new int[]{4,5,6};

    private final int OLETUSLAUTA = 1; // 0,1,2 suorakokotaulukon indeksi
    private final int OLETUSSUORA = 1;// 0,2,2 suorakokotaulukon indeksi
    
    private Peli peli;
    private Naytto naytto;

        
 /**
  * Luo Peli-olion luokkamuuttujissa olevilla oletusasetuksilla
  * Luo Naytto-olion luokkamuuttujissa olevilla oletusasetuksilla, Kontrolleri välitetään Nättö -oliolle
  * 
  * @author 513228
  */
    
    public Kontrolleri() {
        this.peli=new Peli(lautakoot[OLETUSLAUTA][0],lautakoot[OLETUSLAUTA][1],suorakoot[OLETUSSUORA]);
        this.naytto=new Naytto(lautakoot, suorakoot, this);
    }

    /**
     * Luo uuden Peli-olion annetuilla parametreilla
     * @param leveys laudan leveys
     * @param korkeus on korkeus
     */
    public void uusiPeli(int leveys, int korkeus){
        this.peli = new Peli(leveys, korkeus, this.peli.annaPelilauta().annaSuoranKoko());
    }
    /**
     * Luo uuden Peli-olion annetuilla parametreilla
     * @param suorakoko uuden Pelin tavoiteltava suorakoko
     */

    public void uusiPeli(int suorakoko){
        this.peli = new Peli(this.peli.annaPelilauta().annaLeveys(), this.peli.annaPelilauta().annaKorkeus(), suorakoko);
    }

    /**
     * Peliruudukon nappien painalusten käsittely, kutsutaan NapinKuuntelijasta ActionPerformed -metodista
     * Asettaa klikattuun ruutuun vuorossa olevan Napin
     * Koordinoi Pelilaudan tilanne tarkistukset eli aiheuttaako lisäys voittorivejä
     * Ohjaa kohti uutta peliä, jos päättynyt
     * Toiminnot Ketjutettu komeen seuraavaan metodiin kasitteleVastaus(), tarkistaTilanne(), naytaPelinVoitto
     * @param x Klikatun ruudun x-koordinaatti
     * @param y Klikatun ruudun y-koordinaatti
     */
    public void kasitteleVastaus(int x, int y){
        //System.out.println(x + " " + y);
        if (this.peli.annaTilanne().equals("Kesken")) {

            if (this.peli.annaPelilauta().asetaMerkki(x, y, this.peli.annaVuoro())) {
                naytto.asetaNappi(x,y,peli.annaVuoro());
                tarkistaTilanne(x, y);
            }
        }
    }
    public void tarkistaTilanne(int x, int y) {        
        ArrayList rivi = this.peli.annaPelilauta().etsiSuorat(x, y);
        if (rivi.size()>=this.peli.annaPelilauta().annaSuoranKoko()) {
            this.peli.asetaTilanne(this.peli.annaVuoro());
            naytaPelinVoitto(rivi);
        }  
        else if (this.peli.annaPelilauta().annaMaxKoko()==this.peli.annaPelilauta().annaMerkkilkm()){
            
        }

        else this.peli.vaihdaVuoro();

    }        
    public void naytaPelinVoitto(ArrayList rivi) {
        this.naytto.naytaVoittorivi(rivi, this.peli.annaVuoro());
    }
    public int[][] annaLautakoot() {
        return this.lautakoot;
    }
    public int[] annaSuorakoot() {
        return this.suorakoot;
    }

    public Naytto annaNaytto() {
        return this.naytto;
    }
    public Peli annaPeli() {
        return this.peli;
    }

}
    


