package practicum;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class ColorsEventHandler implements EventHandler<ActionEvent> {

    Label label;
    Color color;

    public ColorsEventHandler (Label label, Color color) {
        this.label = label;
        this.color = color;
    }

    @Override
    public void handle(ActionEvent arg0) {
        label.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
