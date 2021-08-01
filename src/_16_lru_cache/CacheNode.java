package _16_lru_cache;

public class CacheNode<K, V> {
    private K key;
    private V value;

    private CacheNode<K,V> prev;
    private CacheNode<K,V> next;

    public CacheNode(K key, V value, CacheNode<K,V> prev, CacheNode<K,V> next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public CacheNode<K, V> getPrev() {
        return prev;
    }

    public void setPrev(CacheNode<K, V> prev) {
        this.prev = prev;
    }

    public CacheNode<K, V> getNext() {
        return next;
    }

    public void setNext(CacheNode<K, V> next) {
        this.next = next;
    }
}
