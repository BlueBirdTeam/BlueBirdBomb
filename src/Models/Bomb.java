package Models;

import Controllers.MainController;
import Vues.MainVue;
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
    private MainModel mainModel;
    private MainVue mainVue;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public Bomb(int xPosition, int yPosition, int id) throws IOException {
        this.id = id;
        bombImage = ImageIO.read(new File("bomb.png"));
        
        //La position de la bombe est calculée de façon à correspondre à la case la plus proche
        this.xPosition = (Math.round((float) ((xPosition + MainVue.getCaseSize() + MainController.getMovesSpeed()) / MainVue.getCaseSize())) - 1) * MainVue.getCaseSize();
        this.yPosition = (Math.round((float) ((yPosition + MainVue.getCaseSize() + MainController.getMovesSpeed()) / MainVue.getCaseSize())) - 1) * MainVue.getCaseSize();
        
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Run Thread
    @Override
    public void run() {
        try {    
            sleep((long) 1500);
        }
        catch(InterruptedException e) {}
        
        try {
            setImage(ImageIO.read(new File("explosion.png")));
        }
        catch(IOException e) {}
        
        mainVue.repaint();
        
        try {    
            sleep((long) 500);
        }
        catch(InterruptedException e) {}
        
        mainModel.getBombs()[id] = null;
        
        mainVue.repaint();
        
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
    
    public void setMainModel(MainModel mainModel) {
        this.mainModel = mainModel;
    }
    
    public void setMainVue(MainVue mainVue) {
        this.mainVue = mainVue;
    }
    

}
