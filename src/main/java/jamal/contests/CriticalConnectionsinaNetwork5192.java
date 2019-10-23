package jamal.contests;

import java.util.*;
public class CriticalConnectionsinaNetwork5192 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        System.out.println(solution.criticalConnections(4, connections));

    }

    static class Solution {
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            Map<Integer, DS> indegree = new HashMap();

            for (List<Integer> edge : connections) {
                int x = edge.get(0);
                int y = edge.get(1);

                if (indegree.containsKey(y)) {
                    indegree.get(y).indegree++;
                } else {
                    indegree.put(y, new DS(y, 1, 0));
                }

                if (indegree.containsKey(x)) {
                    indegree.get(x).outdegree++;
                } else {
                    indegree.put(x, new DS(x, 0, 1));
                }

            }
            System.out.println(indegree);

            return null;
        }

        class DS {
            int vertex;
            int indegree;
            int outdegree;

            public DS(int vertex, int indegree, int outdegree) {
                this.vertex = vertex;
                this.vertex = indegree;
                this.vertex = outdegree;
            }

            @Override
            public String toString() {
                return "DS{" +
                        "vertex=" + vertex +
                        ", indegree=" + indegree +
                        ", outdegree=" + outdegree +
                        '}';
            }
        }
    }
}
