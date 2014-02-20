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
public class NapinKuuntelija implements ActionListener {

    Nappi nappi;
    Kontrolleri kontrolleri;
    
    public NapinKuuntelija(Nappi nappi, Kontrolleri kontrolleri) {
        this.nappi=nappi;
        this.kontrolleri=kontrolleri;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.kontrolleri.kasitteleVastaus(this.nappi.annaX(), this.nappi.annaY());
    }

}
