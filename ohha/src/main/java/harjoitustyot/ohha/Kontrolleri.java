/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 513228
 */
public class Kontrolleri {
    private Peli peli;
    private Naytto naytto;
    
    public Kontrolleri(Naytto naytto, Peli peli) {
        this.peli=peli;
        this.naytto=naytto;
    }
    public void Kontrolloi() {
        ActionListener kuuntelija;
        for (int i=0;i<this.peli.annaPelilauta().annaLeveys();i++) {
            for (int j=0;j<this.peli.annaPelilauta().annaKorkeus();j++) {
                kuuntelija = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {                  
//                        int x = e.getSource();
                        kasitteleVastaus(1,1);
                    }
                };
                naytto.annaNappi(i+1, j+1).addActionListener(kuuntelija);
            }
        }
    }
    private void kasitteleVastaus(int x, int y){
        if (peli.annaPelilauta().asetaMerkki(x, y, peli.annaVuoro()))
            naytto.asetaNappi(x,y,peli.annaVuoro());
        
    }
}