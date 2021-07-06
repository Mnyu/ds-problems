package _03_sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the largest unique string in the given string
 */
public class _22_LargestUniqueSubString {

    public String longestUniqueString(String s) {
        if (s == null) return "";
        int i = 0;
        int j = 0;
        int winLength = 0;
        int maxWinLength = Integer.MIN_VALUE;
        int maxWinStart = 0;
        int maxWinEnd = 0;

        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                winLength = j - i;
                if (winLength > maxWinLength) {
                    maxWinLength = winLength;
                    maxWinStart = i;
                    maxWinEnd = j - 1;
                }
                while (i < j && set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
            } else {
                set.add(s.charAt(j));
                j++;
            }
        }
        winLength = j - i;
        if (winLength > maxWinLength) {
            maxWinLength = winLength;
            maxWinStart = i;
            maxWinEnd = j - 1;
        }
        return s.substring(maxWinStart, maxWinEnd + 1);
    }

    public static void main(String[] args) {
        _22_LargestUniqueSubString obj = new _22_LargestUniqueSubString();
        System.out.println(obj.longestUniqueString("abcabed"));
        System.out.println(obj.longestUniqueString("prateekbhaiya"));
        System.out.println(obj.longestUniqueString("prateekbhaiyaqwertpu"));
        System.out.println(obj.longestUniqueString("abcaa"));
        System.out.println(obj.longestUniqueString("aaaaa"));
    }

    /**
     * Complexity :
     *  Time : O(2N)
     *  Space : O(N)
     */

}
