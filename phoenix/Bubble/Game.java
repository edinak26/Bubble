package phoenix.Bubble;

public class Game {
    private GamePanel panel;
    private GameFrame frame;
    private GameThread gameThread;

    public Game(){
        panel = new GamePanel();
        frame = new GameFrame(panel);
        gameThread = new GameThread(panel);
    }
    public void start(){
        gameThread.start();
    }
}
