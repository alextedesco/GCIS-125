import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageViewer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        HBox box = new HBox();
        Image image = new Image("media/images/sunflowers.jpg");
        ImageView view = new ImageView(image);
        box.getChildren().add(view);
        
        
        Scene scene = new Scene(box);

        stage.setTitle("Image Viewer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch (args);
    }
    
}
