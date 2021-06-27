package _01_arrays_vectors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given - Array of N integers
 *
 * Find the longest band
 *
 * Band : A band is subset which can be re-ordered such that all elements are consecutive.
 */

public class _04_LongestBand {

    public int longestBand(List<Integer> nums) {
        if(nums == null) return 0;

        int maxLength = 0;

        Set<Integer> set = new HashSet<>(nums);

        for (int x : nums) {
            if(!set.contains(x - 1)) {
                int currLength = 1;
                while(set.contains(x+1)) {
                    currLength++;
                    x++;
                }
                maxLength = Math.max(maxLength, currLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        _04_LongestBand obj = new _04_LongestBand();
        System.out.println(obj.longestBand(Arrays.asList(1,9,3,0,18,5,2,4,10,7,12,6)));
    }

    /**
     *  Time Complexity = O(N) [adding to set] + O(2N) [for + while loop] ~ O(N)
     *  Space Complexity = O(N)
     */
}
