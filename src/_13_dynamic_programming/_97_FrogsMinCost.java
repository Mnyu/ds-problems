package _13_dynamic_programming;

public class _97_FrogsMinCost {
    public int minCost(int[] stones) {
        if (stones == null || stones.length == 0)
            return -1;
        int[] cache = new int[stones.length];
        return minCost(stones, 0, cache);
    }

    private int minCost(int[] stones, int index, int[] cache) {
        if (index == stones.length - 1)
            return 0;
        if (cache[index] > 0)
            return cache[index];

        int cost1 = Integer.MAX_VALUE;
        int cost2 = Integer.MAX_VALUE;

        if (index + 1 < stones.length) {
            cost1 = Math.abs(stones[index] - stones[index + 1]) + minCost(stones, index + 1, cache);
        }
        if (index + 2 < stones.length) {
            cost2 = Math.abs(stones[index] - stones[index + 2]) + minCost(stones, index + 2, cache);
        }
        cache[index] = Math.min(cost1, cost2);
        return cache[index];
    }

    public static void main(String[] args) {
        _97_FrogsMinCost obj = new _97_FrogsMinCost();
        System.out.println(obj.minCost(new int[]{10, 10}));
        System.out.println(obj.minCost(new int[]{30, 10, 60, 10, 60, 50}));
        System.out.println(obj.minCost(new int[]{10, 30, 40, 20}));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Bottom Up DP approach can save recursion stack space as well.
}
