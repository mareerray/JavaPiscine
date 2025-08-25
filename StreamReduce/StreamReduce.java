import java.util.*;
import java.util.stream.*;
import java.util.Objects;

public class StreamReduce {
    //-------------------------------------------------------------------------
    // returns the sum of integers in the stream.
    public static Integer sumAll(Stream<Integer> s) {
        return s.filter(Objects::nonNull)         // Remove nulls
                .mapToInt(Integer::intValue)      // Convert to IntStream
                .sum();                           // Sum the ints
        // filter(Objects::nonNull): removes null values for safety.
        // mapToInt(Integer::intValue): converts each Integer to an int, producing an IntStream.
        // (you need to turn each Integer object into a primitive int so you can use methods like .sum())
        // sum(): calculates the total sum of all the numbers.
    }
    //-------------------------------------------------------------------------
    // sums the result of the division, of all the integers in the stream, by the divider.
    public static Integer divideAndAddElements(Stream<Integer> s, int divider) {
        Objects.requireNonNull(s, "Stream cannot be null");
        if (divider == 0) throw new IllegalArgumentException("Divider cannot be zero");
        return s.filter(Objects::nonNull)
                .mapToInt(Integer::intValue) // Convert (unbox) Integer to int
                .map(i -> i / divider)  // Safely do math as int
                .sum();
    }
}