/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;



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
       if (x>this.pelilautaLeveys-1) return false;
       if (y>this.pelilautaKorkeus-1) return false;
       if (merkki.matches("Risti")) syote=1;
       else if (merkki.matches("Nolla")) syote=2;
       else return false;
//Tarkista onko paikka vapaana
       if (this.lautamatriisi[x][y]==0) {
           this.lautamatriisi[x][y]=syote;
       }
       return true;
    }
   
   
   /*
   public int[][] etsiSuorat() {
       etsiVaakaan();
       return null;
   }

   private int[][] etsiVaakaan() {
      int[][] rivintyhjennys = {{0,0},{0,0},{0,0},{0,0},{0,0}};
      int[][] rivinkoordinaatit = rivintyhjennys;
      int rivinpituus = 0;
      int rivinmerkki = 0;
      
      outerloop:
      for (int j=0;j<this.pelilautaKorkeus;j=j+1) {
          rivinkoordinaatit = rivintyhjennys;
          rivinkoordinaatit[0][0] = 0;  
          rivinkoordinaatit[0][1] = j;  
          rivinpituus=1;
          if (this.lautamatriisi[0][j]==1)
              rivinmerkki=1;
          else rivinmerkki=2;
         
          for (int i=1;i<this.pelilautaLeveys-SUORANKOKO;i=i+1) {
            if (this.lautamatriisi[i][j]==1){
                    
            }
          }
            
            if (this.lautamatriisi[i][j]==2);
                    nolla+=1;
   }
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
}
