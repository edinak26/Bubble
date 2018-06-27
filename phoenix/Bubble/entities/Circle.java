package phoenix.Bubble.entities;

    import phoenix.Bubble.GamePanelConstants;

        public class Circle extends Point {
    protected int circleRadius;

            public Circle(){
                    circleRadius =GamePanelConstants.PLAYER_RADIUS;
                }
    public Circle(int radius){
                    circleRadius =radius;
                }
    Circle(Point point){
                    super(point);
                }
    Circle(Point point,int radius){
                    super(point);
                    circleRadius=radius;
                }

            protected int getUpperBorderY(){
                    return y- circleRadius;
                }
    protected int getBottomBorderY(){
                    return y+ circleRadius;
                }
    protected int getLeftBorderX(){
                    return x- circleRadius;
                }
    protected int getRightBorderX(){
                    return x+ circleRadius;
                }
}

