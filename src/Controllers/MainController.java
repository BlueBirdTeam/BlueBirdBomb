package Controllers;

import Files.MapFile;
import Models.MainModel;
import Models.Map;
import Models.Player;
import Vues.MainVue;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MainController extends JFrame implements KeyListener {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private MainVue mainVue;
    private MainModel mainModel;
    private MediaTracker tracker;
        
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public MainController() throws IOException {
        mainModel = new MainModel();
        initialize();
    }
    
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    private void initialize() throws IOException {
        tracker = new MediaTracker(this);
        
        Image playerImage = ImageIO.read(new File("player.png"));
        tracker.addImage(playerImage, 0);
        
        mainModel.setPlayer(new Player(0, 0, playerImage));
        mainModel.setMap(new Map(new MapFile(new File("map.bin"))));
        tracker.addImage(mainModel.getMap().getImages()[0], 1);
        tracker.addImage(mainModel.getMap().getImages()[1], 2);
        tracker.addImage(mainModel.getMap().getImages()[2], 3);
        
        mainVue = new MainVue(mainModel);        
        mainModel.setMainVue(mainVue);
        
        setSize(970, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainVue);
        setVisible(true);
        
        try {
            tracker.waitForAll();
        }
        catch(InterruptedException e) { return; }
        
        addKeyListener(this);
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
        catch(UnsupportedOperationException e) {e.printStackTrace();}
                
        switch(key) {
            case KeyEvent.VK_RIGHT :
                mainModel.moveOnX(1);
                break;
            case KeyEvent.VK_LEFT :
                mainModel.moveOnX(-1);
                break;
            case KeyEvent.VK_UP :
                mainModel.moveOnY(-1);
                break;
            case KeyEvent.VK_DOWN :
                mainModel.moveOnY(1);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) { }

}
