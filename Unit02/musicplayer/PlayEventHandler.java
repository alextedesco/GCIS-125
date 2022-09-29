package musicplayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class PlayEventHandler implements EventHandler<ActionEvent> {

    Song song;
    Label label;

    public PlayEventHandler (Song song, Label label) {

        this.song = song;
        this.label = label;
    }

    @Override
    public void handle(ActionEvent event) {
        song.playSong();
        label.setText(song.description + " is playing" );
    }
}