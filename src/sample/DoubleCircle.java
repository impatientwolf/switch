package sample;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.util.Duration;

public class DoubleCircle extends Obstacle{
public Group leftCircle;
public double x1;
public double y1;
public Group rightCircle;
public double x2;
public double y2;

    public DoubleCircle( Group leftCircle, double x1, double y1, Group rightCircle, double x2, double y2) {
        super(x1,y1);
        this.leftCircle = leftCircle;
        this.x1 = x1;
        this.y1 = y1;
        this.rightCircle = rightCircle;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void rotateMe(Group g,boolean reverse, int angle, int duration) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), this.leftCircle);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(2);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
        // do opposite of left
        RotateTransition rotateTransition2 = new RotateTransition(Duration.seconds(duration), this.rightCircle);
        rotateTransition2.setAutoReverse(reverse);
        rotateTransition2.setByAngle(angle);
        rotateTransition2.setRate(-2);
        rotateTransition2.setCycleCount(90);
        rotateTransition2.play();

    }

    @Override
    public void arrangeMe(double x,double y) {
        this.Xlayout=x;
        this.Ylayout=y;
        this.leftCircle.setLayoutX(x-80);
        this.leftCircle.setLayoutY(y);
        this.rightCircle.setLayoutX(x+80);
        this.rightCircle.setLayoutY(y);
    }
}
