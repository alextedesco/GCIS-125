package memory.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import memory.model.Memory;
import memory.model.MemoryException;

public class MoveMaker implements EventHandler<ActionEvent> {

    int row;
    int col;
    MemoryGUI gui = new MemoryGUI();
    Button button;
    Memory model;
    Label score;
    Label moves;

    public MoveMaker (int row, int col, Button button, Memory model, Label score, Label moves) {
        this.row = row;
        this.col = col;
        this.button = button;
        this.model = model;
        this.score = score;
        this.moves = moves;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            // Card card = model.getCard(col, row);
            // char symbol = card.getSymbol();
            Image image = MemoryGUI.symbols(model, col, row);
            ImageView view = new ImageView(image);
            button.setGraphic(view);
            model.flip(col, row);
            score.setText("Score \n   " + Integer.toString(model.getScore()));
            System.out.println("The Score is now " + model.getScore());
            moves.setText("Moves \n    " + Integer.toString(model.getMoves()));
            System.out.println("The user has made " + model.getMoves() + " moves.");
        } catch (MemoryException e) {
            System.err.println("Invalid Move! Can't flip a card that is already face up!");
        }
    }

}
