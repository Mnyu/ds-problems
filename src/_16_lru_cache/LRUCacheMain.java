package _16_lru_cache;

public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<String, Integer>(1);
//        LRUCache<String, Integer> cache = new LRUCache<String, Integer>(2);
//        LRUCache<String, Integer> cache = new LRUCache<String, Integer>(3);
//        LRUCache<String, Integer> cache = new LRUCache<String, Integer>(4);
        cache.insert("mango", 10);
        cache.insert("apple", 20);
        cache.insert("guava", 30);
        System.out.println(cache.getMostRecentKey());

        cache.insert("mango", 40);
        System.out.println(cache.getMostRecentKey());

        cache.insert("banana", 20);
        System.out.println(cache.getMostRecentKey());

        if (cache.getValue("apple") == null) {
            System.out.println("apple does not exist");
        }

        if (cache.getValue("guava") == null) {
            System.out.println("guava does not exist");
        }

        if (cache.getValue("banana") == null) {
            System.out.println("banana does not exist");
        }

        if (cache.getValue("mango") == null) {
            System.out.println("mango does not exist");
        }
    }
}
