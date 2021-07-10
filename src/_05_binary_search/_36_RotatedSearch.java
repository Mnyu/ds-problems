package _05_binary_search;

/**
 * Given : Distinct array of integers
 */
public class _36_RotatedSearch {
    public int rotatedSearch(int[] arr, int key) {
        if (arr == null) return -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[start] <= arr[mid]) {
                // Left side is sorted
                if (arr[start] <= key && arr[mid] >= key) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // Right side is sorted
                if (arr[mid] <= key && arr[end] >= key) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _36_RotatedSearch obj = new _36_RotatedSearch();
        System.out.println(obj.rotatedSearch(new int[]{7,9,11,13,1,3,5}, 7));
        System.out.println(obj.rotatedSearch(new int[]{7,9,11,13,1,3,5}, 9));
        System.out.println(obj.rotatedSearch(new int[]{7,9,11,13,1,3,5}, 11));
        System.out.println(obj.rotatedSearch(new int[]{7,9,11,13,1,3,5}, 13));
        System.out.println(obj.rotatedSearch(new int[]{7,9,11,13,1,3,5}, 1));
        System.out.println(obj.rotatedSearch(new int[]{7,9,11,13,1,3,5}, 3));
        System.out.println(obj.rotatedSearch(new int[]{7,9,11,13,1,3,5}, 5));
        System.out.println(obj.rotatedSearch(new int[]{7,9,11,0,1,3,5}, 1));
        System.out.println(obj.rotatedSearch(new int[]{7,9,11,0,1,2,3,5}, 1));
        System.out.println(obj.rotatedSearch(new int[]{7,9,11,0,1,2,3,5}, 10));
    }
}
