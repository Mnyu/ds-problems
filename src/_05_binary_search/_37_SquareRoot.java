package _05_binary_search;

/**
 * Given : Integers N and P
 * Find square root of number N upto P places.
 * Do it without any library function.
 */
public class _37_SquareRoot {

    public float squareRoot(int n, int p) {
        int start = 0;
        int end = n;
        float ans = 0.0f;
        // Integer Part - Binary Search between 0 - n
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid < n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // Floating Part - Linear search since p<<<n and no of digits = 9
        float factor = 0.1f;
        for (int place = 0; place < p; place++) {
            while (ans * ans <= n) {
                ans = ans + factor;
            }
            ans = ans - factor;
            factor = factor / 10.0f;
        }
        return ans;
    }

    public static void main(String[] args) {
        _37_SquareRoot obj = new _37_SquareRoot();
        System.out.println(obj.squareRoot(10,2));
        System.out.println(obj.squareRoot(50,3));
        System.out.println(obj.squareRoot(49,3));
        System.out.println(obj.squareRoot(10,4));
        System.out.println(obj.squareRoot(10,0));
    }
}
