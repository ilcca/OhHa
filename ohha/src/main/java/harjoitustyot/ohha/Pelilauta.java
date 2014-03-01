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
 * 
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
   private int SUORANKOKO=5;
   private int maxmerkkilkm;
   private int merkkilkm = 0;

   /**
    * Konstruktori luo laudan matriisin annetuilla leveydellä ja korkeudella
    * Jos annetut mittasuhteet liian isoja tai pieniä, luo oletuskokoisen laudan
    * @param leveys Laudan leveys
    * @param korkeus Laudaan korkeus
    * @param suorankoko Pelissä tavopiteltavan merkkijonon pituus
    * 
    */
   public Pelilauta (int leveys, int korkeus, int suorankoko){
        this.pelilautaKorkeus=korkeus;
        this.pelilautaLeveys=leveys;

        this.SUORANKOKO=suorankoko;
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
    * Kokoaa neljä tarkistus metodia etsiVaakaan, etsiPystyyn, etsiOIkeaYlä, etsi VasenALa pelin voittajan selvittämiseksi
    * Etsintä tehdään aina viimeksi lisätyn koordinaatin välittömästä läheisyydstä - eu tarkista siis koko lautaa
    * Palauttaa voittorivin, jossa voi olla useampia voittosuuntia
    * @param x Leveys koordinaatti
    * @param y Pystykoordinaatti
    * @return Palauttaa ArrayListin jossa tarkistuspisteestä lasketit vierekkäisten samojen merkkien koordinaatit
    */
   public ArrayList etsiSuorat(int x, int y) {
       
//       System.out.println("Suoorankoko2: " + this.SUORANKOKO);
       ArrayList kaikki = new ArrayList();
       ArrayList vaakaan = etsiVaakaan(x,y);
       ArrayList pystyyn = etsiPystyyn(x,y);
       ArrayList ristiin1 = etsiVasenYlaOikeaAla(x,y);
       ArrayList ristiin2 = etsiOikeaYlaVasenAla(x,y);
//       System.out.println(vaakaan);
//       System.out.println(pystyyn);
//       System.out.println(ristiin1);
       
       if (vaakaan.size()>=this.SUORANKOKO)
           kaikki.addAll(vaakaan);
       if (pystyyn.size()>=this.SUORANKOKO)
           kaikki.addAll(pystyyn);
       if (ristiin1.size()>=this.SUORANKOKO)
           kaikki.addAll(ristiin1);
       if (ristiin2.size()>=this.SUORANKOKO)
           kaikki.addAll(ristiin2);
 //      System.out.println(kaikki);
       return kaikki;
   }
   
   /** Vakaan tarkistus
    * Kokoaa annetusta koordinaatista vaakaan samojen vierekkäisten merkkien koordinaatit taulukkoon
    * @param x Leveys koordinaatti
    * @param y Pystykoordinaatti
    * @return Palauttaa ArrayListin jossa tarkistuspisteestä lasketit vierekkäisten samojen merkkien koordinaatit
    */
   private ArrayList etsiVaakaan(int x, int y) {
       int merkki = this.lautamatriisi[x-1][y-1];
       ArrayList koordinaatit = new ArrayList();

       if (merkki==1 || merkki==2) {
       //Vasen suunta
           int vasenmax;        
           ArrayList koordinaatti = new ArrayList();
           koordinaatti.add(x);
           koordinaatti.add(y);
           koordinaatit.add(koordinaatti);
           

           if (x-this.SUORANKOKO+koordinaatit.size()<1)
                vasenmax=1;
           else vasenmax=x-this.SUORANKOKO+koordinaatit.size();
        
           for (int i=x-1;i>=vasenmax;i=i-1){
                if (this.lautamatriisi[i-1][y-1]==merkki) {
                    koordinaatti = new ArrayList();
                    koordinaatti.add(i);
                    koordinaatti.add(y);
                    koordinaatit.add(koordinaatti);
                }         
                else break;
           }

           //Oikea suunta
           int oikeamax;
           if (x+this.SUORANKOKO-koordinaatit.size()>this.pelilautaLeveys)
                oikeamax=this.pelilautaLeveys;
           else oikeamax=x+this.SUORANKOKO-koordinaatit.size();
        
           for (int i=x+1;i<=oikeamax;i=i+1){
                if (this.lautamatriisi[i-1][y-1]==merkki) {
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
   /** Pystyyn tarkistus
    * Kokoaa annetusta koordinaatista pystyyn samojen peräkkäisten merkkien koordinaatit taulukkoon
    * @param x Leveys koordinaatti
    * @param y Pystykoordinaatti
    * @return Palauttaa ArrayListin jossa tarkistuspisteestä lasketit vierekkäisten samojen merkkien koordinaatit
    */
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
   
   /** Oikealle alas tarkistus - ensimmäinen viistosuunta
    * Kokoaa annetusta koordinaatista Oikealle alas samojen vierekkäisten merkkien koordinaatit taulukkoon
    * @param x Leveys koordinaatti
    * @param y Pystykoordinaatti
    * @return Palauttaa ArrayListin jossa tarkistuspisteestä lasketit vierekkäisten samojen merkkien koordinaatit
    */

   private ArrayList etsiVasenYlaOikeaAla(int x, int y) {
       int merkki = lautamatriisi[x-1][y-1];
       ArrayList koordinaatit = new ArrayList();

       if (merkki==1 || merkki==2) {
           ArrayList koordinaatti = new ArrayList();
           koordinaatti.add(x);
           koordinaatti.add(y);
           koordinaatit.add(koordinaatti);

           //Vasenyläsuunta           
           int ylosmax;        
           if (y-SUORANKOKO<0)
                ylosmax=y-1;
           else ylosmax=SUORANKOKO-1;
        
           int vasenmax;        
           if (x-SUORANKOKO<0)
                vasenmax=x-1;
           else vasenmax=SUORANKOKO-1;
           int max=Math.min(vasenmax, ylosmax);
//           System.out.println("1.max " + max);
           for (int i=1;i<=max;i=i+1){
                if (lautamatriisi[x-1-i][y-1-i]==merkki) {
                    koordinaatti = new ArrayList();
                    koordinaatti.add(x-i);
                    koordinaatti.add(y-i);
                    koordinaatit.add(koordinaatti);
                }         
                else break;
           }
           
//           System.out.println("b:" + koordinaatit);

           //Oikeaalasuunta           
           int alasmax;        
           if (this.pelilautaKorkeus<y+SUORANKOKO-koordinaatit.size())
                alasmax=this.pelilautaKorkeus-y;
           else alasmax=SUORANKOKO-koordinaatit.size();
        
           int oikeamax;        
           if (this.pelilautaLeveys<x+SUORANKOKO-koordinaatit.size())
                oikeamax=this.pelilautaLeveys-x;
           else oikeamax=SUORANKOKO-koordinaatit.size();

           max=Math.min(oikeamax, alasmax);
           
//           System.out.println("2.max " + max);

           for (int i=1;i<=max;i=i+1){
                if (lautamatriisi[x-1+i][y-1+i]==merkki) {
                    koordinaatti = new ArrayList();
                    koordinaatti.add(x+i);
                    koordinaatti.add(y+i);
                    koordinaatit.add(koordinaatti);
                }         
                else break;
           }
       }
//       System.out.println("a:" + koordinaatit);

       return koordinaatit;
   
   }
   
   
   /** Oikealle ylös tarkistus - toinen viistosuunta
    * Kokoaa annetusta koordinaatista Oikealle ylös samojen vierekkäisten merkkien koordinaatit taulukkoon
    * @param x Leveys koordinaatti
    * @param y Pystykoordinaatti
    * @return Palauttaa ArrayListin jossa tarkistuspisteestä lasketit vierekkäisten samojen merkkien koordinaatit
    */

   private ArrayList etsiOikeaYlaVasenAla(int x, int y) {
       int merkki = lautamatriisi[x-1][y-1];
       ArrayList koordinaatit = new ArrayList();

       if (merkki==1 || merkki==2) {
           ArrayList koordinaatti = new ArrayList();
           koordinaatti.add(x);
           koordinaatti.add(y);
           koordinaatit.add(koordinaatti);

           //Oikeayläsuunta           
           int ylosmax;        
           if (y-SUORANKOKO<0)
                ylosmax=y-1;
           else ylosmax=SUORANKOKO-1;
        
           int oikeamax;        
           if (this.pelilautaLeveys<x+SUORANKOKO-koordinaatit.size())
                oikeamax=this.pelilautaLeveys-x;
           else oikeamax=SUORANKOKO-koordinaatit.size();

           int max=Math.min(oikeamax, ylosmax);
//           System.out.println("1.max " + max);
           for (int i=1;i<=max;i=i+1){
                if (lautamatriisi[x-1+i][y-1-i]==merkki) {
                    koordinaatti = new ArrayList();
                    koordinaatti.add(x+i);
                    koordinaatti.add(y-i);
                    koordinaatit.add(koordinaatti);
                }         
                else break;
           }
           
//           System.out.println("b:" + koordinaatit);

           //Oikeaalasuunta           
           int alasmax;        
           if (this.pelilautaKorkeus<y+SUORANKOKO-koordinaatit.size())
                alasmax=this.pelilautaKorkeus-y;
           else alasmax=SUORANKOKO-koordinaatit.size();
        
           int vasenmax;        
           if (x-SUORANKOKO<0)
                vasenmax=x-1;
           else vasenmax=SUORANKOKO-1;

           max=Math.min(vasenmax, alasmax);
           
//           System.out.println("2.max " + max);

           for (int i=1;i<=max;i=i+1){
                if (lautamatriisi[x-1-i][y-1+i]==merkki) {
                    koordinaatti = new ArrayList();
                    koordinaatti.add(x-i);
                    koordinaatti.add(y+i);
                    koordinaatit.add(koordinaatti);
                }         
                else break;
           }
       }
//       System.out.println("a:" + koordinaatit);

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
   
//aputulosteita
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
