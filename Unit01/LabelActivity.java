import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LabelActivity extends Application {

    private static Label makeLabel (String labelName, String font, int fontSize, Color textColor, int paddingSize, Color backgroundColor,
    Pos alignment, Color borderColor, BorderStrokeStyle borderStrokeStyle, int cornerRadiiSize, BorderWidths borderStroke) {
        Label label = new Label(labelName);
        label.setFont(new Font(font, fontSize));
        label.setTextFill(textColor);
        label.setPadding(new Insets(paddingSize));
        label.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setAlignment(alignment);
        label.setBorder(new Border(new BorderStroke(borderColor, borderStrokeStyle, new CornerRadii(cornerRadiiSize), borderStroke)));
        return label;
    }

    public void start (Stage stage) throws Exception {
        HBox box = new HBox();
        Label label_1 = makeLabel("Label #1", "Comic Sans", 20, Color.BLUE, 10, Color.BLACK, Pos.CENTER_LEFT, 
        Color.YELLOW, BorderStrokeStyle.DASHED, 5, BorderStroke.DEFAULT_WIDTHS);
        box.getChildren().add((label_1));

        Label label_2 = makeLabel("Label #2", "Times New Roman", 30, Color.RED, 20, Color.YELLOW, Pos.CENTER,
        Color.BLUE, BorderStrokeStyle.DOTTED, 8, BorderStroke.THICK);
        box.getChildren().add((label_2));

        Label label_3 = makeLabel("Label #3", "Arial", 40, Color.GREEN, 40, Color.PURPLE, Pos.CENTER_RIGHT,
        Color.PINK, BorderStrokeStyle.SOLID, 10, BorderStroke.THIN);
        box.getChildren().add((label_3));

        Scene scene = new Scene(box);

        stage.setTitle("Java GUI #1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
