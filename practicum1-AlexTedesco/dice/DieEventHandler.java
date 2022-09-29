package dice;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DieEventHandler implements EventHandler<ActionEvent> {

    Die die;
    ImageView sideView;
    Label view;
    Image [] SIDES;


    public DieEventHandler (Die die, ImageView sideView, Label view, Image[] SIDES) {
        this.die = die;
        this.sideView = sideView;
        this.view = view;
        this.SIDES = SIDES;
    }

    @Override
    public void handle(ActionEvent arg0) {
        die.roll();   
        sideView = new ImageView(SIDES[die.getValue() - 1]);
        view.setGraphic(sideView);
    }
    
}
