import java.util.*;

public class KeepTheChange {
    // returns the list of coins that compose the change
    // using the smallest possible number of coins
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        int[] minCoins = new int[amount + 1];
        int[] lastCoin = new int[amount + 1];

        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && minCoins[i - coin] != Integer.MAX_VALUE) {
                    if (minCoins[i - coin] + 1 < minCoins[i]) {
                        minCoins[i] = minCoins[i - coin] + 1;
                        lastCoin[i] = coin;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        if (minCoins[amount] == Integer.MAX_VALUE) {
            return result; // no solution
        }
        int curr = amount;
        while (curr > 0) {
            int coin = lastCoin[curr];
            result.add(coin);
            curr -= coin;
        }
        result.sort(Comparator.reverseOrder());
        return result;
    }
}