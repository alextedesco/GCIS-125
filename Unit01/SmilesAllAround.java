import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SmilesAllAround extends Application {

    public static String getRandomPNG(String [] array) {
        int randomInt = new Random().nextInt(array.length);
        return array[randomInt];
    }

    public static StackPane makeStackPane () {
        String[] brows = new String[]{"media/images/emojis/browsangry.png", "media/images/emojis/browsbasic.png", "media/images/emojis/browshuh.png", "media/images/emojis/browsworried.png"};
        String randomBrow = getRandomPNG(brows);
        String[] eyes = new String[]{"media/images/emojis/eyesblack.png", "media/images/emojis/eyesblue.png", "media/images/emojis/eyesbrown.png", "media/images/emojis/eyesgreen.png"};
        String randomEyes = getRandomPNG(eyes);
        String[] heads = new String[]{"media/images/emojis/headblue.png", "media/images/emojis/headgreen.png", "media/images/emojis/headred.png", "media/images/emojis/headyellow.png"};
        String randomHeads = getRandomPNG(heads);
        String[] mouths = new String[]{"media/images/emojis/mouthbasic.png", "media/images/emojis/mouthdelerious.png", "media/images/emojis/mouthhm.png", "media/images/emojis/mouthohno.png"};
        String randomMouths = getRandomPNG(mouths);
        String[] nose = new String[]{"media/images/emojis/noseblue.png", "media/images/emojis/nosegreen.png", "media/images/emojis/noseorange.png", "media/images/emojis/nosered.png"};
        String randomNose = getRandomPNG(nose);
        
        StackPane pane = new StackPane();
        pane.getChildren().addAll(
            new ImageView(randomHeads),
            new ImageView(randomEyes),
            new ImageView(randomBrow),
            new ImageView(randomMouths),
            new ImageView(randomNose));
        return pane;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();
        Label label = new Label("0");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font("Impact", 30));
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        box.getChildren().add((label));

        GridPane gridPane = new GridPane();
        StackPane pane1 = makeStackPane();
        StackPane pane2 = makeStackPane();
        StackPane pane3 = makeStackPane();
        StackPane pane4 = makeStackPane();
        StackPane pane5 = makeStackPane();
        StackPane pane6 = makeStackPane();
        StackPane pane7 = makeStackPane();
        StackPane pane8 = makeStackPane();
        StackPane pane9 = makeStackPane();
        StackPane pane10 = makeStackPane();
        StackPane pane11 = makeStackPane();
        StackPane pane12 = makeStackPane();
        StackPane pane13 = makeStackPane();
        StackPane pane14 = makeStackPane();
        StackPane pane15 = makeStackPane();
        StackPane pane16 = makeStackPane();
        gridPane.add(pane1, 0, 0);
        gridPane.add(pane2, 0, 1);
        gridPane.add(pane3, 0, 2);
        gridPane.add(pane4, 0, 3);
        gridPane.add(pane5, 1, 0);
        gridPane.add(pane6, 1, 1);
        gridPane.add(pane7, 1, 2);
        gridPane.add(pane8, 1, 3);
        gridPane.add(pane9, 2, 0);
        gridPane.add(pane10, 2, 1);
        gridPane.add(pane11, 2, 2);
        gridPane.add(pane12, 2, 3);
        gridPane.add(pane13, 3, 0);
        gridPane.add(pane14, 3, 1);
        gridPane.add(pane15, 3, 2);
        gridPane.add(pane16, 3, 3);
        box.getChildren().add((gridPane));

        Button button = new Button("Randomize");
        button.setFont(new Font("Comic Sans", 15));
        button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box.getChildren().add((button));
        button.setOnAction(new SmilesAllAroundUpdater(label, gridPane));

        Scene scene = new Scene(box);
        stage.setTitle("StackPane Emoji");
        stage.setScene(scene);
        stage.show();   
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}