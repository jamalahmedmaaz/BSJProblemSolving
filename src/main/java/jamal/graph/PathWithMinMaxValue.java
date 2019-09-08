package jamal.graph;

import java.util.*;

public class PathWithMinMaxValue {

    private int n = 0;
    private Map<Integer, List<Vertex>> map = new HashMap();
    private Map<Integer, Integer> values = new HashMap();
    private int[][] A;

    public int maximumMinimumPath(int[][] A) {
        n = A.length;
        this.A = A;
        createGraph(A);

        // for(Map.Entry<Integer,List<Vertex>> instance : map.entrySet()){
        //     System.out.println(instance.getKey() + "   "+ Arrays.toString(instance.getValue().toArray())  );
        // }

        Dijkstra d = new Dijkstra();
        d.shortestPath();

        // int min = Integer.MAX_VALUE;
        // for(int i : d.distance.keySet()){
        //     min = Math.min(min, i);
        //     System.out.println(d.distance.get(i));
        // }

        int min = Integer.MAX_VALUE;

        int i = (A.length - 1) * A.length + (A[0].length - 1);
        // System.out.println(i);
        while (i != 0) {
            min = Math.min(min, values.get(i));
            i = d.intro.get(i);
        }
        return min;
    }

    static class VertexSort implements Comparator<Vertex> {

        public int compare(Vertex one, Vertex two) {
            return one.weight - two.weight;
        }
    }

    class Dijkstra {

        private PriorityQueue<Vertex> pq = new PriorityQueue(new VertexSort());
        private Map<Integer, Integer> distance = new HashMap();
        private Map<Integer, Integer> intro = new HashMap();

        public void shortestPath() {
            init();
            // System.out.println(Arrays.toString(pq.toArray()));
            while (!pq.isEmpty()) {
                int current = pq.poll().index;
                for (Vertex neighboars : map.get(current)) {
                    int weight = distance.get(current) + neighboars.weight;
                    // System.out.println(weight + "  "+current);
                    if (distance.get(neighboars.index) != Integer.MIN_VALUE && distance.get(neighboars.index) < weight && neighboars.index != 0) {
                        //Remove from PQ.
                        Vertex v = new Vertex(neighboars.index, distance.get(neighboars.index));
                        pq.remove(v);
                        v.setWeight(weight);
                        pq.add(v);
                        distance.put(v.index, v.weight);
                        intro.put(neighboars.index, current);

                    }
                }
                // System.out.println(Arrays.toString(pq.toArray()));
            }
        }

        public void init() {
            for (int i : map.keySet()) {
                if (i != 0) {
                    distance.put(i, Integer.MIN_VALUE);
                    pq.add(new Vertex(i, Integer.MIN_VALUE));
                } else {
                    distance.put(i, A[0][0]);
                    pq.add(new Vertex(i, A[0][0]));
                }
            }
        }
    }

    class Vertex {
        int index;
        int weight;

        public Vertex(int i, int j, int weight) {
            this.index = i * n + j;
            this.weight = weight;
        }

        public Vertex(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + index + " -> " + weight + ")";
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public boolean equals(Object object) {
            return ((Vertex) (object)).index == this.index;
        }
    }

    public void createGraph(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {

                int current = i * A.length + j;

                if (!map.containsKey(current)) {
                    map.put(current, new ArrayList());
                }

                //Right
                if (j + 1 < A[i].length) {
                    map.get(current).add(new Vertex(i, j + 1, A[i][j + 1]));
                }

                //Left
                if (j - 1 >= 0) {
                    map.get(current).add(new Vertex(i, j - 1, A[i][j - 1]));
                }

                //Top
                if (i - 1 >= 0) {
                    map.get(current).add(new Vertex(i - 1, j, A[i - 1][j]));
                }

                //Bottom
                if (i + 1 < A.length) {
                    map.get(current).add(new Vertex(i + 1, j, A[i + 1][j]));
                }
                values.put(current, A[i][j]);
            }
        }
    }

}
