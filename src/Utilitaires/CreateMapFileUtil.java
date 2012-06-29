package Utilitaires;

import Files.MapFile;
import java.io.File;
import java.io.IOException;

public class CreateMapFileUtil {
    
    public static void main(String[] args) throws IOException {
        
        String name = "";
        System.out.print("Donnez un nom à la map : ");
        name = Scan.readString() + ".bin";
        
        MapFile mapFile = new MapFile(new File(name));
        
        mapFile.writeMap();
        
    }

}
