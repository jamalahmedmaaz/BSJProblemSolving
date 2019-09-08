package jamal.contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MaxLevelSum {

    List<Integer> list = new ArrayList();


    public int maxLevelSum(TreeNode root) {

        rec(root, 0);
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
                index = i;
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
        return index;
    }

    public void rec(TreeNode root, int height) {
        if (root == null) {
            return;
        }

        if (list.size() <= height) {
            list.add(0);
        }
        list.set(height, root.val + list.get(height));

        rec(root.left, height + 1);
        rec(root.right, height + 1);

    }

    private class TreeNode {
        public TreeNode left;
        public Integer val;
        public TreeNode right;
    }
}
