package PacMan;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;

public class SoundsEventHandler implements EventHandler<ActionEvent> {


    private final MediaPlayer player;


    public SoundsEventHandler (MediaPlayer startMedia) {
        this.player = startMedia;
    }

    @Override
    public void handle(ActionEvent event) {
        player.stop();
        player.play();
        System.out.println(player.getStatus());
    }
    
}
