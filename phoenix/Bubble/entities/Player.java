package phoenix.Bubble.entities;

import phoenix.Bubble.GamePanel;
import phoenix.Bubble.entities.basicEntities.ColorCircle;

import java.awt.*;



public class Player extends ColorCircle {
    private double speedX;
    private double speedY;
    private KeyboardListener keyboard;


    public Player(KeyboardListener keyboard){
        this.keyboard = keyboard;
    }


    public void update(){
        setMovingSpeed();
        move();
        checkCrossedPanelBorder();

    }
    private void setMovingSpeed(){
        setMovingUpSpeed();
        setMovingDownSpeed();
        setMovingLeftSpeed();
        setMovingRightSpeed();
        setMovingDeceleration();
    }
    private void setMovingUpSpeed(){
        if(keyboard.isUpPressed()&&speedY>-GamePanel.MAX_SPEED){
            speedY -=GamePanel.SPEED_SHIFT;
        }
    }
    private void setMovingDownSpeed(){
        if(keyboard.isDownPressed()&&speedY<GamePanel.MAX_SPEED){
            speedY += GamePanel.SPEED_SHIFT;
        }
    }
    private void setMovingLeftSpeed(){
        if(keyboard.isLeftPressed()&&speedX>-GamePanel.MAX_SPEED){
            speedX -= GamePanel.SPEED_SHIFT;
        }
    }
    private void setMovingRightSpeed(){
        if(keyboard.isRightPressed()&&speedX<GamePanel.MAX_SPEED){
            speedX += GamePanel.SPEED_SHIFT;
        }
    }
    private void setMovingDeceleration(){
        if(!keyboard.isUpPressed()&&!keyboard.isDownPressed()&&(int)speedY!=0){
            speedY=(Math.abs(speedY)-GamePanel.SPEED_SHIFT)*speedY/Math.abs(speedY);
        }
        if(!keyboard.isLeftPressed()&&!keyboard.isRightPressed()&&(int)speedX!=0){
            speedX=(Math.abs(speedX)-GamePanel.SPEED_SHIFT)*speedX/Math.abs(speedX);
        }
    }
    private void move(){
        y=y+(int)speedY;
        x=x+(int)speedX;
    }
    private void checkCrossedPanelBorder(){
        if(getUpperBorderY()<=0){
            y=circleRadius;
        }
        if(getBottomBorderY()>=GamePanel.PANEL_HEIGHT){
            y=GamePanel.PANEL_HEIGHT-circleRadius;
        }
        if(getLeftBorderX()<=0){
            x=circleRadius;
        }
        if(getRightBorderX()>=GamePanel.PANEL_WIDTH){
            x=GamePanel.PANEL_WIDTH-circleRadius;
        }
    }
    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval(getLeftBorderX(),getUpperBorderY(),2* circleRadius,2* circleRadius);
        g.setStroke(new BasicStroke(3));
        g.setColor(color.darker());
        g.drawOval(getLeftBorderX(),getUpperBorderY(),2* circleRadius,2* circleRadius);
        g.setStroke(new BasicStroke(1));
    }

}
