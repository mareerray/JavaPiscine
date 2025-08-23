import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class MapInventory {
    public static int getProductPrice(Map<String, Integer> inventory, String productId) {
        if (inventory == null || productId == null) return -1;
        Integer price = inventory.get(productId);
        if (price == null) return -1;
        return price;
    }

    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
        // Make a new empty list
        List<String> productIdList = new ArrayList<>();

        if (inventory == null) return productIdList;

        // Loop through the map's entries and check which product have the givem price
        for (String productId : inventory.keySet()) {
            if ( inventory.get(productId) != null && price == inventory.get(productId)) {
                productIdList.add(productId);
            }
        }
        Collections.sort(productIdList); // Sort the list ascendingly
        return productIdList;
    }

    // For large maps, entrySet() is slightly faster
    /* public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
        List<String> productIdList = new ArrayList<>();

        if (inventory == null) return productIdList; // return an empty list if inventory is missing

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() != null && entry.getValue() == price) {
                productIdList.add(entry.getKey());
            }
        }

        return productIdList; // will be empty if no matches
    } */
}