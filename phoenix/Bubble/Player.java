package phoenix.Bubble;

import java.awt.*;

public class Player {
    private int x;
    private int y;
    private int r;

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

        up=false;
        down=false;
        left=false;
        right=false;
    }

    public void update(){
        if(up&&y>r){
            y -= speed;
        }
        if(down&&y<GamePanel.PANEL_HEIGHT-r){
            y+=speed;
        }
        if(left&&x>r){
            x -= speed;
        }
        if(right&&x<GamePanel.PANEL_WIDTH-r){
            x+=speed;
        }
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
