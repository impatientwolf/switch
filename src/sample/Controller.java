
package sample;

        import javafx.animation.RotateTransition;
        import javafx.beans.property.SimpleObjectProperty;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.layout.Pane;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Arc;
        import javafx.scene.shape.Circle;
        import javafx.stage.Stage;
        import javafx.util.Duration;

        import javax.crypto.Cipher;
        import javax.swing.*;
        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;

public class Controller<onMouseClicked> implements Initializable {

    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;
    @FXML
    private ImageView playImage;
    @FXML
    private ImageView settingsImage;
    @FXML
    private ImageView loadImage;
    @FXML
    private ImageView playImage1;
    @FXML
    private ImageView saveImage1;
    @FXML
    private ImageView saveImage;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setRotate(c1, true, 360, 10);
        setRotate(c2, false, 360, 10);
        setRotate(c3, true, 360, 10);


        setRotate(playImage, false, 360, 10);
        setRotate(playImage1, false, 360, 10);
        setRotate(settingsImage, true, 360, 10);
        setRotate(loadImage, true, 360, 10);
        setRotate(saveImage, true, 360, 10);
        setRotate(saveImage1, true, 360, 15);

    }

    private void setRotate(Circle c, boolean reverse, int angle, int duration) {

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), c);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(7);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
    }

    private void setRotate(Arc c, boolean reverse, int angle, int duration) {

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), c);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(7);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
    }

    private void setRotate(ImageView c, boolean reverse, int angle, int duration) {

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), c);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(7);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
    }



    public void moveToPlayScreen(ActionEvent actionEvent) throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("playscreen.fxml"));
        Scene scene = new Scene(root);
        Stage playstage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        BackgroundCanvas canvas=new BackgroundCanvas();
        playstage.setScene(scene);
        playstage.show();
    }



    public void openSettingsScene(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("settingsScreen.fxml"));
        Scene playscreen = new Scene(root);

        // root.getChildrenUnmodifiable().add();
        Stage playstage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        playstage.setTitle("PlayScreen");
        playstage.setScene(playscreen);
        playstage.show();

    }
    public void openPauseScene(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("pausescreen.fxml"));
        Scene playscreen = new Scene(root);
        Stage playstage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        playstage.setScene(playscreen);
        playstage.show();
    }



}


