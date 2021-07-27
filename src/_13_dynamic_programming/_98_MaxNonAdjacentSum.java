package _13_dynamic_programming;

/**
 * Given : array of positive integers
 * Find the max sum of non adjacent elements in array.
 */
public class _98_MaxNonAdjacentSum {
    public int maxNonAdjacentSum(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        if(nums.length == 1)
            return Math.max(nums[0], 0);
        int prevToPrev = nums[0];
        int prev = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            int val = Math.max(prev, nums[i] + prevToPrev);
            prevToPrev = prev;
            prev = val;
        }
        return prev;
    }

    public static void main(String[] args) {
        _98_MaxNonAdjacentSum obj = new _98_MaxNonAdjacentSum();
        System.out.println(obj.maxNonAdjacentSum(new int[]{6, 10, 12, 7, 9, 14}));
    }
    // Bottom Up DP approach used and space optimized by not using the complete dp/cache array just previous 2 values.
    // Time Complexity : O(N)
    // Space Complexity : O(1)
}
