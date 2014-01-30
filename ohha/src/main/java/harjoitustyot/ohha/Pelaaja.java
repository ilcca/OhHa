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
class Pelaaja {
    private String nimi = "";
    private String merkki = "";
    
    public Pelaaja(String nimi, String merkki) {
        this.nimi=nimi;
        this.merkki=merkki;
    }
    public String annaNimi(){
        return this.nimi;
    }
    public String annaMerkki(){
        return this.merkki;
    }
    public String toString(){
        return this.merkki + ": " + this.nimi;
    }
}
