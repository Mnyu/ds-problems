package _13_dynamic_programming;

/**
 * Given : a ladder of size N and integer K
 * Compute number of ways to climb the ladder if you can jump at-most K at every step.
 *
 * 3 Approaches:
 *  a. Top Down DP
 *  b. Bottom Up DP
 *  c. Top Down DP optimized further
 */
public class _93_NKLadders {
    public int noOfWaysTopDownDP(int n, int k) {
        int[] cache = new int[n+1];
        return noOfWaysTopDownDP(n, k, cache);
    } // Time Complexity : O(nk), Space : O(n)

    private int noOfWaysTopDownDP(int n, int k, int[] cache) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
        if (cache[n] > 0) {
            return cache[n];
        }
        int ways = 0;
        int temp = k;
        while (temp > 0) {
            ways = ways + noOfWaysTopDownDP(n - temp, k, cache);
            temp--;
        }
        cache[n] = ways;
        return ways;
    }

    public int noOfWaysBottomUpDP(int n, int k) {
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = k;
            int ways = 0;
            while (temp > 0) {
                if(i - temp >= 0) {
                    ways = ways + cache[i - temp];
                }
                temp--;
            }
            cache[i] = ways;
        }
        return cache[n];
    } // Time Complexity : O(nk), Space : O(n)


    public int noOfWaysTopDownDPOptimized(int n, int k) {
        int[] cache = new int[n+1];
        return noOfWaysTopDownDPOptimized(n, k, cache);
    } // Time Complexity : O(n), Space : O(n)

    private int noOfWaysTopDownDPOptimized(int n, int k, int[] cache) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return 1;
        if (cache[n] > 0) {
            return cache[n];
        }
        cache[n] = 2 * noOfWaysTopDownDPOptimized(n - 1, k, cache) - noOfWaysTopDownDPOptimized(n - k - 1, k, cache);
        return cache[n];
    }

    public static void main(String[] args) {
        _93_NKLadders obj = new _93_NKLadders();
        System.out.println(obj.noOfWaysTopDownDP(4,3));
        System.out.println(obj.noOfWaysBottomUpDP(4,3));
        System.out.println(obj.noOfWaysTopDownDPOptimized(4,3));
        System.out.println(obj.noOfWaysTopDownDP(6,3));
        System.out.println(obj.noOfWaysBottomUpDP(6,3));
        System.out.println(obj.noOfWaysTopDownDPOptimized(6,3));
    }
}
