package _03_sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given area of consecutive plots in array P[]
 * Find all consecutive sequence of plots that add to area = K
 */
public class _21_Housing {

    public List<List<Integer>> subArraysWithTargetSum(int[] arr, int k) {

        List<List<Integer>> result = new ArrayList<>();
        if (arr == null) return result;
        int i = 0;
        int j = 0;
        int currSum = 0;

        while (j < arr.length) {
            // Expand to right
            currSum = currSum + arr[j];
            j++;

            // Contract till currSum < k and i < j
            while (currSum > k && i < j) {
                currSum = currSum - arr[i];
                i++;
            }

            if (currSum == k) {
                result.add(Arrays.asList(i, j - 1));
            }
        }
        return result;
    }

    public int[] smallestSubArrayWithTargetSum(int[] arr, int k) {

        if (arr == null) return new int[0];

        int left = 0;
        int right = 0;
        int currSum = 0;
        int minWinLength = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (right < arr.length) {
            currSum = currSum + arr[right];
            right++;

            while (currSum > k && left < right) {
                currSum = currSum - arr[left];
                left++;
            }

            if (currSum == k) {
                int winLength = right - left;
                if (winLength < minWinLength) {
                    minWinLength = winLength;
                    result = new int[]{left, right - 1};
                }
            }
        }
        return result;
    }

    //TODO : Write function if input contains negative numbers.

    public static void main(String[] args) {
        _21_Housing obj = new _21_Housing();
        System.out.println(obj.subArraysWithTargetSum(new int[]{1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2}, 8));
        System.out.println(obj.subArraysWithTargetSum(new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, 8));
        System.out.println(obj.subArraysWithTargetSum(new int[]{8, 1, 7, 8, 7, 1, 8, 5, 2, 1, 8}, 8));
        System.out.println(obj.subArraysWithTargetSum(new int[]{8, 1, 7, 8, 7, 1, 8, 8, 1, 1, 1}, 8));

        System.out.println(Arrays.toString(obj.smallestSubArrayWithTargetSum(new int[]{1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2}, 8)));
        System.out.println(Arrays.toString(obj.smallestSubArrayWithTargetSum(new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, 8)));
        System.out.println(Arrays.toString(obj.smallestSubArrayWithTargetSum(new int[]{8, 1, 7, 8, 7, 1, 8, 5, 2, 1, 8}, 8)));
        System.out.println(Arrays.toString(obj.smallestSubArrayWithTargetSum(new int[]{8, 1, 7, 8, 7, 1, 8, 8, 1, 1, 1}, 8)));

    }

}
