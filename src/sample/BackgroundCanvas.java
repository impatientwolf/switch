package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class BackgroundCanvas {
    @FXML
    private Arc a1;
    @FXML
    private Arc a2;
    @FXML
    private Arc a3;
    @FXML
    private Arc a4;
    @FXML
    private Circle smallC;
    /* @FXML
     private onMouseClicked onMouseClick;*/
    @FXML
    private Circle myBall;

    private final ClassBall obj =new ClassBall();
    private AnimationTimer animator;
    private int animatorFlag=0;



    public void onMouseClicked(MouseEvent mouseEvent) throws InterruptedException {
        if(animatorFlag==0){//means not running
            this.animatorFlag=1;
            animator=obj.startTimeline(animator,myBall);
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
     Controller obj=new Controller();
     obj.openPauseScene(actionEvent);
    }
}
