import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SortList {
    public static List<Integer> sort(List<Integer> list) {
        // Should return null when the list is null
        if (list == null) return null;

        // Copy the list to a newList
        List<Integer> sortedList = new ArrayList<>(list);

        // Use a built-in functions to sort a list
        // sorts from smallest to largest
        Collections.sort(sortedList);
        return sortedList;

    }
    /*
    public static List<Integer> sort(List<Integer> list) {
        // Copy the list to a newList
        List<Integer> sortedList = new ArrayList<>(list);
        // Should return null when the list is null or empty
        if (list == null || list.isEmpty()) return null;
        // Use Bubble Sort
        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (sortedList.get(j) > sortedList.get(j+1)) {
                    int temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j+1));
                    sortedList.set(j+1, temp);
                }
            }
        }
        return sortedList;
    }*/

    public static List<Integer> sortReverse(List<Integer> list) {
        // Should return null when the list is null
        if (list == null) return null;

        // Copy the list to a newList
        List<Integer> sortedReverseList = new ArrayList<>(list);

        // Use a built-in functions to sort a list
        // sorts from largest to smallest
        Collections.sort(sortedReverseList, Collections.reverseOrder());
        return sortedReverseList;
    }
    /*
    public static List<Integer> sort(List<Integer> list) {
        // Copy the list to a newList
        List<Integer> sortedReversList = new ArrayList<>(list);
        // Should return null when the list is null or empty
        if (list == null || list.isEmpty()) return null;
        // Use Bubble Sort
        for (int i = 0; i < sortedReversList.size() - 1; i++) {
            for (int j = 0; j < sortedReversList.size() - i - 1; j++) {
                if (sortedReversList.get(j) < sortedReversList.get(j+1)) {
                    int temp = sortedReversList.get(j);
                    sortedReversList.set(j, sortedReversList.get(j+1));
                    sortedReversList.set(j+1, temp);
                }
            }
        }
        return sortedReversList;
    }*/
}