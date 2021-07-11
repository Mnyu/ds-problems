package _06_recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given : String s
 * Find all subsets/subsequences of the string
 */
public class _43_StringSubSequences {
    public List<String> allSubSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s != null) {
            collectSubSeq(s, 0, new StringBuilder(), result);
        }
        return result;
    }

    private void collectSubSeq(String s, int index, StringBuilder sb, List<String> result) {
        if (index == s.length()) {
            result.add(sb.toString());
            return;
        }
        collectSubSeq(s, index + 1, sb.append(s.charAt(index)), result);
        sb.deleteCharAt(sb.length() - 1);
        collectSubSeq(s, index + 1, sb, result);
    }

    public static void main(String[] args) {
        _43_StringSubSequences obj = new _43_StringSubSequences();
        System.out.println(obj.allSubSequences("abc"));
    }
    // This is a brute force approach using recursion.
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
    // This approach may be required in other problems along with other concepts.
}
