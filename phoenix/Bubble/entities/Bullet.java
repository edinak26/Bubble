package phoenix.Bubble.entities;

import phoenix.Bubble.GamePanel;
import phoenix.Bubble.entities.basicEntities.ColorCircle;

import java.awt.*;
import java.util.Random;

public class Bullet extends ColorCircle {
    private double speed;

    public Bullet(Player player){
        x=player.getX();
        y=player.getY();
        color=GamePanel.BULLET_COLOR;
        circleRadius=2;
        speed=11;
    }

    public void update(){
       //Random randNum  = new Random(System.currentTimeMillis());
        y-=speed ;//+ randNum.nextInt(10);
    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval(x,y,circleRadius,2*circleRadius);
    }

}
