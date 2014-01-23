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
      Pelilauta lauta1 = new Pelilauta(7,7);
      
      String vastaus = lauta1.tulostaLautaMatriisi(); 

      assertEquals("0000000,0000000,0000000,0000000,0000000,0000000,0000000,", vastaus);
    }
    @Test
    public void LuoLiianPieniPelilauta() {
      Pelilauta lauta2 = new Pelilauta(5,5);
      
      String vastaus = lauta2.tulostaLautaMatriisi(); 

      assertEquals("0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,", vastaus);
    }
        

    @Test
    public void LuoLiianIsoPelilauta() {
      Pelilauta lauta3 = new Pelilauta(30,30);
      
      String vastaus = lauta3.tulostaLautaMatriisi(); 

      assertEquals("0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,0000000000,", vastaus);
    }

}
