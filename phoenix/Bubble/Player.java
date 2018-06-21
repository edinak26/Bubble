package phoenix.Bubble;

import java.awt.*;

public class Player {
    private int x;
    private int y;
    private int r;

    private double dx;
    private double dy;

    private int speed;

    private Color color1;
    private Color color2;//TODO need in future

    public static boolean up;//TODO it s too bad, you must change
    public static boolean down;
    public static boolean left;
    public static boolean right;

    public Player(){
        x=GamePanelConstants.PANEL_WIDTH/2;
        y=GamePanelConstants.PANEL_HEIGHT/2;
        r=GamePanelConstants.PLAYER_RADIUS;
        color1 = GamePanelConstants.PLAYER_COLOR;
        speed = 5;

        dx=0;
        dy=0;

        up=false;
        down=false;
        left=false;
        right=false;
    }

    public void update(){
        if(up&&y>r){
            dy = -speed;
        }
        if(down&&y<GamePanel.PANEL_HEIGHT-r){
            dy=speed;
        }
        if(left&&x>r){
            dx = -speed;
        }
        if(right&&x<GamePanel.PANEL_WIDTH-r){
            dx=speed;
        }
        if(up&&left||left&&down||down&&right||right&&up){
            dy=dy * Math.sin(45);
            dx=dx * Math.cos(45);
        }
        y=y+(int)dy;
        x=x+(int)dx;
        dx=0;
        dy=0;
    }

    public void draw(Graphics2D g){
        g.setColor(color1);
        g.fillOval(x-r,y-r,2*r,2*r);
        g.setStroke(new BasicStroke(3));
        g.setColor(color1.darker());
        g.drawOval(x-r,y-r,2*r,2*r);
        g.setStroke(new BasicStroke(1));
    }

}
