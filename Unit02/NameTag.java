import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class NameTag extends Application {

    
    private static Label makeLabel (String labelName, String font, int fontSize, Color textColor, int paddingSize, Color backgroundColor,
    Pos alignment, Color borderColor, BorderStrokeStyle borderStrokeStyle, int cornerRadiiSize, BorderWidths borderStroke) {
        Label label = new Label(labelName);
        label.setFont(new Font(font, fontSize));
        label.setTextFill(textColor);
        label.setPadding(new Insets(paddingSize));
        label.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setAlignment(alignment);
        label.setBorder(new Border(new BorderStroke(borderColor, borderStrokeStyle, new CornerRadii(cornerRadiiSize), borderStroke)));
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        return label;
    }

    public void start (Stage stage) throws Exception {
        VBox box = new VBox();
        Label label_1 = makeLabel("Hello My Name Is", "Impact", 20, Color.BLUE, 0, Color.WHITE, Pos.CENTER, 
        Color.YELLOW, BorderStrokeStyle.NONE, 0, BorderStroke.DEFAULT_WIDTHS);
        box.getChildren().add((label_1));

        Label label_2 = makeLabel("Your Name", "Comic Sans", 30, Color.RED, 0, Color.WHITE, Pos.CENTER,
        Color.BLUE, BorderStrokeStyle.SOLID, 8, BorderStroke.THICK);
        box.getChildren().add((label_2));

        TextField textField = new TextField();
        textField.setPromptText("Enter Your Name");
        box.getChildren().add((textField));

        Button button1 = new Button();
        button1.setText("Update Name Tag");
        button1.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box.getChildren().add((button1));

        button1.setOnAction(new NameTagUpdater(textField, label_2));

        Button button2 = new Button();
        button2.setText("Clear");
        button2.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        box.getChildren().add((button2));

        button2.setOnAction(new NameTagClearUpdater(label_2));

        Scene scene = new Scene(box);

        stage.setTitle("Java GUI #1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch (args);
    }


    
}
