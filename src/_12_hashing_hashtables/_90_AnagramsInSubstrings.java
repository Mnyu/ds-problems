package _12_hashing_hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2 Strings are Anagrams of each other if the letters of one string can be
 * re-arranged to form the other string.
 * <p>
 * Given : a string
 * Find the number of pairs of substrings of the string that
 * are anagrams of each other.
 */
public class _90_AnagramsInSubstrings {
    public int noOfAnagramsinSubStrings(String s) {
        if (s == null)
            return -1;
        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String a = s.substring(i, j + 1);
                char[] arr = a.toCharArray();
                Arrays.sort(arr); // Bottleneck - increasing complexity
                freqMap.put(String.valueOf(arr), freqMap.getOrDefault(String.valueOf(arr), 0) + 1);
            }
        }
        int count = 0;
        for (String key : freqMap.keySet()) {
            int value = freqMap.get(key);
            if (value > 1) {
                count = count + (value * (value - 1)) / 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _90_AnagramsInSubstrings obj = new _90_AnagramsInSubstrings();
        System.out.println(obj.noOfAnagramsinSubStrings("abba"));
        System.out.println(obj.noOfAnagramsinSubStrings("abcd"));
    }
    // Time Complexity : O(N * N * NlogN) ~ O(N^3LogN) --- should be made O(N^3)
    // Space Complexity : O(N)
}
