import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPaneActivity extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();
        pane.getChildren().addAll(
            new ImageView("media/images/emojis/headyellow.png"),
            new ImageView("media/images/emojis/eyesblack.png"),
            new ImageView("media/images/emojis/mouthbasic.png"),
            new ImageView("media/images/emojis/browshuh.png"),
            new ImageView("media/images/emojis/noseorange.png")
        );

        Scene scene = new Scene(pane);

        stage.setTitle("StackPane Emoji");
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
