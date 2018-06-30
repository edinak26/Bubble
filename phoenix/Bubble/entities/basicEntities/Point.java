package phoenix.Bubble.entities.basicEntities;

import phoenix.Bubble.GamePanelConstants;

        public class Point {
    protected int x;
    protected int y;

            Point(){
                x=GamePanelConstants.PANEL_WIDTH/2;
                y=GamePanelConstants.PANEL_HEIGHT/2;
            }
    Point(int x,int y){
                this.x=x;
                this.y=y;
            }
    Point(Point point){
                this.x=point.x;
                this.y=point.y;
            }
            public int getX(){
                return x;
            }
            public int getY(){
                return y;
            }

        }
