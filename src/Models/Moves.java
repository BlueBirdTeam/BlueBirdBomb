package Models;

import java.io.IOException;

public class Moves extends Thread {
    
    //=======================================================================================//
    //                                                                           VARIABLES                                                                                 //
    //=======================================================================================//
    
    private GameModel gameModel;
    private int direction = 0;
    
    //=======================================================================================//
    //                                                                       CONSTRUCTORS                                                                             //
    //=======================================================================================//
    
    public Moves(GameModel gameModel) {
        super();
        
        this.gameModel = gameModel;
    }
    
    //=======================================================================================//
    //                                                                              METHODS                                                                                //
    //=======================================================================================//
    
    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------Run Thread
    @Override
    public void run() {
        
        Thread current = Thread.currentThread();
        
        while(current == this) {
        
            switch(direction) {
                case 0 :
                    break;
                case 1 :
                    gameModel.moveOnX(10);
                    break;
                case 2 :
                    gameModel.moveOnY(10);
                    break;
                case 3 :
                    gameModel.moveOnX(-10);
                    break;
                case 4 :
                    gameModel.moveOnY(-10);
                    break;
                case 10 :
                    try {gameModel.putBomb();
                    } catch(IOException | InterruptedException e) {}
                    break;
           }
            
            if(direction == 10) {
                try {sleep(100);
                } catch(InterruptedException e) {}
            }
            else {
                try {sleep(25);
                } catch(InterruptedException e) {}
            }
            
        }       
    }
    
   public void setDirection(int direction) {
        this.direction = direction;
    }

}
