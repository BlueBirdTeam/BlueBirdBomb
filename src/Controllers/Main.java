package Controllers;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameController game = new GameController();
        Thread gameThread = new Thread(game);
        gameThread.start();
        
    }
    
    

}
