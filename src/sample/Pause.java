package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Pause implements Initializable {
    @FXML
    private ImageView playImage1;
    @FXML
    private ImageView saveImage1;
    private Stage primaryStage;
    private Controller cont=new Controller();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cont.setRotate(playImage1, false, 360, 10);
        cont.setRotate(saveImage1, true, 360, 15);

    }


    public void backToHomeScreen(ActionEvent actionEvent) throws IOException {
        ClassBall.setnYvelocity(-5);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setTitle("Color Switch");
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void playButtonClicked(ActionEvent actionEvent) {
        ClassBall.setnYvelocity(-5);
        primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Controller.playScene);
        primaryStage.show();
    }
}
