/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harjoitustyot.ohha;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
/**
 *
 * @author 513228
 */
public class Naytto extends JFrame{
    JPanel paneeli;
    JButton[][] napit;
    
    /*public static void main(String[] args) {
        new GUI();
    }
    */
    public Naytto(int korkeus, int leveys) {
        super("RistiNolla");
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.paneeli = new JPanel();
        this.paneeli.setLayout(new GridLayout(leveys, korkeus));

        this.napit = new JButton[leveys][korkeus];
        for (int i=0;i<leveys;i++) {
            for (int j=0;j<korkeus;j++) {
                this.napit[i][j]=new JButton();
                this.paneeli.add(napit[i][j]);
            }
        }
        
        add(this.paneeli);        
        setVisible(true);
        
    }
    public JButton[][] annaNapit() {
        return this.napit;  
    }
    public JButton annaNappi(int x, int y) {
        return this.napit[x-1][y-1];  
    }
    public void asetaNappi(int x, int y, String merkki) {
        this.napit[x-1][y-1].setLabel(merkki);
    }
}
    


