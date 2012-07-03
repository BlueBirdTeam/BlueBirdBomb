package Models;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BrickExplosion extends Thread {

    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private int nb;
    private int posX;
    private int posY;
    private GameModel gameModel;
    private Image image;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public BrickExplosion(int nb, int posX, int posY, GameModel gameModel) throws IOException {
        this.nb = nb;
        this.posX = posX;
        this.posY = posY;
        this.gameModel = gameModel;
        this.image = ImageIO.read(new File("nuage.png"));
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Run Thread
    @Override
    public void run() {
        String path;
        
        //Attendre l'explosion de la bombe
        try {
            sleep(1500);
        } catch (InterruptedException ex) {}
        
        //Afficher l'animation
        for(int i = 1; i < 11; i++) {
            path = "brickExplosion/bExp" + i + ".png";
            
            try {
                setImage(ImageIO.read(new File(path)));
            }
            catch(IOException e) {System.out.println("erreur");}
            
            //Libérer l'accès à la case avant que l'étoile n'apparaisse
            if(i == 8) {
                gameModel.getMap().getMapTab()[posY / 40][posX / 40] = 0; 
            }
            
            //Laisser un intervalle de 50ms entre chaque image
            try {
                sleep(30);
            } catch (InterruptedException e) {}
        }
        
        //Laisser afficher la dernière image pour un meilleur effet visuel
        try {
            sleep(200);
        } catch (InterruptedException ex) {}
        
        //Retirer l'explosion de la liste du gameModel
        gameModel.getExplosions()[nb] = null;
        
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public int getNb() {
        return nb;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public Image getImage() {
        return image;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Setters
    public void setNb(int nb) {
        this.nb = nb;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    
}
