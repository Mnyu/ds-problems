package _13_dynamic_programming;

import java.util.Arrays;

/**
 * Given : 2 Strings
 * Find the number of times the 2nd string occurs as a sub-sequence in the 1st string.
 * <p>
 * Eg Input :
 * s1 = "ABCDCE"
 * s2 = "ABC"
 * Output : 2
 */
public class _104_SubSequenceCount {
    public int count(String big, String small) {
        if (big == null || small == null)
            return -1;
        int[][] cache = new int[big.length()][small.length()];
        int result = count(big, small, 0, 0, cache);
//        System.out.println("****************");
//        for (int[] a : cache) {
//            System.out.println(Arrays.toString(a));
//        }
        return result;
    }

    private int count(String big, String small, int i, int j, int[][] cache) {
        if (j == small.length())
            return 1;
        if (i == big.length())
            return 0;
        if (cache[i][j] > 0)
            return cache[i][j];
        int count = 0;
        if (big.charAt(i) == small.charAt(j)) {
            count = count + count(big, small, i + 1, j + 1, cache);
        }
        count = count + count(big, small, i + 1, j, cache);

        cache[i][j] = count;
        return cache[i][j];
    }

    public int countBottomUpDP(String big, String small) {
        if (big == null || small == null)
            return -1;
        int[][] cache = new int[big.length() + 1][small.length() + 1]; // IMPORTANT STEP FOR BOTTOM UP

        for (int i = 0; i <= big.length(); i++) {
            // If smaller string is "", 1 subsequence i.e. "" will occur in bigger string.
            cache[i][0] = 1;
        }
        for (int i = 1; i <= big.length(); i++) {
            for (int j = 1; j <= small.length(); j++) {
                cache[i][j] = cache[i - 1][j];
                if (big.charAt(i - 1) == small.charAt(j - 1)) {
                    cache[i][j] = cache[i][j] + cache[i - 1][j - 1];
                }
            }
        }
        return cache[big.length()][small.length()];
    }

    public static void main(String[] args) {
        _104_SubSequenceCount obj = new _104_SubSequenceCount();
        System.out.println(obj.count("ABCDCE", "ABC"));
        System.out.println(obj.countBottomUpDP("ABCDCE", "ABC"));
        System.out.println(obj.count("ABBCECDGCC", "ABC"));
        System.out.println(obj.countBottomUpDP("ABBCECDGCC", "ABC"));
        System.out.println(obj.count("ABADBCDCE", "ABC"));
        System.out.println(obj.countBottomUpDP("ABADBCDCE", "ABC"));
        System.out.println(obj.count("ABCDCE", ""));
        System.out.println(obj.countBottomUpDP("ABCDCE", ""));
        System.out.println(obj.count("", "ABC"));
        System.out.println(obj.countBottomUpDP("", "ABC"));
    }
    // Time Complexity : O(N^2)
    // Space Complexity : O(N^2)
}
