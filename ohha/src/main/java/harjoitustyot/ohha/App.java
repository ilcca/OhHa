package harjoitustyot.ohha;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Pelilauta pelilauta = new Pelilauta(30,30);
        
        System.out.println(pelilauta.tulostaLautaMatriisi());   
        System.out.println( "Hello World!" );
    }
}
