package Vues;

import Models.MainModel;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MainVue extends JPanel {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private MainModel mainModel;
    private int caseSize = 60;    
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public MainVue(MainModel mainModel) {
        this.mainModel = mainModel;
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
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
