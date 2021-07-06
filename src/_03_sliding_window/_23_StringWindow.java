package _03_sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given 2 strings - big & small
 * Find the smallest window/substring in the big string that contains
 * all characters of the small string.
 * <p>
 * Also,
 * - window can have additional chars than required
 * - if small string has duplicates then those duplicates ust be present with same/higher count in window
 */
public class _23_StringWindow {


    public String shortestStringWindow(String big, String small) {

        if (big == null || small == null) return "";

        int totalDistinctKeys = 0;
        int totalChars = small.length();
        Map<Character, Integer> smallStringMap = new HashMap<>();

        for (int i = 0; i < small.length(); i++) {
            char c = small.charAt(i);
            if (!smallStringMap.containsKey(c)) {
                totalDistinctKeys++;
            }
            smallStringMap.put(c, smallStringMap.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int distinctKeys = 0;
        int count = 0;
        Map<Character, Integer> bigStringMap = new HashMap<>();

        int length = 0;
        int minLength = Integer.MAX_VALUE;
        int minWinStart = 0;
        int minWinEnd = 0;

        while (j < big.length()) {
            char ch = big.charAt(j);
            if (distinctKeys == totalDistinctKeys && count >= totalChars) {
                while (i < j && distinctKeys == totalDistinctKeys && count >= totalChars) {
                    char c = big.charAt(i);
                    if (bigStringMap.containsKey(c) && bigStringMap.get(c) == 1) {
                        bigStringMap.remove(c);
                        distinctKeys--;
                        count--;
                    } else if (bigStringMap.containsKey(c)) {
                        bigStringMap.put(c, bigStringMap.get(c) - 1);
                        count--;
                    }
                    i++;
                }
                length = j - i + 1;
                if (length < minLength) {
                    minLength = length;
                    minWinStart = i - 1;
                    minWinEnd = j - 1;
                }
            } else {
                if (smallStringMap.containsKey(ch)) {
                    if (!bigStringMap.containsKey(ch)) {
                        distinctKeys++;
                    }
                    bigStringMap.put(ch, bigStringMap.getOrDefault(ch, 0) + 1);
                    count++;

                }
                j++;
            }

        }
        return big.substring(minWinStart, minWinEnd + 1);
    }

    public static void main(String[] args) {
        _23_StringWindow obj = new _23_StringWindow();
        System.out.println(obj.shortestStringWindow("hello_world", "lol"));
        System.out.println(obj.shortestStringWindow("fizzbuzz", "fuzz"));
        System.out.println(obj.shortestStringWindow("fizzzbuzz", "fuzz"));
        System.out.println(obj.shortestStringWindow("fizfzbuzz", "fuzz"));
    }

}
