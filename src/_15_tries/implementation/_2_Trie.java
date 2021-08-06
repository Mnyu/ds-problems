package _15_tries.implementation;

import java.util.LinkedList;
import java.util.Queue;

public class _2_Trie<V> {
    private _1_TrieNode<V> root;

    public _2_Trie() {
        root = new _1_TrieNode<V>(' ', null);
    }

    public void put(String key, V val) {
        if (key == null || val == null) {
            throw new IllegalArgumentException("Illegal arguments");
        }
        root = put(key, val, root, 0);
    }

    private _1_TrieNode<V> put(String key, V val, _1_TrieNode<V> x, int i) {
        if (x == null) {
            x = new _1_TrieNode<>(key.charAt(i - 1), null);
        }
        if (i == key.length()) {
            x.setVal(val);
            return x;
        }
        char c = key.charAt(i);
        x.addChild(c, put(key, val, x.getChild(c), i + 1));
        return x;
    }

    public V get(String key) {
        if (key == null) throw new IllegalArgumentException("Illegal Key");
        _1_TrieNode<V> node = get(root, key, 0);
        if (node == null) return null;
        return node.getVal();
    }

    private _1_TrieNode<V> get(_1_TrieNode<V> x, String key, int i) {
        if (x == null) return null;
        if (i == key.length())
            return x;
        char c = key.charAt(i);
        return get(x.getChild(c), key, i + 1);
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public void delete(String key) {
        if (key == null) throw new IllegalArgumentException("Illegal Key");
        delete(root, key, 0);
    }

    private _1_TrieNode<V> delete(_1_TrieNode<V> x, String key, int i) {
        if (x == null) return null;
        if (i == key.length()) {
            x.setVal(null);
        } else {
            char c = key.charAt(i);
            _1_TrieNode<V> returnedNode = delete(x.getChild(c), key, i + 1);
            if (returnedNode == null) {
                x.removeChild(c);
            }
        }
        if (x.getVal() != null) {
            return x;
        }
        for (_1_TrieNode<V> child : x.getAllChildren()) {
            if (child != null)
                return x;
        }
        return null;
    }

    public Iterable<String> keys() {
        Queue<String> queue = new LinkedList<>();
        collectKeysWithPrefix(root, queue, new StringBuilder());
        return queue;
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        if (prefix == null) throw new IllegalArgumentException("Illegal prefix");
        _1_TrieNode<V> prefixEndingNode = get(root, prefix, 0);
        Queue<String> queue = new LinkedList<>();
        if (prefixEndingNode != null) {
            collectKeysWithPrefix(prefixEndingNode, queue, new StringBuilder(prefix));
        }
        return queue;
    }

    private void collectKeysWithPrefix(_1_TrieNode<V> x, Queue<String> queue, StringBuilder sb) {
        if (x == null) return;
        if (x.getVal() != null) queue.add(sb.toString());
        for (_1_TrieNode<V> node : x.getAllChildren()) {
            sb.append(node.getKey());
            collectKeysWithPrefix(node, queue, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public Iterable<String> keysThatMatch(String expression) {
        if (expression == null) throw new IllegalArgumentException("Illegal expression");
        Queue<String> queue = new LinkedList<>();
        collectKeysThatMatch(root, expression, queue, 0, new StringBuilder());
        return queue;
    }

    private void collectKeysThatMatch(_1_TrieNode<V> x, String exp, Queue<String> queue, int i, StringBuilder sb) {
        if (x == null) return;
        if (x.getVal() != null && i == exp.length()) queue.add(sb.toString());
        if (i == exp.length()) return;
        char c = exp.charAt(i);
        if (c == '?') {
            for (_1_TrieNode<V> node : x.getAllChildren()) {
                sb.append(node.getKey());
                collectKeysThatMatch(node, exp, queue, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else if (c == '*') {
            // TODO : SEEMS LIKE THIS APPROACH OF WILD-CARD MATCHING IS INEFFICIENT - FIND AN EFFICIENT APPROACH
            collectKeysThatMatch(x, exp, queue, i + 1, sb); // matching zero characters
            for (_1_TrieNode<V> node : x.getAllChildren()) {
                sb.append(node.getKey());
                collectKeysThatMatch(node, exp, queue, i, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            sb.append(c);
            collectKeysThatMatch(x.getChild(c), exp, queue, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String longestPrefixOf(String query) {
        if (query == null) throw new IllegalArgumentException("Illegal query");
        int length = longestPrefixOf(root, query, 0, 0);
        return query.substring(0, length);
    }

    private int longestPrefixOf(_1_TrieNode<V> x, String query, int i, int length) {
        if (x == null) return length;
        if (x.getVal() != null) {
            length = i;
        }
        if (i == query.length()) {
            return length;
        }
        char c = query.charAt(i);
        return longestPrefixOf(x.getChild(c), query, i + 1, length);
    }
}
