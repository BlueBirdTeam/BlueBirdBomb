package Models;

import Vues.GameVue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FloatingCloud extends Thread {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    Image cloudImage;
    Image[] images;
    GameVue gameVue;
    int xPosition, yPosition;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public FloatingCloud() throws IOException {
        images  = new Image[3];
        images[0] = ImageIO.read(new File("fCloud1.png"));
        images[1] = ImageIO.read(new File("fCloud2.png"));
        images[2] = ImageIO.read(new File("fCloud3.png"));
        xPosition = 646;
        yPosition = (int) Math.round(Math.random() * (510 - 135));        
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Run Thread
    @Override
    public void run() {        
        int i = 0;
        int random = (int) Math.round(Math.random() * 2);
        setImage(images[random]);
        
        while(true) {
            do{                
                i++;
                xPosition -= i;
                
                gameVue.repaint();
                
                try {
                    sleep(100);
                } catch (InterruptedException ex) {System.out.println("erreur"); }
            
            } while(i < 50);
            
            i = 0;
            xPosition = 646;
            yPosition = (int) Math.round(Math.random() * (510 - 135));
            
            random = (int) Math.round(Math.random() * 2);
            setImage(images[random]);
        }
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public Image getImage() {
        return cloudImage;
    }
    
    public int getxPosition() {
        return xPosition;
    }
    
    public int getyPosition() {
        return  yPosition;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Setters
    public void setGameVue(GameVue gameVue) {
        this.gameVue = gameVue;
    }
    
    public void setImage(Image cloudImage) {
        this.cloudImage = cloudImage;
    }

}
