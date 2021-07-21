package _08_stacks_queues_deques;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given price of a stock over next n days, your task is to calculate span of stock’s price for all n days.
 * <p>
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today
 * and going backwards) for which the price of the stock was less than or equal to today's price.
 * <p>
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85],
 * then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 */
public class _66_StockSpanProblem {
    public List<Integer> getSpans(int[] prices) {
        if (prices == null) return null;
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> spans = new ArrayList<>();
        spans.add(1);
        stack.push(0);
        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] >= prices[stack.getFirst()]) {
                stack.removeFirst();
            }
            int prevHighestIndex = stack.isEmpty() ? -1 : stack.getFirst();
            spans.add(i - prevHighestIndex);
            stack.push(i);
        }
        return spans;
    }

    public static void main(String[] args) {
        _66_StockSpanProblem obj = new _66_StockSpanProblem();
        System.out.println(obj.getSpans(new int[]{100, 80, 60, 70, 60, 75, 85}));
    }
    // The important thing here is the observation about popping non-useful elements.
    // Time Complexity : O(2N) [each element pushed once and popped once] ~ O(N)
    // Space Complexity : O(N) [stack]
}
