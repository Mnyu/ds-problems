package _13_dynamic_programming;

/**
 * Count the number of BSTs that can be forned using N nodes numbered from 1 to N
 * Eg
 * Input : 3 Output : 5
 * Input : 4 Output : 14
 * <p>
 * The nos : 1 2 5 14 42... are called catalan nos
 */
public class _101_CountBSTs {
    public int countBstTopDown(int num) {
        if (num < 0) return -1;
        int[] cache = new int[num + 1];
        return countBstTopDown(num, cache);
    }

    private int countBstTopDown(int num, int[] cache) {
        if (num == 0 || num == 1) return 1;
        if (cache[num] > 0) return cache[num];

        for (int i = 1; i <= num; i++) {
            cache[num] = cache[num] + countBstTopDown(i - 1, cache) * countBstTopDown(num - i, cache);
        }
        return cache[num];
    }

    public int countBstBottomUp(int num) {
        if (num < 0) return -1;

        int[] cache = new int[num + 1];
        cache[0] = cache[1] = 1;

        for (int i = 2; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                cache[i] = cache[i] + cache[j - 1] * cache[i - j];
            }
        }
        return cache[num];
    }

    public static void main(String[] args) {
        _101_CountBSTs obj = new _101_CountBSTs();
        System.out.println(obj.countBstTopDown(3));
        System.out.println(obj.countBstBottomUp(3));
        System.out.println(obj.countBstTopDown(4));
        System.out.println(obj.countBstBottomUp(4));
        System.out.println(obj.countBstTopDown(5));
        System.out.println(obj.countBstBottomUp(5));
    }
    // Time Complexity : O(N^2) [Both recursive and iterative]
    // Space Complexity : O(N)
}
