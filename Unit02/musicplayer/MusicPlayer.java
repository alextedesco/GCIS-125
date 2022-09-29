/**
 * This class creates a Music Player GUI which shows a library of songs. When a song is clicked it shows the album cover/artist,
 * changes the description label to the song and artist, and begins playing the song that was clicked. At the bottom of the
 * GUI there are five command buttons that allow the song to be played, paused, stopped, rewinded, and fast forwarded.
 * 
 * @author Alex Tedesco
 */

package musicplayer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MusicPlayer extends Application {

    /**
    * @param currentSong The default configured song when the GUI launches
    */

    Song currentSong = new Song("music/track01.mp3", "Brandenberg Concerto no. 1 in F major, JS Bach", "images/bach.png");


    @Override
    public void start(Stage stage) throws Exception {

        VBox box1 = new VBox();

        Image bachImage = new Image("images/bach.png");

        Image beethovenImage = new Image("images/beethoven.png");

        Image mozartImage = new Image("images/mozart.png");

        ImageView view = new ImageView(bachImage);

        Label songDescription = new Label("No current song is playing");
        songDescription.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        songDescription.setAlignment(Pos.CENTER);

        Button button1 = new Button("Brandenberg Concerto no. 1 in F major, JS Bach");
        button1.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Song song1 = new Song("music/track01.mp3", button1.getText(), "images/bach.png");
        button1.setOnAction(new MusicPlayerEventHandler(button1, stage, song1, view, bachImage, songDescription, currentSong));

        
        Button button2 = new Button("Piano Sonata no. 10, LV Beethoven");
        button2.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Song song2 = new Song("music/track02.mp3", button2.getText(), "images/beethoven.png");
        button2.setOnAction(new MusicPlayerEventHandler(button2, stage, song2, view, beethovenImage, songDescription, currentSong));

        Button button3 = new Button("Adagio in C major, WA Mozart");
        button3.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Song song3 = new Song("music/track03.mp3", button3.getText(), "images/mozart.png");
        button3.setOnAction(new MusicPlayerEventHandler(button3, stage, song3, view, mozartImage, songDescription, currentSong));

        Button button4 = new Button("March in D major, WA Mozart");
        button4.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Song song4 = new Song("music/track04.mp3", button4.getText(), "images/mozart.png");
        button4.setOnAction(new MusicPlayerEventHandler(button4, stage, song4, view, mozartImage, songDescription, currentSong));

        Button button5 = new Button("Sonata no 12 in A flat major, LV Beethoven");
        button5.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        Song song5 = new Song("music/track05.mp3", button5.getText(), "images/beethoven.png");
        button5.setOnAction(new MusicPlayerEventHandler(button5, stage, song5, view, beethovenImage, songDescription, currentSong));

        HBox box2 = new HBox();

        Button rewind = new Button("⏪ Rewind");
        rewind.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        rewind.setOnAction(new RewindEventHandler(currentSong));

        Button pause = new Button("⏸️ Pause");
        pause.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        pause.setOnAction(new PauseEventHandler(currentSong, songDescription));

        Button play = new Button("▶️ Play");
        play.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        play.setOnAction(new PlayEventHandler(currentSong, songDescription));

        Button stop = new Button("⏹️ Stop");
        stop.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        stop.setOnAction(new StopEventHandler(currentSong));

        Button fastForward = new Button("⏩ Fast Forward");
        fastForward.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        fastForward.setOnAction(new FastForwardEventHandler(currentSong));

        box2.getChildren().add(rewind);
        box2.getChildren().add((pause));
        box2.getChildren().add((play));
        box2.getChildren().add((stop));
        box2.getChildren().add((fastForward));
        box2.setAlignment(Pos.CENTER);

        box1.getChildren().add(view);
        box1.getChildren().add((button1));
        box1.getChildren().add((button2));
        box1.getChildren().add((button3));
        box1.getChildren().add((button4));
        box1.getChildren().add((button5));
        box1.getChildren().add((songDescription));
        box1.getChildren().add((box2));

        Scene scene = new Scene(box1);

        stage.setTitle("Music Player");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch (args);
    }
}