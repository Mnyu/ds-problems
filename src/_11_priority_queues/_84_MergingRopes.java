package _11_priority_queues;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given : N ropes, each having a different size.
 * Task : Join the ropes together at minimum total cost
 * The cost of joining 2 ropes of size X and Y = X + Y
 * <p>
 * Ropes - [4,3,2,6]
 * Output - 29
 */
public class _84_MergingRopes {
    public int minCostOfMergingRopes(int[] ropeSizes) {
        if (ropeSizes == null || ropeSizes.length == 0)
            return -1;
        Queue<Integer> heap = new PriorityQueue<>();
        for (int size : ropeSizes) {
            heap.add(size);
        }
        int minCost = 0;
        while (heap.size() > 1) {
            int a = heap.remove();
            int b = heap.remove();
            minCost = minCost + a + b;
            heap.add(a + b);
        }
        return minCost;
    }

    public static void main(String[] args) {
        _84_MergingRopes obj = new _84_MergingRopes();
        System.out.println(obj.minCostOfMergingRopes(null));
        System.out.println(obj.minCostOfMergingRopes(new int[]{1}));
        System.out.println(obj.minCostOfMergingRopes(new int[]{4, 3, 2, 6}));
    }
    // Time Complexity : O(NlogN)
    // Space Complexity : O(N)
}
