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
                
        Peli peli = new Peli();
        Naytto naytto = new Naytto(peli.annaPelilauta().annaLeveys(),peli.annaPelilauta().annaKorkeus());
        Kontrolleri kontrolleri = new Kontrolleri(naytto, peli);
//        peli.suoritaVuoroja();
        
    }

}
