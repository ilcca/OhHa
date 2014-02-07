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

import java.util.ArrayList;


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
        Pelilauta pelilauta = new Pelilauta(7, 1);
        pelilauta.asetaMerkki(1, 1, "Risti");
        pelilauta.asetaMerkki(2, 1, "Risti");
        pelilauta.asetaMerkki(3, 1, "Risti");
        pelilauta.asetaMerkki(4, 1, "Risti");
        pelilauta.asetaMerkki(5, 1, "Risti");
        ArrayList vastaus = pelilauta.etsiSuorat(5,1);
        
        assertEquals("0000000,0000000,0000000,0000000,0000000,0000000,0000001,", vastaus);
    }

}
