package Controllers;

import Files.MapFile;
import Models.GameModel;
import Models.Map;
import Models.Player;
import Vues.GameVue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameController extends JFrame implements KeyListener, MouseListener {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private GameVue gameVue;
    private GameModel gameModel;
    private final static int frameWidth = GameVue.getCaseSize() * 16 + 146;
    private final static int frameHeight = GameVue.getCaseSize() * 12 - 12;
    private static int movesSpeed = 10;
        
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public GameController() throws IOException {
        gameModel = new GameModel();
        initialize();
    }    
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    private void initialize() throws IOException {
        //Initialiser l'image du player
        Image playerImage = ImageIO.read(new File("player.png"));
        
        //Attribuer une map et un player au gameModel
        gameModel.setPlayer(new Player(0, 0, playerImage));
        gameModel.setMap(new Map(new MapFile(new File("map2.bin"))));
        
        //Création de la gameVue
        gameVue = new GameVue(gameModel);        
        gameModel.setGameVue(gameVue);
        
        //Configuration de la fenêtre principale
        setTitle("BlueBirdBomb");        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(gameVue);
        setSize(frameWidth, frameHeight);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - frameWidth)/2, (Toolkit.getDefaultToolkit().getScreenSize().height - frameHeight)/2);
        setResizable(false);
        setVisible(true);
        
        //Lancement des nuages flottants
        gameVue.getFloatingCloud().start();
        
        //Lancement de la barre de statistiques
        gameVue.getStatBar().start();
        
        //Ajout des listeners
        addKeyListener(this);
        addMouseListener(this);
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public static int getMovesSpeed() {
        return movesSpeed;
    }
    
    public static int getFrameWidth() {
        return frameWidth;
    }
    
    public static int getFrameHeight() {
        return frameHeight;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Méthodes héritées de l'interface KeyListener
    @Override
    public void keyTyped(KeyEvent ke) { }

    @Override
    public void keyPressed(KeyEvent ke) {
        int key = 0;
        
        try {
            key = ke.getKeyCode();
        }
        catch(UnsupportedOperationException e) { }
                
        switch(key) {
            case KeyEvent.VK_RIGHT : //Mouvement vers la droite
                gameModel.moveOnX(movesSpeed);
                break;
            case KeyEvent.VK_LEFT : //Mouvement vers la gauche
                gameModel.moveOnX(-movesSpeed);
                break;
            case KeyEvent.VK_UP : //Mouvement vers le haut
                gameModel.moveOnY(-movesSpeed);
                break;
            case KeyEvent.VK_DOWN : //Mouvement vers le bas
                gameModel.moveOnY(movesSpeed);
                break;
            case KeyEvent.VK_SPACE : //Déposer une bombe
                try {
                    gameModel.putBomb();
                }
                catch(IOException | InterruptedException e) {}
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) { }

    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Méthodes héritées de l'interface MouseListener
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1) System.out.println("test");
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
