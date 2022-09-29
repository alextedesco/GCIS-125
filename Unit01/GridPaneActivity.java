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
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GridPaneActivity extends Application {

    private static Label makeLabel (String labelName, String font, int fontSize, Color textColor, int paddingSize, Color backgroundColor,
    Pos alignment) {
        Label label = new Label(labelName);
        label.setFont(new Font(font, fontSize));
        label.setTextFill(textColor);
        label.setPadding(new Insets(paddingSize));
        label.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, new Insets(1))));
        label.setAlignment(alignment);
        label.setMaxSize(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        return label;
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();

        Label ac = makeLabel("AC", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(ac, 0, 1, 2, 1);

        Label percent = makeLabel("%", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(percent, 2, 1);

        Label divide = makeLabel("/", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(divide, 3, 1);

        Label seven = makeLabel("7", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(seven, 0, 2);

        Label eight = makeLabel("8", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(eight, 1, 2);
        Label nine = makeLabel("9", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(nine, 2, 2);

        Label multiply = makeLabel("x", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(multiply, 3, 2);

        Label four = makeLabel("4", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(four, 0, 3);

        Label five = makeLabel("5", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(five, 1, 3);

        Label six = makeLabel("6", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(six, 2, 3);

        Label minus = makeLabel("-", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(minus, 3, 3);

        Label one = makeLabel("1", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(one, 0, 4);

        Label two = makeLabel("2", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(two, 1, 4);

        Label three = makeLabel("3", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(three, 2, 4);

        Label plus = makeLabel("+", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(plus, 3, 4);

        Label zero = makeLabel("0", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(zero, 0, 5, 2, 1);

        Label decimal = makeLabel(".", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(decimal, 2, 5);

        Label equals = makeLabel("=", "Arial", 30, Color.BLACK, 1, Color.LIGHTGRAY, Pos.CENTER);
        gridPane.add(equals, 3, 5);

        Label display = makeLabel("123.456", "Arial", 30, Color.BLACK, 1, Color.WHITE, Pos.CENTER_RIGHT);
        display.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderStroke.DEFAULT_WIDTHS)));
        gridPane.add(display, 0, 0, 4, 1);

        Scene scene = new Scene(gridPane);
        
        stage.setTitle("Grid Pane Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
