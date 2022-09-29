package practicum;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Colors extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox box1 = new VBox();
        Label label = new Label();
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box1.getChildren().add(label);
        VBox.setVgrow(label, Priority.ALWAYS);

        HBox box2 = new HBox();
        
        Button redButton = new Button("R");
        redButton.setTextFill(Color.RED);
        redButton.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        redButton.setFont(new Font("Times New Roman", 20));
        redButton.setOnAction(new ColorsEventHandler(label, Color.RED));
        HBox.setHgrow(redButton, Priority.ALWAYS);
        box2.getChildren().add(redButton);

        Button greenButton = new Button("G");
        greenButton.setTextFill(Color.GREEN);
        greenButton.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        greenButton.setFont(new Font("Times New Roman", 20));
        greenButton.setOnAction(new ColorsEventHandler(label, Color.GREEN));
        HBox.setHgrow(greenButton, Priority.ALWAYS);
        box2.getChildren().add(greenButton);

        Button blueButton = new Button("B");
        blueButton.setTextFill(Color.BLUE);
        blueButton.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        blueButton.setFont(new Font("Times New Roman", 20));
        blueButton.setOnAction(new ColorsEventHandler(label, Color.BLUE));
        HBox.setHgrow(blueButton, Priority.ALWAYS);
        box2.getChildren().add(blueButton);

        box1.getChildren().add(box2);
        
        Scene scene = new Scene(box1);
        stage.setTitle("Colors!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
