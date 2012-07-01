package Models;

import Controllers.GameController;
import Vues.GameVue;
import java.io.*;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Bomb extends Thread {
    
     //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private int id;
    private int xPosition, yPosition;
    private Image bombImage;
    private GameModel gameModel;
    private GameVue gameVue;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public Bomb(int xPosition, int yPosition, int id) throws IOException {
        this.id = id;
        bombImage = ImageIO.read(new File("bomb.png"));
        
        //La position de la bombe est calculée de façon à correspondre à la case la plus proche
        this.xPosition = (Math.round ( (float) ( (xPosition + GameVue.getCaseSize() + GameController.getMovesSpeed() )  / GameVue.getCaseSize() ) ) - 1 ) * GameVue.getCaseSize();
        this.yPosition = (Math.round ( (float) ( (yPosition + GameVue.getCaseSize() + GameController.getMovesSpeed() )  / GameVue.getCaseSize() ) ) - 1 ) * GameVue.getCaseSize();
        
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Run Thread
    @Override
    public void run() {
        //Attendre 1.5 seconde avant de faire exploser la bombe
        try {    
            sleep((long) 1500);
        }
        catch(InterruptedException e) {}
        
        //Afficher l'animation d'explosion avec 0.05s entre chaque image
        String fileName = "explosion/exp";        
        for(int i = 1; i < 18; i++) {
             try {
                setImage(ImageIO.read(new File(fileName + i + ".png")));
             }catch(IOException e) {}
             
            gameVue.repaint();
            
            try {    
                sleep((long) 50);
            }catch(InterruptedException e) {}
        }
        
        //Retirer la bombe de la liste des bombes à afficher
        gameModel.getBombs()[id] = null;
        
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }
    
    public Image getImage() {
        return bombImage;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Setters
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setImage(Image image) {
        this.bombImage = image;
    }
    
    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }
    
    public void setGameVue(GameVue gameVue) {
        this.gameVue = gameVue;
    }
    

}
