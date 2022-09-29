package dice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * An application that provides a 6-sided die rolling simulator.
 */
public class DieView extends Application {
    /**
     * Images for each of the 6 sides of the die.
     */
    private static final Image[] SIDES = {
        new Image("media/images/one.png"),
        new Image("media/images/two.png"),
        new Image("media/images/three.png"),
        new Image("media/images/four.png"),
        new Image("media/images/five.png"),
        new Image("media/images/six.png")
    };
    
    /**
     * The die being rolled.
     */
    private Die die;

    /**
     * The image view that displays an image of the side of the die that is 
     * currently facing up.
     */
    private ImageView sideView;

    @Override
    public void start(Stage stage) throws Exception {
        die = new Die();
        sideView = new ImageView(SIDES[die.getValue() - 1]);

        Label view = new Label("", sideView);
        view.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        // STUDENT: add an observer to die that calls dieRolled() on this class
        // when the die changes
        dieRolled();

        VBox box = new VBox();

        Button rollButton = new Button("Roll!");
        rollButton.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        // STUDENT: add an event handler to the rollButton that rolls the die
        rollButton.setOnAction(new DieEventHandler(die, sideView, view, SIDES));

        box.getChildren().addAll(view, rollButton);
        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.setTitle("Roll the Die!");
        stage.show();
    }

    /**
     * This method should be called whenever the die has been rolled so that the
     * image displayed by the image view is updated.
     */
    public void dieRolled() {
        int value = die.getValue();
        Image side = SIDES[value-1];
        sideView.setImage(side);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
