package _13_dynamic_programming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given : array of boxes. Each box is represented using 3 integers denoting width, depth and height of the box
 * Stack up the boxes and maximize the total height of the stack
 * <p>
 * A box must have strictly smaller width, depth and height than any other box below it.
 */
public class _100_BoxStacking {
    public int maxHeightBoxStacking(int[][] boxes) {
        if (boxes == null || boxes.length == 0)
            return -1;

        // Sorting of boxes based on height
        Arrays.sort(boxes, Comparator.comparingInt(box -> box[2]));

        int[] height = new int[boxes.length];
        height[0] = boxes[0][2];
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 1; i < boxes.length; i++) {
            int currHeight = boxes[i][2];
            for (int j = 0; j < i; j++) {
                if (boxes[j][0] < boxes[i][0] && boxes[j][1] < boxes[i][1] && boxes[j][2] < boxes[i][2]) {
                    currHeight = Math.max(currHeight, height[j] + boxes[i][2]);
                }
            }
            height[i] = currHeight;
            maxHeight = Math.max(maxHeight, height[i]);
        }
        return maxHeight;
    }

    public int maxHeightBoxStackingTopDownDP(int[][] boxes) {
        if (boxes == null || boxes.length == 0)
            return -1;
        // Sorting of boxes based on height
        Arrays.sort(boxes, Comparator.comparingInt(box -> box[2]));
        return maxHeightBoxStackingTopDownDP(boxes, boxes.length - 1, new int[boxes.length]);
    }

    private int maxHeightBoxStackingTopDownDP(int[][] boxes, int index, int[] cache) {
        if (index < 0)
            return Integer.MIN_VALUE;
        if (cache[index] > 0)
            return cache[index];

        int currHeight = boxes[index][2];
        for (int i = index - 1; i >= 0; i--) {
            if (boxes[i][0] < boxes[index][0] && boxes[i][1] < boxes[index][1]) {
                currHeight = Math.max(currHeight, boxes[index][2] + maxHeightBoxStackingTopDownDP(boxes, i, cache));
            }
        }
        cache[index] = Math.max(currHeight, maxHeightBoxStackingTopDownDP(boxes, index - 1, cache));
        return cache[index];
    }

    public static void main(String[] args) {
        _100_BoxStacking obj = new _100_BoxStacking();
        System.out.println(obj.maxHeightBoxStacking(new int[][]{
                {2, 2, 1}, {2, 1, 2}, {3, 2, 3}, {2, 3, 4}, {4, 4, 5}, {2, 2, 8}
        }));
        System.out.println(obj.maxHeightBoxStackingTopDownDP(new int[][]{
                {2, 2, 1}, {2, 1, 2}, {3, 2, 3}, {2, 3, 4}, {4, 4, 5}, {2, 2, 8}
        }));
        System.out.println(obj.maxHeightBoxStacking(new int[][]{
                {2, 1, 2}, {3, 2, 3}, {2, 2, 8}, {2, 3, 4}, {2, 2, 1}, {4, 4, 5}
        }));
        System.out.println(obj.maxHeightBoxStackingTopDownDP(new int[][]{
                {2, 1, 2}, {3, 2, 3}, {2, 2, 8}, {2, 3, 4}, {2, 2, 1}, {4, 4, 5}
        }));
    }
    // Time Complexity : BottomUp - O(N^2) and TopDown - O(N^2)
    // Space Complexity : O(N)
}
