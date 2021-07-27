package _13_dynamic_programming;

public class _96_MinJumps {
    public int minJumps(int[] values) {
        if (values == null || values.length == 0)
            return -1;
        int[] cache = new int[values.length];
        return minJumps(values, 0, cache);
    }

    private int minJumps(int[] values, int index, int[] cache) {
        if (index == values.length - 1)
            return 0;
        if (index > values.length - 1)
            return Integer.MAX_VALUE;
        if (cache[index] > 0)
            return cache[index];
        int value = values[index];
        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= value; i++) {
            int jumps = minJumps(values, index + i, cache);
            if (jumps != Integer.MAX_VALUE) {
                jumps = 1 + jumps;
            }
            minJumps = Math.min(minJumps, jumps);
        }
        cache[index] = minJumps;
        return cache[index];
    }

    public static void main(String[] args) {
        _96_MinJumps obj = new _96_MinJumps();
        System.out.println(obj.minJumps(new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 2, 5}));
        System.out.println(obj.minJumps(new int[]{3, 4, 2, 1, 2, 3, 7, 1, 1, 3}));
    }
    // Time Complexity : O(N*C) where C = max element in the input array
    // Space Complexity : O(N)
}
