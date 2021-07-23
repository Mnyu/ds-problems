package _11_priority_queues;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _86_MergeKSortedArrays {

    public List<Integer> kWaySorted(int[][] kSortedArrays) {
        List<Integer> result = new ArrayList<>();
        if (kSortedArrays == null || kSortedArrays.length == 0)
            return result;
        int k = kSortedArrays.length;
        Queue<Triplet> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.add(new Triplet(kSortedArrays[i][0], i, 0));
        }
        while (!minHeap.isEmpty()) {
            Triplet triplet = minHeap.remove();
            result.add(triplet.data);
            int row = triplet.row;
            if (triplet.col < kSortedArrays[row].length - 1) {
                int col = triplet.col + 1;
                minHeap.add(new Triplet(kSortedArrays[row][col], row, col));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _86_MergeKSortedArrays obj = new _86_MergeKSortedArrays();
        System.out.println(obj.kWaySorted(new int[][]{{10, 15, 20, 30}, {2, 5, 8, 14, 24}, {0, 11, 60, 90}}));
    }
    // Time Complexity : O(NlogK)
    // Space Complexity : O(K)
}

class Triplet implements Comparable<Triplet> {
    public int data;
    public int row;
    public int col;

    public Triplet(int data, int row, int col) {
        this.data = data;
        this.row = row;
        this.col = col;
    }

    @Override
    public int compareTo(Triplet other) {
        return this.data - other.data;
    }

}