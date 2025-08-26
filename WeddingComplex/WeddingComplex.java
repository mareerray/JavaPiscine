import java.util.*;

/* returns a map of name from the first map associated with a name from the second list.
Each map argument will be composed as follows :
Key: The name of the member to marry
Value: The ordered list of preference containing members (keys) from the other map.
To objective of this function is to determine the best couple possible. */

public class WeddingComplex {
    // group1 and group2: Map of preferences lists
    public static Map<String, String> createBestCouple(Map<String, List<String>> group1, Map<String, List<String>> group2) {
        Map<String, String> group1Pair = new HashMap<>(); // result: group1 member -> group2 member
        Map<String, String> group2Pair = new HashMap<>(); // track current partner of group2 member
        
        Set<String> available = new HashSet<>(group1.keySet()); // group1 members who still need a pair

        // while someone is available in group1
        while (!available.isEmpty()) {
            String g1Member = available.iterator().next(); // pick any available member from group1
            List<String> prefs = group1.get(g1Member);
            for (String g2Member : prefs) { // go through their preferences
                // If g2Member is single, pair them up
                if (!group2Pair.containsKey(g2Member)) {
                    group1Pair.put(g1Member, g2Member);
                    group2Pair.put(g2Member, g1Member);
                    available.remove(g1Member);
                    break;
                } else {
                    // g2Member is matched, check if g2Member prefers g1Member over their current partner
                    String currentPartner = group2Pair.get(g2Member);
                    List<String> g2MemberPrefs = group2.get(g2Member);
                    if (g2MemberPrefs.indexOf(g1Member) < g2MemberPrefs.indexOf(currentPartner)) {
                        // g2Member prefers new proposer g1Member — rematch!
                        group1Pair.put(g1Member, g2Member);
                        group2Pair.put(g2Member, g1Member);
                        available.remove(g1Member);
                        available.add(currentPartner); // old partner becomes available
                        break;
                    }
                    // else: g2Member doesn't want to switch, keep looking
                }
            }
        }
        return group1Pair;
    }
}
