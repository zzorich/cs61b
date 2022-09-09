package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Your name here
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>, Iterable<K> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (p == null) {
            return null;
        }
        if (key.compareTo(p.key) < 0) {
            return getHelper(key, p.left);
        }
        if (key.compareTo(p.key) > 0) {
            return getHelper(key, p.right);
        }
        return p.value;
    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(key, root);
    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {
        if (p == null) {
            ++size;
            return new Node(key, value);
        }
        if (key.compareTo(p.key) < 0) {
            p.left = putHelper(key, value, p.left);
        } else if (key.compareTo(p.key) > 0) {
            p.right= putHelper(key, value, p.right);
        } else {
            p.value = value;
        }
        return p;
    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        root = putHelper(key, value, root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return size;
    }

    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        HashSet<K> keySet = new HashSet<>();
        for (K key: this) {
            keySet.add(key);
        }
        return keySet;
    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        V value = get(key);
        root = removeHelper(root, key);
        return value;
    }

    private Node min(Node rt) {
        if (rt.left == null) {
            return rt;
        }
        return min(rt.left);
    }

    private Node removeMin(Node rt) {
        if (rt.left == null) {
            --size;
            return rt.right;
        }
        rt.left = removeMin(rt.left);
        return rt;
    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        if (get(key) != value) {
            return null;
        }
        return remove(key);
    }

    private Node removeHelper(Node rt, K key) {
        if (rt == null) {
            return null;
        }
        if (key.compareTo(rt.key) < 0) {
            rt.left = removeHelper(rt.left, key);
            return rt;
        }
        if (key.compareTo(rt.key) > 0) {
            rt.right = removeHelper(rt.right, key);
            return rt;
        }
        if (rt.right == null) {
            --size;
            return rt.left;
        }
        if (rt.left == null) {
            --size;
            return rt.right;
        }
        Node smallestNode = min(rt.right);
        smallestNode.right = removeMin(rt.right); //size has been reduced here, no further reduction is needed.
        smallestNode.left = rt.left;
        return smallestNode;
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTiterator();
    }

    private class BSTiterator implements Iterator<K> {

        Stack<Node> sets;

        public BSTiterator() {
            sets = new Stack<>();
            pushLeft(root);
        }
        @Override
        public boolean hasNext() {
            return !sets.empty();
        }

        @Override
        public K next() {
            Node ele = sets.pop();
            if (ele.right != null) {
                pushLeft(ele.right);
            }
            return ele.key;
        }
        private void pushLeft(Node root) {
            Node ptr = root;
            while (ptr != null) {
                sets.push(ptr);
                ptr = ptr.left;
            }
        }
    }
}
