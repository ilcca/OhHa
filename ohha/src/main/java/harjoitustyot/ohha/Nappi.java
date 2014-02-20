/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author 513228
 */
public class Nappi extends JButton {
    private final int x,y;
    public Nappi(int x, int y) {
        this.x=x;
        this.y=y;
        super.setBackground(Color.white);
    
    }
    public void asetaNappi() {
    }
    public int annaX() {
        return this.x;
    }
    public int annaY() {
        return this.y;
    }
    
}
