package _05_binary_search;

public class _35_FrequencyCount {

    public int frequencyCount(int[] arr, int k) {
        if (arr == null || upperBound(arr, k) == -1 || lowerBound(arr, k) == -1)
            return 0;
        return upperBound(arr, k) - lowerBound(arr, k) + 1;
    }

    private int lowerBound(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int lowerBound = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                lowerBound = mid;
                end = mid - 1;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lowerBound;

    }

    private int upperBound(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int upperBound = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == k) {
                upperBound = mid;
                start = mid + 1;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return upperBound;
    }

    public static void main(String[] args) {
        _35_FrequencyCount obj = new _35_FrequencyCount();
        System.out.println(obj.frequencyCount(new int[]{0,1,1,2,3,3,3,3,3,4,5,5,5,10}, 3));
        System.out.println(obj.frequencyCount(new int[]{0,1,1,2,3,3,3,3,3,4,5,5,5,10}, 11));
        System.out.println(obj.frequencyCount(null, 3));
    }
}
