/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import java.util.ArrayList;

/**
 *
 * @author 513228
 */
public class Kontrolleri {
    private Peli peli;
    private Naytto naytto;
    
    public Kontrolleri(Naytto naytto, Peli peli) {
        this.peli=peli;
        this.naytto=naytto;
        
        Nappi[][] napit = naytto.annaNapit();
        for (int j=0;j<peli.annaPelilauta().annaKorkeus();j++) {
            for (int i=0;i<peli.annaPelilauta().annaLeveys();i++) {
                napit[i][j].addActionListener(new NapinKuuntelija(napit[i][j], this));
            }
        }
    }

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
        this.naytto.naytaVoittorivi(rivi);
    }
 }
    


