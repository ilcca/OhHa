/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;

/**
 *
 * @author 513228
 */
public class Naytto extends JFrame{
    JPanel paneeli;
    Nappi[][] napit;
    private final Image ristikuva = new ImageIcon(getClass().getResource("/risti.PNG")).getImage();
    private final Image nollakuva = new ImageIcon(getClass().getResource("/nolla.PNG")).getImage();
    //getScaleInstance(
    //setEnabled(false)
    private final ImageIcon risti= new ImageIcon(ristikuva);
    private final ImageIcon nolla= new ImageIcon(nollakuva);
//private static final ImageIcon nolla = new ImageIcon("nolla.PNG");
/*public static void main(String[] args) {
        new GUI();
    }
    */
    public Naytto(int leveys, int korkeus) {
        super("RistiNolla");
        setSize(1000,700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.paneeli = new JPanel();
        this.paneeli.setLayout(new GridLayout(leveys, korkeus));
        
        this.napit = new Nappi[leveys][korkeus];
        for (int j=0;j<leveys;j++) {
            for (int i=0;i<korkeus;i++) {
                this.napit[i][j]=new Nappi(i+1, j+1);
                this.paneeli.add(napit[i][j]);
            }
        }
        
        add(this.paneeli);        
        setVisible(true);
        
    }
    public void naytaVoittorivi(ArrayList voittorivi) {
        for (int i=0;i<voittorivi.size();i++) {
            ArrayList k = (ArrayList) voittorivi.get(i);
            napit[(int)k.get(0)-1][(int)k.get(1)-1].setBackground(Color.green);
        }
        /*        System.out.println(k.get(0));
        System.out.println(voittorivi.get(0));
        System.out.println(voittorivi);
        //this.napit[voittorivi.get(0).get(0)][voittorivi.get(0).get(1)].setLabel("red");
*/                
    }
    public Nappi[][] annaNapit() {
        return this.napit;  
    }
    public Nappi annaNappi(int x, int y) {
        return this.napit[x-1][y-1];  
    }
    public void asetaNappi(int x, int y, String merkki) {
        if (merkki.equals("Risti")) this.napit[x-1][y-1].setLabel("X");
        else this.napit[x-1][y-1].setLabel("o");

        //if (merkki.equals("Risti")) this.napit[x-1][y-1].setIcon(risti);
        //else this.napit[x-1][y-1].setIcon(nolla);
                
    }
}
    


