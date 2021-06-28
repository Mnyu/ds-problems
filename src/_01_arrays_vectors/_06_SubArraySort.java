package _01_arrays_vectors;

import java.util.Arrays;

/**
 * Given - Array of size at least 2
 * <p>
 * Find the smallest sub-array that needs to be sorted in place so that the entire
 * input array becomes sorted
 * <p>
 * If input array already sorted - return [-1,-1],
 * otherwise, return start and end index of smallest sub-array
 */

public class _06_SubArraySort {

    private boolean isOutOfOrder(int[] a, int i) {
        int x = a[i];
        if (i == 0)
            return x > a[i + 1];
        if (i == a.length - 1)
            return x < a[i - 1];
        return x < a[i - 1] || x > a[i + 1];
    }

    public int[] subArrayIndex(int[] a) {

        if (a == null) return new int[]{-1, -1};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            if (isOutOfOrder(a, i)) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        int left = 0;
        while (a[left] <= min) {
            left++;
        }
        int right = a.length - 1;
        while (a[right] >= max) {
            right--;
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        _06_SubArraySort obj = new _06_SubArraySort();
        System.out.println(Arrays.toString(obj.subArrayIndex(new int[]{1,2,3,4,5,8,6,7,9,10,11})));
        System.out.println(Arrays.toString(obj.subArrayIndex(new int[]{1,2,3,4,5,8,6,9,7,10,11})));
        System.out.println(Arrays.toString(obj.subArrayIndex(new int[]{1,2,3,4,5,6,7,8,9,10,11})));
        System.out.println(Arrays.toString(obj.subArrayIndex(new int[]{11,10,9,8,7,6,5,4,3,2,1})));
        System.out.println(Arrays.toString(obj.subArrayIndex(null)));
    }

    /**
     *  Time Complexity = O(N)
     *  Space Complexity = O(1)
     */

}
