package phoenix.Bubble.entities.basicEntities;

import phoenix.Bubble.GamePanelConstants;
import phoenix.Bubble.entities.basicEntities.Circle;

import java.awt.*;

        public class ColorCircle extends Circle {
    protected Color color;

            public ColorCircle() {
                color=GamePanelConstants.PLAYER_COLOR;
            }

            public ColorCircle(Color color) {
                this.color = color;
            }
}
