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
    private int[][] blaster;
    private boolean state;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public Bomb(int xPosition, int yPosition, int id, GameModel gameModel) throws IOException {
        this.id = id;
        this.gameModel = gameModel;
        state = false;
        bombImage = ImageIO.read(new File("bomb.png"));
        
        //La position de la bombe est calculée de façon à correspondre à la case la plus proche
        this.xPosition = (Math.round ( (float) ( (xPosition + GameVue.getCaseSize() + GameController.getMovesSpeed() )  / GameVue.getCaseSize() ) ) - 1 ) * GameVue.getCaseSize();
        this.yPosition = (Math.round ( (float) ( (yPosition + GameVue.getCaseSize() + GameController.getMovesSpeed() )  / GameVue.getCaseSize() ) ) - 1 ) * GameVue.getCaseSize();
        
        //Calcul des cases devant accueilir le "souffle" de la bombe
        blaster = new int[8][3];
        calculateBlaster();
        destroyBricks();
        
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
        
        state = true;
        
        //Afficher l'animation d'explosion avec 0.05s entre chaque image
        String fileName = "explosion/exp";        
        for(int i = 1; i < 18; i++) {
             try {
                setImage(ImageIO.read(new File(fileName + i + ".png")));
             }catch(IOException e) {}
            
            try {    
                sleep((long) 50);
            }catch(InterruptedException e) {}
        }
        
        //Retirer la bombe de la liste des bombes à afficher
        gameModel.getBombs()[id] = null;
        
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Calcul du blaster
    private void calculateBlaster() {
               
        //Initialisation du blaster        
        for(int i = 0; i < 8; i++) {
            blaster[i][0] = 0;
            blaster[i][1] = 0;
            blaster[i][2] = 0;
        }
        
        //Calcul des positions        
        blaster[0][0] = this.xPosition - GameVue.getCaseSize();
        blaster[0][1] = this.yPosition;
        
        blaster[1][0] = this.xPosition - 2 * GameVue.getCaseSize();
        blaster[1][1] = this.yPosition;
        
        blaster[2][0] = this.xPosition;
        blaster[2][1] = this.yPosition - GameVue.getCaseSize();
        
        blaster[3][0] = this.xPosition;
        blaster[3][1] = this.yPosition - 2 * GameVue.getCaseSize();
        
        blaster[4][0] = this.xPosition + GameVue.getCaseSize();
        blaster[4][1] = this.yPosition;
        
        blaster[5][0] = this.xPosition + 2 * GameVue.getCaseSize();
        blaster[5][1] = this.yPosition;
        
        blaster[6][0] = this.xPosition;
        blaster[6][1] = this.yPosition + GameVue.getCaseSize();
        
        blaster[7][0] = this.xPosition;
        blaster[7][1] = this.yPosition + 2 * GameVue.getCaseSize();
        
        //Déterminer si le blast doit être affiché (s'il n'est pas bloqué par un objet)        
        int caseI, caseIplus;
        
        for(int i = 0; i < 8; i += 2) {
            
            if(blaster[i][0] >= 0 && blaster[i][0] < 16 * GameVue.getCaseSize() && blaster[i][1] >= 0 && blaster[i][1] < 12 * GameVue.getCaseSize()) {
                
                caseI = gameModel.getMap().getMapTab()[blaster[i][1] / 40][blaster[i][0] / 40];
               
                if(caseI != 2) {
                    blaster[i][2] = 1;
                    
                    if(blaster[i + 1][0] >= 0 && blaster[i + 1][0] < 16 * GameVue.getCaseSize() && blaster[i + 1][1] >= 0 && blaster[i + 1][1] < 12 * GameVue.getCaseSize()) {
                        
                        caseIplus = gameModel.getMap().getMapTab()[blaster[i + 1][1] / 40][blaster[i + 1][0] / 40];
                        
                        if(caseI != 1 && caseIplus != 2) blaster[i + 1][2] = 1;
                    }
                }
            }
        }
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Détruit les blocks touchés par le blaster
    private void destroyBricks() throws IOException {
        int line, col;
        BrickExplosion explosion;
        
        for(int i = 0; i < 8; i++) {
            if(blaster[i][2] == 1) {
                line = blaster[i][1] / 40;
                col = blaster[i][0] / 40;
                
                //Retirer la brique de la map
                if(gameModel.getMap().getMapTab()[line][col] == 1) {
                    
                    gameModel.getMap().getMapTab()[line][col] = 3;
                
                    //Ajouter une explosion à la liste du gameModel et lancer l'animation
                    explosion = new BrickExplosion(GameModel.getExplosionCount(), blaster[i][0], blaster[i][1], gameModel);
                    gameModel.addExplosion(explosion);
                    explosion.start();                
                }
            }
        }
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
    
    public int[][] getBlaster() {
        return blaster;
    }
    
    public boolean hasExplosed() {
        return state;
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
