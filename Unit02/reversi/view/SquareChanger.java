package reversi.view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import reversi.model.Square;
import reversi.model.SquareObserver;

public class SquareChanger implements SquareObserver {

    ImageView view;
    private Button button;

    public SquareChanger (ImageView view, Button button) {
        this.button = button;
        this.view = view;
    }

    @Override
    public void squareChanged(Square s) {
        button.setGraphic(view);
    }
    
}
