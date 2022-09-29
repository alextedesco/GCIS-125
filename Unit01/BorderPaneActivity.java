import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class BorderPaneActivity extends Application {

    private static Label makeLabel (String labelName, String font, int fontSize, Color textColor, int paddingSize, Color backgroundColor,
    Pos alignment) /*Color borderColor, BorderStrokeStyle borderStrokeStyle, int cornerRadiiSize, BorderWidths borderStroke/** */ {
        Label label = new Label(labelName);
        label.setFont(new Font(font, fontSize));
        label.setTextFill(textColor);
        label.setPadding(new Insets(paddingSize));
        label.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setAlignment(alignment);
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        // label.setBorder(new Border(new BorderStroke(borderColor, borderStrokeStyle, new CornerRadii(cornerRadiiSize), borderStroke)));
        return label;
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox box = new HBox();
        BorderPane pane = new BorderPane();
        pane.setTop(makeLabel("Top", "Arial", 12, Color.BLACK, 10, Color.YELLOW, Pos.CENTER));
        pane.setBottom(makeLabel("Bottom", "Arial", 12, Color.BLACK, 10, Color.PINK, Pos.CENTER));
        pane.setLeft(makeLabel("Left", "Arial", 12, Color.BLACK, 10, Color.GREEN, Pos.CENTER));
        pane.setRight(makeLabel("Right", "Arial", 12, Color.BLACK, 10, Color.BLUE, Pos.CENTER));
        pane.setCenter(makeLabel("Center", "Arial", 12, Color.BLACK, 10, Color.ORANGE, Pos.CENTER));
        box.getChildren().add((pane));

        Scene scene = new Scene(box);
        
        stage.setTitle("Java GUI #1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
