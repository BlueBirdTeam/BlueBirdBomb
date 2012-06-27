package Vues;

import Models.MainModel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainVue extends JPanel {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private MainModel mainModel;
    private int caseSize = 60;
    Image bg;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public MainVue(MainModel mainModel) throws IOException {
        this.mainModel = mainModel;
        bg = ImageIO.read(new File("background.png"));
        setBackground(Color.BLACK);
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
        
        for(int y = 0; y < mainModel.getMap().getMapTab()[0].length; y++) {
            for(int x = 0; x < mainModel.getMap().getMapTab().length; x++) {
                g.drawImage(mainModel.getMap().getImages()[mainModel.getMap().getMapTab()[x][y]], y*caseSize, x*caseSize, 60, 60, this);
            }
        }
        
        g.drawImage(mainModel.getPlayer().getPlayerImage(), mainModel.getPlayer().getxPosition()*caseSize, mainModel.getPlayer().getyPosition()*caseSize, 60, 60, this);
       
        
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public MainModel getMainModel() {
        return mainModel;
    }

    public int getCaseSize() {
        return caseSize;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Setters
    public void setMainModel(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public void setCaseSize(int caseSize) {
        this.caseSize = caseSize;
    }
    
    
    


}
