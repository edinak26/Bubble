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
                setMovingSpeed();
                setMovingVerticalHorizontalShift();
                setMovingDiagonalShift();
                System.out.println(speed);
                move();
                checkCrossedPanelBorder();
                setZeroShift();

                    }
    private void setMovingSpeed(){
                setMovingUpSpeed();
                setMovingDownSpeed();
                setMovingLeftSpeed();
                setMovingRightSpeed();
                setMovingDeceleration();
            }
    private void setMovingUpSpeed(){
                if(keyboard.isUpPressed()){
                        speedY -=GamePanel.SPEED_SHIFT;
                    }
            }
    private void setMovingDownSpeed(){
                if(keyboard.isDownPressed()){
                        speedY += GamePanel.SPEED_SHIFT;
                    }
            }
    private void setMovingLeftSpeed(){
                if(keyboard.isLeftPressed()){
                        speedX -= GamePanel.SPEED_SHIFT;
                    }
            }
    private void setMovingRightSpeed(){
                if(keyboard.isRightPressed()){
                        speedX += GamePanel.SPEED_SHIFT;
                    }
            }
            private void setMovingDeceleration(){
                if(!keyboard.isUpPressed()&&!keyboard.isDownPressed()&&(int)speedY!=0){
                    speedY-=(Math.abs(speedY)-GamePanel.SPEED_SHIFT)*speedY/Math.abs(speedY);
                }
                if(!keyboard.isLeftPressed()&&!keyboard.isRightPressed()&&(int)speedX!=0){
                    speedX-=(Math.abs(speedX)-GamePanel.SPEED_SHIFT)*speedX/Math.abs(speedX);
                }
            }
            private void setMovingVerticalHorizontalShift(){
                shiftX+=speedX;
                shiftY+=speedY;
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
    private void setSpeed1() {
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
