package Models;

import Vues.MainVue;
import java.io.IOException;

public class MainModel {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private Map map;
    private Player player;
    private MainVue mainVue;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public MainModel() {
        
    }    
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    public void moveOnX(int xMoveSize) {
        boolean ok = false;
        int casePositionX = 0, casePositionYup = 0, casePositionYdown = 0;
        int caseSize = mainVue.getCaseSize();
        
        switch(xMoveSize) {
            case 10 :
                casePositionX = (player.getxPosition() + caseSize + xMoveSize - 1) / caseSize;
                casePositionYup = player.getyPosition() / caseSize;
                casePositionYdown = (player.getyPosition() + caseSize - 1) / caseSize;               
                
                if(map.isFree(casePositionX, casePositionYup) && map.isFree(casePositionX, casePositionYdown)) {
                    player.moveOnX(xMoveSize);
                    mainVue.repaint();
                }
                  
                break;
                
            case -10 :
                casePositionX = (player.getxPosition() + xMoveSize) / caseSize;
                casePositionYup = (player.getyPosition() / caseSize);
                casePositionYdown = (player.getyPosition() + caseSize - 1) / caseSize;
                
                if(map.isFree(casePositionX, casePositionYup) && map.isFree(casePositionX, casePositionYdown) && (player.getxPosition() + xMoveSize) >= 0) {
                    player.moveOnX(xMoveSize);
                    mainVue.repaint();
                }
                
                break;
        }     
    }
    
    public void moveOnY(int yMoveSize) {
        boolean ok = false;
        int casePositionXleft = 0, casePositionXright = 0, casePositionY = 0;
        int caseSize = mainVue.getCaseSize();
        
        switch(yMoveSize) {
            case -10 :
                casePositionXleft = (player.getxPosition() / caseSize);
                casePositionXright = (player.getxPosition() + caseSize - 1) / caseSize;
                casePositionY = (player.getyPosition() + yMoveSize) / caseSize;
                
                if(map.isFree(casePositionXleft, casePositionY) && map.isFree(casePositionXright, casePositionY) && (player.getyPosition() + yMoveSize) >= 0) {
                    player.moveOnY(yMoveSize);
                    mainVue.repaint();
                }
                
                break;
                
            case 10 :
                casePositionXleft = (player.getxPosition() / caseSize);
                casePositionXright = (player.getxPosition() + caseSize - 1) / caseSize;
                casePositionY = (player.getyPosition() + caseSize + yMoveSize - 1) / caseSize;
                
                if(map.isFree(casePositionXleft, casePositionY) && map.isFree(casePositionXright, casePositionY)) {
                    player.moveOnY(yMoveSize);
                    mainVue.repaint();
                }
                
                break;
        }        
        
    }
    
    public void putBomb() throws IOException{
        player.putBomb();
        mainVue.repaint();
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public MainVue getMainVue() {
        return mainVue;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Setters
    public void setMap(Map map) {
        this.map = map;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMainVue(MainVue mainVue) {
        this.mainVue = mainVue;
    }
    
    

}
