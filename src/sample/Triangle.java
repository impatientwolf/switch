package sample;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.util.Duration;

public class Triangle extends Obstacle {
    public Group myTriangle;

    public Triangle(Group myTriangle,double x,double y) {
        super(x,y);
        this.myTriangle = myTriangle;
    }

    @Override
    public void rotateMe(Group g,boolean reverse, int angle, int duration) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), this.myTriangle);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(7);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
    }

    @Override
    public void arrangeMe(double x,double y) {
        this.Xlayout=x;
        this.Ylayout=y;

        this.myTriangle.setLayoutX(x);
        this.myTriangle.setLayoutY(y);
    }
}
