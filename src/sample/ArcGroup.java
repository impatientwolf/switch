package sample;

import javafx.animation.RotateTransition;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.awt.*;
import java.io.Closeable;
import java.util.Random;

public class ArcGroup extends Obstacle {
    public Group  arcGroup;
    public ArcGroup(Group myarc,double x,double y) {
        super(x,y);
        this.arcGroup=myarc;
    }


    @Override
    public void rotateMe(Group g,boolean reverse, int angle, int duration) {
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), this.arcGroup);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(2);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
    }

    @Override
    public void arrangeMe(double x,double y) {
     this.Xlayout=x;
     this.Ylayout=y;
     this.arcGroup.setLayoutX(x);
     this.arcGroup.setLayoutY(y);
    }
}
