package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;

public class Main extends Application {
//    public Stage window;
// #boycott iiitd
    @Override
    public void start(Stage primaryStage) throws Exception{
//        window=primaryStage;
        String path = "src/sample/image/music.mp3";

        //Media sound = new Media(Paths.get(path).toUri().toString());
        //AudioClip mediaPlayer = new AudioClip(sound.getSource());
//        mediaPlayer.play();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(new Scene(root, 1080, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
