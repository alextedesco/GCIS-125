package reversi.model;

/**
 * A class that represents a square on a board in a game of Reversi.
 */
public class Square {
    /**
     * The piece that may or may not occupy the square.
     */
    private SquareColor piece;
    private SquareObserver observer;

    /**
     * Creates a new, empty square.
     */
    public Square() {
        piece = SquareColor.EMPTY;
    }

    /**
     * Returns true if the square has a piece played on it, and false
     * otherwise.
     *
     * @return True if a piece has been played on the square. Otherwise false.
     */
    public boolean isOccupied() {
        return piece != SquareColor.EMPTY;
    }

    /**
     * Returns the currently face-up color of the piece on this square (or
     * Color.EMPTY if there is no piece).
     *
     * @return The currently face-up color of the piece on this square.
     */
    public SquareColor getOccupyingColor() {
        return piece;
    }

    /**
     * Attempts to play a piece on the square.
     *
     * @param piece The piece being played on the square.
     *
     * @throws ReversiException If a piece has already been played on the
     * square.
     */
    public void occupy(SquareColor piece) throws ReversiException {
        if(isOccupied()) {
            throw new ReversiException("Square is already occupied");
        } else {
            this.piece = piece;
            notifyObserver();
        }
    }

    /**
     * Resets the square to the empty state (no piece played).
     */
    public void reset() {
        piece = SquareColor.EMPTY;
        notifyObserver();
    }

    /**
     * Flips the piece played on this square to the opposite side.
     *
     * @throws ReversiException If the square is empty.
     */
    public void flip() throws ReversiException {
        if(!isOccupied()) {
            throw new ReversiException("Square is empty.");
        } else {
            piece = piece.flip();
            notifyObserver();
        }
    }

    public void setOnChange (SquareObserver observer) {
        this.observer = observer;
    }

    private void notifyObserver () {
        if (observer != null) {
            observer.squareChanged(this);
        }

    }

    /**
     * Returns a string representation of the square; either " " if the square
     * is empty, or the short symbol for the piece if it is not.
     *
     * @return A string representation of the square.
     */
    @Override
    public String toString() {
        return isOccupied() ? piece.getSymbol() : " ";
    }
}
