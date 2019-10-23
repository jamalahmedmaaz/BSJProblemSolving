package jamal.datastructure;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public class RedBlackTree<K, V> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    int size = 0;
    private transient RBNode<K, V> root;

    public V put(K key, V value) {
        new Pair<>(0, 0);
        new HashMap<>().computeIfAbsent(0, x -> 1);
        RBNode<K, V> tmp = root;
        RBNode<K, V> parent;
        int comparedValue;
        if (key == null) {
            throw new NullPointerException();
        }
        @SuppressWarnings("unchecked")
        Comparable<? super K> k = (Comparable<? super K>) key;
        do {
            parent = tmp;
            comparedValue = k.compareTo(tmp.key);
            if (comparedValue < 0) {
                tmp = tmp.left;
            } else if (comparedValue > 0) {
                tmp = tmp.right;
            } else {
                return tmp.setValue(value);
            }
        } while (tmp != null);

        RBNode<K, V> newElement = new RBNode<>(key, value, parent);
        if (comparedValue < 0) {
            parent.left = newElement;
        } else {
            parent.right = newElement;
        }
        fixAfterInsertion(newElement);
        size++;
        return null;
    }

    private void fixAfterInsertion(RBNode<K, V> node) {
        node.color = RED;

        while (node != null && node != root && node.parent.color == RED) {
            if (parentOf(node) == leftOf(parentOf(parentOf(node)))) {
                RBNode<K, V> y = rightOf(parentOf(parentOf(node)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(node), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    node = parentOf(parentOf(node));
                } else {
                    if (node == rightOf(parentOf(node))) {
                        node = parentOf(node);
                        rotateLeft(node);
                    }
                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    rotateRight(parentOf(parentOf(node)));
                }
            } else {
                RBNode<K, V> y = leftOf(parentOf(parentOf(node)));
                if (colorOf(y) == RED) {
                    setColor(parentOf(node), BLACK);
                    setColor(y, BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    node = parentOf(parentOf(node));
                } else {
                    if (node == leftOf(parentOf(node))) {
                        node = parentOf(node);
                        rotateRight(node);
                    }
                    setColor(parentOf(node), BLACK);
                    setColor(parentOf(parentOf(node)), RED);
                    rotateLeft(parentOf(parentOf(node)));
                }
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(RBNode<K, V> p) {
        if (p != null) {
            RBNode<K, V> r = p.right;
            p.right = r.left;
            if (r.left != null) {
                r.left.parent = p;
            }
            r.parent = p.parent;
            if (p.parent == null) {
                root = r;
            } else if (p.parent.left == p) {
                p.parent.left = r;
            } else {
                p.parent.right = r;
            }
            r.left = p;
            p.parent = r;
        }
    }

    private void rotateRight(RBNode<K, V> node) {
        if (node != null) {
            RBNode<K, V> tmpLeft = node.left;
            node.left = tmpLeft.right;
            if (tmpLeft.right != null) {
                tmpLeft.right.parent = node;
            }
            tmpLeft.parent = node.parent;
            if (node.parent == null) {
                root = tmpLeft;
            } else if (node.parent.right == node) {
                node.parent.right = tmpLeft;
            } else {
                node.parent.left = tmpLeft;
            }
            tmpLeft.right = node;
            node.parent = tmpLeft;
        }
    }

    private static <K, V> RBNode<K, V> parentOf(RBNode<K, V> p) {
        return (p == null ? null : p.parent);
    }

    private static <K, V> boolean colorOf(RBNode<K, V> p) {
        return (p == null ? BLACK : p.color);
    }

    private static <K, V> void setColor(RBNode<K, V> p, boolean c) {
        if (p != null) {
            p.color = c;
        }
    }

    private static <K, V> RBNode<K, V> leftOf(RBNode<K, V> p) {
        return (p == null) ? null : p.left;
    }

    private static <K, V> RBNode<K, V> rightOf(RBNode<K, V> p) {
        return (p == null) ? null : p.right;
    }

    static final class RBNode<K, V> {
        K key;
        V value;
        RBNode<K, V> left;
        RBNode<K, V> right;
        RBNode<K, V> parent;
        boolean color = BLACK;

        /**
         * Make a new cell with given key, value, and parent, and with
         * {@code null} child links, and BLACK color.
         */
        public RBNode(K key, V value, RBNode<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        /**
         * Returns the key.
         *
         * @return the key
         */
        public K getKey() {
            return key;
        }

        /**
         * Returns the value associated with the key.
         *
         * @return the value associated with the key
         */
        public V getValue() {
            return value;
        }

        /**
         * Replaces the value currently associated with the key with the given
         * value.
         *
         * @return the value associated with the key before this method was
         * called
         */
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;

            return valEquals(key, e.getKey()) && valEquals(value, e.getValue());
        }

        static final boolean valEquals(Object o1, Object o2) {
            return (Objects.equals(o1, o2));
        }

        @Override
        public int hashCode() {
            int keyHash = (key == null ? 0 : key.hashCode());
            int valueHash = (value == null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

}
