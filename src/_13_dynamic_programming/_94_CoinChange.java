package _13_dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Given : Array of coin denominations and integer M.
 * Find minimum coins required to make the change.
 */
public class _94_CoinChange {
    public int minCoins(int[] coins, int sum) {
        if (coins == null || coins.length == 0 || sum < 0) {
            return -1;
        }
        Map<Integer, Integer> sumToCoinsMap = new HashMap<>();
        return minCoins(coins, sum, sumToCoinsMap);
    }

    private int minCoins(int[] coins, int sum, Map<Integer, Integer> sumToCoinsMap) {
        if (sum == 0) return 0;
        if (sumToCoinsMap.get(sum) != null) return sumToCoinsMap.get(sum);
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (sum - coin >= 0) {
                minCoins = Math.min(minCoins, minCoins(coins, sum - coin, sumToCoinsMap));
            }
        }
        if (minCoins != Integer.MAX_VALUE) {
            minCoins = minCoins + 1;
        }
        sumToCoinsMap.put(sum, minCoins);
        return sumToCoinsMap.get(sum);
    }

    public static void main(String[] args) {
        _94_CoinChange obj = new _94_CoinChange();
        System.out.println(obj.minCoins(new int[]{1,3,7,10}, 15));
    }
    // Time Complexity : O(Sum)
    // Space Complexity : O(Sum)
}
