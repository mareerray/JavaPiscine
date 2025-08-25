import java.util.stream.*;
import java.util.Objects;
import java.util.List;
import java.util.Set;

public class StreamMap {
    //-------------------------------------------------------------------------
    //  Returns the sum of the length of the strings in the stream.
    public static Integer sumOfStringLength(Stream<String> s) {
        Objects.requireNonNull(s, "Stream cannot be null");
        return s
                .filter(Objects::nonNull)
                .mapToInt(String::length)  // or .mapToInt(s -> s.length())
                .sum();
        // String::length is a method reference (a shortcut for s -> s.length())
        // s -> s.length() is a lambda expression that takes each string s and returns its length.
        // mapToInt(s -> s.length()) creates a stream of int values representing each string’s length.
        // .sum() adds up all those lengths to get the total.
        // use Objects.requireNonNull(s) at the start of your method to throw an error if the argument is null.
        // add .filter(Objects::nonNull) before mapping to length—this skips any null strings.
    }
    //-------------------------------------------------------------------------
    // returns the list of all the strings in upper case.
    public static List<String> upperCaseAllString(Stream<String> s) {
        Objects.requireNonNull(s, "Stream cannot be null");
        return s
                .filter(Objects::nonNull)
                .map(String::toUpperCase)  // or .map(str -> str.toUpperCase())
                .collect(Collectors.toList());
        // use .map(String::toUpperCase) to convert each string in the stream to its uppercase version.
        // collect the result into a list with .collect(Collectors.toList()).
    }
    //-------------------------------------------------------------------------
    // keeps only doubles greater than 42,
    // transforms the doubles to integers and returns them as a set.
    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        Objects.requireNonNull(s, "Stream cannot be null");
        return s
                .filter(Objects::nonNull)
                .filter(d -> d > 42)
                .mapToInt(Double::intValue)       // Map to primitive int
                .boxed()                          // Convert int to Integer (object)
                .collect(Collectors.toSet());     // Collect to Set<Integer>
        // filter doubles greater than 42.
        // .mapToInt(Double::intValue) safely converts Double to int.
        // .boxed() wraps each int as an Integer so it can go into a Set<Integer>.
        // (type safety and boxing are important to avoid generic type errors.)
        // collect to a set using .collect(Collectors.toSet()), which ensures uniqueness.
    }
}