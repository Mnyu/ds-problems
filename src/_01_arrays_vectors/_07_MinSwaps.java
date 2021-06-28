package _01_arrays_vectors;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given - Array
 * <p>
 * Find Min no of swaps needed to make array sorted
 */
public class _07_MinSwaps {
    public int minSwaps(int[] arr) {
        if (arr == null) return 0;

        Map<Integer, Integer> valuesIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            valuesIndexMap.put(arr[i], i);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = valuesIndexMap.get(arr[i]);
        }
        int i = 0;
        int swaps = 0;
        while (i < arr.length) {
            while (i != arr[i]) {
                swaps++;
                swap(arr, i, arr[i]);
            }
            i++;
        }
        return swaps;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        _07_MinSwaps obj = new _07_MinSwaps();
        System.out.println(obj.minSwaps(new int[] {10,11,5,4,3,2,1}));
        System.out.println(obj.minSwaps(new int[] {5,4,3,2,1}));
        System.out.println(obj.minSwaps(new int[] {1,2,3,4}));
        System.out.println(obj.minSwaps(new int[] {2,1}));
        System.out.println(obj.minSwaps(new int[] {1,2}));
        System.out.println(obj.minSwaps(new int[] {1}));
    }

    /**
     *  Time Complexity = O(N) [build-map] + O(NlogN) [sort] + O(N) [replace arr value with index] + O(N) [swapping main logic]
     *                  ~ O(NlogN)
     *  Space Complexity = O(N) [map]
     */
}
