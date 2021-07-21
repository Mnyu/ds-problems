package _08_stacks_queues_deques;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a running stream of characters
 * Find the first non repeating character
 */
public class _63_FirstNonRepeatingLetter {
    public char[] firstNonRepeatingLetter(String s) {
        if (s == null) return null;
        Map<Character, Integer> freqMap = new HashMap<>();
        Deque<Character> queue = new ArrayDeque<>();
        char[] result = new char[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            if (freqMap.get(c) == null) {
                freqMap.put(c, 1);
                queue.offer(c);
            } else {
                freqMap.put(c, freqMap.get(c) + 1);
            }
            while (!queue.isEmpty() && freqMap.get(queue.element()) > 1) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                result[i] = '0';
            } else {
                result[i] = queue.element();
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        _63_FirstNonRepeatingLetter obj = new _63_FirstNonRepeatingLetter();
        System.out.println(Arrays.toString(obj.firstNonRepeatingLetter("")));
        System.out.println(Arrays.toString(obj.firstNonRepeatingLetter("aabcbcd")));
        System.out.println(Arrays.toString(obj.firstNonRepeatingLetter("aaabbcdbbaac")));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N) [Map and Queue]
}
