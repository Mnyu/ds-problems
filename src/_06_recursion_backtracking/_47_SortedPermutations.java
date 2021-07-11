package _06_recursion_backtracking;

import java.util.Set;
import java.util.TreeSet;

/**
 * Given  : a string S of lowercase alphabets,
 * Find all 'unique' permutations of the string in a 'sorted' order.
 */
public class _47_SortedPermutations {
    public Set<String> sortedPermutations(String s) {
        Set<String> result = new TreeSet<>();
        if (s == null || "".equals(s))
            return result;
        collectPermutations(s.toCharArray(),0,new StringBuilder(), result);
        return result;
    }
    private void collectPermutations(char[] a, int startIndex, StringBuilder sb, Set<String> result) {
        if (startIndex == a.length) {
            result.add(sb.toString());
            return;
        }
        for (int i = startIndex; i < a.length; i++) {
            swap(a, startIndex, i);
            collectPermutations(a, startIndex + 1, sb.append(a[startIndex]), result);
            sb.deleteCharAt(sb.length() - 1);
            // THIS IS THE IMPORTANT BACK-TRACKING STEP
            swap(a, startIndex, i);
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        _47_SortedPermutations obj = new _47_SortedPermutations();
        System.out.println(obj.sortedPermutations("abc"));
        System.out.println(obj.sortedPermutations("abdc"));
        System.out.println(obj.sortedPermutations("abac"));
    }
    // Time Complexity : O(n!) + O(n!log(n!)) [Sorting/TreeSet] ~ O(n!log(n!))
    // Space Complexity : O(n)
}
