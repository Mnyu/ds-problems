package _02_strings;

import java.util.*;

public class _13_StringKeySort {

    public enum SortType {
        NUMERIC, LEXICAL
    }

    public List<String> customSort(List<String> strings, int keyColumn, boolean reverse, SortType sortType) {

        List<String> result = new ArrayList<>();
        Map<String, String> keyToStringMap = new HashMap<>();
        List<String> keys = new ArrayList<>();

        for (String s : strings) {
            String[] temp = s.split(" ");
            if (temp.length <= keyColumn - 1) {
                return result;
            }
            keyToStringMap.put(temp[keyColumn - 1], s);
            keys.add(temp[keyColumn - 1]);
        }

        if (sortType == SortType.LEXICAL) {
            Collections.sort(keys);
        } else {
            Comparator<String> numComparator = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
                }
            };
            keys.sort(numComparator);
        }
        if (reverse) Collections.reverse(keys);
        for (String key : keys) {
            result.add(keyToStringMap.get(key));
        }

        return result;
    }

    public static void main(String[] args) {
        _13_StringKeySort obj = new _13_StringKeySort();
        System.out.println(obj.customSort(Arrays.asList("92 022", "82 12", "77 13"), 2, false, SortType.NUMERIC));
        System.out.println(obj.customSort(Arrays.asList("92 022", "82 12", "77 13"), 2, false, SortType.LEXICAL));
        System.out.println(obj.customSort(Arrays.asList("92 022", "82 12", "77"), 2, false, SortType.LEXICAL));
        System.out.println(obj.customSort(Arrays.asList("92 022", "82 12", "77 13"), 2, true, SortType.NUMERIC));
        System.out.println(obj.customSort(Arrays.asList("92 022", "82 12", "77 13"), 2, true, SortType.LEXICAL));
    }
}
