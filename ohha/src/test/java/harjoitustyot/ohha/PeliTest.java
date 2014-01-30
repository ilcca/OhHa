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
public class PeliTest {
    
    public PeliTest() {
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
    public void luoPeliTulosta() {
      Peli peli = new Peli();
      
      String vastaus = peli.toString(); 

      assertEquals("0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"Risti: Ilkka\r\n" +
"Nolla: Antti", vastaus);
    }
    @Test
    public void luoPeliTulostaPelilauta() {
      Peli peli = new Peli();
      
      String vastaus = peli.annaPelilauta().toString(); 

      assertEquals("0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n" +
"0000000000\r\n", vastaus);
    }
    @Test
    public void luoPeliTulostaRisti() {
      Peli peli = new Peli();
      
      String vastaus = peli.annaPelaajaRisti().toString(); 

      assertEquals("Risti: Ilkka", vastaus);
    }
    @Test
    public void luoPeliTulostaNolla() {
      Peli peli = new Peli();
      
      String vastaus = peli.annaPelaajaNolla().toString(); 

      assertEquals("Nolla: Antti", vastaus);
    }

}
