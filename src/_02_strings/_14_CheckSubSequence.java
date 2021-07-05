package _02_strings;

/**
 * Given 2 non-empty strings, write a method that determines
 * whether the second substring is sub-sequence of 1st one
 */
public class _14_CheckSubSequence {
    public boolean isSubsSequence(String big, String small) {
        if (big == null || small == null)
            return false;
        int j = 0;
        for (int i = 0; i < big.length() && j < small.length(); i++) {
            if (big.charAt(i) == small.charAt(j)) {
                j++;
            }
        }
        return j == small.length();
    }

    public static void main(String[] args) {
        _14_CheckSubSequence obj = new _14_CheckSubSequence();
        System.out.println(obj.isSubsSequence("coding minutes", "cines"));
        System.out.println(obj.isSubsSequence("coding minutes", "citnes"));
    }
}
