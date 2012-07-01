package Vues;

import Models.FloatingCloud;
import Models.GameModel;
import Models.StatBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameVue extends JPanel {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private GameModel gameModel;
    private static int caseSize = 40;
    Image bg;
    FloatingCloud floatingCloud;
    StatBar statBar;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public GameVue(GameModel gameModel) throws IOException {
        this.gameModel = gameModel;
        bg = ImageIO.read(new File("background.png"));
        floatingCloud = new FloatingCloud();
        floatingCloud.setGameVue(this);
        statBar = new StatBar();
        statBar.setGameVue(this);
        setBackground(Color.BLACK);
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Affichage du background
        g.drawImage(bg, 0, 0, this.getWidth() -140, this.getHeight(), this);
        
        //Affichage des éléments
        for(int y = 0; y < gameModel.getMap().getMapTab()[0].length; y++) {
            for(int x = 0; x < gameModel.getMap().getMapTab().length; x++) {
                g.drawImage(gameModel.getMap().getImages()[gameModel.getMap().getMapTab()[x][y]], y*caseSize, x*caseSize, caseSize, caseSize, this);
            }
        }
        
        //Affichage des bombe
        if(GameModel.getBombCount() > 0) {
            for(int i = 0; i < GameModel.getBombCount(); i++)
                if(gameModel.getBombs()[i] != null) {
                    g.drawImage(gameModel.getBombs()[i].getImage(), gameModel.getBombs()[i].getxPosition(), gameModel.getBombs()[i].getyPosition(), caseSize, caseSize, this);
                    
                    //Affichage du blaster
                    for(int i2 = 0; i2 < 8; i2++) {
                        if(gameModel.getBombs()[i].getBlaster()[i2][2] == 1 && gameModel.getBombs()[i].hasExplosed()) {
                            g.drawImage(gameModel.getBombs()[i].getImage(), gameModel.getBombs()[i].getBlaster()[i2][0], gameModel.getBombs()[i].getBlaster()[i2][1], caseSize, caseSize, this);
                        }
                    }
                }
        }
        
        //Affichage du player
        g.drawImage(gameModel.getPlayer().getPlayerImage(), gameModel.getPlayer().getxPosition(), gameModel.getPlayer().getyPosition(), caseSize, caseSize, this);
        
        //Affichage des nuages flottants
        g.drawImage(floatingCloud.getImage(), floatingCloud.getxPosition(), floatingCloud.getyPosition(), 230, 135, this);
     
        // Affichage de la barre de statistiques
        g.drawImage(statBar.getImage(), 640, 0, 140, 440, this);
        Font font = new Font("Helvetica-bold", Font.BOLD, 15);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("Statistiques", 667, 50);
        g.drawImage(statBar.getImageLife(), 647, 80, 20, 20, this);
        g.drawString("x 3", 670, 95);
        g.drawImage(statBar.getImageTimer(), 647, 110, 20, 20, this);
        g.drawString("00:59", 672, 127);
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public GameModel getGameModel() {
        return gameModel;
    }

    public static int getCaseSize() {
        return caseSize;
    }
    
    public FloatingCloud getFloatingCloud() {
        return floatingCloud;
    }
    
    public StatBar getStatBar() {
        return statBar;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Setters
    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

  
    
    


}
