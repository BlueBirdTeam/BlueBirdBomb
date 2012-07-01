package Models;

import Controllers.GameController;
import java.io.*;
import java.util.*;
import Utilitaires.*;
import Vues.GameVue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatBar extends JPanel implements Runnable {

    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private Image bg, life, timer;
    private int time = 60;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public StatBar() throws IOException {
        bg = ImageIO.read(new File("StatBarBG.png"));
        life = ImageIO.read(new File("life.png"));
        timer = ImageIO.read(new File("timer.png"));
        
    }
   
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(this.getImage(), 640, 0, 140, 510, this);
        Font font = new Font("Helvetica-bold", Font.BOLD, 15);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Statistiques", 667, 50);
        g.drawImage(this.getImageLife(), 650, 80, 20, 20, this);
        g.drawString("x 3", 673, 95);
        g.drawImage(this.getImageTimer(), 650, 110, 20, 20, this);
        g.drawString("00:" + time, 675, 127);
    }
        
    @Override
    public void run() {
        while(true) {
            do {
                time--;
                this.repaint();
                try {
                    Thread.sleep((long) 1000);
                } catch (InterruptedException ex) { System.out.println("erreur"); }
            } while(time <= 60);
        }   
    }
    
    public Image getImage() {
        return bg;
    }
    
    public Image getImageLife() {
        return life;
    }
    
    public Image getImageTimer() {
        return timer;
    }
}
