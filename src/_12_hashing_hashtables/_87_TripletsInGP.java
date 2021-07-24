package _12_hashing_hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * Given : Array
 * Count the number of triplets wth indices (i,j,k) such that the elements are in GP for a given ratio r
 * and (i<j<k)
 */
public class _87_TripletsInGP {
    public int tripletInGPCount(int[] arr, int r) {
        if (arr == null || arr.length == 0)
            return -1;
        Map<Integer, Integer> leftFreqMap = new HashMap<>();
        Map<Integer, Integer> rightFreqMap = new HashMap<>();

        for (int a : arr) {
            rightFreqMap.put(a, rightFreqMap.getOrDefault(a, 0) + 1);
        }
        int count = 0;
        for (int a : arr) {
            int leftContribution = 0;
            int rightContribution = 0;
            rightFreqMap.put(a, rightFreqMap.get(a) - 1);
            if (a % r == 0 && leftFreqMap.get(a / r) != null && leftFreqMap.get(a / r) > 0) {
                leftContribution = leftFreqMap.get(a / r);
            }
            if (rightFreqMap.get(a * r) != null && rightFreqMap.get(a * r) > 0) {
                rightContribution = rightFreqMap.get(a * r);
            }
            count = count + leftContribution * rightContribution;
            leftFreqMap.put(a, leftFreqMap.getOrDefault(a, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        _87_TripletsInGP obj = new _87_TripletsInGP();
        System.out.println(obj.tripletInGPCount(new int[]{1,16,4,16,64,16}, 4));
    }
    // Time Complexity : O(N)
    // Space Complexity : O(N)
}
