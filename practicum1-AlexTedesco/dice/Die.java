package dice;

import java.util.Random;

/**
 * A class that represents a 6-sided die that can be rolled.
 */
public class Die {
    /**
     * the number of sides on the die.
     */
    private static final int SIDES = 6;

    /**
     * Used to roll the die.
     */
    private static final Random RNG = new Random();

    /**
     * The value of the side that is currently facing up.
     */
    private int value;

    /**
     * An observer that is notified whenever the side facing up on the die 
     * changes.
     */
    private DieObserver observer;

    /**
     * Creates a new die with 6 sides.
     */
    public Die() {
        roll();
    }

    /**
     * Allows an observer to register to be notified whenever the side facing
     * up changes.
     * 
     * @param observer The observer that is registering for notification.
     */
    public void setOnRoll(DieObserver observer) {
        this.observer = observer;
    }

    /**
     * Returns the value of the side that is currently facing up.
     * 
     * @return The value of the side that is currently facing up.
     */
    public int getValue() {
        return value;
    }

    /**
     * Rolls the die. Notifies the observer after the die is rolled. Of course 
     * it is possible that the die is rolled to the same value twice in a row.
     */
    public void roll() {
        value = RNG.nextInt(SIDES) + 1;
        if(observer != null) {
            observer.dieRolled(this);
        }
    }
}
