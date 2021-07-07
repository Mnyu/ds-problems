package _04_sorting_searching;

/**
 * Write a function that takes array of distinct integers as input
 * and returns the kth smallest in the array.
 */
public class _28_QuickSelect {

    public int smallestK(int[] arr, int k) {
        if (arr == null || k >= arr.length)
            return -1;
        return smallestK(arr, 0, arr.length - 1, k);
    }

    private int smallestK(int[] arr, int start, int end, int k) {
        int pivotIndex = partition(arr, start, end);
        if (pivotIndex == k)
            return arr[pivotIndex];
        else if (pivotIndex > k)
            return smallestK(arr, start, pivotIndex - 1, k);
        else
            return smallestK(arr, pivotIndex + 1, end, k);
    }


    private int partition(int[] arr, int start, int end) {
        if (start >= end)
            return -1;
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < arr[end]) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, end);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        _28_QuickSelect obj = new _28_QuickSelect();
        System.out.println(obj.smallestK(new int[]{10,5,2,0,7,6,4},0));
        System.out.println(obj.smallestK(new int[]{10,5,2,0,7,6,4},1));
        System.out.println(obj.smallestK(new int[]{10,5,2,0,7,6,4},2));
        System.out.println(obj.smallestK(new int[]{10,5,2,0,7,6,4},3));
        System.out.println(obj.smallestK(new int[]{10,5,2,0,7,6,4},4));
        System.out.println(obj.smallestK(new int[]{10,5,2,0,7,6,4},5));
        System.out.println(obj.smallestK(new int[]{10,5,2,0,7,6,4},6));
        System.out.println(obj.smallestK(new int[]{10,5,2,0,7,6,4},7));
    }
}
