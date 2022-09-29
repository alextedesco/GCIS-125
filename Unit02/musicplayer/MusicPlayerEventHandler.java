package musicplayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MusicPlayerEventHandler implements EventHandler<ActionEvent> {


    Button button;
    Stage stage;
    Song song;
    ImageView cover;
    Image newCover;
    Label label;
    Song currentSong;


    public MusicPlayerEventHandler (Button button, Stage stage, Song song, ImageView cover, Image newCover, Label label, Song currentSong) {
        this.button = button;
        this.stage = stage;
        this.song = song;
        this.cover = cover;
        this.newCover = newCover;
        this.label = label;
        this.currentSong = currentSong;
    }

    @Override
    public void handle(ActionEvent event) {
        currentSong.pauseSong();
        currentSong.changeSong(song);
        stage.setTitle(button.getText());
        cover.setImage(newCover);
        label.setText(song.description + " is playing");
        currentSong.playSong();
    } 
}
