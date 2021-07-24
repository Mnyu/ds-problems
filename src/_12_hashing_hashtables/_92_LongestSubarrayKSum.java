package _12_hashing_hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * Given : an array and target sum K
 * Find the length of longest subarray whose sum == K
 */
public class _92_LongestSubarrayKSum {
    public int longestSubarrayLength(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return -1;

        Map<Integer, Integer> cummSumToIndex = new HashMap<>();
        int cummSum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            cummSum = cummSum + arr[i];
            if (!cummSumToIndex.containsKey(cummSum)) {
                cummSumToIndex.put(cummSum, i);
            }
            if (cummSumToIndex.containsKey(cummSum - k)) {
                maxLength = Math.max(maxLength, i - cummSumToIndex.get(cummSum - k));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        _92_LongestSubarrayKSum obj = new _92_LongestSubarrayKSum();
        System.out.println(obj.longestSubarrayLength(new int[]{0, -2, 1, 2, 3, 4, 5, 6, 15, 10, 5}, 15));
        System.out.println(obj.longestSubarrayLength(new int[]{0, -2, 1, 2, 3, 4, 51, 6, 15, 10, 5}, 15));
        System.out.println(obj.longestSubarrayLength(new int[]{0, -2, 1, 2, 3, 4, 51, 6, 15, 101, 5}, 15));
        System.out.println(obj.longestSubarrayLength(new int[]{0, -2, 1, 2, 3, 4, 51, 6, 151, 101, 5}, 15));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)
}
