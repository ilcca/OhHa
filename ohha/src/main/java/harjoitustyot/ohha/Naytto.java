/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
/**
 *
 * @author 513228
 */
public class Naytto extends JFrame{
    JPanel paneeli;
    Nappi[][] napit;
    
    /*public static void main(String[] args) {
        new GUI();
    }
    */
    public Naytto(Peli peli) {
        super("RistiNolla");
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
//Alusta Panel ja Grid
        this.paneeli = new JPanel();
        this.paneeli.setLayout(new GridLayout(pelilauta.annaLeveys(),pelilauta.annaKorkeus()));
//Luo Napit        
        this.napit = new Nappi[pelilauta.annaLeveys()][pelilauta.annaKorkeus()];
        for (int i=0;i<pelilauta.annaLeveys();i++) {
            for (int j=0;j<pelilauta.annaKorkeus();j++) {
                this.napit[i][j]=new Nappi();
                //lisääNapit Gridiin
                this.paneeli.add(napit[i][j]);
            }
        }
        
        add(this.paneeli);        
        setVisible(true);
        
    }
}
    


