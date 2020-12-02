package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class ClassBall {


    public ClassBall(Circle ball,double x,double y,double radius) {
     ball.setCenterX(x);
     ball.setCenterY(y);
     ball.setFill(Color.RED);
     ball.setRadius(radius);
    }

}