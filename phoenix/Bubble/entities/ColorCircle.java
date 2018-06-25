package phoenix.Bubble.entities;

import phoenix.Bubble.GamePanelConstants;

import java.awt.*;

public class ColorCircle extends Circle{
    protected Color color;

    public ColorCircle() {
        color=GamePanelConstants.PLAYER_COLOR;
    }

    public ColorCircle(Color color) {
        this.color = color;
    }
}
