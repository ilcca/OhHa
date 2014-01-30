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
public class Peli {
    private final Pelaaja pelaajaRisti;
    private final Pelaaja pelaajaNolla;
    private Pelilauta pelilauta;
    public Peli() {
        this.pelaajaRisti=new Pelaaja ("Ilkka", "Risti");
        this.pelaajaNolla=new Pelaaja ("Antti", "Nolla");
        this.pelilauta=new Pelilauta (10, 10);
    }
    public Pelilauta annaPelilauta (){
        return this.pelilauta;
    }
    public Pelaaja annaPelaajaRisti (){
        return this.pelaajaRisti;
    }
    public Pelaaja annaPelaajaNolla (){
        return this.pelaajaNolla;
    }
    
    public String toString() {
        return this.pelilauta.toString() + this.pelaajaRisti + "\r\n" + this.pelaajaNolla;
    }
}

