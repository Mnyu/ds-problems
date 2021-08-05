package _17_lru_cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement LRU cache which supports following operations in O(1) time:
 * insert(key, value)
 * getValue(key)
 * getMostRecentKey()
 */
public class LRUCache<K, V> {
    private Map<K, CacheNode<K, V>> map;
    private int capacity;
    private CacheNode<K, V> head;
    private CacheNode<K, V> tail;
    private int totalItems;

    public LRUCache(int capacity) {
        if (capacity < 1)
            throw new IllegalArgumentException("Capacity > 0 required");
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public void insert(K key, V value) {
        if (map.containsKey(key)) {
            CacheNode<K, V> node = map.get(key);
            node.setValue(value);
            moveToHead(node);
            return;
        }
        if (totalItems == capacity) {
            removeNodeFromTail();
        }
        createNodeAtHead(key, value);
    }

    public V getValue(K key) {
        if (!map.containsKey(key))
            return null;
        CacheNode<K, V> node = map.get(key);
        moveToHead(node);
        return head.getValue();
    }

    public K getMostRecentKey() {
        return head != null ? head.getKey() : null;
    }

    private void removeNodeFromTail() {
        map.remove(tail.getKey());
        totalItems--;
        if (tail == head) {
            tail = null;
            head = null;
            return;
        }
        tail = tail.getPrev();
        tail.setNext(null);
    }

    private void moveToHead(CacheNode<K, V> node) {
        createNodeAtHead(node.getKey(), node.getValue());
        removeNode(node);
    }

    private void removeNode(CacheNode<K, V> node) {
        CacheNode<K, V> prev = node.getPrev();
        CacheNode<K, V> next = node.getNext();
        if (head == node) {
            head = next;
        }
        if (tail == node) {
            tail = prev;
        }
        if (prev != null) {
            prev.setNext(next);
        }
        if (next != null) {
            next.setPrev(prev);
        }
        totalItems--;
    }

    private void createNodeAtHead(K key, V value) {
        CacheNode<K, V> newNode = new CacheNode<>(key, value, null, null);
        map.put(key, newNode);
        if (head == null) {
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
        }
        head = newNode;
        totalItems++;
    }
}
