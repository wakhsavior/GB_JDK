package balls.common;

import java.awt.*;

public interface CanvasReapaintListner {
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);
}
