package phoenix.Bubble;

import java.awt.*;

public class GameBackground {
    private Color color;

    GameBackground(){
        color=Color.BLUE;
    }
    public void update(){

    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(0,0,GamePanel.WIDTH,GamePanel.HEIGHT);
    }
}
