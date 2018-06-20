package phoenix.Bubble;

import java.awt.*;

public class Player {
    private int x;
    private int y;
    private int r;

    private Color color1;
    private Color color2;//TODO need in future

    public Player(){
        x=GamePanelConstants.PANEL_WIDTH/2;
        y=GamePanelConstants.PANEL_HEIGHT/2;
        r=GamePanelConstants.PLAYER_RADIUS;
        color1 = GamePanelConstants.PLAYER_COLOR;
    }

    public void update(){

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
