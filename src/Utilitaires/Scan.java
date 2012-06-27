package Utilitaires;

import java.util.Locale;
import java.util.Scanner;

public class Scan {

    public static int readInt() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();        
    }
    
    public static double readDouble() {        
        Scanner s = new Scanner(System.in).useLocale(Locale.US);
        return s.nextDouble();       
    }
    
    public static String readString() {
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
    
    
}
