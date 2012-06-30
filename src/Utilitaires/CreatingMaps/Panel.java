package Utilitaires.CreatingMaps;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private CreationWindow creationWindow;
    private Image bg;
    private JTextField champ;
    private int caseSize = 40;
    private int imageNb;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public Panel() throws IOException {
        setLayout(null);
        
        bg = ImageIO.read(new File("BackGround.png"));
        
        champ = new JTextField("0");
        champ.setBounds(0, 0, 20, 20);
        add(champ);
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------PaintComponent
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), this);
        
        for(int y = 0; y < 12; y++) {
            for(int x = 0; x < 16; x++) {
                g.drawImage(creationWindow.getImages()[creationWindow.getMatrix()[y][x]], x*caseSize + 150, y*caseSize + 100, caseSize, caseSize, this);
            }
        }
        
        String test = String.valueOf(imageNb);
        
        g.drawString(String.valueOf(imageNb), 120, 120);
        
        
        
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Setters
    public void setCreationWindow(CreationWindow creationWindow) {
        this.creationWindow = creationWindow;
    }
    
    public void setImageNb(int imageNb) {
        this.imageNb = imageNb;
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public int getImageNb() {
        return Integer.parseInt(champ.getText());
    }
    
    
    

}
