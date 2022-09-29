package practicum;
import java.util.Date;

import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXBoilerplate extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(new Date().toString());   
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}