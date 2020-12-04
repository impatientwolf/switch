package sample;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class ClassBall {
private static long last;
private static long counter=0;
private static double Yvelocity=-1;


    public static long getLast() {
        return last;
    }

    public static void setLast(long last) {
        ClassBall.last = last;
    }

    public static long getCounter() {
        return counter;
    }

    public static void setCounter(long counter) {
        ClassBall.counter = counter;
    }

    public static double getYvelocity() {
        return Yvelocity;
    }

    public static void setYvelocity(double yvelocity) {
        Yvelocity = yvelocity;
    }

    public ClassBall()  {

    }

    public AnimationTimer startTimeline(AnimationTimer animator,Circle ball){
        animator=new AnimationTimer() {
            @Override
            public void handle(long now) {
              if(now-last>100){
                   if(counter<=40){
                       ball.setCenterY(ball.getCenterY()+Yvelocity);
                       counter++;
                       //Yvelocity=Yvelocity-0.01;
                   }
                   else {
                       if(ball.getCenterY()<=0){
                           ball.setCenterY(ball.getCenterY()-Yvelocity);
                       }
                       else {
                           this.stop();
                           System.out.println("animation stopped");
                       }
                   }
                   last=now;
               }
                //System.out.println(Thread.currentThread().getName());
            }
        };
        return animator;
    }



}