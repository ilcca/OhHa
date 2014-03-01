/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;
import java.awt.Color;
import javax.swing.JButton;

/**
 * Tavoiteltavan suoran valikoiden napit
 * Tallettaa tiedot suorakoosta
 * @author 513228
 */
public class SuoraKoonValitsinNappi extends JButton{
    private int koko;
    
    public SuoraKoonValitsinNappi(int koko, String label) {
        this.koko=koko;
        super.setName("Suorakoon valitsin");
        super.setLabel(label );

    }
    public SuoraKoonValitsinNappi(int koko, String label, Boolean valittu) {
        this.koko=koko;
        super.setName("Suorakoon valitsin");
        super.setLabel(label );
        super.setBackground(Color.blue);
    }
    public int annaKoko() {
        return this.koko;
    }
    public String annaTyyppi() {
        return this.getName();
    }
    
}
