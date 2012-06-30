package Utilitaires.CreatingMaps;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class CreationWindow extends JFrame implements MouseListener {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private final int frameWidth = 960;
    private final int frameHeight = 720;
    private Image[] images;
    private Panel panel;
    private int[][] matrix;
    private int currentImage;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public CreationWindow() throws IOException {
        matrix = new int[12][16];
        initialise();
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Méthode principale invouée à la création de la fenêtre
    private void initialise() throws IOException {
        
        //Configuration de la fenêtre
        setTitle("Utilitaire de création de maps");
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - frameWidth)/2, (Toolkit.getDefaultToolkit().getScreenSize().height - frameHeight)/2);
        setResizable(false);
        
        //Initialisation du Panel
        panel = new Panel();
        getContentPane().add(panel);
        panel.setCreationWindow(this);
        
        //Initialisation de la matrice       
        for(int y = 0; y < 12; y++) {
            for(int x = 0; x < 16; x++) {
                matrix[y][x] = 0;
            }
        }
        
        //Initialisation du tableau d'images
        images = new Image[3];
        images[0] = ImageIO.read(new File("grille.png"));
        images[1] = ImageIO.read(new File("nuage.png"));
        images[2] = ImageIO.read(new File("wall.png"));        
        
        //Ajout du MouseListener
        addMouseListener(this);
        
        int test = panel.getImageNb();
        panel.setImageNb(test);
        panel.repaint();
        
        //Affichage de la fenêtre
        setVisible(true);      
        
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public Image[] getImages() {
        return images;
    }
    
    public int[][] getMatrix() {
        return matrix;
    }
    
    

    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Méthodes héritées de MouseListener    
    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    


}
