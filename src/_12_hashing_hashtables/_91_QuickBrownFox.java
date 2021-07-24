package _12_hashing_hashtables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given : a string without spaces and a list of words.
 * Write a function that finds the minimum bars/partition to be added to the string,
 * so that all resulting words after placing the bars are found in the given list.
 * <p>
 * Input :
 * s = "thequickbrownfox"
 * list = ["the", "quickbrown", "fox", "quick", "brown"]
 * <p>
 * Output : 2
 * after placing 2 bars s = "the|quickbrown|fox"
 * thw words the, quickbrown and fox are all present in the list
 * and 2 the minimum.
 */
public class _91_QuickBrownFox {
    public int minimumBarsBruteForce(String s, Set<String> set) {
        if (s == null || set == null || set.size() == 0)
            return -1;
        int val = minimumBarsBruteForce(s, set, 0, 0);
        return val != Integer.MAX_VALUE ? val : -1;
    }

    private int minimumBarsBruteForce(String s, Set<String> set, int start, int i) {
        if (i == s.length() - 1) {
            if (set.contains(s.substring(start, i + 1))) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if (set.contains(s.substring(start, i + 1))) {
            return Math.min(1 + minimumBarsBruteForce(s, set, i + 1, i + 1),
                    minimumBarsBruteForce(s, set, start, i + 1));
        }
        return minimumBarsBruteForce(s, set, start, i + 1);
    }

    public static void main(String[] args) {
        _91_QuickBrownFox obj = new _91_QuickBrownFox();
        System.out.println(obj.minimumBarsBruteForce("thequickbrownfoxjumpsoverthehighbridge",
                new HashSet<>(Arrays.asList("the", "fox", "thequickbrownfox", "jumps", "lazy", "lazyfox",
                        "highbridge", "the", "over", "bridge", "high", "tall", "quick", "brown"))
        ));
        System.out.println(obj.minimumBarsBruteForce("thequickbrownfox",
                new HashSet<>(Arrays.asList("the", "fox", "quickbrown", "quick", "brown"))
        ));
        System.out.println(obj.minimumBarsBruteForce("thequickbrownfox",
                new HashSet<>(Arrays.asList("the1", "fox1", "quickbrown1", "quick1", "brown1"))
        ));
    }
    // The above solution can be improved using DP as there are overlapping sub-problems.
}
