package _06_recursion_backtracking;

/**
 * Given : Array of non-negative integers and a target sum
 * Find if there is a subset of the array with sum == target sum
 */
public class _44_SubSetSum {
    public boolean isSubsetPresent(int[] arr, int targetSum) {
        return arr != null && isSubsetPresent(arr, 0, targetSum);
    }
    private boolean isSubsetPresent(int[] arr, int index, int pendingSum) {
        if (index == arr.length) {
            return pendingSum == 0;
        }
        return isSubsetPresent(arr, index + 1, pendingSum - arr[index]) ||
                isSubsetPresent(arr, index + 1, pendingSum);
    }

    public static void main(String[] args) {
        _44_SubSetSum obj = new _44_SubSetSum();
        System.out.println(obj.isSubsetPresent(new int[]{10,12,15,6,19,20}, 16));
    }
    // Brute Force Solution
    // Time Complexity : O(2^n)
    // Space  Complexity : O(n)
}
