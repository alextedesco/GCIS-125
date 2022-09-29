package reversi.model;

/**
 * Represents a piece in Reversi.
 */
public enum SquareColor {
    EMPTY(" "),
    WHITE("W"),
    BLACK("B");

    /**
     * A 1-character string representing the piece.
     */
    private final String symbol;

    private SquareColor(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns the opposing color. Useful when changing turns or flipping
     * pieces. The opposing color of "empty" is "empty".
     *
     * @return The opposing color.
     */
    public SquareColor flip() {
        return this == EMPTY ? EMPTY : (this == BLACK ? WHITE : BLACK);
    }
}
