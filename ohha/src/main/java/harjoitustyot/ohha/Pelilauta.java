/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;
import java.util.Arrays;
import java.util.ArrayList;


/**
 *Pitää yllä pelilaudan tilannetta mitä merkkejä risti tai nolla missäkin kohtaa lautaa. 
 * Luokan kautta merkkien lisäykset tarkastuksineen
 * Luokan kautta tarkistus onko voittorivejä laudalla annetusta koordinaatista
 * @author 513228
 */
public class Pelilauta {
   private int pelilautaKorkeus;
   private int pelilautaLeveys;
   private final int OLETUSKOKO=10;
   private final int MinLeveys = 5;
   private final int MaxLeveys = 50;
   private final int MinKorkeus = 1;
   private final int MaxKorkeus = 50;
   private int[][] lautamatriisi; // pelilaudan ruudukko, ruudukoilla arvot 0 = tyhjä, 1=pelaajan yksi merkki, 2=pelaajan kaksi merkki
   //kuinka montaa peräkkäistä tavoitellaan
   private final int SUORANKOKO=5;
   private int maxmerkkilkm;
   private int merkkilkm = 0;

   /**
    * Konstruktori luo laudan matriisin annetuilla leveydellä ja korkeudella
    * Jos annetut mittasuhteet liian isoja tai pieniä, luo oletuskokoisen laudan
    * @param leveys Laudan leveys
    * @param korkeus Laudaan korkeus
    */
   public Pelilauta (int leveys, int korkeus){
       //Asettaa korkeus ja leveysmuuttujat jos ovat välillä 7-25 muuten oletuskoko 15
       if (korkeus>=this.MinKorkeus && korkeus<=this.MaxKorkeus && leveys>=this.MinLeveys && leveys<=this.MaxLeveys) {
        this.pelilautaKorkeus=korkeus;
        this.pelilautaLeveys=leveys;
       }
       else {
        this.pelilautaKorkeus=OLETUSKOKO;
        this.pelilautaLeveys=OLETUSKOKO;           
       }
       
       //luo pelilaudan matriisin ja alustaa matriisin ruutujen aloitustilat eli tyhjjät
       this.lautamatriisi=new int [pelilautaKorkeus][pelilautaLeveys];
       this.maxmerkkilkm=this.pelilautaKorkeus*this.pelilautaLeveys;

   }
/**
 * Asettaa annetun merkin laudalle jos paikka on vapaana ja laudalla. 
 * Merkki Risti merkataan lautamatriisi -taulukkoon arvolla 1 ja merkki Nolla merkataan arvolla 2, tyhjät ruudut ovat arvoja 0
 * @param x leveyskoordinaatti (1 = vasein ruutu)
 * @param y korkeuskoordinaatti (1 = ylin ruutu)
 * @param merkki Saa olla syötteenä vain "Risti" tai "Nolla"
 * @return onnistuiko asennus
 */
   public boolean asetaMerkki(int x, int y, String merkki) {
       int syote;
//Tarkista parametrit
//Hyväksyy leveys (x) ja korkeus (y) koordinaatit vain jos mahtuvat laudalle
       if (x>this.pelilautaLeveys) return false;
       if (y>this.pelilautaKorkeus) return false;
       if (x<1) return false;
       if (y<1) return false;
//Hyväksyy merkiksi, vain "Risti" tai "Nolla"
       if (merkki.matches("Risti")) syote=1;
       else if (merkki.matches("Nolla")) syote=2;
       else return false;
//Tarkista onko paikka vapaana
// kalibroi koordinaatit array-viittauksiksi alkaen paikasta 0
       x=x-1; 
       y=y-1;

       if (this.lautamatriisi[x][y]==0) {
           this.lautamatriisi[x][y]=syote;
           this.merkkilkm+=1;
           return true;
       }
       return false;
   }
   
   
   /**
    * Kokoaa kolme tarkistus metodia etsiVaakaan, etsiPystyyn, etsiVinoon pelin voittajan selvittämiseksi
    * Etsintä tehdään aina viimeksi lisätyn koordinaatin välittömästä läheisyydstä - eu tarkista siis koko lautaa
    * HUOM! vasta vaakaan tarkistus kolmesta metodista valmiina
    * @param x Leveys koordinaatti
    * @param y Pystykoordinaatti
    * @return Palauttaa ArrayListin jossa tarkistuspisteestä lasketit vierekkäisten samojen merkkien koordinaatit
    */
   public ArrayList etsiSuorat(int x, int y) {
       
       ArrayList kaikki = new ArrayList();
       ArrayList vaakaan = etsiVaakaan(x,y);
       ArrayList pystyyn = etsiPystyyn(x,y);
       System.out.println(vaakaan);
       System.out.println(pystyyn);
       
       if (vaakaan.size()>=5)
           kaikki.addAll(vaakaan);
       if (pystyyn.size()>=5)
           kaikki.addAll(pystyyn);
//       System.out.println(kaikki);
       return kaikki;
   }
   
   /** Vakaan tarkistus
    * Kokoaa annetusta koordinaatista vaakaan samojen vierekkäisten merkkien koordinaatit taulukkoon
    * @param x Leveys koordinaatti
    * @param y Pystykoordinaatti
    * @return Palauttaa ArrayListin jossa tarkistuspisteestä lasketit vierekkäisten samojen merkkien koordinaatit
    */
   private ArrayList etsiVaakaan(int x, int y) {
       int merkki = lautamatriisi[x-1][y-1];
       ArrayList koordinaatit = new ArrayList();

       if (merkki==1 || merkki==2) {
       //Vasen suunta
           int vasenmax;        
           ArrayList koordinaatti = new ArrayList();
           koordinaatti.add(x);
           koordinaatti.add(y);
           koordinaatit.add(koordinaatti);
           

           if (x-SUORANKOKO+koordinaatit.size()<1)
                vasenmax=1;
           else vasenmax=x-SUORANKOKO+koordinaatit.size();
        
           for (int i=x-1;i>=vasenmax;i=i-1){
                if (lautamatriisi[i-1][y-1]==merkki) {
                    koordinaatti = new ArrayList();
                    koordinaatti.add(i);
                    koordinaatti.add(y);
                    koordinaatit.add(koordinaatti);
                }         
                else break;
           }

           //Oikea suunta
           int oikeamax;
           if (x+SUORANKOKO-koordinaatit.size()>this.pelilautaLeveys)
                oikeamax=this.pelilautaLeveys;
           else oikeamax=x+SUORANKOKO-koordinaatit.size();
        
           for (int i=x+1;i<=oikeamax;i=i+1){
                if (lautamatriisi[i-1][y-1]==merkki) {
                    koordinaatti = new ArrayList();
                    koordinaatti.add(i);
                    koordinaatti.add(y);
                    koordinaatit.add(koordinaatti);
                }         
                else break;
           }
       }
       return koordinaatit;
   
   }
   private ArrayList etsiPystyyn(int x, int y) {
       int merkki = lautamatriisi[x-1][y-1];
       ArrayList koordinaatit = new ArrayList();

       if (merkki==1 || merkki==2) {
       //Ylöspäin
           int ylosmax;        
           ArrayList koordinaatti = new ArrayList();
           koordinaatti.add(x);
           koordinaatti.add(y);
           koordinaatit.add(koordinaatti);
           

           if (y-SUORANKOKO+koordinaatit.size()<1)
                ylosmax=1;
           else ylosmax=y-SUORANKOKO+koordinaatit.size();
        
           for (int i=y-1;i>=ylosmax;i=i-1){
                if (lautamatriisi[x-1][i-1]==merkki) {
                    koordinaatti = new ArrayList();
                    koordinaatti.add(x);
                    koordinaatti.add(i);
                    koordinaatit.add(koordinaatti);
                }         
                else break;
           }

           //Alaspäin
           int alasmax;
           if (y+SUORANKOKO-koordinaatit.size()>this.pelilautaKorkeus)
                alasmax=this.pelilautaKorkeus;
           else alasmax=y+SUORANKOKO-koordinaatit.size();
        
           for (int i=y+1;i<=alasmax;i=i+1){
                if (lautamatriisi[x-1][i-1]==merkki) {
                    koordinaatti = new ArrayList();
                    koordinaatti.add(x);
                    koordinaatti.add(i);
                    koordinaatit.add(koordinaatti);
                }         
                else break;
           }
       }
       return koordinaatit;
   
   }
   
   
   
   public int[][] haeLautaMatriisiTaulukko() {
       return this.lautamatriisi;
   }
   public int annaMaxKoko() {
       return this.maxmerkkilkm;
   }
   public int annaMerkkilkm() {
       return this.merkkilkm;
   }
   public int annaSuoranKoko() {
       return this.SUORANKOKO;
   }
   public int annaKorkeus() {
       return this.pelilautaKorkeus;
   }
   public int annaLeveys() {
       return this.pelilautaLeveys;
   }
   
   public String tulostaLautaMatriisi() {
       String tuloste = "";
       for (int j=0;j<this.pelilautaKorkeus;j=j+1) {
           for (int i=0;i<this.pelilautaLeveys;i=i+1){
               tuloste = tuloste + this.lautamatriisi[i][j];
           }          
           tuloste+=",";
       }
   return tuloste;
   }
   public String toString() {
       String tuloste = "";
       for (int j=0;j<this.pelilautaKorkeus;j=j+1) {
           for (int i=0;i<this.pelilautaLeveys;i=i+1){
               tuloste = tuloste + this.lautamatriisi[i][j];
           }          
           tuloste+="\r\n";
       }
   return tuloste;
   
   }

}
