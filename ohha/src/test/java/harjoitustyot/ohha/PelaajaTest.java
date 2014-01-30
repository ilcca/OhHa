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
public class PelaajaTest {
    
    public PelaajaTest() {
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
*/
    @Test
    public void luoPelaajaIlkkaTulostaNimi() {
      Pelaaja pelaaja = new Pelaaja("Ilkka","Risti");
      
      String vastaus = pelaaja.annaNimi(); 

      assertEquals("Ilkka", vastaus);
    }
    @Test
    public void luoPelaajaRistiTulostaMerkki() {
      Pelaaja pelaaja = new Pelaaja("Ilkka","Risti");
      
      String vastaus = pelaaja.annaMerkki(); 

      assertEquals("Risti", vastaus);
    }
    @Test
    public void luoPelaajaTulosta() {
      Pelaaja pelaaja = new Pelaaja("Ilkka","Risti");
      
      String vastaus = pelaaja.toString(); 

      assertEquals("Risti: Ilkka", vastaus);
    }

}
