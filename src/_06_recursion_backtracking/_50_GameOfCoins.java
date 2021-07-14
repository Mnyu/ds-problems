package _06_recursion_backtracking;

/**
 * Oswald and Henry are playing the game of coins. They have a row of 'n' coins [C1,C2,C3...Cn] with values
 * [V1,V2,V3...Vn] where Ci coin has Vi value. They take turns alternatively.
 * In one turn the player can pick either the first or the last coin of the row.
 * Given both Oswald and Henry are very smart players [PLAY OPTIMALLY], you need to
 * find the maximum possible value Oswald can earn if he plays first.
 */
public class _50_GameOfCoins {

    public int maxValue(int nums[]) {
        if (nums != null && nums.length > 0) {
            return maxValue(nums, 0, nums.length - 1, 1, 0);
        }
        return -1;
    }

    private int maxValue(int[] nums, int start, int end, int pickNo, int currSum) {
        if (start > end) {
            return currSum;
        }
        if (pickNo % 2 == 1) {
            // Oswald's turn to play optimally, he has to maximize for himself.
            return Math.max(maxValue(nums, start + 1, end, pickNo + 1, currSum + nums[start]),
                    maxValue(nums, start, end - 1, pickNo + 1, currSum + nums[end]));
        }
        // Henry's turn, he will play optimally as well and minimize for Oswald.
        return Math.min(maxValue(nums, start + 1, end, pickNo + 1, currSum),
                maxValue(nums, start, end - 1, pickNo + 1, currSum));
    }

    public static void main(String[] args) {
        _50_GameOfCoins obj = new _50_GameOfCoins();
        System.out.println(obj.maxValue(null));
        System.out.println(obj.maxValue(new int[]{100}));
        System.out.println(obj.maxValue(new int[]{1, 2}));
        System.out.println(obj.maxValue(new int[]{1, 2, 3}));
        System.out.println(obj.maxValue(new int[]{1, 2, 3, 4}));
        System.out.println(obj.maxValue(new int[]{1, 5, 2}));
        System.out.println(obj.maxValue(new int[]{1, 5, 233, 7}));
    }
    // This solution is brute force - to understand recursion and backtracking
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
}
