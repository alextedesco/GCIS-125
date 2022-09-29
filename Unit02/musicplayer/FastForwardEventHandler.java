package musicplayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class FastForwardEventHandler implements EventHandler<ActionEvent> {

    Song song;

    public FastForwardEventHandler (Song song) {
        this.song = song;
    }

    @Override
    public void handle(ActionEvent event) {
        song.fastForwardSong();
    }   
}