/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;
import java.util.Arrays;


/**
 *
 * @author 513228
 */
public class Pelilauta {
   private int pelilautaKorkeus;
   private int pelilautaLeveys;
   private final int OLETUSKOKO=10;
   private int[][] lautamatriisi; // pelilaudan ruudukko, ruudukoilla arvot 0 = tyhjä, 1=pelaajan yksi merkki, 2=pelaajan kaksi merkki
   //kuinka montaa peräkkäistä tavoitellaan
   private final int SUORANKOKO=5;
   
   public Pelilauta (int korkeus, int leveys){
       //Asettaa korkeus ja leveysmuuttujat jos ovat välillä 7-25 muuten oletuskoko 15
       if (korkeus>=7 && korkeus<=25 && leveys>=7 && leveys<=25) {
        this.pelilautaKorkeus=korkeus;
        this.pelilautaLeveys=leveys;
       }
       else {
        this.pelilautaKorkeus=OLETUSKOKO;
        this.pelilautaLeveys=OLETUSKOKO;           
       }
       
       //luo pelilaudan matriisin ja alustaa matriisin ruutujen aloitustilat eli tyhjjät
       this.lautamatriisi=new int [pelilautaKorkeus][pelilautaLeveys];
   }
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
           return true;
       }
       return false;
   }
   
   
   /*
   public int[][] etsiSuorat(int x, int y, String merkki) {
       int tulosvektori[][]=etsiVaakaan(x,y,merkki);
       return null;
   }

   private int[][] etsiVaakaan(int x, int y) {
       int merkki = lautamatriisi[x-1][y-1];
       if (merkki==1 || merkki==2) {
       //Vasen suunta
       int suora = 1;
       int vasen=SUORANKOKO-suora;
       if (vasen>x)
           vasen=x;
       for (int i=vasen;i<=0;i=i-1){
           if (lautamatriisi[i-1][y-1]==merkki) {
               suora+=1;
           }         
           else break;
       }
       int oikea=SUORANKOKO-suora;
       if (oikea>x)
           oikea=x;
       for (int i=oikea;i<=0;i=i-1){
           if (lautamatriisi[i-1][y-1]==merkki) {
               suora+=1;
           }         
           else break;
       }
       }
       return null;
   }
   */
   
   
   public int[][] haeLautaMatriisiTaulukko() {
       return this.lautamatriisi;
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
