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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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




    Controller cont =new Controller();

    private final ClassBall obj =new ClassBall();
    private AnimationTimer animator;
    private int animatorFlag=0;



    public  Group getArcGroup() {
        return arcGroup;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cont.setRotate(smallC,false,360,10);
      //smallC.setVisible(false);
         cont.setRotate2(arcGroup,false,360,20);
//         cont.setRotate2();
       arcGroup.setVisible(false);

    }


    public void onMouseClicked(MouseEvent mouseEvent) throws InterruptedException {
        Obstacle.temporyEquate(arcGroup);
        Obstacle.addObstacles(myPane);
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
        }

    }

    public void openPauseScene(ActionEvent actionEvent) throws IOException {
        cont.openPauseScene(actionEvent);

    }
}