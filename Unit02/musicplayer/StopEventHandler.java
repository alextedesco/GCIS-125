package musicplayer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class StopEventHandler implements EventHandler<ActionEvent> {

    Song song;
    Label label;
    ImageView view;

    public StopEventHandler (Song song) {
        this.song = song;
    }

    @Override
    public void handle(ActionEvent event) {
        song.stopSong();

    }
}
