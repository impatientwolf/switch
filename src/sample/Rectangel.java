package sample;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.util.Duration;

public class Rectangel extends Obstacle {
    public Group myRectangle;

    public Rectangel(Group myRectangle,double x,double y) {
        super(x,y);
        this.myRectangle= myRectangle;
    }

    @Override
    public void rotateMe(Group g,boolean reverse, int angle, int duration) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), this.myRectangle);
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
        this.myRectangle.setLayoutY(y);
        this.myRectangle.setLayoutX(x);
    }
}
