package phoenix.Bubble;

import phoenix.Bubble.entities.Bullet;
import phoenix.Bubble.entities.KeyboardListener;
import phoenix.Bubble.entities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements GamePanelConstants{
    private BufferedImage image;
    private Graphics2D g;
    private GameBackground background;
    KeyboardListener keyboard;

    private Player player;
    private ArrayList<Bullet> bullets;

    public GamePanel(){
        super();

        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        setFocusable(true);
        requestFocus();

        image = new BufferedImage(PANEL_WIDTH,PANEL_HEIGHT,BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        background = new GameBackground(BACKGROUND_COLOR);
        keyboard=new KeyboardListener();
        player =new Player(keyboard);
        bullets = new ArrayList<Bullet>();
        addKeyListener(keyboard);
    }

    public void gameUpdate(){
        background.update();
        player.update();
        if(keyboard.isSpacePressed()){
            bullets.add(new Bullet(player));
        }
        for(int i = 0; i<bullets.size();i++){
            bullets.get(i).update();
        }
    }
    public void gameRender(){
        background.draw(g);
        player.draw(g);
        for(int i = 0; i<bullets.size();i++){

            bullets.get(i).draw(g);
        }
    }
    public void gameDraw(){
            Graphics g2 = this.getGraphics();
            g2.drawImage(image, 0, 0, null);
            g2.dispose();
    }

}
