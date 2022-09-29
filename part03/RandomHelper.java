package part03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomHelper {
    /**
     * A constant representing the correct, final size of the list.
     */
    public static final int SIZE = 100000;

    /**
     * Used to generate pseudorandom numbers.
     */
    private static final Random RNG = new Random();

    /**
     * Returns a pseudorandom number in the range 1 to 1,000,000 (inclusive).
     * 
     * @return A pseudorandom number in the rand [1 - 1000000].
     */
    public static int nextInt() {
        return RNG.nextInt(1000000) + 1;
    }

    /**
     * Returns true if the specified list contains only unique values, and 
     * false otherwise. The "?" means that the list can be any kind of list
     * (integers, strings, Pokemon, etc.).
     * 
     * @param list The list being checked for uniqueness.
     * 
     * @return True if the list does not contain any duplicate values, and 
     * false otherwise.
     */
    public static void assertList(List<?> list) {
        HashSet<?> uniqueValues = new HashSet<>(list);
        assertEquals(list.size(), uniqueValues.size());
        assertEquals(SIZE, list.size());
    }
}
