import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NameTagUpdater implements EventHandler<ActionEvent> {

    TextField textField;
    Label label;

    public NameTagUpdater (TextField textField, Label label) {
        this.textField = textField;
        this.label = label;

    }


    @Override
    public void handle(ActionEvent event) {
        String text = textField.getText();
        label.setText(text);
    }
    
}
