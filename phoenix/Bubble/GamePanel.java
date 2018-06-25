package phoenix.Bubble;

import phoenix.Bubble.entities.KeyboardListener;
import phoenix.Bubble.entities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements GamePanelConstants{
    private BufferedImage image;
    private Graphics2D g;
    private GameBackground background;

    private Player player;

    public GamePanel(){
        super();

        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        setFocusable(true);
        requestFocus();

        image = new BufferedImage(PANEL_WIDTH,PANEL_HEIGHT,BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        background = new GameBackground(BACKGROUND_COLOR);
        KeyboardListener keyboard=new KeyboardListener();
        player =new Player(keyboard);
        addKeyListener(keyboard);
    }

    public void gameUpdate(){
        background.update();
        player.update();
    }
    public void gameRender(){
        background.draw(g);
        player.draw(g);
    }
    public void gameDraw(){
            Graphics g2 = this.getGraphics();
            g2.drawImage(image, 0, 0, null);
            g2.dispose();
    }

}
