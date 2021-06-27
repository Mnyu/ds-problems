package _01_arrays_vectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given : array - n integers and number - s denoting target sum
 *
 * Find a pair of 2 DISTINCT integers that form that sum s.
 * Assume - only 1 such pair
 */

public class _01_Pairs {

    public ArrayList<Integer> getPair(List<Integer> nums, int sum) {
        ArrayList<Integer> pair = new ArrayList<>();
        if (nums == null) return pair;
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(sum - x)) {
                pair.add(sum - x);
                pair.add(x);
                break;
            }
            set.add(x);
        }
        return pair;
    }

    public static void main(String[] args) {
        _01_Pairs obj = new _01_Pairs();

        // Ideal Case
        List<Integer> a1 = Arrays.asList(10, 5, 2, 3, -6, 9, 11);
        List<Integer> pair1 = obj.getPair(a1, 4);
        System.out.println(pair1.toString());

        // Null check
        List<Integer> a3 = null;
        List<Integer> pair3 = obj.getPair(a3, 4);
        System.out.println(pair3.toString());

        // List with 0 elements
        List<Integer> a4 = new ArrayList<>();
        List<Integer> pair4 = obj.getPair(a4, 4);
        System.out.println(pair4.toString());

        // List with 1 element
        List<Integer> a2 = Arrays.asList(10);
        List<Integer> pair2 = obj.getPair(a2, 4);
        System.out.println(pair2.toString());

        // List with no elements with target sum
        List<Integer> a5 = Arrays.asList(10, 5, 2, 3, -5, 7, 11);
        List<Integer> pair5 = obj.getPair(a5, 4);
        System.out.println(pair5.toString());

        // List with duplicates
        List<Integer> a6 = Arrays.asList(10, 5, 2, 3, -5, 7, 2);
        List<Integer> pair6 = obj.getPair(a6, 4);
        System.out.println(pair6.toString());
    }

    /**
     *  Time Complexity = O(N)
     *  Space Complexity = O(N)
     */
}
