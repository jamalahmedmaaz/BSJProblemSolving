package jamal.graph;

import javafx.util.Pair;

import java.util.*;
public class MyDijkstraAlgorithm {

    //Pair key = neighbour and value to weight to reach the node.
    Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();
    Map<Integer, Integer> weights = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> weights.get(a)));

    public static void main(String[] args) {
        MyDijkstraAlgorithm dijkstraAlgorithm = new MyDijkstraAlgorithm();
        createGraph(dijkstraAlgorithm);
        populateWeightMap(dijkstraAlgorithm);

        dijkstraAlgorithm.weights.put(0, 0);
        for (int node : dijkstraAlgorithm.weights.keySet()) {
            dijkstraAlgorithm.pq.add(node);
        }
        dijkstraAlgorithm.findShortestPath();
        dijkstraAlgorithm.weights.entrySet().stream().forEach(System.out::println);
    }

    private void findShortestPath() {
        while (!pq.isEmpty()) {
            int minElement = pq.poll();
            List<Pair<Integer, Integer>> neighbors = graph.get(minElement);
            if (neighbors != null) {
                for (Pair<Integer, Integer> neighbor : neighbors) {
                    int currentElement = neighbor.getKey();
                    int tmpValue = weights.get(currentElement);
                    if (tmpValue > neighbor.getValue() + weights.get(minElement)) {
                        weights.put(currentElement, neighbor.getValue() + weights.get(minElement));
                        pq.add(currentElement);
                        int min = pq.poll();
                        pq.add(min);
                    }
                }
            }
        }
    }

    private static void createGraph(MyDijkstraAlgorithm dijkstraAlgorithm) {
        dijkstraAlgorithm.graph.put(0, new ArrayList<>(Arrays.asList(new Pair<>(1, 4), new Pair<>(7, 8))));
        dijkstraAlgorithm.graph.put(1, new ArrayList<>(Arrays.asList(new Pair<>(2, 8), new Pair<>(7, 11))));
        dijkstraAlgorithm.graph.put(2, new ArrayList<>(Arrays.asList(new Pair<>(1, 8), new Pair<>(8, 2), new Pair<>(5, 4), new Pair<>(3, 7))));
        dijkstraAlgorithm.graph.put(3, new ArrayList<>(Arrays.asList(new Pair<>(2, 7), new Pair<>(4, 9), new Pair<>(5, 14))));
        dijkstraAlgorithm.graph.put(4, new ArrayList<>(Arrays.asList(new Pair<>(3, 9), new Pair<>(5, 10))));
        dijkstraAlgorithm.graph.put(5, new ArrayList<>(Arrays.asList(new Pair<>(6, 2), new Pair<>(2, 4), new Pair<>(3, 14), new Pair<>(4, 10))));
        dijkstraAlgorithm.graph.put(6, new ArrayList<>(Arrays.asList(new Pair<>(7, 1), new Pair<>(8, 6), new Pair<>(5, 2))));
        dijkstraAlgorithm.graph.put(7, new ArrayList<>(Arrays.asList(new Pair<>(0, 8), new Pair<>(1, 11), new Pair<>(8, 7), new Pair<>(6, 1))));
        dijkstraAlgorithm.graph.put(8, new ArrayList<>(Arrays.asList(new Pair<>(7, 7), new Pair<>(2, 2), new Pair<>(6, 6))));
    }

    private static void populateWeightMap(MyDijkstraAlgorithm dijkstraAlgorithm) {
        for (Map.Entry<Integer, List<Pair<Integer, Integer>>> entry : dijkstraAlgorithm.graph.entrySet()) {
            dijkstraAlgorithm.weights.put(entry.getKey(), Integer.MAX_VALUE);
            for (Pair<Integer, Integer> p : entry.getValue()) {
                dijkstraAlgorithm.weights.put(p.getKey(), Integer.MAX_VALUE);
            }
        }
    }
}

