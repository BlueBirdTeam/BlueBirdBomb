package Models;

import java.awt.Image;
import java.io.IOException;

public class Player {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private int xPosition, yPosition;
    private Image playerImage;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public Player(int xPosition, int yPosition, Image playerImage) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.playerImage = playerImage;
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    public void moveOnX(int xMoveSize) {
        xPosition += xMoveSize;
    }
    
    public void moveOnY(int yMoveSize) {
        yPosition += yMoveSize;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public Image getPlayerImage() {
        return playerImage;
    }
  
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Setters
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setPlayerImage(Image playerImage) {
        this.playerImage = playerImage;
    }
 
    
    

}
