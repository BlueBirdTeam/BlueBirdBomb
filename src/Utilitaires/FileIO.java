package Utilitaires;

import java.io.*;
import java.util.*;

public class FileIO extends RandomAccessFile {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private int recordSize;    
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public FileIO(File file, String mode, int recordSize) throws IOException {
        super(file, mode);
        this.recordSize = recordSize;
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
   
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Déplace la tête de lecture à l'enregistrement indiqué
    public void seekFile(int recordId) throws IOException {
        seek(recordSize * recordId - recordSize);
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Déplace la tête de lecture à la fin du fichier
    public void seekToEnd() throws IOException {
        seek(length());
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Ecrit une chaine de caractères en insérant les blancs nécessaires pour le fomatage
    public void writeString(String string, int stringSize) throws IOException {
        //Retirer les espaces superflus de la chaine
        string = string.trim();
        if(string.length() > 30) string = string.substring(0, 30);
        int stringLength = string.length();
        
        //Insérer les espaces nécessaires
        for(int i = 0; i < stringSize - stringLength; i++) {
            string += " ";            
        }

        //Ecrire la chaine dans le fichier
        writeBytes(string);
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Lit une chaine de caractères en respectant le formatage
    public String readString(int stringSize) throws IOException {
        //Initialiser une chaine vide
        String string = "";
        
        //Remplir la chaine avec le nombre de bytes correspondant au formatage
        for(int i = 0; i < stringSize; i++) {
            string += (char) readByte();
        }
        
        //Retourner la chaine sans les espaces superflus
        return string.trim();
    }
    
}
