package Models;

import Vues.GameVue;
import java.io.IOException;

public class GameModel {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private Map map;
    private Player player;
    private GameVue gameVue;
    private static int bombCount = 0;
    private static int explosionCount = 0;
    private Bomb[] bombs;
    private FloatingCloud[] floatingClouds;
    private BrickExplosion[] brickExplosions;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public GameModel() {
        bombs = new Bomb[1000];
        brickExplosions = new BrickExplosion[1000];
        floatingClouds = new FloatingCloud[1000];
    }    
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    
    //=======================================================================================//
    //      Pour chaque type de déplacements, on calcule sur quelleS caseS veut avancer le player
    //      La taille de l'image du player est prise en compte dans le calcul
    //      Ceci permet que le player ne traverse pas une case non libre lorsqu'il se trouve par exemple entre deux cases
    //      La map est ensuite consultée pour savoir si les cases sont libres et autorisent le déplacement
    //      La vue principale est finalement redessinée
    //=======================================================================================//
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Gestion des déplacements sur l'axe X
    public void moveOnX(int xMoveSize) { 

        int casePositionX = 0, casePositionYup = 0, casePositionYdown = 0;
        int caseSize = GameVue.getCaseSize();
        
        switch(xMoveSize) {
            case 10 :
                casePositionX = (player.getxPosition() + caseSize + xMoveSize - 1) / caseSize;
                casePositionYup = player.getyPosition() / caseSize;
                casePositionYdown = (player.getyPosition() + caseSize - 1) / caseSize;               
                
                if(map.isFree(casePositionX, casePositionYup) && map.isFree(casePositionX, casePositionYdown)) {
                    player.moveOnX(xMoveSize);
                }
                  
                break;
                
            case -10 :
                casePositionX = (player.getxPosition() + xMoveSize) / caseSize;
                casePositionYup = (player.getyPosition() / caseSize);
                casePositionYdown = (player.getyPosition() + caseSize - 1) / caseSize;
                
                if(map.isFree(casePositionX, casePositionYup) && map.isFree(casePositionX, casePositionYdown) && (player.getxPosition() + xMoveSize) >= 0) {
                    player.moveOnX(xMoveSize);
                }
                
                break;
        }     
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Gestion des déplacements sur l'axe Y
    public void moveOnY(int yMoveSize) {
        
        int casePositionXleft = 0, casePositionXright = 0, casePositionY = 0;
        int caseSize = GameVue.getCaseSize();
        
        switch(yMoveSize) {
            case -10 :
                casePositionXleft = (player.getxPosition() / caseSize);
                casePositionXright = (player.getxPosition() + caseSize - 1) / caseSize;
                casePositionY = (player.getyPosition() + yMoveSize) / caseSize;
                
                if(map.isFree(casePositionXleft, casePositionY) && map.isFree(casePositionXright, casePositionY) && (player.getyPosition() + yMoveSize) >= 0) {
                    player.moveOnY(yMoveSize);
                }
                
                break;
                
            case 10 :
                casePositionXleft = (player.getxPosition() / caseSize);
                casePositionXright = (player.getxPosition() + caseSize - 1) / caseSize;
                casePositionY = (player.getyPosition() + caseSize + yMoveSize - 1) / caseSize;
                
                if(map.isFree(casePositionXleft, casePositionY) && map.isFree(casePositionXright, casePositionY)) {
                    player.moveOnY(yMoveSize);
                }
               
                break;
        }        
        
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Gestion des dépôts de bombes
    public void putBomb() throws IOException, InterruptedException { 
        Bomb bomb = new Bomb(player.getxPosition(), player.getyPosition(), bombCount, this);
        bomb.setGameVue(gameVue);        
        bombs[bombCount] = bomb;
        
        bomb.start();
        
        bombCount++;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Gestion des explosions
    public void addExplosion(BrickExplosion explosion) {
        brickExplosions[explosionCount] = explosion;
        explosionCount++;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public Map getMap() {
        return map;
    }

    public Player getPlayer() {
        return player;
    }

    public GameVue getGameVue() {
        return gameVue;
    }
    
    public static int getBombCount() {
        return bombCount;
    }
    
    public Bomb[] getBombs() {
        return bombs;
    }
    
    public static int getExplosionCount() {
        return explosionCount;
    }
    
    public BrickExplosion[] getExplosions() {
        return brickExplosions;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Setters
    public void setMap(Map map) {
        this.map = map;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGameVue(GameVue gameVue) {
        this.gameVue = gameVue;
    }
  
    

}
