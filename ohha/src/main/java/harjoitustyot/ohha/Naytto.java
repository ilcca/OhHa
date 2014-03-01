/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;

/**
 *Alustaa, koordinoi ja piirtää pelin grafiikat
 * @author 513228
 */
public class Naytto extends JFrame{
    private final int KEHYSX = 700;
    private final int KEHYSY = 700;

    private JPanel paneeliOhjaimet;
    private JPanel paneeliRuudukko;

    private LautaKoonValitsinNappi[] lautakoko;

    private SuoraKoonValitsinNappi[] suorakoko;
    
    private Nappi[][] ruudukko;

    
    private final Image ristikuva = new ImageIcon(getClass().getResource("/risti2.PNG")).getImage();
    private final Image nollakuva = new ImageIcon(getClass().getResource("/nolla2.PNG")).getImage();
    private final Image voittoristikuva = new ImageIcon(getClass().getResource("/voittoristi2.PNG")).getImage();
    private final Image voittonollakuva = new ImageIcon(getClass().getResource("/voittonolla2.PNG")).getImage();
    //getScaleInstance(
    //setEnabled(false)
    private final ImageIcon risti= new ImageIcon(ristikuva);
    private final ImageIcon nolla= new ImageIcon(nollakuva);
    private final ImageIcon voittoristi= new ImageIcon(voittoristikuva);
    private final ImageIcon voittonolla= new ImageIcon(voittonollakuva);

/**
 * Alustaa pelin valikot ja pelilaudan ruudukon
 * asettaa actionListener -toiminnot valikkojen ja laudan nappeihin
 * @param lautakoot valikoissa näkyvär lautavaihtoehdot
 * @param suorakoot valikoissa näkyvät pelissä tavoiteltavat suorakoko vaihtoehdot
 * @param k Kontrolleri, jolle annetaan nappien painallukset NapinKuuntelija -olion kauta
 */
    public Naytto(int[][] lautakoot, int suorakoot[], Kontrolleri k) {
        super("RistiNolla");
        setSize(KEHYSX,KEHYSY);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        super.setLayout(new GridLayout(2,1));        

        this.paneeliOhjaimet = new JPanel();
        this.paneeliOhjaimet.setLayout(new GridLayout(2,3));        
        int leveys=k.annaPeli().annaPelilauta().annaLeveys();
        int korkeus=k.annaPeli().annaPelilauta().annaKorkeus();
        
        //Alustaa asettaa lautavaihtoehtovalikot
        this.lautakoko = new LautaKoonValitsinNappi[lautakoot.length];
        for (int i=0;i<lautakoko.length;i++){
            if (lautakoot[i][0]==leveys && lautakoot[i][1]==korkeus)
                this.lautakoko[i]=new LautaKoonValitsinNappi(lautakoot[i][0],lautakoot[i][1], true);
            else
                this.lautakoko[i]=new LautaKoonValitsinNappi(lautakoot[i][0],lautakoot[i][1]);
            this.lautakoko[i].addActionListener(new NapinKuuntelija(this.lautakoko[i], k));
            this.paneeliOhjaimet.add(this.lautakoko[i]);
        }
        
        //Alustaa asettaa suoravaihtoehtovalikot
        this.suorakoko = new SuoraKoonValitsinNappi[suorakoot.length];
        for (int i=0;i<suorakoko.length;i++){
            String label="";
            for (int j=0;j<suorakoot[i];j++) label = label + "x";
            if (suorakoot[i]==k.annaPeli().annaPelilauta().annaSuoranKoko())
                this.suorakoko[i]=new SuoraKoonValitsinNappi(suorakoot[i],label, true);
            else
                this.suorakoko[i]=new SuoraKoonValitsinNappi(suorakoot[i],label);
            this.suorakoko[i].addActionListener(new NapinKuuntelija(this.suorakoko[i], k));
            this.paneeliOhjaimet.add(this.suorakoko[i]);
        }
        
        this.paneeliRuudukko = new JPanel();
        this.paneeliRuudukko.setLayout(new GridLayout(leveys, korkeus));


        //ALustaa pelilaudan ruudukon
        this.ruudukko = new Nappi[leveys][korkeus];
        for (int j=0;j<leveys;j++) {
            for (int i=0;i<korkeus;i++) {
                this.ruudukko[i][j]=new Nappi(i+1, j+1, "Ruutu");
                this.paneeliRuudukko.add(ruudukko[i][j]);
            }
        }
   
        add(this.paneeliOhjaimet);        
        add(this.paneeliRuudukko);        
        setVisible(true);        

        for (int j=0;j<korkeus;j++) {
            for (int i=0;i<leveys;i++) {
                this.ruudukko[i][j].addActionListener(new NapinKuuntelija(ruudukko[i][j], k));
            }
        }
    }

    /**
     * Päivittää laudan tavoiteltavan suorakoon, jos niitä muutettu pelin alussa
     * Konstruktorin alustuvat toiminnot uudelleen
     * @param lautakoot
     * @param suorakoot
     * @param k 
     */
    public void paivitaAloitus(int[][] lautakoot, int suorakoot[], Kontrolleri k) {

        this.getContentPane().removeAll();
        
        super.setLayout(new GridLayout(2,1));        

        this.paneeliOhjaimet = new JPanel();
        this.paneeliOhjaimet.setLayout(new GridLayout(2,3));        
        int leveys=k.annaPeli().annaPelilauta().annaLeveys();
        int korkeus=k.annaPeli().annaPelilauta().annaKorkeus();
        
        this.lautakoko = new LautaKoonValitsinNappi[lautakoot.length];
        for (int i=0;i<lautakoko.length;i++){
            if (lautakoot[i][0]==leveys && lautakoot[i][1]==korkeus)
                this.lautakoko[i]=new LautaKoonValitsinNappi(lautakoot[i][0],lautakoot[i][1], true);
            else
                this.lautakoko[i]=new LautaKoonValitsinNappi(lautakoot[i][0],lautakoot[i][1]);
            this.lautakoko[i].addActionListener(new NapinKuuntelija(this.lautakoko[i], k));
            this.paneeliOhjaimet.add(this.lautakoko[i]);
        }
        
        this.suorakoko = new SuoraKoonValitsinNappi[suorakoot.length];
        for (int i=0;i<suorakoko.length;i++){
            String label="";
            for (int j=0;j<suorakoot[i];j++) label = label + "x";
            if (suorakoot[i]==k.annaPeli().annaPelilauta().annaSuoranKoko())
                this.suorakoko[i]=new SuoraKoonValitsinNappi(suorakoot[i],label, true);
            else
                this.suorakoko[i]=new SuoraKoonValitsinNappi(suorakoot[i],label);
            this.suorakoko[i].addActionListener(new NapinKuuntelija(this.suorakoko[i], k));
            this.paneeliOhjaimet.add(this.suorakoko[i]);
        }
        
        this.paneeliRuudukko = new JPanel();
        this.paneeliRuudukko.setLayout(new GridLayout(leveys, korkeus));

        this.ruudukko = new Nappi[leveys][korkeus];
        for (int j=0;j<leveys;j++) {
            for (int i=0;i<korkeus;i++) {
                this.ruudukko[i][j]=new Nappi(i+1, j+1, "Ruutu");
                this.paneeliRuudukko.add(ruudukko[i][j]);
            }
        }
   
        add(this.paneeliOhjaimet);        
        add(this.paneeliRuudukko);        
        setVisible(true);        

        for (int j=0;j<korkeus;j++) {
            for (int i=0;i<leveys;i++) {
                this.ruudukko[i][j].addActionListener(new NapinKuuntelija(ruudukko[i][j], k));
            }
        }
        
    }

    /**
     * Apumetodi, jolla poistetaan valikot näkyvistä kun peli alkaa
     */
    public void poistaValikot(){
        this.remove(this.paneeliOhjaimet);
        this.setLayout(new GridLayout(1,1));

    }

    /**
     * kun peli päätyy, piirtää voittorivit käänteisillä väreillä
     * @param voittorivi
     * @param merkki 
     */
    public void naytaVoittorivi(ArrayList voittorivi, String merkki) {
        for (int i=0;i<voittorivi.size();i++) {
            ArrayList<Integer> k = (ArrayList) voittorivi.get(i);
            if (merkki.equals("Risti")) ruudukko[k.get(0)-1][k.get(1)-1].setIcon(voittoristi);
            if (merkki.equals("Nolla")) ruudukko[(int)k.get(0)-1][(int)k.get(1)-1].setIcon(voittonolla);
//            ruudukko[(int)k.get(0)-1][(int)k.get(1)-1].setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
//            ruudukko[(int)k.get(0)-1][(int)k.get(1)-1].setBackground(Color.green);
        }
    }

    public Nappi annaNappi(int x, int y) {
        return this.ruudukko[x-1][y-1];  
    }

    public Nappi[][] annaNapit() {
        return this.ruudukko;  
    }

    public void asetaNappi(int x, int y, String merkki) {
        //if (merkki.equals("Risti")) this.ruudukko[x-1][y-1].setLabel("x");
        //else this.ruudukko[x-1][y-1].setLabel("o");

        if (merkki.equals("Risti")) this.ruudukko[x-1][y-1].setIcon(this.risti);
        else this.ruudukko[x-1][y-1].setIcon(this.nolla);
                
    }
}
    


