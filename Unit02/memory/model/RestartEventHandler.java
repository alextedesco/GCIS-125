package memory.model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import memory.view.MemoryGUI;

public class RestartEventHandler implements EventHandler<ActionEvent> {

    Memory model;
    Label score;
    Label moves;
    GridPane pane;



    public RestartEventHandler (Memory model, Label score, Label moves, GridPane pane) {
        this.model = model;
        this.score = score;
        this.moves = moves;
        this.pane = pane;
    }

    @Override
    public void handle(ActionEvent arg0) {
        Memory newModel = MemoryGUI.makeModel();
        model = MemoryGUI.changeModel(newModel);
        score.setText("Score \n   " + model.getScore());
        moves.setText("Moves \n    " + model.getMoves());
        System.out.println("Game Restarted");
        MemoryGUI.restartButtons(pane);
    }
    
}
