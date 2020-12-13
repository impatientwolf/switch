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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class BackgroundCanvas implements Initializable {
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
            System.out.println("Animation just stopped due to multiple clicked");
            this.animator.stop();
            ClassBall.setCounter(0);
            ClassBall.setLast(0);
            animator.start();
            System.out.println("Animation just Started again");
            if(myBall.getCenterY()<-310){
                updateCoordinates();
            };
        }

    }

    public void openPauseScene(ActionEvent actionEvent) throws IOException {
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

    private static void updateCoordinates(){


    }




}