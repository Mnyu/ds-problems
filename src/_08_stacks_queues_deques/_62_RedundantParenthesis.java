package _08_stacks_queues_deques;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given : An expression string with balanced parenthesis.
 * Find if it contains redundant parenthesis or not.
 * <p>
 * A set of parenthesis is redundant if same sub-expression is surrounded by unnecessary
 * or multiple brackets.
 */
public class _62_RedundantParenthesis {
    public boolean isRedundant(String exp) {
        if (exp == null) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : exp.toCharArray()) {
            if (c == ')') {
                boolean isOperatorPresent = false;
                while(!stack.isEmpty() && stack.peek() != '('){
                    if (isOperator(stack.pop())) {
                        isOperatorPresent = true;
                    }
                }
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                if (!isOperatorPresent) {
                    return true;
                }
            } else {
                stack.push(c);
            }
        }
        return false;
    }
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) {
        _62_RedundantParenthesis obj = new _62_RedundantParenthesis();
        System.out.println(obj.isRedundant(""));
        System.out.println(obj.isRedundant("((a+b))"));
        System.out.println(obj.isRedundant("(a+(b)+c)"));
        System.out.println(obj.isRedundant("(a+b * (c-d))"));
    }
    // Time Complexity : O(2N) ~ O(N)
    // Space Complexity : O(N)
}
