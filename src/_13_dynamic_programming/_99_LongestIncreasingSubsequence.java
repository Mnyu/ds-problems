package _13_dynamic_programming;

/**
 * Given : array sequence
 * Find the length of the longest subsequence such that all elements of the subsequence are in ascending order.
 */
public class _99_LongestIncreasingSubsequence {
    public int longestIncreasingSubSequence(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        return longestIncreasingSubSequence(arr, 0, new int[arr.length]);
    }

    private int longestIncreasingSubSequence(int[] arr, int index, int[] cache) {
        if (index == arr.length - 1) {
            cache[index] = 1;
            return cache[index];
        }
        if (cache[index] > 0)
            return cache[index];
        int longestLength = 0;
        for (int i = index; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    cache[i] = Math.max(cache[i], 1 + longestIncreasingSubSequence(arr, j, cache));
                }
            }
            longestLength = Math.max(longestLength, cache[i]);
        }
        return longestLength;
    }

    public int lisBottomUpDP(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int[] cache = new int[arr.length];
        int longest = 0;
        for (int i = 0; i < arr.length; i++) {
            int maxLength = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    maxLength = Math.max(maxLength, 1 + cache[j]);
                }
            }
            cache[i] = maxLength > 0 ? maxLength : 1;
            longest = Math.max(longest, cache[i]);
        }
        return longest;
    }

    public static void main(String[] args) {
        _99_LongestIncreasingSubsequence obj = new _99_LongestIncreasingSubsequence();
        System.out.println(obj.longestIncreasingSubSequence(new int[]{8, 30, 100}));
        System.out.println(obj.lisBottomUpDP(new int[]{8, 30, 100}));
        System.out.println(obj.longestIncreasingSubSequence(new int[]{50, 4, 10, 8, 30, 100}));
        System.out.println(obj.lisBottomUpDP(new int[]{50, 4, 10, 8, 30, 100}));
        System.out.println(obj.longestIncreasingSubSequence(new int[]{50, 4, 10, 8, 9, 30, 11, 100}));
        System.out.println(obj.lisBottomUpDP(new int[]{50, 4, 10, 8, 9, 30, 11, 100}));
        System.out.println(obj.longestIncreasingSubSequence(new int[]{8}));
        System.out.println(obj.lisBottomUpDP(new int[]{8}));
    }
    // Time Complexity : O(N^2) [Both top down and bottom up]
    // Space Complexity : O(N) - [less in bottom up]
}
