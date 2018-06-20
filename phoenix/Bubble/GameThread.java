package phoenix.Bubble;

import javax.swing.*;

public class GameThread extends JPanel implements Runnable{
    private GamePanel panel;

    GameThread(GamePanel panel){
        this.panel=panel;
    }
    void start(){
        Thread thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        while(true){
            gameUpdateRenderDreaw();
            sleep(15);
        }
    }
    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void gameUpdateRenderDreaw(){
        gameUpdate();
        gameRender();
        gameDraw();
    }
    private void gameUpdate(){
        panel.gameUpdate();
    }
    private void gameRender(){
        panel.gameRender();
    }
    private void gameDraw()   { panel.gameDraw();   }

}
