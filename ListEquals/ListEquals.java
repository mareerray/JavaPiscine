import java.util.List;

public class ListEquals {
    public static boolean areListsEqual(List<String> list1, List<String> list2) {
        // both null → equal
        if (list1 == null && list2 == null) return true;
        // one is null → not equal
        if (list1 == null || list2 == null) return false;
        // both not null → check contents
        return list1.equals(list2);
    }
}