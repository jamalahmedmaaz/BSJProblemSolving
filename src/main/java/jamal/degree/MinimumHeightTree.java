package jamal.degree;

import java.util.*;
public class MinimumHeightTree {
    public static void main(String[] args) {
        MinimumHeightTree minimumHeightTree = new MinimumHeightTree();
        String S = "ab#c";
        Stack<Character> s1 = new Stack<>();
        System.out.println(Arrays.toString("   jamal    madan  ".split("\\s+")));
        for (int i = 0; i < S.length(); i++) {
            if (Objects.equals(S.charAt(i), '#')) {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.push(S.charAt(i));
            }
        }
        StringBuilder sb1 = new StringBuilder();
        while (!s1.isEmpty()) {
            sb1.insert(0, s1.pop());
        }
        System.out.println(sb1.toString());
        System.out.println(Arrays.deepToString(minimumHeightTree.findMinHeightTree(6,
                new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}).toArray()));
    }

    private List<Integer> findMinHeightTree(int n, int[][] edges) {
        List<List<Integer>> myGraph = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            myGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            myGraph.get(edges[i][0]).add(edges[i][1]);
            myGraph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        Queue<Integer> myQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                return result;
            } else if (degree[i] == 1) {
                myQueue.offer(i);
            }
        }

        while (!myQueue.isEmpty()) {
            result = new ArrayList<>();
            int size = myQueue.size();

            while (size-- > 0) {
                int curr = myQueue.poll();
                result.add(curr);
                degree[curr]--;
                for (int k = 0; k < myGraph.get(curr).size(); k++) {
                    int next = myGraph.get(curr).get(k);
                    if (degree[next] == 0) {
                        continue;
                    }
                    if (degree[next] == 2) {
                        myQueue.offer(next);
                    }
                    degree[next]--;
                }
            }
        }
        return result;
    }

}
