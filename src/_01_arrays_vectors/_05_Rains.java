package _01_arrays_vectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given - non-negative integers representing an elevation map
 * where width of each bar = 1 unit
 * <p>
 * Compute how much units of water it can trap after raining
 */

public class _05_Rains {

    public int totalWater(List<Integer> heights) {
        if (heights == null) return 0;
        int water = 0;

        int tempMax = heights.get(0);
        int[] left = new int[heights.size()];
        for (int i = 0; i < heights.size(); i++) {
            tempMax = Math.max(tempMax, heights.get(i));
            left[i] = tempMax;
        }

        tempMax = heights.get(heights.size() - 1);
        int[] right = new int[heights.size()];
        for (int i = heights.size() - 1; i >= 0; i--) {
            tempMax = Math.max(tempMax, heights.get(i));
            right[i] = tempMax;
        }

        for (int i = 0; i < heights.size(); i++) {
            water += Math.min(left[i], right[i]) - heights.get(i);
        }
        return water;
    }

    public static void main(String[] args) {
        _05_Rains obj = new _05_Rains();
        System.out.println(obj.totalWater(Arrays.asList(0,1,0,2,1,0,1,3,2,1,2,1)));
    }

    /**
     *  Time Complexity = O(N) + O(N) + O(N) ~ O(N)
     *  Space Complexity = O(2N) [2 arrays]
     */
}

