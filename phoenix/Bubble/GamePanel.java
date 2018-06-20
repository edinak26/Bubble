package phoenix.Bubble;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements GamePanelConstants{
    private BufferedImage image;
    private Graphics2D g;
    private GameBackground background;

    public GamePanel(){
        super();

        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        setFocusable(true);
        requestFocus();

        image = new BufferedImage(PANEL_WIDTH,PANEL_HEIGHT,BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        background = new GameBackground(BACKGROUND_COLOR);
    }

    public void gameUpdate(){
        background.update();
    }
    public void gameRender(){
        background.draw(g);
    }
    public void gameDraw(){
            Graphics g2 = this.getGraphics();
            g2.drawImage(image, 0, 0, null);
            g2.dispose();
    }

}
