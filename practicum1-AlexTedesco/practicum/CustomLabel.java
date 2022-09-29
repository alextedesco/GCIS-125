package practicum;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CustomLabel extends Application {

    private static Label makeLabel (String labelName, String font, int fontSize, Color textColor, int paddingSize, Color backgroundColor, Pos alignment) {
        Label label = new Label(labelName);
        label.setFont(new Font(font, fontSize));
        label.setTextFill(textColor);
        label.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setAlignment(alignment);
        label.setPadding(new Insets(paddingSize));
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        return label;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label label = makeLabel("Label", "Times New Roman", 20, Color.BLACK, 10, Color.ORANGE, Pos.CENTER);
        Scene scene = new Scene(label);
        stage.setTitle("Custom Label");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
