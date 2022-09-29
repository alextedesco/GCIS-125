package musicplayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RewindEventHandler implements EventHandler<ActionEvent> {

    Song song;

    public RewindEventHandler (Song song) {
        this.song = song;
    }

    @Override
    public void handle(ActionEvent event) {
        song.rewindSong();
    } 
}