package jamal.ser_der_tree;

import java.util.ArrayList;
import java.util.List;
class Solution {

    int index = 0;

    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper2(root, sb);
        return sb.toString();

    }

    private void serializeHelper2(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        } else {
            sb.append((char) (root.val + '0'));
            int size = root.children.size();
            sb.append((char) (size + '0'));
            for (int i = 0; i < size; i++) {
                serializeHelper2(root.children.get(i), sb);
            }
        }

    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        return deserializeHelper(data.toCharArray());
    }

    public Node deserializeHelper(char[] data) {
        int val = data[index++] - '0';
        int size = data[index++] - '0';

        Node root = new Node(val);
        root.children = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            root.children.add(deserializeHelper(data));
        }

        return root;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}