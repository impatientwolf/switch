package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class BackgroundCanvas implements Initializable,Runnable {
    @FXML
    private  Pane myPane;
    @FXML
    private  Arc a1;
    @FXML
    private Arc a2;
    @FXML
    private Arc a3;
    @FXML
    private Arc a4;
    @FXML
    private Circle smallC;
    @FXML
    private Circle myBall;
    @FXML
    private  Group arcGroup;
    @FXML
    private Group rectangle;
    @FXML
    private Group triangle;
    @FXML
    private Group doubleCircle_left;
    @FXML
    private Group doubleCircle_right;

    private static int counter=0;
    private static double Ycoordinate;
    private static AnimationTimer obstacleTimeline;

    Controller cont =new Controller();

    private List<Obstacle > myList=new ArrayList<>(6);

    private final ClassBall obj =new ClassBall();
    private AnimationTimer animator;
    private int animatorFlag=0;



    public  Group getArcGroup() {
        return arcGroup;
    }
    private ArcGroup myArc;
    private Triangle myTriangle;
    private Rectangel myRectangle;
    private DoubleCircle myDoubleCircles;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       // System.out.println(myBall.getLayoutX());
        //System.out.println(myBall.getLayoutY());
        cont.setRotate(smallC,false,360,10);
       arcGroup.setVisible(false);
       rectangle.setVisible(false);
       triangle.setVisible(false);
       doubleCircle_left.setVisible(false);
       doubleCircle_right.setVisible(false);
       this.rotateAll(arcGroup);
       this.rotateAll(triangle);
       this.rotateAll(rectangle);
       //this.rotateAll(doubleCircle_left);
       this.rotateAll(doubleCircle_right);
       myPane.getChildren().removeAll(arcGroup,rectangle,triangle,doubleCircle_left,doubleCircle_right);
       myPane.getChildren().addAll(myRectangle.myRectangle,myTriangle.myTriangle,myArc.arcGroup,myDoubleCircles.leftCircle,myDoubleCircles.rightCircle);
       myRectangle.myRectangle.setVisible(true);
       myTriangle.myTriangle.setVisible(true);
       myArc.arcGroup.setVisible(true);
       myDoubleCircles.leftCircle.setVisible(true);
       myDoubleCircles.rightCircle.setVisible(true);
       Obstacle.arrangeObstacles(myList,myPane);
        obstacleTimeline=this.updateCoordinates();
        print();

    }


    public void onMouseClicked(MouseEvent mouseEvent) throws InterruptedException {

        if(animatorFlag==0){//means not running
            this.animatorFlag=1;
            animator=ClassBall.startTimeline(myBall);
            animator.start();
            System.out.println("Animation just Started");
            animator.start();
        }
        else{
            //System.out.println("Animation just stopped due to multiple clicked");
            this.animator.stop();
            ClassBall.setCounter(0);
            ClassBall.setLast(0);
            animator.start();
            //System.out.println("Animation just Started again");
            counter=0;

            if(myBall.getCenterY()<-310){

                //Runnable target;
                //Thread t1=new Thread(new BackgroundCanvas());
                //t1.start();
                //this.updateCoordinates();

                /*Thread thread = new Thread("obstacle"){
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+" was called");
                        obstacleTimeline.start();
                    }
                };
                thread.start();*/
            obstacleTimeline.start();
            }

        }

    }

    public void openPauseScene(ActionEvent actionEvent) throws IOException {
        ClassBall.setnYvelocity(0);
        cont.openPauseScene(actionEvent);

    }

    private  void rotateAll(Group g){  //rotate and initial formation of objects
        if(g.getId().equals("arcGroup")){
                myArc= new ArcGroup(g,0,0);
                myArc.rotateMe(g,false,360,10);
                myList.add(myArc);
        }
        else if (g.getId().equals("triangle")){
            myTriangle=new Triangle(g,0,0);
            myTriangle.rotateMe(g,false,360,10);
            myList.add(myTriangle);
        }
        else if (g.getId().equals("rectangle")){
            myRectangle=new Rectangel(g,0,0);
            myRectangle.rotateMe(g,false,360,10);
            myList.add(myRectangle);
        }
        else{
            myDoubleCircles=new DoubleCircle(g,0,0,this.doubleCircle_left,0,0);//sending right left automatic put
            myDoubleCircles.rotateMe(g,false,360,10);
            myList.add(myDoubleCircles);
        }

    }

    private  AnimationTimer updateCoordinates(){
        System.out.println("update was called");
     Iterator it =myList.iterator();
     double last=0;
     return new AnimationTimer() {
         @Override
         public void handle(long now) {
             if (now - last > 100){
                 //System.out.println("Phase 1 passed");
                 if(counter<20){
                    // System.out.println(Thread.currentThread().getName());
                 for(int i=0;i<myList.size();i++){
                     // write here if object goes out
                     System.out.println(myList.toString());
                     Obstacle obj=myList.get(i);
                     if(obj instanceof ArcGroup){
                         if(obj.Ylayout>850){
                             obj.updateMyPosition(myPane,myList,obj,i,((ArcGroup) obj).arcGroup);
                             break;
                         }
                         obj.arrangeMe(500, obj.Ylayout+4);
                     }
                     else if(obj instanceof Rectangel){
                         if(obj.Ylayout>850){
                             obj.updateMyPosition(myPane,myList,obj,i,((Rectangel) obj).myRectangle);
                             break;
                         }
                         obj.arrangeMe(500, obj.Ylayout+4);
                     }
                     else if(obj instanceof Triangle){
                         if(obj.Ylayout>850){
                             obj.updateMyPosition(myPane,myList,obj,i,((Triangle) obj).myTriangle);
                             // updateList(obj,((Triangle) obj).myTriangle,i);
                             break;
                         }
                         obj.arrangeMe(500, obj.Ylayout+4);
                     }
                     else{
                         if(obj.Ylayout>850){
                             obj.updateMyPosition(myPane,myList,obj,i,((DoubleCircle) obj).leftCircle);
                         break;
                         }
                         obj.arrangeMe(500, obj.Ylayout+4);
                     }
                 }
                 counter++;
                 }
                 else {
                     this.stop();
                 }
                 System.out.println(myList.toString());
             }
         }
     };
    }


    @Override
    public void run() {
        //this.updateCoordinates();
    }

    public void print(){
        System.out.println("backcanvas heyaaa");
    }
}