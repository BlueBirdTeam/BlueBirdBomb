package Controllers;

import Files.MapFile;
import Models.MainModel;
import Models.Map;
import Models.Player;
import Vues.MainVue;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MainController extends JFrame implements KeyListener, MouseListener {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private MainVue mainVue;
    private MainModel mainModel;
    private MediaTracker tracker;
    private final int frameWidth = MainVue.getCaseSize() * 16 + 6;
    private final int frameHeight = MainVue.getCaseSize() * 12 + 30;
    private static int movesSpeed = 10;
        
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
        mainModel.setMap(new Map(new MapFile(new File("map2.bin"))));
        tracker.addImage(mainModel.getMap().getImages()[0], 1);
        tracker.addImage(mainModel.getMap().getImages()[1], 2);
        tracker.addImage(mainModel.getMap().getImages()[2], 3);
        
        mainVue = new MainVue(mainModel);        
        mainModel.setMainVue(mainVue);
        
        setTitle("BlueBirdBomb");
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainVue);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - frameWidth)/2, (Toolkit.getDefaultToolkit().getScreenSize().height - frameHeight)/2);
        setResizable(false);
        setVisible(true);
        
        try {
            tracker.waitForAll();
        }
        catch(InterruptedException e) { return; }
        
        addKeyListener(this);
        addMouseListener(this);
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public static int getMovesSpeed() {
        return movesSpeed;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Méthodes héritées de l'interface KeyListener
    @Override
    public void keyTyped(KeyEvent ke) { }

    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void keyPressed(KeyEvent ke) {
        int key = 0;
        
        try {
            key = ke.getKeyCode();
        }
        catch(UnsupportedOperationException e) {e.printStackTrace();}
                
        switch(key) {
            case KeyEvent.VK_RIGHT :
                mainModel.moveOnX(movesSpeed);
                break;
            case KeyEvent.VK_LEFT :
                mainModel.moveOnX(-movesSpeed);
                break;
            case KeyEvent.VK_UP :
                mainModel.moveOnY(-movesSpeed);
                break;
            case KeyEvent.VK_DOWN :
                mainModel.moveOnY(movesSpeed);
                break;
            case KeyEvent.VK_SPACE :
                try {
                    mainModel.putBomb();
                }
                catch(IOException | InterruptedException e) {}
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) { }

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
