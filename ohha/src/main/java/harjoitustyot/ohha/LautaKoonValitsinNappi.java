/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import java.awt.Color;
import javax.swing.JButton;

/**
 *Lautakoon valikon napit
 * Tallettaa tiedot laudan mittasuhteista
 * @author 513228
 */
public class LautaKoonValitsinNappi extends JButton{
    private int leveys;
    private int korkeus;
    
    public LautaKoonValitsinNappi(int leveys, int korkeus, boolean valittu) {
        this.leveys=leveys;
        this.korkeus=korkeus;
        super.setName("Lautakoon valitsin");
        super.setLabel(leveys + "x" + korkeus);
        super.setBackground(Color.blue);
    }
    public LautaKoonValitsinNappi(int leveys, int korkeus) {
        this.leveys=leveys;
        this.korkeus=korkeus;
        super.setName("Lautakoon valitsin");
        super.setLabel(leveys + "x" + korkeus);
    }
    public int annaLeveys() {
        return this.leveys;
    }
    public int annaKorkeus() {
        return this.korkeus;
    }
    public String annaTyyppi() {
        return super.getName();
    }

}
