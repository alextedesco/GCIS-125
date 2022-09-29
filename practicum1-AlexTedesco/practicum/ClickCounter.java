package practicum;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClickCounter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();
        int num = 0;
        Label label = new Label(Integer.toString(num));
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setFont(new Font("Times New Roman", 50));
        label.setTextFill(Color.ORANGE);
        label.setAlignment(Pos.CENTER);
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box.getChildren().add(label);      
        
        Button button = new Button("Click Me!");
        button.setTextFill(Color.PURPLE);
        button.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        button.setOnAction(new ClickCounterEventHandler(label, num));
        box.getChildren().add(button);
        
        Scene scene = new Scene(box);
        stage.setTitle("Count!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
