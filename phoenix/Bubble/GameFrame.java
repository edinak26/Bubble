package phoenix.Bubble;

import javax.swing.*;

public class GameFrame {

    GamePanel panel;
    public GameFrame(){
        panel = new GamePanel();
        JFrame startFrame = new JFrame("BubbleShooter2D");
        startFrame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startFrame.setContentPane(panel);
        startFrame.pack();
        startFrame.setLocationRelativeTo(null);
        startFrame.setVisible(true);


    }

    public void startGame(){
        panel.start();
    }
}
