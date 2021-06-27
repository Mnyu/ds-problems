package _01_arrays_vectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  Given : Array - N Integers and TargetSum
 *
 *  Find triplets of distinct integers that add up to form target sum
 *  Numbers n each triplet should be ordered and each triplet should also be ordered.
 *
 */

public class _02_Triplets {

    public List<List<Integer>> getTriplets(List<Integer> nums, int targetSum) {
        List<List<Integer>> triplets = new ArrayList<>();
        if (nums == null) return triplets;

        Collections.sort(nums); // Important Step

        int n = nums.size();
        for (int i = 0; i < n - 3; i++) {
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int currentSum = nums.get(i) + nums.get(start) + nums.get(end);
                if (currentSum == targetSum) {
                    triplets.add(Arrays.asList(nums.get(i), nums.get(start), nums.get(end)));
                    start++;
                    end--;
                } else if (currentSum < targetSum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        _02_Triplets obj = new _02_Triplets();
        System.out.println(obj.getTriplets(Arrays.asList(1,2,3,4,5,6,7,8,9,15), 18).toString());
        System.out.println(obj.getTriplets(Arrays.asList(1,2,3,3,5), 6).toString());
        System.out.println(obj.getTriplets(null, 18).toString());
        System.out.println(obj.getTriplets(Arrays.asList(1), 18).toString());
        System.out.println(obj.getTriplets(new ArrayList<>(), 18).toString());
    }

    /**
     *  Time Complexity = O(NlogN) + O(N^2) ~ O(N^2)
     *  Space Complexity = O(1)
     */

}
