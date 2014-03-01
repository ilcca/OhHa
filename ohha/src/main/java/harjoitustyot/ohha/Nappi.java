/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import java.awt.Color;
import javax.swing.JButton;

/**
 *Pelilaudan ruudukon painikeet
 * tallentaa nappien sijainnin
 * @author 513228
 */
public class Nappi extends JButton {
    private int x;
    private int y;
    public Nappi(int x, int y, String tyyppi) {
        this.x=x;
        this.y=y;
        super.setBackground(Color.white);
        super.setName(tyyppi);
    
    }
    public Nappi(String label, String tyyppi) {
        super.setBackground(Color.white);
        super.setName(tyyppi);
        super.setLabel(label);
           
    }

    public int annaX() {
        return this.x;
    }
    public int annaY() {
        return this.y;
    }
    public String annaTyyppi() {
        return this.getName();
    }
    
}
