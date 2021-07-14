package _06_recursion_backtracking;

/**
 * Oswald and Henry are again playing the game of coins. They have a row of 'n' coins [C1,C2,C3...Cn] with
 * values [V1,V2,V3...Vn] where Ci coin has Vi value. They take turns alternatively.
 * In one turn the player can pick either the first or the last coin of the row and he is supposed to do it 'k' times in a turn
 * Given both Oswald and Henry are very smart players [PLAY OPTIMALLY], you need to
 * find the maximum possible value Oswald can earn if he plays first.
 */
public class _51_GameOfCoinsAdvanced {

    public int maxValue(int nums[], int k) {
        if (nums != null && nums.length > 0) {
            return maxValue(nums, k, 0, nums.length - 1, 0, 0);
        }
        return -1;
    }

    private int maxValue(int[] nums, int k, int start, int end, int pickNo, int currSum) {
        if (start > end) {
            return currSum;
        }
        if ((pickNo / k) % 2 == 0) {
            // Oswald's turn to play optimally, he has to maximize for himself.
            return Math.max(maxValue(nums, k, start + 1, end, pickNo + 1, currSum + nums[start]),
                    maxValue(nums, k, start, end - 1, pickNo + 1, currSum + nums[end]));
        }
        // Henry's turn, he will play optimally as well and minimize for Oswald.
        return Math.min(maxValue(nums, k, start + 1, end, pickNo + 1, currSum),
                maxValue(nums, k, start, end - 1, pickNo + 1, currSum));
    }

    public static void main(String[] args) {
        _51_GameOfCoinsAdvanced obj = new _51_GameOfCoinsAdvanced();
        System.out.println(obj.maxValue(new int[]{10, 15, 20, 9, 2, 5}, 2));

    }
    // This solution is brute force - to understand recursion and backtracking
    // Time Complexity : O(2^n)
    // Space Complexity : O(n)
}
