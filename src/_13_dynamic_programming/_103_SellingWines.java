package _13_dynamic_programming;

import java.util.Arrays;

/**
 * There is a collections of N wines placed linearly on a shelf. The price of ith wine is p[i].
 * Since wines get better every year, suppose today is the year 1, on the year y the price of the wine will be y * p[i].
 * <p>
 * We want to sell all the wines we have, but exactly 1 wine per year starting this year.
 * Another constraint is : Each year we can sell either the leftmost or rightmost wine without re-ordering.
 * <p>
 * Find the maximum profit we can get if we sell all the wines in optimal order.
 */
public class _103_SellingWines {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1)
            return -1;
        int[][] cache = new int[prices.length][prices.length];
        return maxProfit(prices, 1, 0, prices.length - 1, cache);
    }

    private int maxProfit(int[] prices, int year, int start, int end, int[][] cache) {
        if (start > end)
            return 0;
        if (cache[start][end] > 0)
            return cache[start][end];

        int startTaken = year * prices[start] + maxProfit(prices, year + 1, start + 1, end, cache);
        int endTaken = year * prices[end] + maxProfit(prices, year + 1, start, end - 1, cache);
        cache[start][end] = Math.max(startTaken, endTaken);
        return cache[start][end];
    }

    public int maxProfitBottomUpDP(int[] prices) {
        if (prices == null || prices.length == 1)
            return -1;
        int[][] cache = new int[prices.length][prices.length];
        for (int row = prices.length - 1; row >= 0; row--) {
            for (int col = 0; col < prices.length; col++) {
                int noOfYears = prices.length - (col - row);
                if (row == col) {
                    cache[row][row] = noOfYears * prices[row];
                } else if (row < col) {
                    int leftTaken = noOfYears * prices[row] + cache[row + 1][col];
                    int rightTaken = noOfYears * prices[col] + cache[row][col - 1];
                    cache[row][col] = Math.max(leftTaken, rightTaken);
                }
            }
        }
        for (int[] arr : cache) {
            System.out.println(Arrays.toString(arr));
        }
        return cache[0][prices.length - 1];
    }

    public static void main(String[] args) {
        _103_SellingWines obj = new _103_SellingWines();
        System.out.println(obj.maxProfit(new int[]{2, 3, 5, 1, 4}));
        System.out.println(obj.maxProfitBottomUpDP(new int[]{2, 3, 5, 1, 4}));
    }
    // Time Complexity : O(N^2)
    // Space Complexity : O(N^2)

    // TopDownDP : The key here is to identify that the 2 variables to be taken for DP array formulation is start and end index of array.
    //              Year is simply a multiplication factor, should not taken for DP array formulation.
    // BottomUpDP : Formulating Bottom Up approach is hard for this problem. It has to be well thought through.
}
