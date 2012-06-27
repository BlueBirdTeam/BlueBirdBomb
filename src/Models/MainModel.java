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
        if(map.isFree(player.getxPosition() + xMoveSize, player.getyPosition())) {
            player.moveOnX(xMoveSize);
            mainVue.repaint();
        }
    }
    
    public void moveOnY(int yMoveSize) {
        if(map.isFree(player.getxPosition(), player.getyPosition() + yMoveSize)) {
            player.moveOnY(yMoveSize);
            mainVue.repaint();
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
