package _06_recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method to generate all possible N pairs of balanced parentheses ( and )
 * Input : 2
 * Output :
 * [()(), (())]
 */
public class _45_GeneratingBrackets {
    public List<String> generateParentheses(int num) {
        List<String> result = new ArrayList<>();
        if (num > 1) {
            generateParentheses(num, num, new StringBuilder(), result);
        }
        return result;
    }

    private void generateParentheses(int leftRemaining, int rightRemaining, StringBuilder sb, List<String> result) {
        if (leftRemaining == 0 && rightRemaining == 0) {
            result.add(sb.toString());
            return;
        }
        if (leftRemaining == rightRemaining) {
            generateParentheses(leftRemaining - 1, rightRemaining, sb.append("("), result);
            sb.deleteCharAt(sb.length() - 1);
        } else if (leftRemaining < rightRemaining) {
            if (leftRemaining > 0) {
                generateParentheses(leftRemaining - 1, rightRemaining, sb.append("("), result);
                sb.deleteCharAt(sb.length() - 1);
            }
            generateParentheses(leftRemaining, rightRemaining - 1, sb.append(")"), result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        _45_GeneratingBrackets obj = new _45_GeneratingBrackets();
        System.out.println(obj.generateParentheses(2));
        System.out.println(obj.generateParentheses(3));
    }
    // Time Complexity : O(2^N)
    // Space Complexity : O(N)
}
