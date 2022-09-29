package reversi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import reversi.model.Reversi;
import reversi.view.ReversiGUI;

public class MoveMaker implements EventHandler<ActionEvent> {

    int row;
    int col;
    ReversiGUI gui = new ReversiGUI();
    Button button;
    Reversi model;

    public MoveMaker (int row, int col, Button button, Reversi model) {
        this.row = row;
        this.col = col;
        this.button = button;
        this.model = model;
    }

    @Override
    public void handle(ActionEvent event) {
        
        if (model.getCurrentPlayer().getSymbol().equals("W")) {
            if (gui.makeMove(row, col).equals("Move Accepted at Row: " + row + " Col: " + col)) {
                ImageView whiteView = new ImageView(ReversiGUI.whitepiece);
                button.setGraphic(whiteView);
                model.pass();
            } else {
                ImageView blankView = new ImageView(ReversiGUI.blank);
                button.setGraphic(blankView);
            }
        } else if (model.getCurrentPlayer().getSymbol().equals("B")) {
            if (gui.makeMove(row, col).equals("Move Accepted at Row: " + row + " Col: " + col)) {
                ImageView blackView = new ImageView(ReversiGUI.blackpiece);
                button.setGraphic(blackView);
                gui.makeMove(row, col);
                model.pass();
        } else {
            ImageView blankView = new ImageView(ReversiGUI.blank);
            button.setGraphic(blankView);
            }
        }
    }
}
