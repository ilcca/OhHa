/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 513228
 */
public class PelilautaTest {
    
    public PelilautaTest() {
    }
    
/*
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {}

*/
    @Test
    public void LuoPelilauta() {
      Pelilauta lauta = new Pelilauta(7,7);
      
      String vastaus = lauta.tulostaLautaMatriisi(); 

      assertEquals("0000000,0000000,0000000,0000000,0000000,0000000,0000000,", vastaus);
    }
    @Test
    public void LuoLiianPieniPelilauta() {
      Pelilauta lauta = new Pelilauta(5,5);
      
      String vastaus = lauta.tulostaLautaMatriisi(); 

      assertEquals("0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,", vastaus);
    }
        

    @Test
    public void LuoLiianIsoPelilauta() {
      Pelilauta lauta = new Pelilauta(30,30);
      
      String vastaus = lauta.tulostaLautaMatriisi(); 

      assertEquals("0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,", vastaus);
    }
    @Test
    public void LuoLiianLeveaPelilauta() {
      Pelilauta lauta = new Pelilauta(30,7);
      
      String vastaus = lauta.tulostaLautaMatriisi(); 

      assertEquals("0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,", vastaus);
    }
    @Test
    public void LuoLiianKorkeaPelilauta() {
      Pelilauta lauta = new Pelilauta(7,30);
      
      String vastaus = lauta.tulostaLautaMatriisi(); 

      assertEquals("0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,", vastaus);
    }
    @Test
    public void asetaMerkkiRistiOikeinTulostaLauta() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      
      lauta4.asetaMerkki(3, 3, "Risti");
      String vastaus = lauta4.tulostaLautaMatriisi(); 

      assertEquals("0000000,0000000,0010000,0000000,0000000,0000000,0000000,", vastaus);
    }
    @Test
    public void asetaMerkkiRistiOikeinTulostaOnnistuiko() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      boolean vastaus = false;
      vastaus = lauta4.asetaMerkki(3, 3, "Risti");
      assertEquals(true, vastaus);
    }


    @Test
    public void asetaMerkkiNollaOikeinTulostaLauta() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      
      lauta4.asetaMerkki(3, 3, "Nolla");
      String vastaus = lauta4.tulostaLautaMatriisi(); 

      assertEquals("0000000,0000000,0020000,0000000,0000000,0000000,0000000,", vastaus);
    }
    @Test
    public void asetaMerkkiNollaOikeinTulostaOnnistuiko() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      boolean vastaus = false;
      vastaus = lauta4.asetaMerkki(3, 3, "Nolla");

      assertEquals(true, vastaus);
    }
    @Test
    public void asetaMerkkiNollaVarattuunPaikkaanTulostaOnnistuiko() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      boolean vastaus = false;
      vastaus = lauta4.asetaMerkki(3, 3, "Nolla");
      vastaus=lauta4.asetaMerkki(3, 3, "Nolla");
      assertEquals(false, vastaus);

    }
    @Test
    public void asetaMerkkiNollaVarattuunPaikkaanTulostaLauta() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      lauta4.asetaMerkki(3, 3, "Risti");
      lauta4.asetaMerkki(3, 3, "Nolla");
      String vastaus = lauta4.tulostaLautaMatriisi(); 

      assertEquals("0000000,0000000,0010000,0000000,0000000,0000000,0000000,", vastaus);

    }
    @Test
    public void asetaMerkkiVaaraTulostaOnnistuiko() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      boolean vastaus = false;
      vastaus = lauta4.asetaMerkki(3, 3, "Nola");
      assertEquals(false, vastaus);

    }
    @Test
    public void asetaMerkkiRistiLaudanRajalleVasenylaTulostaLauta() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      lauta4.asetaMerkki(1, 1, "Risti");
      String vastaus = lauta4.tulostaLautaMatriisi(); 
      assertEquals("1000000,0000000,0000000,0000000,0000000,0000000,0000000,", vastaus);
    }
    @Test
    public void asetaMerkkiRistiLaudanRajalleOikeaAlaTulostaLauta() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      lauta4.asetaMerkki(7, 7, "Risti");
      String vastaus = lauta4.tulostaLautaMatriisi(); 
      assertEquals("0000000,0000000,0000000,0000000,0000000,0000000,0000001,", vastaus);
    }
    @Test
    public void asetaMerkkiRistiYliLaudanVasenYlaTulostaOnnistuiko() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      boolean vastaus = false;
      vastaus = lauta4.asetaMerkki(0, 0, "Risti");
      assertEquals(false, vastaus);
    }
    @Test
    public void asetaMerkkiRistiYliLaudanOikeaAlaTulostaOnnistuiko() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      boolean vastaus = false;
      vastaus = lauta4.asetaMerkki(8, 8, "Risti");
      assertEquals(false, vastaus);
    }
    @Test
    public void asetaMerkkiRistiYliLaudanYlhaallaTulostaOnnistuiko() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      boolean vastaus = false;
      vastaus = lauta4.asetaMerkki(5, 0, "Risti");
      assertEquals(false, vastaus);
    }
    @Test
    public void asetaMerkkiRistiYliLaudanALhaallaTulostaOnnistuiko() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      boolean vastaus = false;
      vastaus = lauta4.asetaMerkki(5, 8, "Risti");
      assertEquals(false, vastaus);
    }
    @Test
    public void asetaMerkkiRistiYliLaudanOikeallaTulostaOnnistuiko() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      boolean vastaus = false;
      vastaus = lauta4.asetaMerkki(8, 5, "Risti");
      assertEquals(false, vastaus);
    }
    @Test
    public void asetaMerkkiRistiYliLaudanVasemmallaTulostaOnnistuiko() {
      Pelilauta lauta4 = new Pelilauta(7,7);
      boolean vastaus = false;
      vastaus = lauta4.asetaMerkki(0, 5, "Risti");
      assertEquals(false, vastaus);
    }

}
