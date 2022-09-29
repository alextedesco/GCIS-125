import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class SmilesAllAroundUpdater implements EventHandler<ActionEvent> {

    Label label;
    GridPane pane;

    public SmilesAllAroundUpdater (Label label, GridPane pane) {
        this.label = label;
        this.pane = pane;
    }

    @Override
    public void handle(ActionEvent event) {
        String current = label.getText();
        int newValue = Integer.parseInt(current) + 1;
        label.setText(Integer.toString(newValue));
        StackPane pane1 = SmilesAllAround.makeStackPane();
        StackPane pane2 = SmilesAllAround.makeStackPane();
        StackPane pane3 = SmilesAllAround.makeStackPane();
        StackPane pane4 = SmilesAllAround.makeStackPane();
        StackPane pane5 = SmilesAllAround.makeStackPane();
        StackPane pane6 = SmilesAllAround.makeStackPane();
        StackPane pane7 = SmilesAllAround.makeStackPane();
        StackPane pane8 = SmilesAllAround.makeStackPane();
        StackPane pane9 = SmilesAllAround.makeStackPane();
        StackPane pane10 = SmilesAllAround.makeStackPane();
        StackPane pane11 = SmilesAllAround.makeStackPane();
        StackPane pane12 = SmilesAllAround.makeStackPane();
        StackPane pane13 = SmilesAllAround.makeStackPane();
        StackPane pane14 = SmilesAllAround.makeStackPane();
        StackPane pane15 = SmilesAllAround.makeStackPane();
        StackPane pane16 = SmilesAllAround.makeStackPane();
        pane.add(pane1, 0, 0);
        pane.add(pane2, 0, 1);
        pane.add(pane3, 0, 2);
        pane.add(pane4, 0, 3);
        pane.add(pane5, 1, 0);
        pane.add(pane6, 1, 1);
        pane.add(pane7, 1, 2);
        pane.add(pane8, 1, 3);
        pane.add(pane9, 2, 0);
        pane.add(pane10, 2, 1);
        pane.add(pane11, 2, 2);
        pane.add(pane12, 2, 3);
        pane.add(pane13, 3, 0);
        pane.add(pane14, 3, 1);
        pane.add(pane15, 3, 2);
        pane.add(pane16, 3, 3);
    }    
}
