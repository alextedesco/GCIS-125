package PacMan;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PacMan extends Application {

    public void start (Stage stage) throws Exception {
        VBox box = new VBox();

        Button start = new Button("Start");
        start.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box.getChildren().add((start));

        String startPath = "media/sounds/start.wav";
        String startUri = new File(startPath).toURI().toString();
        Media startMedia = new Media(startUri);
        MediaPlayer startPlayer = new MediaPlayer(startMedia);

        start.setOnAction(new SoundsEventHandler (startPlayer));

        Button chomp = new Button("Chomp");
        chomp.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box.getChildren().add((chomp));

        String chompPath = "media/sounds/chomp.wav";
        String chompUri = new File(chompPath).toURI().toString();
        Media chompMedia = new Media(chompUri);
        MediaPlayer chompPlayer = new MediaPlayer(chompMedia);

        chomp.setOnAction(new SoundsEventHandler(chompPlayer));

        Button eat = new Button("Eat");
        eat.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box.getChildren().add((eat));

        String eatPath = "media/sounds/eat.wav";
        String eatUri = new File(eatPath).toURI().toString();
        Media eatMedia = new Media(eatUri);
        MediaPlayer eatPlayer = new MediaPlayer(eatMedia);

        eat.setOnAction(new SoundsEventHandler(eatPlayer));

        Button end = new Button("End");
        end.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box.getChildren().add((end));

        String endPath = "media/sounds/end.wav";
        String endUri = new File(endPath).toURI().toString();
        Media endMedia = new Media(endUri);
        MediaPlayer endPlayer = new MediaPlayer(endMedia);

        end.setOnAction(new SoundsEventHandler(endPlayer));

        Scene scene = new Scene(box);

        stage.setTitle("Java GUI #1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch (args);
    }   
}
