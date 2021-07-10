package _05_binary_search;

import java.util.Arrays;

/**
 * Given : 2 non empty arrays
 * Find the pair of numbers (one from each array) whose absolute difference is minimum
 * Print any pair with the smallest difference.
 * <p>
 * Sample Input :
 * a1 = [-1,5,10,20,3]
 * a2 = [26,134,135,15,17]
 * <p>
 * Sample Output :
 * [20,17]
 */
public class _39_MinPairs {
    // a1 = n
    // a2 = m
    public int[] minPair(int[] a1, int[] a2) {
        if (a1 == null || a2 == null || a1.length == 0 || a2.length == 0)
            return new int[]{};
        Arrays.sort(a2); // mlogm
        int p1 = 0;
        int p2 = 0;
        int min = Integer.MAX_VALUE;
        // nlogm
        for (int i = 0; i < a1.length; i++) {
            int index = lowerBound(a2, a1[i]);
            if (index > 1 && a1[i] - a2[index - 1] < min) {
                min = a1[i] - a2[index - 1];
                p1 = a1[i];
                p2 = a2[index - 1];
            }
            if (index != a2.length && a2[index] - a1[i] < min) {
                min = a2[index] - a1[i];
                p1 = a1[i];
                p2 = a2[index];
            }
        }
        return new int[]{p1, p2};
    }


    private int lowerBound(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        _39_MinPairs obj = new _39_MinPairs();
        System.out.println(Arrays.toString(obj.minPair(new int[]{-1,5,10,20,3}, new int[]{26,134,135,15,17})));
        System.out.println(Arrays.toString(obj.minPair(new int[]{26,134,135,15,17}, new int[]{-1,5,10,20,3})));
        System.out.println(Arrays.toString(obj.minPair(new int[]{1,2,3,4}, new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(obj.minPair(new int[]{1,2,3,4}, new int[]{-1,-2,-3,-4})));
        System.out.println(Arrays.toString(obj.minPair(new int[]{-1,-2,-3,-4}, new int[]{-1,-2,-3,-4})));
    }

    /**
     * Time complexity : a1=N,a2=M - O(MlogM) [Sorting] + O(NlogM) [For] = O(MlogM + NlogM)
     * Space complexity : O(M) [Sorting]
     */
}
