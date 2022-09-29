import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class GrowingGraphics extends Application {

    public void start (Stage stage) throws Exception {
        HBox box = new HBox();

        VBox box1 = new VBox();
                
        ImageView jumpImage1 = new ImageView("smb/jump.png");
        ImageView jumpImage2 = new ImageView("smb/jump.png");
        ImageView jumpImage3 = new ImageView("smb/jump.png");

        Label label1 = new Label("Jump!", jumpImage1);        
        label1.setContentDisplay(ContentDisplay.TOP);
        label1.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        

        Label label2 = new Label("Jump!", jumpImage2);
        label2.setContentDisplay(ContentDisplay.TOP);
        label2.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        

        Label label3 = new Label("Jump!", jumpImage3);
        label3.setContentDisplay(ContentDisplay.TOP);
        label3.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        

        box1.getChildren().add(label1);
        box1.getChildren().add(label2);
        box1.getChildren().add(label3);
        VBox.setVgrow(label1, Priority.ALWAYS);
        VBox.setVgrow(label2, Priority.ALWAYS);
        VBox.setVgrow(label3, Priority.ALWAYS);

        HBox box2 = new HBox();

        ImageView goombaImage1 = new ImageView("smb/goomba.png");
        ImageView goombaImage2 = new ImageView("smb/goomba.png");
        ImageView goombaImage3 = new ImageView("smb/goomba.png");

        Button button1 = new Button("Goomba", goombaImage1);
        button1.setPadding(new Insets(50));
        button1.setContentDisplay(ContentDisplay.BOTTOM);
        button1.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        
        Button button2 = new Button("Goomba", goombaImage2);
        button2.setPadding(new Insets(50));
        button2.setContentDisplay(ContentDisplay.BOTTOM);
        button2.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        

        Button button3 = new Button("Goomba", goombaImage3);
        button3.setPadding(new Insets(50));
        button3.setContentDisplay(ContentDisplay.BOTTOM);
        button3.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);        

        HBox.setHgrow(button1, Priority.ALWAYS);
        HBox.setHgrow(button2, Priority.ALWAYS);
        HBox.setHgrow(button3, Priority.ALWAYS);


        box2.getChildren().add(button1);
        box2.getChildren().add(button2);
        box2.getChildren().add(button3);

        box.getChildren().add(box1);
        box.getChildren().add(box2);
        
        Scene scene = new Scene(box);

        stage.setTitle("Growing Graphics");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch (args);
    }
}
