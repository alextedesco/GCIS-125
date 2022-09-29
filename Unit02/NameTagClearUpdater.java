import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class NameTagClearUpdater implements EventHandler<ActionEvent> {

    Label label;

    public NameTagClearUpdater (Label label) {
        this.label = label;

    }


    @Override
    public void handle(ActionEvent event) {
        label.setText("");
    }
    
}
