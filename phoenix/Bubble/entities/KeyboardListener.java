package phoenix.Bubble.entities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

        public class KeyboardListener implements KeyListener {
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean isPressedSomething;


            @Override
    public void keyTyped(KeyEvent e) {

                    }

            @Override
    public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key==KeyEvent.VK_W){
                        up=true;
                    }
                if(key==KeyEvent.VK_S){
                        down=true;
                    }
                if(key==KeyEvent.VK_A){
                        left=true;
                    }
                if(key==KeyEvent.VK_D){
                        right=true;
                    }
                isPressedSomething=true;
            }

            @Override
    public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if(key==KeyEvent.VK_W){
                        up=false;
                    }
                if(key==KeyEvent.VK_S){
                        down=false;
                    }
                if(key==KeyEvent.VK_A){
                        left=false;
                    }
                if(key==KeyEvent.VK_D){
                        right=false;
                    }
                isPressedSomething=up||down||left||right;
            }

            public boolean isUpPressed() {
                return up;
            }

            public boolean isDownPressed() {
                return down;
            }

            public boolean isLeftPressed() {
                return left;
            }

            public boolean isRightPressed() {
                return right;
            }
    public boolean isPressedSomething(){
                return isPressedSomething;
            }
}
