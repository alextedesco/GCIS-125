/**
 * This class creates a GUI that plays a game of Memory
 * @author Alex Tedesco
 */

package memory.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import memory.model.Memory;
import memory.model.MemoryException;
import memory.model.RestartEventHandler;

public class MemoryGUI extends Application {
    // Default Card Types
    public final static Image back = new Image("media/images/memory/back.png");
    public final static Image blank = new Image("media/images/memory/blank.png");

    // A-O - 14 Card Types (Goat & Troll Cards)
    public final static Image goat00 = new Image("media/images/memory/goat00.png");
    public final static Image goat01 = new Image("media/images/memory/goat01.png");
    public final static Image goat02 = new Image("media/images/memory/goat02.png");
    public final static Image goat03 = new Image("media/images/memory/goat03.png");
    public final static Image goat04 = new Image("media/images/memory/goat04.png");
    public final static Image goat05 = new Image("media/images/memory/goat05.png");
    public final static Image goat06 = new Image("media/images/memory/goat06.png");
    public final static Image goat07 = new Image("media/images/memory/goat07.png");
    public final static Image goat08 = new Image("media/images/memory/goat08.png");
    public final static Image goat09 = new Image("media/images/memory/goat09.png");
    public final static Image troll00 = new Image("media/images/memory/troll00.png");
    public final static Image troll01 = new Image("media/images/memory/troll01.png");
    public final static Image troll02 = new Image("media/images/memory/troll02.png");
    public final static Image troll03 = new Image("media/images/memory/troll03.png");
    public final static Image troll04 = new Image("media/images/memory/troll04.png");

    public final static Image wood = new Image("media/images/memory/wood.png");

    public static final char[] symbols = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O'};

    public static Memory makeModel () {
        try {
            Memory model = new Memory(4, 4, symbols);
            return model;
        } catch (MemoryException e) {
            System.err.println("Failed to make Memory model!");
        }
        return null;
    }

    public static Memory model = makeModel ();

    public static Label score = new Label();
    public static Label moves = new Label();
    public static Button restart = new Button("Restart Game");

    /**
     * Creates each button in the Memory GUI
     * @param row - The row that the button is made at
     * @param col - The column that the button is made at
     */


    private static Button makeMemoryButton (int row, int col) {
        ImageView view = new ImageView(wood);
        Button button = new Button("", view);
        button.setBackground(new Background(
            new BackgroundImage(
                wood,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
            )));
        button.setPadding(new Insets(0));
        button.setPrefSize(72, 72);
        button.setOnAction(new memory.view.MoveMaker(row, col, button, model, score, moves));
        return button;
    }

    public static void restartButtons (GridPane pane) {
        for(int c = 0; c < 4; c++){
            for(int r = 0; r < 4; r++){
                Button button = makeMemoryButton(c, r);
                pane.add(button, c, r);
            }
        }
    }

    public static Memory changeModel (Memory newModel) {
        model = newModel;
        return model;
    }

    /**
     * Flips a card in the MemoryGUI
     * @param row - The row of the card
     * @param col - The column of the card
     */

    public void makeMove (int row, int col) throws MemoryException {
        model.flip (row, col);        
    }

    /**
     * This methods maps each Image with a char. It is used to set the graphic of each button after being clicked
     * @param newSong - The Song object that becomes the new current song
     * @param col - Column used to identify the char of the card
     * @param row - Row used to identify the char of the card
     */

    public static Image symbols (Memory model, int col, int row) throws MemoryException {
        char symbol = model.getCard(col, row).getSymbol();
        if (symbol == 'A') {
            return goat00;
        } else if (symbol == 'B') {
            return goat01;
        } else if (symbol == 'C') {
            return goat02;
        } else if (symbol == 'D') {
            return goat03;
        } else if (symbol == 'E') {
            return goat04;
        } else if (symbol == 'F') {
            return goat05;
        } else if (symbol == 'G') {
            return goat06;
        } else if (symbol == 'H') {
            return goat07;
        } else if (symbol == 'I') {
            return goat08;
        } else if (symbol == 'J') {
            return goat09;
        } else if (symbol == 'K') {
            return troll00;
        } else if (symbol == 'L') {
            return troll01;
        } else if (symbol == 'M') {
            return troll02;
        } else if (symbol == 'N') {
            return troll03;
        } else if (symbol == 'O') {
            return troll04;
        }
        return null;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox box1 = new VBox();
        score.setText("Score \n   " + model.getScore());
        score.setBackground(new Background(new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY)));
        score.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        score.setAlignment(Pos.CENTER);
        VBox.setVgrow(score, Priority.ALWAYS);

        moves.setText ("Moves \n    " + model.getMoves());
        moves.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        moves.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        moves.setAlignment(Pos.CENTER);
        VBox.setVgrow(moves, Priority.ALWAYS);

        box1.getChildren().add(score);
        box1.getChildren().add(moves);

        GridPane pane = new GridPane();
        for(int c = 0; c < 4; c++){
            for(int r = 0; r < 4; r++){
                Button button = makeMemoryButton(c, r);
                pane.add(button, c, r);
            }
        }

        HBox box2 = new HBox();
        box1.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box2.getChildren().add(box1);
        box2.getChildren().add(pane);

        VBox box3 = new VBox();
        box3.getChildren().add(box2);
        restart.setOnAction(new RestartEventHandler(model, score, moves, pane));
        restart.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box3.getChildren().add(restart);

        Scene scene = new Scene(box3);

        stage.setTitle("Goats vs. Memory");
        stage.setScene(scene);
        stage.show();
        System.out.println("Memory Game has started");
    }
    
    public static void main(String[] args) {
        launch (args);
    }
}
