
package sample;

        import javafx.animation.RotateTransition;
        import javafx.beans.property.SimpleObjectProperty;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Group;
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
    private ImageView saveImage;

    public static Scene playScene;
    private Stage primaryStage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setRotate(c1, true, 360, 10);
        setRotate(c2, false, 360, 10);
        setRotate(c3, true, 360, 10);


        setRotate(playImage, false, 360, 10);

        setRotate(settingsImage, true, 360, 10);
        setRotate(loadImage, true, 360, 10);
        setRotate(saveImage, true, 360, 10);

        Pane root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("playscreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        playScene = new Scene(root);
        print();

    }

   public void setRotate(Circle c, boolean reverse, int angle, int duration) {

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), c);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(7);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
    }

    public void setRotate(Group c, boolean reverse, int angle, int duration) {

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), c);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(7);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
    }

    public void setRotate(ImageView c, boolean reverse, int angle, int duration) {

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(duration), c);
        rotateTransition.setAutoReverse(reverse);
        rotateTransition.setByAngle(angle);
        rotateTransition.setRate(7);
        rotateTransition.setCycleCount(90);
        rotateTransition.play();
    }



    public void moveToPlayScreen(ActionEvent actionEvent) throws IOException {
//        Pane root = FXMLLoader.load(getClass().getResource("playscreen.fxml"));
//        playScene = new Scene(root);
        primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(playScene);
        primaryStage.show();
//        playScene= ((Node) actionEvent.getSource()).getScene();
    }



    public void openSettingsScene(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("settingsScreen.fxml"));
        Scene playscreen = new Scene(root);

        // root.getChildrenUnmodifiable().add();
        primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setTitle("Settings");
        primaryStage.setScene(playscreen);
        primaryStage.show();

    }
    public void openPauseScene(ActionEvent actionEvent) throws IOException {
//        playScene=((Node) actionEvent.getSource()).getScene();
        Parent root = FXMLLoader.load(getClass().getResource("pausescreen.fxml"));
        Scene playscreen = new Scene(root);
        primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setTitle("PauseScreen");
        primaryStage.setScene(playscreen);
        primaryStage.show();
    }


//    public void backToHomeScreeen(ActionEvent actionEvent) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        primaryStage.setTitle("Color Switch");
//        Scene scene=new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    public void playButtonClicked(ActionEvent actionEvent) {
//        primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        primaryStage.setScene(playScene);
//        primaryStage.show();
//    }
    public void print(){System.out.println("heyaaaaaaaaa");}
}


