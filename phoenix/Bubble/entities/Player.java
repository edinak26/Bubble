package phoenix.Bubble.entities;

import phoenix.Bubble.GamePanel;

import java.awt.*;

public class Player extends ColorCircle{
    private double shiftX;
    private double shiftY;
    private double speedX;
    private double speedY;
    private int speed;
    private KeyboardListener keyboard;


    public Player(KeyboardListener keyboard){

        this.keyboard = keyboard;
        speed = 0;
        setZeroShift();
    }


    public void update(){
        setMovingVerticalHorizontalShift();
        setMovingDiagonalShift();
        setSpeed();
        System.out.println(speed);
        move();
        checkCrossedPanelBorder();
        setZeroShift();

    }
    private void setMovingVerticalHorizontalShift(){
        setMovingUpShift();
        setMovingDownShift();
        setMovingLeftShift();
        setMovingRightShift();
    }
    private void setMovingUpShift(){
        if(keyboard.isUpPressed()){
            speedY -= speed;
        }
    }
    private void setMovingDownShift(){
        if(keyboard.isDownPressed()){
            shiftY += speed;
        }
    }
    private void setMovingLeftShift(){
        if(keyboard.isLeftPressed()){
            shiftX -= speed;
        }
    }
    private void setMovingRightShift(){
        if(keyboard.isRightPressed()){
            shiftX += speed;
        }
    }
    private void setMovingDiagonalShift(){
        boolean isUpLeftDiagonalMoving=keyboard.isUpPressed()&&keyboard.isLeftPressed();
        boolean isUpRightDiagonalMoving=keyboard.isUpPressed()&&keyboard.isRightPressed();
        boolean isDownLeftDiagonalMoving=keyboard.isDownPressed()&&keyboard.isLeftPressed();
        boolean isDownRightDiagonalMoving=keyboard.isDownPressed()&&keyboard.isRightPressed();
        boolean isDiagonalMoving=isUpLeftDiagonalMoving||isUpRightDiagonalMoving||isDownLeftDiagonalMoving||isDownRightDiagonalMoving;
        if(isDiagonalMoving){
            shiftY = shiftY * Math.sin(45);
            shiftX = shiftX * Math.cos(45);
        }
    }
    private void setSpeed() {
        if(keyboard.isPressedSomething()&&speed<GamePanel.MAX_SPEED){
            speed++;
        }
        if(!keyboard.isPressedSomething()&&speed>0){
            speed--;
        }
    }
    private void move(){
        y=y+(int)shiftY;
        x=x+(int)shiftX;
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
    private void setZeroShift(){
        shiftX=0;
        shiftY=0;
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
