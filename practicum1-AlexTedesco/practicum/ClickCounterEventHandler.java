package practicum;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ClickCounterEventHandler implements EventHandler<ActionEvent>  {

    Label label;
    int num;

    public ClickCounterEventHandler (Label label, int num) {
        this.label = label;
        this.num = num;
    }

    @Override
    public void handle(ActionEvent arg0) {
        num = num + 1;
        String stringNum = Integer.toString(num);
        label.setText(stringNum);
    }
}
