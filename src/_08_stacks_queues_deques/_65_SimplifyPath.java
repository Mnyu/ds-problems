package _08_stacks_queues_deques;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given : String representing valid UNIX path
 * Simplify it
 */
public class _65_SimplifyPath {

    public String simplifiedPath(String path) {
        if (path == null) return null;
        String[] tokens = path.split("/");
        List<String> filteredTokens = new ArrayList<>();
        for (String s : tokens) {
            if (!"".equals(s) && !".".equals(s)) {
                filteredTokens.add(s);
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        if (path.charAt(0) == '/') {
            // Absolute path
            stack.addFirst("");
        }
        for (String token : filteredTokens) {
            if ("..".equals(token)) {
                if (!stack.isEmpty() && "..".equals(stack.getFirst())) {
                    // This will happen in relative path
                    stack.addFirst(token);
                } else if (!stack.isEmpty() && !"".equals(stack.getFirst())) {
                    stack.removeFirst();
                }
            } else {
                stack.addFirst(token);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast()).append("/");
        }
        return sb.length() > 1 ? sb.substring(0, sb.length() - 1) : sb.toString();
    }

    public static void main(String[] args) {
        _65_SimplifyPath obj = new _65_SimplifyPath();
        System.out.println(obj.simplifiedPath("/../x/y/../z/././w/a///../../c/./"));
        System.out.println(obj.simplifiedPath("/a/./b/../../c"));
        System.out.println(obj.simplifiedPath("/a/.."));
        System.out.println(obj.simplifiedPath("/a///b"));
        System.out.println(obj.simplifiedPath("/a/../"));
        System.out.println(obj.simplifiedPath("/../../../../../a"));
        System.out.println(obj.simplifiedPath("/a/./b/./c/./d/"));
        System.out.println(obj.simplifiedPath("/a/../../../../."));
    }

    // The important step here is tokenization.
    // Then we just have to make sure to cover for all cases.
    // Time Complexity : O(N)
    // Space Complexity : O(N) - [stack]
}
