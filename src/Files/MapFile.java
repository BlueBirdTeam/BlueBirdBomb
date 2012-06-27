package Files;

import java.io.*;
import java.util.*;
import Utilitaires.*;

public class MapFile extends FileIO {
    
    //=======================================================================================//
    //                                                                           VARIABLES   //
    //=======================================================================================//
    
    private File mapFile;
    private final int nbCol = 16;
    private final int nbLine = 12;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS    //
    //=======================================================================================//
    
    public MapFile(File mapFile) throws IOException {
        super(mapFile, "rw", 16);
        this.mapFile = mapFile;        
    }
    
    //=======================================================================================//
    //                                                                              METHODS  //
    //=======================================================================================//
    
    public int getNbLine() {
        return nbLine;
    }
    
    public int getNbCol() {
        return nbCol;
    }
    public void writeMap() throws IOException {
        String line = "";
        boolean success;
        
        for(int i1 = 0; i1 < nbLine; i1++) {
            
            do {           
                System.out.print("Line " + i1 + " :");
                line = Scan.readString();
                success = descriptAndWriteMapLign(line);
            } while(!success);
        }       
    }
    
    private boolean descriptAndWriteMapLign(String lign) throws IOException {
        if(lign.length() == nbCol) {
            writeString(lign, nbCol);
            return true;
        }
        return false;
    }
    
    public int[][] readMap() throws IOException {
        int[][] mapTab = new int[nbLine][nbCol];
        String lign;
        
        seekFile(1);
        
        for(int i1 = 0; i1 < nbLine; i1++) {
            lign = readString(nbCol);
            
            for(int i2 = 0; i2 < nbCol; i2++) {
                
                switch(lign.charAt(i2)) {
                    case 'o' :
                        mapTab[i1][i2] = 0;
                        break;
                    case 'b' :
                        mapTab[i1][i2] = 1;
                        break;
                    case 'w' :
                        mapTab[i1][i2] = 2;
                        break;
                }
            }                        
        }
        
        return mapTab;
    }
    
    @Override
    public String toString() {
        String retour = "";
        int[][] tab = new int[nbLine][nbCol];
        
        try {
            tab = readMap();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
        for(int i1 = 0; i1 < nbLine; i1++) {
            for(int i2 = 0; i2 < nbCol; i2++) {
                retour += tab[i1][i2];
            }
            retour += "\n";
        }
        
        return retour;
    }
    
    
    
    

}
