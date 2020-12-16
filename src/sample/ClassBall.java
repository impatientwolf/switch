package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

import java.awt.*;

import static java.lang.Thread.sleep;

public class ClassBall  {
    private static long last;
    private static long counter=0;
    private static double Yvelocity=-5;
    private static double nYvelocity=Yvelocity*1.1;
    private static int flag=1;

    public static double getnYvelocity() {
        return nYvelocity;
    }

    public static void setnYvelocity(double nYvelocity) {
        ClassBall.nYvelocity = nYvelocity;
    }

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

 private static BackgroundCanvas obj2=new BackgroundCanvas();
    public ClassBall()  {

    }

    public static AnimationTimer startTimeline(Circle ball){
        AnimationTimer animator = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - last > 100) {
                    if((collisionChecker(ball))){

                        //this.stop();
                    }
                    else{
                    if (counter <= 20) {
                        //TestFunction(ball);
                        if (ball.getCenterY() <= -330) {
                            counter = 25;
                        } else {
                            ball.setCenterY(ball.getCenterY() + Yvelocity);
                            counter++;

                            //Yvelocity=Yvelocity-0.01;
                        }
                        flag = 1;
                    } else {
                        try {
                            Sleep();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (ball.getCenterY() <= 0) {
                            ball.setCenterY(ball.getCenterY() - nYvelocity);
                            flag = 0;
                        } else {
                            this.stop();
                            System.out.println("animation stopped");
                        }
                    }
                    last = now;
                }
                }

            }
        };
        return animator;
    }

    private static boolean collisionChecker(Circle ball) {
        for(Obstacle obj:BackgroundCanvas.myList){
            if(obj.checkCollision(obj,ball)){
                return true;
            }
        }
        return false;

    }



    private static void Sleep() throws InterruptedException {
        if(flag==1)sleep(90);
    }
}