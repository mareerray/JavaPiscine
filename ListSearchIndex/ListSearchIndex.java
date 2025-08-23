import java.util.List;
import java.util.ArrayList;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null || list.isEmpty()) {
            // List is missing or has no elements
            return null;
        }
        if (value == null) {
            // Value to search for is missing
            return null;
        }
        int index = list.lastIndexOf(value);
        if (index == -1) {
            return null;
        } else {
            return index;
        }
    }
    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null || list.isEmpty()) {
            // List is missing or has no elements
            return null;
        }
        if (value == null) {
            // Value to search for is missing
            return null;
        }
        int index = list.indexOf(value);
        if (index == -1) {
            return null;
        } else {
            return index;
        }
    }
    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        // Set up a result list
        List<Integer> resultList = new ArrayList<>();

        // List is missing or has no elements or value is missing, return an empty list
        if (list == null || list.isEmpty() || value == null) {
            return resultList;
        }

        // Loop through the list
        for (int i = 0; i < list.size(); i++) {
            if (value.equals(list.get(i))) {
                resultList.add(i); // save the index if found
            }
        }
        return resultList;
    }
}