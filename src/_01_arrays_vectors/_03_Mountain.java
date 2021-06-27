package _01_arrays_vectors;

import java.util.Arrays;
import java.util.List;

/**
 * Given - Array of distinct integers
 * <p>
 * Find the length of the highest mountain.
 * At least 3 numbers are required to form a mountain.
 */
public class _03_Mountain {

    public int maxPeak(List<Integer> nums) {
        if (nums == null) return 0;
        int maxPeakLength = 0;
        for (int i = 1; i < nums.size() - 1; ) {
            if (nums.get(i) > nums.get(i - 1) && nums.get(i) > nums.get(i + 1)) {
                int currentPeakLength = 1;
                int j = i;
                while (j > 0 && nums.get(j) > nums.get(j - 1)) {
                    currentPeakLength++;
                    j--;
                }
                while (i < nums.size() - 1 && nums.get(i) > nums.get(i + 1)) {
                    currentPeakLength++;
                    i++;
                }
                maxPeakLength = Math.max(maxPeakLength, currentPeakLength);
            } else {
                i++;
            }
        }
        return maxPeakLength;
    }


    public static void main(String[] args) {
        _03_Mountain obj = new _03_Mountain();
        System.out.println(obj.maxPeak(Arrays.asList(5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4)));
        System.out.println(obj.maxPeak(null));
        System.out.println(obj.maxPeak(Arrays.asList(5)));
        System.out.println(obj.maxPeak(Arrays.asList(5, 6)));
        System.out.println(obj.maxPeak(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println(obj.maxPeak(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)));
        System.out.println(obj.maxPeak(Arrays.asList(1, 2, 3, 4, 3, 2, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        System.out.println(obj.maxPeak(Arrays.asList(1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 9, 8, 7, 6)));
    }

    /**
     *  Time Complexity = O(2N) ~ O(N)
     *  Space Complexity = O(1)
     */

}
