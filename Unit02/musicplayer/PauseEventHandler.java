package musicplayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class PauseEventHandler implements EventHandler<ActionEvent> {

    Song song;
    Label label;

    public PauseEventHandler (Song song, Label label) {
        this.song = song;
        this.label = label;
    }

    @Override
    public void handle(ActionEvent event) {
        song.pauseSong();
        label.setText(song.description + " is paused" );
    }  
}