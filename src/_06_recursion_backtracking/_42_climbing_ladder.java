package _06_recursion_backtracking;

/**
 * Given : Ladder with n steps and you can take 1,2,3 steps at a time
 * Find the number of ways to climb the ladder.
 * e.g. n = 4 answer = 7
 */
public class _42_climbing_ladder {
    public int noOfWays(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        return noOfWays(n - 1) + noOfWays(n - 2) + noOfWays(n - 3);
    }

    public static void main(String[] args) {
        _42_climbing_ladder obj = new _42_climbing_ladder();
        System.out.println(obj.noOfWays(4));
        System.out.println(obj.noOfWays(5));
    }
    // The above solution is using recursion only.
    // Time Complexity : O(3^n) - Exponential - BAD
    // Space Complexity : O(n)
    // Since there are overlapping sub-problems, DP should be used to optimize the solution.
}
