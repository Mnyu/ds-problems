package _13_dynamic_programming;

public class _95_CuttingRods {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return -1;
        int[] cache = new int[prices.length];
        return maxProfit(prices, prices.length, cache);
    }

    private int maxProfit(int[] prices, int length, int[] cache) {
        if (length <= 0)
            return 0;
        if (cache[length - 1] > 0)
            return cache[length - 1];
        int maxProfit = 0;
        for (int i = 1; i <= length; i++) {
            maxProfit = Math.max(maxProfit, prices[i - 1] + maxProfit(prices, length - i, cache));
        }
        cache[length - 1] = maxProfit;
        return cache[length - 1];
    }
    // Time Complexity : O(N^2)
    // Space Complexity : O(N)

    public int maxProfitBottomUp(int[] prices) {
        if (prices == null || prices.length == 0)
            return -1;
        int[] cache = new int[prices.length + 1];
        cache[0] = 0;
        cache[1] = prices[0];
        for (int i = 2; i <= prices.length; i++) {
            for (int j = i; j > 0; j--) {
                cache[i] = Math.max(cache[i], prices[j - 1] + cache[i - j]);
            }
        }
        return cache[prices.length];
    }
    // Time Complexity : O(N^2)
    // Space Complexity : O(N)

    public static void main(String[] args) {
        _95_CuttingRods obj = new _95_CuttingRods();
        System.out.println(obj.maxProfit(new int[]{1, 5, 8, 9}));
        System.out.println(obj.maxProfitBottomUp(new int[]{1, 5, 8, 9}));
        System.out.println(obj.maxProfit(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
        System.out.println(obj.maxProfitBottomUp(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
        System.out.println(obj.maxProfit(new int[]{3, 5, 8, 9, 10, 17, 17, 20}));
        System.out.println(obj.maxProfitBottomUp(new int[]{3, 5, 8, 9, 10, 17, 17, 20}));
    }
}
