package Models;

import Controllers.GameController;
import java.io.*;
import java.util.*;
import Utilitaires.*;
import Vues.GameVue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import javax.imageio.ImageIO;

public class StatBar extends Thread {

    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private Image bg, life, timer;
    private int yPosition, xPosition;
    private int height = GameController.getFrameHeight();
    private int width = 200;
    private GameVue gameVue;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public StatBar() throws IOException {
        bg = ImageIO.read(new File("StatBarBG.png"));
        life = ImageIO.read(new File("life.png"));
        timer = ImageIO.read(new File("timer.png"));
        yPosition = 0;
        xPosition = GameController.getFrameWidth();
        
    }
   
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    @Override
    public void run() {
        // timer à définir
        gameVue.repaint();
    }
    
    public int getxPosition() {
        return xPosition;
    }
    
    public int getyPosition() {
        return yPosition;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setGameVue(GameVue gameVue) {
        this.gameVue = gameVue;
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
