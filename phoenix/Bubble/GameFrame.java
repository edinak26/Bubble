package phoenix.Bubble;

import javax.swing.*;

public class GameFrame {
    private JFrame frame;

    public GameFrame(GamePanel panel){
        frame = new JFrame("BubbleShooter2D");
        frame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
