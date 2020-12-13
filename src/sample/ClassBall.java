package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Circle;

import static java.lang.Thread.sleep;

public class ClassBall  {
    private static long last;
    private static long counter=0;
    private static double Yvelocity=-4;
    private static int flag=1;


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
                    if (counter <= 24) {
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
                            ball.setCenterY(ball.getCenterY() - Yvelocity * 1.2);
                            flag = 0;
                        } else {
                            this.stop();
                            System.out.println("animation stopped");
                        }
                    }
                    last = now;
                }

            }
        };
        return animator;
    }


    private static void Sleep() throws InterruptedException {
        if(flag==1)sleep(90);
    }
}