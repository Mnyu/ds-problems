package _02_strings;

/**
 * Write a method to replace all the spaces in a string with ‘%20’.
 */
public class _12_Space20 {

    public String replaceSpace(String s) {
        if (s == null) return "";
        char[] sArr = s.toCharArray();
        int spaces = 0;
        for (char ch : sArr) {
            if (ch == ' ')
                spaces++;
        }
        int newLen = sArr.length + 2 * spaces;
        char[] newArr = new char[newLen];
        int index = newArr.length - 1;
        for (int i = sArr.length - 1; i >= 0; i--) {
            if (sArr[i] == ' ') {
                newArr[index] = '0';
                newArr[index - 1] = '2';
                newArr[index - 2] = '%';
                index = index - 3;
            } else {
                newArr[index] = sArr[i];
                index--;
            }
        }
        return new String(newArr);
    }

    public static void main(String[] args) {
        _12_Space20 obj = new _12_Space20();
        System.out.println(obj.replaceSpace("Hello World!  How are you?"));
        System.out.println(obj.replaceSpace(null));
        System.out.println(obj.replaceSpace("123"));
        System.out.println(obj.replaceSpace("   "));
    }
}
