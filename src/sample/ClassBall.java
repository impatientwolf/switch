package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

import java.awt.*;
import java.security.spec.RSAOtherPrimeInfo;

import static java.lang.Thread.sleep;

public class ClassBall  {
    private static Paint currentColor;
    private static long last;
    private static long counter=0;
    private static double Yvelocity=-5;
    private static double nYvelocity=Yvelocity*1.1;
    private static int flag=1;
    public static int getScore() {
        return score;
    }
    Controller cont=new Controller();
    public static void setScore(int score) {
        ClassBall.score = score;
    }

    private static int score=0;


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
//                        cont.openGameoverScene();
//                        this.stop();
                    }

                    if (counter <= 20) {

                        if(checkColorSwitch(ball)){
                            ball.setFill(currentColor);
                            ball.setStroke(currentColor);
                        }

                      if(checkStarCollision(ball)){
                          //System.out.println("Yasssssssssssss");
                          score=score+1;
                          ///update label----------------------------------------------------------------------
                          System.out.println("Current score-------  "+score);
                           //System.out.println("current score -- "+score);
                       }
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

    public static boolean  checkStarCollision(Circle ball){

        for(Obstacle obj:BackgroundCanvas.myList){
            //Obstacle obj=BackgroundCanvas.myList.get(i);
            if((obj.star!=null)&&(obj.star.isVisible())){
                //System.out.println(BackgroundCanvas.myList.get(i).star.hashCode());
                if(((Path)Shape.intersect(ball,obj.colorStar)).getElements().size()>0){
                    obj.star.setVisible(false);
                    System.out.println("Yasssssssssssssssssss");
                    return true;
                }
                //System.out.println(obj.Ylayout+"  "+(720+ball.getCenterY()));

         }
        }
           return false;
    }
    public static boolean checkColorSwitch(Circle ball){
        for(Obstacle o:BackgroundCanvas.myList){
            if(((Path)Shape.intersect(ball,o.colorSwitch)).getElements().size()>0){
                currentColor=o.colorSwitch.getStroke();
                //System.out.println(o.colorSwitch.getStroke());
                o.colorSwitch.setVisible(false);
                return true;
            }
        }
        return false;
    }


    private static void Sleep() throws InterruptedException {
        if(flag==1)sleep(90);
    }

    public void restartButtonClicked(ActionEvent actionEvent) {
    }

    public void spendButtonClicked(ActionEvent actionEvent) {
    }
}