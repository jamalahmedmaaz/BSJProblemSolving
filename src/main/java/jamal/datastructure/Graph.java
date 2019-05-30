package jamal.datastructure;

import java.util.*;

public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.adjacencyList();
        graph.adjacencyMatrix();
    }

    private void adjacencyMatrix() {
        // 1, 2, 3, 4, 5 = total 5.
        int[][] edges = new int[6][6];

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                if (i == 1 && (j == 2 || j == 3)) {
                    edges[i][j] = 1;
                }
                if (i == 2 && (j == 1 || j == 3 || j == 4)) {
                    edges[i][j] = 1;
                }
                if (i == 3 && (j == 1 || j == 2 || j == 4)) {
                    edges[i][j] = 1;
                }
                if (i == 4 && (j == 2 || j == 3)) {
                    edges[i][j] = 1;
                }
            }
        }
        System.out.println();
        for (int[] i : edges) {
            System.out.println(Arrays.toString(i));
        }
    }

    private void adjacencyList() {

        Map<Edge, List<Edge>> map = new HashMap<>();

        // A, {B,C,D}
        Edge<String> a = new Edge<>("A");
        Edge<String> b = new Edge<>("B");
        Edge<String> c = new Edge<>("C");
        Edge<String> d = new Edge<>("D");
        Edge<String> e = new Edge<>("E");

        map.put(a, Arrays.asList(b, c, d));
        map.put(b, Arrays.asList(a, d));
        map.put(c, Arrays.asList(a, d));
        map.put(d, Arrays.asList(e));
        map.put(e, new ArrayList<>());

        for (Map.Entry<Edge, List<Edge>> instance : map.entrySet()) {
            System.out.println(instance.getKey() + " --> " + printString(instance.getValue()));
        }

    }

    private String printString(List<Edge> edges) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Edge edge : edges) {
            stringBuilder.append(edge.val).append(" -> ");
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

    class Edge<E> {
        private E val;

        public Edge(E val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object element) {
            return element.equals(val);
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }

}
