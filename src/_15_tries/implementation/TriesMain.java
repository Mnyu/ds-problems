package _15_tries.implementation;

public class TriesMain {
    public static void main(String[] args) {
        _2_Trie<Boolean> trie1 = new _2_Trie<>();
        trie1.put("she", true);
        trie1.put("sells", true);
        trie1.put("sea", true);
        trie1.put("shells", true);
        trie1.put("by", true);
        trie1.put("the", true);
        trie1.put("sea", true);
        trie1.put("shore", true);

        System.out.println("shells present? " + trie1.contains("shells") + "  shells get : " + trie1.get("shells"));
        System.out.println("shell present? " + trie1.contains("shell") + "  shell get : " + trie1.get("shell"));
        System.out.println("by present? " + trie1.contains("by") + "  by get : " + trie1.get("by"));
        System.out.println("she present? " + trie1.contains("she") + "  she get : " + trie1.get("she"));
        System.out.println("sh present? " + trie1.contains("sh") + "  sh get : " + trie1.get("sh"));

        System.out.println("\nAll Keys : " + trie1.keys());

        System.out.println("\nKeys wth prefix sh : " + trie1.keysWithPrefix("sh"));
        System.out.println("Keys wth prefix b : " + trie1.keysWithPrefix("b"));
        System.out.println("Keys wth prefix s : " + trie1.keysWithPrefix("s"));
        System.out.println("Keys wth prefix thef : " + trie1.keysWithPrefix("thef"));
        System.out.println("Keys wth prefix the : " + trie1.keysWithPrefix("the"));
        System.out.println("Keys wth prefix aa : " + trie1.keysWithPrefix("aa"));

        System.out.println("\nKeys that match sh: " + trie1.keysThatMatch("sh"));
        System.out.println("Keys that match sh?: " + trie1.keysThatMatch("sh?"));
        System.out.println("Keys that match ?h?: " + trie1.keysThatMatch("?h?"));
        System.out.println("Keys that match she?: " + trie1.keysThatMatch("she?"));
        System.out.println("Keys that match *h*: " + trie1.keysThatMatch("*h*"));
        System.out.println("Keys that match *: " + trie1.keysThatMatch("*"));

        System.out.println("\nLongest Prefix of sh: " + trie1.longestPrefixOf("sh"));
        System.out.println("Longest Prefix of shellsort: " + trie1.longestPrefixOf("shellsort"));
        System.out.println("Longest Prefix of shells: " + trie1.longestPrefixOf("shells"));


        trie1.delete("shells");
        System.out.println("\nDeleted key : shells");
        System.out.println("shells present? " + trie1.contains("shells") + "  shells get : " + trie1.get("shells"));
        System.out.println("All Keys : " + trie1.keys());
        System.out.println("Keys wth prefix s : " + trie1.keysWithPrefix("s"));
        System.out.println("Longest Prefix of shellsort: " + trie1.longestPrefixOf("shellsort"));

    }
}
