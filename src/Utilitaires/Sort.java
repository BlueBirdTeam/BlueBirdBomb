package Utilitaires;



public class Sort {

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Trie et retourne un tableau d'entiers
    //----------sens = "desc" (plus grand entier à l'indice 0) ou "asc" (plus petit entier à l'indice 0)  
    public static int[] sortIntegers(int[] integers, String sens) {
        int temp;
        
        if(sens == "asc" || sens == "desc") {

            for(int i1 = 0; i1 < integers.length; i1++) {

                for(int i2 = 0; i2 < integers.length; i2++) {

                    switch(sens) {

                        case "desc" :
                            if(integers[i2] < integers[i1]) {
                                temp = integers[i2];
                                integers[i2] = integers[i1];
                                integers[i1] = temp;
                            }
                            break;

                        case "asc" :
                            if(integers[i2] > integers[i1]) {
                                temp = integers[i2];
                                integers[i2] = integers[i1];
                                integers[i1] = temp;
                            }
                            break;
                    }
                }
            }

            return integers;
        }
        
        else return integers;
        
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Trie et retourne un tableau de doubles
    //----------sens = "desc" (plus grand double à l'indice 0) ou "asc" (plus petit double à l'indice 0)  
    public static double[] sortDoubles(double[] doubles, String sens) {
        double temp;
        
        if(sens == "asc" || sens == "desc") {

            for(int i1 = 0; i1 < doubles.length; i1++) {

                for(int i2 = 0; i2 < doubles.length; i2++) {

                    switch(sens) {

                        case "desc" :
                            if(doubles[i2] < doubles[i1]) {
                                temp = doubles[i2];
                                doubles[i2] = doubles[i1];
                                doubles[i1] = temp;
                            }
                            break;

                        case "asc" :
                            if(doubles[i2] > doubles[i1]) {
                                temp = doubles[i2];
                                doubles[i2] = doubles[i1];
                                doubles[i1] = temp;
                            }
                            break;
                    }
                }
            }

            return doubles;
        }
        
        else return doubles;
        
    }
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Trie et retourne un tableau de String
    //----------sens = "desc" (ordre alphabétique décroissant) ou "asc" (ordre alphabétique croissant)  
    public static String[] sortStrings(String[] strings, String sens) {
        String temp;
        
        if(sens == "asc" || sens == "desc") {

            for(int i1 = 0; i1 < strings.length; i1++) {

                for(int i2 = 0; i2 < strings.length; i2++) {

                    switch(sens) {

                        case "desc" :
                            if(strings[i2].compareToIgnoreCase(strings[i1]) > 0) {
                                temp = strings[i2];
                                strings[i2] = strings[i1];
                                strings[i1] = temp;
                            }
                            break;

                        case "asc" :
                            if(strings[i2].compareToIgnoreCase(strings[i1]) < 0) {
                                temp = strings[i2];
                                strings[i2] = strings[i1];
                                strings[i1] = temp;
                            }
                            break;
                    }
                }
            }

            return strings;
        }
        
        else return strings;
        
    }
    
}
