package _11_priority_queues;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given : Running stream of integers
 * Write a function to output median of numbers after every input
 */
public class _85_RunningMedian {
    public float[] medians(int[] arr) {
        if (arr == null) {
            return null;
        }
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        float[] medians = new float[arr.length];
        float currMedian = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < currMedian) {
                // Put in max heap
                if (maxHeap.size() > minHeap.size()) {
                    balanceHeaps(maxHeap, minHeap);
                }
                maxHeap.add(arr[i]);
            } else {
                // Put in min heap
                if (minHeap.size() > maxHeap.size()) {
                    balanceHeaps(minHeap, maxHeap);
                }
                minHeap.add(arr[i]);
            }
            if (minHeap.size() == maxHeap.size()) {
                currMedian = (minHeap.element() + maxHeap.element()) / 2.0f;
            } else if (minHeap.size() > maxHeap.size()) {
                currMedian = minHeap.element();
            } else {
                currMedian = maxHeap.element();
            }
            medians[i] = currMedian;
        }
        return medians;
    }

    private void balanceHeaps(Queue<Integer> heap1, Queue<Integer> heap2) {
        heap2.add(heap1.remove());
    }

    public static void main(String[] args) {
        _85_RunningMedian obj = new _85_RunningMedian();
        System.out.println(Arrays.toString(obj.medians(new int[] {10,5,2,3,0,12,18,20,22})));
    }
    // Time Complexity : O(NlogN)
    // Space Complexity : O(N) - 2 heaps combined store N elements
}
