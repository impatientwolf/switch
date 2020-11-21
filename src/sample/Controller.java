
package sample;

        import javafx.animation.RotateTransition;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.shape.Circle;
        import javafx.util.Duration;

        import java.net.URL;
        import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setRotate(c1,true,360,10);
        setRotate(c2,false,360,10);
        setRotate(c3,true,360,10);

    }

    private void setRotate(Circle c, boolean reverse,int angle, int duration) {

        RotateTransition rotateTransition=new RotateTransition(Duration.seconds(duration),c);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(7);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
    }


}