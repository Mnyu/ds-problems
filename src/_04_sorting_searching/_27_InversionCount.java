package _04_sorting_searching;

/**
 * Variation of Merge Sort
 */

public class _27_InversionCount {


    public int inversionCount(int[] arr) {

        if (arr == null) return -1;
        return inversionCount(arr, 0, arr.length - 1);

    }

    private int inversionCount(int[] arr, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int leftInversions = inversionCount(arr, start, mid);
        int rightInversions = inversionCount(arr, mid + 1, end);
        int crossInversions = merge(arr, start, mid, end);
        return leftInversions + rightInversions + crossInversions;
    }

    private int merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[end - start + 1];

        int inversions = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                inversions = inversions + mid - i + 1;
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (i = 0; i < temp.length; i++) {
            arr[start] = temp[i];
            start++;
        }
        return inversions;
    }

    public static void main(String[] args) {
        _27_InversionCount obj = new _27_InversionCount();
        System.out.println(obj.inversionCount(new int[]{0,5,2,3,1}));
        System.out.println(obj.inversionCount(new int[]{0,5,5,2,3,1}));
    }
}
