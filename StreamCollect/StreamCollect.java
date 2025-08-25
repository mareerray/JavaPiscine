import java.util.*;
import java.util.stream.*;

public class StreamCollect {
    //-------------------------------------------------------------------------
    // maps the first letter (to upper case) to a list of Strings begining with the given letter.
    public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {
        return s
                .filter(word -> word != null && !word.trim().isEmpty())
                .collect(Collectors.groupingBy(
                        word -> Character.toUpperCase(word.charAt(0))
                ));
        // The filter removes unwanted words.
        // groupingBy creates the map and handles making lists and adding elements.
    }
    //-------------------------------------------------------------------------
    // groups the integers by modulo 4 and returns a map associating each module 4 value
    // to the max integer in each group.
    public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer> s) {
        return s
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        num -> num % 4,
                        Collectors.maxBy(Comparator.naturalOrder())
                ));
        // The classifier for groupingBy is num -> num % 4.
        // The maxBy collector finds the maximum value per group.
    }
    //-------------------------------------------------------------------------
    // joins the alphabetically sorted Strings with a ' # ' between each.
    // The resulting String starts with a '{' and ends with a '}'.
    public static String orderAndConcatWithSharp(Stream<String> s) {
        return s
                .sorted() // Sort alphabetically
                .collect(Collectors.joining(" # ", "{", "}")); // Join, add braces (delimeter, prefix, suffix)
        // this collector is a special tool that turns a stream into one final string,
        // with any separator or wrapper.
    }
}

/* ----------------Alternatives------------
    public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {
        // Create an empty map to store results:
        // key = uppercase letter, value = list of matching words
        Map<Character, List<String>> firstLetterResults = new HashMap<>();

        // Go through each word in the stream
        s.forEach(word -> {
            // Skip if word is null or only spaces
            if (word == null || word.trim().isEmpty()) {
                return;
            }

            // Get the first letter as uppercase
            char letter = Character.toUpperCase(word.charAt(0));

            // If map does NOT have the letter yet, create new list and add the word
            if (!firstLetterResults.containsKey(letter)) {
                List<String> wordList = new ArrayList<>();
                wordList.add(word);
                firstLetterResults.put(letter, wordList); // Put new list in map
            } else {
                // If map already has the letter, add word to the existing list
                // .get(letter) checks the map for the given key (letter).
                // If the key is found, it returns the list of words linked with that key.
                // If the key is not found, it returns null.
                // then store this list in wordList.
                List<String> wordList = firstLetterResults.get(letter);
                wordList.add(word);
            }
        });
        // Return the final map with grouped words
        return firstLetterResults;
    }

    public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer> s) {
        // Create an empty map
        Map<Integer, Optional<Integer>> resultsMap = new HashMap<>();

        // Go through each number in the stream
        s.forEach(num -> {
            if (num == null) return; // Ignore if null
            int cal = num % 4; // Calculate num % 4
            if (!resultsMap.containsKey(cal)) { // If key doesn’t exist:
                resultsMap.put(cal, Optional.of(num)); // add it with Optional.of(num).
            } else { // If already exists:
                int tempMax = resultsMap.get(cal).get();
                // get the value with .get() and another.get() to get the value inside the Optional
                if (num > tempMax) {  // compare
                    resultsMap.put(cal, Optional.of(num)); // and put new value only if the new number is bigger.
                } else {
                    return;
                }
            }
        });
        return resultsMap; // Return the map
    }
 */