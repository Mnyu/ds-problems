package _13_dynamic_programming;

import java.util.Arrays;

/**
 * Given 2 strings
 * Find the length of the longest subsequence which is common to both of them
 */
public class _102_LowestCommonSubSequence {
    public int lcsTopDownDP(String a, String b) {
        if (a == null || b == null)
            return -1;
        int[][] cache = new int[a.length()][b.length()];
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
        return lcsTopDownDP(a, b, 0, 0, cache);
    }

    private int lcsTopDownDP(String a, String b, int i, int j, int[][] cache) {
        if (i == a.length() || j == b.length())
            return 0;
        if (cache[i][j] != -1)
            return cache[i][j];
        if (a.charAt(i) == b.charAt(j))
            cache[i][j] = 1 + lcsTopDownDP(a, b, i + 1, j + 1, cache);
        else {
            cache[i][j] = Math.max(lcsTopDownDP(a, b, i + 1, j, cache), lcsTopDownDP(a, b, i, j + 1, cache));
        }
        return cache[i][j];
    }

    public int lcsBottomUpDP(String a, String b) {
        if (a == null || b == null) return -1;

        int[][] cache = new int[a.length() + 1][b.length() + 1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cache[i][j] = 1 + cache[i - 1][j - 1];
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                }
            }
        }
        return cache[a.length()][b.length()];
    }

    public static void main(String[] args) {
        _102_LowestCommonSubSequence obj = new _102_LowestCommonSubSequence();
        System.out.println(obj.lcsTopDownDP("ABCD", "ABEDG"));
        System.out.println(obj.lcsBottomUpDP("ABCD", "ABEDG"));
    }
    // Time Complexity : O(N^2)
    // Space Complexity : O(N^2)
}
