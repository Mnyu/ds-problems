package _04_sorting_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given : List of n strings
 * Concatenate them such that the resultant string is lexicographically smallest.
 */
public class _29_SmallestString {

    public String smallestLexicoString(List<String> strings) {
        Comparator<String> customComp = (o1, o2) -> (o1 + o2).compareTo(o2 + o1);
        strings.sort(customComp);
        return String.join("", strings);
    }

    public static void main(String[] args) {
        _29_SmallestString obj = new _29_SmallestString();
        System.out.println(obj.smallestLexicoString(Arrays.asList("a","ab","aba")));
    }
}
