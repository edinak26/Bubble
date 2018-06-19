package phoenix.Bubble;

public class Game {
    private GameFrame gameFrame;

    public Game(){
        gameFrame = new GameFrame();
    }


    public void start(){
        gameFrame.startGame();
    }
}
