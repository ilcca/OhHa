package harjoitustyot.ohha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author 513228
 */
public class App 
 
{
    public static void main( String[] args )
    {
        Pelilauta pelilauta = new Pelilauta(7, 1);
        System.out.println(pelilauta);
        pelilauta.asetaMerkki(1, 1, "Risti");
        pelilauta.asetaMerkki(2, 1, "Risti");
        pelilauta.asetaMerkki(3, 1, "Risti");
        pelilauta.asetaMerkki(4, 1, "Risti");
        pelilauta.asetaMerkki(5, 1, "Risti");
        System.out.println(pelilauta.etsiSuorat(5,1));

        //System.out.println(peli);
        //peli.suoritaVuoroja();
        
    }
}
