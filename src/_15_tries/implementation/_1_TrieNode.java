package _15_tries.implementation;

import java.util.HashMap;
import java.util.Map;

public class _1_TrieNode<V> {
    private final char c;
    private V val;
    private final Map<Character, _1_TrieNode<V>> map;

    public _1_TrieNode(char c, V val) {
        this.c = c;
        this.val = val;
        this.map = new HashMap<>();
    }

    public void addChild(char c, _1_TrieNode<V> trieNode) {
        map.put(c, trieNode);
    }

    public void removeChild(char c) {
        map.remove(c);
    }

    public _1_TrieNode<V> getChild(char c) {
        return map.get(c);
    }

    public Iterable<_1_TrieNode<V>> getAllChildren() {
        return map.values();
    }

    public char getKey() {
        return c;
    }

    public Iterable<Character> getAllChildrenKeys() {
        return map.keySet();
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }
}
