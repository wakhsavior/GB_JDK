package balls.bricks;

import balls.circles.Ball;
import balls.circles.Background;
import balls.common.CanvasReapaintListner;
import balls.common.Interactable;
import balls.common.MainCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame implements CanvasReapaintListner {
    private static final int WINDOW_HEIGHT = 800;
    private static final int WINDOW_WIDTH = 1200;
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private final Interactable[] interactables = new Interactable[10];
    private Background backgroud;

    private MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        backgroud = new Background();
        for (int i = 0; i < interactables.length; i++) {
            interactables[i] = new Ball();
        }

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);
        setVisible(true);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        backgroud.update(canvas,deltaTime);
        for (int i = 0; i< interactables.length; i++){
            interactables[i].update(canvas,deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g) {
        backgroud.render(canvas,g);
        for (int i = 0; i< interactables.length; i++){
            interactables[i].render(canvas,g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
