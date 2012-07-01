package Models;

import Files.MapFile;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Map {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//.
    
    private MapFile mapFile;
    private int[][] mapTab;
    private Image[] images;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public Map(MapFile mapFile) throws IOException {
        this.mapFile = mapFile;
        this.mapTab = mapFile.readMap();
        
        images = new Image[3];
        
        Image empty = ImageIO.read(new File("grille.png"));
        Image brick = ImageIO.read(new File("nuage.png"));
        Image wall = ImageIO.read(new File("wall.png"));

        this.images[0] = empty;
        this.images[1] = brick;
        this.images[2] = wall;
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Retourne vrai ou faux selon que la case permet un déplacement ou non
    public boolean isFree(int casePositionX, int casePositionY) {
        if(casePositionX < 0 || casePositionX >= mapFile.getNbCol() || casePositionY < 0 || casePositionY >= mapFile.getNbLine()) return false; //Si la case dépasse les limites de la fenêtre, alors false
        else if(mapTab[casePositionY][casePositionX] == 1 || mapTab[casePositionY][casePositionX] == 2) return false; //Si la case est un mur ou une brique alors faux
        else return true; //Sinon vrai
    }

    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Getters
    public MapFile getMapFile() {
        return mapFile;
    }

    public int[][] getMapTab() {
        return mapTab;
    }

    public Image[] getImages() {
        return images;
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Setters
    public void setMapFile(MapFile mapFile) {
        this.mapFile = mapFile;
    }

    public void setMapTab(int[][] mapTab) {
        this.mapTab = mapTab;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }
    
    

}
