package jamal.tree;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        VerticalOrderTraversal verticalOrderTrabersal =
                new VerticalOrderTraversal();
        System.out.println(verticalOrderTrabersal.verticalTraversal(null));
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =
                new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> instance : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : instance.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    private void dfs(TreeNode root, int current, int height, TreeMap<Integer,
            TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(current)) {
            map.put(current, new TreeMap<>());
        }
        if (!map.get(current).containsKey(height)) {
            map.get(current).put(height, new PriorityQueue<>());
        }
        map.get(current).get(height).offer(root.val);
        dfs(root.left, current - 1, height + 1, map);
        dfs(root.right, current + 1, height + 1, map);
    }

    private class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;
    }
}

