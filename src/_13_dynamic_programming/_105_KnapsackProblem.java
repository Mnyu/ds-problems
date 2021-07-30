package _13_dynamic_programming;

/**
 * Given : weights and prices of N items
 * We need to put a subset of items in a bag of capacity W such that we get the
 * maximum total value in the bag(knapsack)
 * <p>
 * e.g.
 * Input : wts : [2,7,3,4]  prices [5,20,20,10]     W = 11
 * Output : 40
 */
public class _105_KnapsackProblem {

    public int maxValue(int[] weights, int[] prices, int totalWeight) {
        if (weights == null || prices == null || prices.length == 0
                || weights.length != prices.length || totalWeight < 0)
            return -1;
        int[][] cache = new int[weights.length][totalWeight + 1]; // Important step - Always pay attention to the size of the cache.
        return maxValue(weights, prices, 0, totalWeight, cache);
    }

    private int maxValue(int[] weights, int[] prices, int i, int totalWeight, int[][] cache) {
        if (totalWeight == 0 || i == weights.length)
            return 0;
        if (cache[i][totalWeight] > 0)
            return cache[i][totalWeight];

        if (totalWeight - weights[i] < 0) {
            cache[i][totalWeight] = maxValue(weights, prices, i + 1, totalWeight, cache);
        } else {
            cache[i][totalWeight] = Math.max(maxValue(weights, prices, i + 1, totalWeight, cache),
                    prices[i] + maxValue(weights, prices, i + 1, totalWeight - weights[i], cache));
        }
        return cache[i][totalWeight];
    }

    public int maxValueBottomUpDP(int[] weights, int[] prices, int totalWeight) {
        if (weights == null || prices == null || prices.length == 0
                || weights.length != prices.length || totalWeight < 0)
            return -1;
        // Important optimization step - Always pay attention to the size of the cache.
        // Here since the values of current row of cache/dp-array depends only on the values of previous row
        // Hence we either have cache like cache[2][totalWeight + 1]
        // or 2 different arrays prev[totalWeight + 1] and curr[totalWeight + 1] each of length totalWeight + 1.
        int[] prev = new int[totalWeight + 1];

        for (int i = 1; i <= weights.length; i++) {
            int[] curr = new int[totalWeight + 1];
            for (int j = 1; j <= totalWeight; j++) {
                if (j - weights[i - 1] >= 0) {
                    curr[j] = Math.max(prices[i - 1] + prev[j - weights[i - 1]], prev[j]);
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[totalWeight];
    }

    public static void main(String[] args) {
        _105_KnapsackProblem obj = new _105_KnapsackProblem();
        System.out.println(obj.maxValue(new int[]{2, 7, 3, 4}, new int[]{5, 20, 20, 10}, 11));
        System.out.println(obj.maxValueBottomUpDP(new int[]{2, 7, 3, 4}, new int[]{5, 20, 20, 10}, 11));
    }
    // Complexity TopDownDP : Time : O(NW), Space O(NW)
    // Complexity BottomUpDP : Time : O(NW), Space O(W) -> [IMPORTANT - see comments above]
}
