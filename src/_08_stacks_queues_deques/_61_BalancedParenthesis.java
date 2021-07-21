package _08_stacks_queues_deques;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given : An expression string
 * Check all the pairs of parenthesis are valid or not
 */
public class _61_BalancedParenthesis {

    public boolean isBalanced(String exp) {
        if (exp == null)
            return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : exp.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                default:
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _61_BalancedParenthesis obj = new _61_BalancedParenthesis();
        System.out.println(obj.isBalanced(""));
        System.out.println(obj.isBalanced("((a+b+c) + [d])"));
        System.out.println(obj.isBalanced("{ a+(b+c) + ([d+e] * f)) } + k"));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N) [for stack]
}
