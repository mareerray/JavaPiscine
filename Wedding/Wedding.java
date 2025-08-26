import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Wedding {
    // returns a map of names which associates randomly a name from the first list to a name of the second list.
    // If the lists have different sizes, some names from the bigger list will be ignored.
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        // Convert sets to lists
        List<String> firstList = new ArrayList<>(first);
        List<String> secondList = new ArrayList<>(second);

        // Shuffle both lists with Collections.shuffle() method
        Collections.shuffle(firstList);
        Collections.shuffle(secondList);

        // find a smaller length
        int minLength = Math.min(firstList.size(), secondList.size());

        // Build a map: use a HashMap to store the pairs(couples).
        Map <String, String> coupleList = new HashMap<>();

        // Pair names: loop through the smaller length
        // and pair names up to the shortest list size
        for (int i = 0; i < minLength; i++) {
            coupleList.put(firstList.get(i), secondList.get(i));
        }
        return coupleList;
    }
}