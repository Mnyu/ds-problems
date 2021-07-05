package _02_strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Print all subsequences of a string sorted by length first
 * and then by lexicographic order.
 */
public class _15_SortedSubSequences {

    public List<String> sortedSubSeq(String string) {
        List<String> result = new ArrayList<>();
        if (string == null) return result;
        collectSubSeq(string, 0, result, new StringBuilder());
        Comparator<String> customComp = (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
        result.sort(customComp);
        return result;
    }

    private void collectSubSeq(String string, int currIndex, List<String> result, StringBuilder sb) {
        if (currIndex == string.length()) {
            result.add(sb.toString());
            return;
        }
        collectSubSeq(string, currIndex + 1, result, sb.append(string.charAt(currIndex)));
        sb.deleteCharAt(sb.length()-1);
        collectSubSeq(string, currIndex + 1, result, sb);
    }

    public static void main(String[] args) {
        _15_SortedSubSequences obj = new _15_SortedSubSequences();
        System.out.println(obj.sortedSubSeq("abcd"));
        System.out.println(obj.sortedSubSeq("bdca"));

    }
}
