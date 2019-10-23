package jamal;

import java.util.*;
public class ConsistentHashing {
    /*
     * @param n: a positive integer
     * @return: n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }

        TreeSet<List<Integer>> treeSet = new TreeSet<>(new MyTreeSetComparator());
        List<Integer> first = new ArrayList<>();
        first.add(0);
        first.add(359);
        first.add(1);

        treeSet.add(first);

        for (int i = 2; i <= n; i++) {
            List<Integer> biggestNode = treeSet.first();
            int x = biggestNode.get(0);
            int y = biggestNode.get(1);
            int z = biggestNode.get(2);
            List<Integer> nodeA = new ArrayList<>();
            List<Integer> nodeB = new ArrayList<>();
            nodeA.add(x);
            nodeA.add((x + y) / 2);
            nodeA.add(z);
            nodeB.add((x + y) / 2 + 1);
            nodeB.add(y);
            nodeB.add(i);

            treeSet.remove(biggestNode);
            treeSet.add(nodeA);
            treeSet.add(nodeB);
        }

        for (List<Integer> node : treeSet) {
            ans.add(node);
        }

        Collections.sort(ans, new MyNodeComparator());

        return ans;
    }
}

class MyTreeSetComparator implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> a, List<Integer> b) {
        int rangeA = a.get(1) - a.get(0);
        int rangeB = b.get(1) - b.get(0);

        if (rangeA != rangeB) {
            return rangeB - rangeA;
        }

        return a.get(2) - b.get(2);
    }
}

class MyNodeComparator implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> a, List<Integer> b) {
        return a.get(0) - b.get(0);
    }
}