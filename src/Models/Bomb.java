package Models;

import java.io.*;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Bomb {
    
     //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private int xPosition, yPosition;
    private Image bombImage;
    private static int bombNbr = 0;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public Bomb(int xPosition, int yPosition) throws IOException {
        bombImage = ImageIO.read(new File("bomb.png"));
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        bombNbr++;
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    public void putBomb(int xPosition, int yPosition) {
        
    }
    
    private static boolean thereIsABomb() {
        return true;
    }

}
