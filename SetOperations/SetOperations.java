import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    // For union, use addAll on a new set, then return the set.
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        // Set up a new empty set
        Set<Integer> result = new HashSet<>();
        if (set1 != null) result.addAll(set1); // add all items from set1
        if (set2 != null) result.addAll(set2); // add all items from set2
        return result;

        // 'result' contains all unique elements from both sets
    }

    // For intersection, use retainAll on a copy, then return the copy.
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1 == null || set2 == null) return new HashSet<>();
        // Copy set 1
        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2); // keep only items also in set2
        return common;

        // 'common' now holds the items that are in both sets
    }
}