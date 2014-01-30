package harjoitustyot.ohha;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Pelilauta pelilauta = new Pelilauta(30,30);
        
//        System.out.println(pelilauta.tulostaLautaMatriisi());   
//        System.out.println(pelilauta);   
//          System.out.println(Arrays.deepToString(pelilauta.haeLautaMatriisiTaulukko()).replaceAll("],", "],\r\n"));
        Peli peli = new Peli();
        System.out.println(peli);
        
    }
}
