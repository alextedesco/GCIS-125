package reversi.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import reversi.MoveMaker;
import reversi.model.Reversi;
import reversi.model.ReversiException;
import reversi.model.Square;

public class ReversiGUI extends Application {

    public final static Image square = new Image("reversi/square.png");
    public final static Image blank = new Image("reversi/blank.png");
    public final static Image blackpiece = new Image("reversi/blackpiece.png");
    public final static Image whitepiece = new Image("reversi/whitepiece.png");

    private static Reversi model = new Reversi();
    private Label playerOneScore = new Label();
    private Label playerTwoScore = new Label();

    private static Button makeReversiButton (int row, int col) {
        
        Square squarePiece = model.getSquare (row, col);
        
        if (squarePiece.isOccupied() == false) {
            ImageView view = new ImageView(blank);
            Button button = new Button("", view);
            button.setBackground(new Background(
                new BackgroundImage(
                    square,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT
                    )));
            button.setPadding(new Insets(0));
            button.setPrefSize(72, 72);
            button.setOnAction(new MoveMaker(row, col, button, model));
            return button;

        } else {
            if (squarePiece.getOccupyingColor().getSymbol().equals("W")) {
                ImageView view = new ImageView(whitepiece);
                Button button = new Button("", view);
                button.setBackground(new Background(
                new BackgroundImage(
                    square,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT
            )));
            button.setPadding(new Insets(0));
            button.setPrefSize(72, 72);
            button.setOnAction(new MoveMaker(row, col, button, model));
            return button;
            } else if (squarePiece.getOccupyingColor().getSymbol().equals("B")) {
                ImageView view = new ImageView(blackpiece);
                Button button = new Button("", view);
                button.setBackground(new Background(
                new BackgroundImage(
                    square,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT
            )));
            button.setPadding(new Insets(0));
            button.setPrefSize(72, 72);
            button.setOnAction(new MoveMaker(row, col, button, model));
            return button;
            }
        }
        return null;  
    }

    public Label getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(Label playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public Label getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(Label playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public String makeMove (int row, int col) {
        try {
            model.move(row, col);
        } catch (ReversiException e) {
           return "Bad Move!";
        }
        return "Move Accepted at Row: " + row + " Col: " + col;
    }

    @Override
    public void start(Stage stage) throws Exception {

        GridPane pane = new GridPane();
        
        for(int c = 0; c < Reversi.COLS; c++){
            for(int r = 0; r < Reversi.ROWS; r++){
                Button button = makeReversiButton(r, c);
                pane.add(button, c, r);
            }
        }

        Scene scene = new Scene(pane);

        stage.setTitle("Reversi");
        stage.setScene(scene);
        stage.show();
        // makeMove(5, 3);
    }
    
    public static void main(String[] args) {
        launch (args);
    }
}
