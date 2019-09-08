package jamal.graph;

import jamal.unionfind.UnionFind;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;
public class Krushkal {

    private Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    private UnionFind unionFind;

    public static void main(String[] args) {
        Krushkal krushkal = new Krushkal();
        krushkal.graph = buildGraph();
        krushkal.unionFind = new UnionFind(krushkal.graph.size());
        krushkal.findMinimumSpanningTree();
    }

    private void findMinimumSpanningTree() {
        //Sort the edges:
        Map<Pair<Integer, Integer>, Integer> edges = getEdges(graph);
        edges.forEach((K, V) -> System.out.println("Edge: " + K + ", Weight: " + V));

        Map<Pair<Integer, Integer>, Integer> sortedEdges = edges.entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        int min = 0;

        Map<Pair<Integer, Integer>, Integer> minEdges = new HashMap<>();
        for (Map.Entry<Pair<Integer, Integer>, Integer> edge : sortedEdges.entrySet()) {
            if (unionFind.union(edge.getKey().getKey(), edge.getKey().getValue())) {
                min = min + edge.getValue();
                minEdges.put(edge.getKey(), edge.getValue());
            }
        }

        unionFind.print();

        minEdges.forEach((k, v) -> System.out.println("Edge: " + k + ", Weight " + v));

        System.out.println("Min total weight is " + min);
    }

    private Map<Pair<Integer, Integer>, Integer> getEdges(Map<Integer, Map<Integer, Integer>> graph) {
        ConcurrentHashMap<Pair<Integer, Integer>, Integer> result = new ConcurrentHashMap<>();
        for (Map.Entry<Integer, Map<Integer, Integer>> instance : graph.entrySet()) {
            int parent = instance.getKey();
            if (instance.getValue() != null) {
                for (Map.Entry<Integer, Integer> subInstance : instance.getValue().entrySet()) {
                    result.put(new Pair<>(parent, subInstance.getKey()), subInstance.getValue());
                }
            }
        }
        return result;
    }

    public static Map<Integer, Map<Integer, Integer>> buildGraph() {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.put(0, new HashMap<>());
        graph.put(1, new HashMap<>());
        graph.put(2, new HashMap<>());
        graph.put(3, new HashMap<>());
        graph.put(4, new HashMap<>());
        graph.put(5, new HashMap<>());

        graph.get(0).put(3, 6);
        graph.get(0).put(1, 4);
        graph.get(0).put(2, 5);

        graph.get(1).put(2, -3);

        graph.get(2).put(5, 4);

        graph.get(3).put(4, 2);

        graph.get(4).put(5, 2);

        graph.get(5).put(4, 1);

        return graph;
    }

}
