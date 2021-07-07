package _04_sorting_searching;

import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array of strings that contain empty strings.
 * Write a method to find the location of a given string
 * ["ai","","","bat","","","car","cat","","","dog",""]
 * location of "bat" = 4
 */
public class _30_SparseSearch {
    public int sparseSearch(List<String> strings, String s) {

        if (strings == null) return -1;

        int i = 0;
        int n = strings.size();
        int searchIndex = -1;

        while (i < n) {

            int mid = i + (n - i) / 2;

            if ("".equals(strings.get(mid))) {
                int midLeft = mid - 1;
                int midRight = mid + 1;
                while(true) {
                    if(midLeft < i && midRight > n - 1){
                        return -1;
                    } else if(midLeft >= i && !"".equals(strings.get(midLeft))) {
                        mid = midLeft;
                        break;
                    } else if (midRight < n && !"".equals(strings.get(midRight))) {
                        mid = midRight;
                        break;
                    }
                    midLeft--;
                    midRight++;
                }
            }
            if (s.equals(strings.get(mid))) {
                searchIndex = mid;
                break;
            } else if (s.compareTo(strings.get(mid)) < 0) {
                n = mid;
            } else {
                i = mid + 1;
            }
        }
        return searchIndex;
    }

    public static void main(String[] args) {
        _30_SparseSearch obj = new _30_SparseSearch();
        System.out.println(obj.sparseSearch(Arrays.asList("ai","","","bat","","","car","cat","","","dog",""), "bat"));
        System.out.println(obj.sparseSearch(Arrays.asList("ai","","","bat","","","car","cat","","","dog","e"), "dog"));
        System.out.println(obj.sparseSearch(Arrays.asList("","","","","",""), "dog"));
    }
}
